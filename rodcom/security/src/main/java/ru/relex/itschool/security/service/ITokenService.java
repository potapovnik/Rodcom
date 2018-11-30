package ru.relex.itschool.security.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import ru.relex.itschool.security.exception.TokenNotFoundException;
import ru.relex.itschool.security.model.LoginResponse;

import javax.servlet.http.HttpServletRequest;

/**
 * @author : sasha
 */
public interface ITokenService {

    LoginResponse generateToken(final String username);


    Jws<Claims> readToken(HttpServletRequest request) throws TokenNotFoundException;
}
