package ru.relex.itschool.security.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;
import ru.relex.itschool.security.service.IMemberSecurityService;
import ru.relex.itschool.security.service.ITokenService;
import ru.relex.itschool.security.utils.Url;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author : sasha
 */
public class JWTFilter extends OncePerRequestFilter {

    private static final Logger logger = LoggerFactory.getLogger(JWTFilter.class);

    private final ITokenService tokenService;
    private final IMemberSecurityService service;

    public JWTFilter(final ITokenService tokenService, IMemberSecurityService service) {
        this.tokenService = tokenService;
        this.service = service;
    }

    @Override
    protected void doFilterInternal(final HttpServletRequest request, final HttpServletResponse response,
                                    final FilterChain filterChain) throws ServletException, IOException {

        if (request.getRequestURI().equalsIgnoreCase(request.getContextPath() + Url.REFRESH)
               // || request.getRequestURI().equalsIgnoreCase(request.getContextPath() + Url.CREATE)
                || request.getRequestURI().equalsIgnoreCase(request.getContextPath() + Url.LOGIN)) {
            logger.debug("Bypass request to {}", request.getRequestURI());
            filterChain.doFilter(request, response);
            return;
        }

        var token = tokenService.readToken(request);

        if (token == null || token.getBody().containsKey("refresh")) {
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            return; // we do not accept refresh tokens
        }

        Object uid = token.getBody().get("uid");

        if (!(uid instanceof Number)) {
            // not a number
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            return;
        }

        var userId = ((Number) uid).intValue();
        var auth = service.findById(userId);
        if (auth == null) {
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            return;
        }
        SecurityContextHolder.getContext().setAuthentication(auth);
        filterChain.doFilter(request, response);
    }
}
