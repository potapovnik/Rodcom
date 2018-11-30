package ru.relex.itschool.security.service;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

/**
 * @author : sasha
 */
public interface IMemberSecurityService {

    UsernamePasswordAuthenticationToken findById(int id);
}
