package ru.relex.itschool.security.service.impl;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.relex.itschool.db.repository.IRcMemberRepository;
import ru.relex.itschool.security.exception.TokenNotFoundException;
import ru.relex.itschool.security.model.LoginResponse;
import ru.relex.itschool.security.service.ITokenService;

import javax.servlet.http.HttpServletRequest;
import java.security.Key;
import java.security.SecureRandom;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

/**
 * @author : sasha
 */
@Service
public class TokenServiceImpl implements ITokenService {

    private static final Logger logger = LoggerFactory.getLogger(TokenServiceImpl.class);

    private static final String BEARER = "Bearer ";
    private static final String AUTHORIZATION = "Authorization";

    private static final Key SIGNING_KEY;

    static {
        SecureRandom sr = new SecureRandom();

        byte[] bytes = new byte[512 / 8];
        sr.nextBytes(bytes);

        SIGNING_KEY = Keys.hmacShaKeyFor(bytes);
    }

    private final IRcMemberRepository repository;

    public TokenServiceImpl(IRcMemberRepository repository) {
        this.repository = repository;
    }


    @Override
    @Transactional
    public LoginResponse generateToken(String username) {
        var now = Instant.now();

        var memberOptional = repository.findByEmail(username);
        if (memberOptional.isEmpty()){
            return null;
        }
        var member = memberOptional.get();

        String accessToken =
                Jwts.builder().signWith(SIGNING_KEY)
                        .setSubject(username)
                        .setIssuedAt(Date.from(now))
                        .setExpiration(Date.from(now.plus(/*5 temporary !!! */ 30 * 60, ChronoUnit.SECONDS)))
                        .claim("uid", member.getMemberId())
                        //.claim("role", member.getRole())
                        .compact();

        String refreshToken = Jwts.builder().signWith(SIGNING_KEY)
                .setSubject(username)
                .setIssuedAt(Date.from(now))
                .setExpiration(Date.from(now.plus(60 * 60, ChronoUnit.SECONDS)))
                .claim("refresh", "true")
                .compact();

        return new LoginResponse(accessToken, refreshToken);
    }

    @Override
    public Jws<Claims> readToken(HttpServletRequest request) throws TokenNotFoundException {

        String header = request.getHeader(AUTHORIZATION);

        if (header == null || !header.startsWith(BEARER)) {
            return null;
        }

        String token = header.substring(BEARER.length());

        try {
            return Jwts
                    .parser()
                    .setSigningKey(SIGNING_KEY)
                    .parseClaimsJws(token);
        } catch (ExpiredJwtException e) {
            logger.info("Token for {} is expired", e.getClaims().getSubject());
        } catch (Exception e) {
            logger.info("Invalid token: {}", e.getMessage());
        }

        return null;
    }
}
