package ru.relex.itschool.security.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import ru.relex.itschool.security.model.LoginResponse;
import ru.relex.itschool.security.service.ITokenService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author : sasha
 */
public class LoginSuccessHandler implements AuthenticationSuccessHandler {


    private final ITokenService tokenService;
    private final ObjectMapper mapper = new ObjectMapper();

    public LoginSuccessHandler(final ITokenService tokenService) {
        this.tokenService = tokenService;
    }

    @Override
    public void onAuthenticationSuccess(final HttpServletRequest request, final HttpServletResponse response,
                                        final Authentication authentication) throws IOException {
        var principal = authentication.getPrincipal();
        String email;
        if (principal instanceof UserDetails) {
            email = ((UserDetails) principal).getUsername();
        } else {
            email = principal.toString();
        }

        LoginResponse loginResponse = tokenService.generateToken(email);
        response.setStatus(HttpServletResponse.SC_OK);
        try (var writer = response.getWriter()) {
            mapper.writeValue(writer, loginResponse);
        }
    }
}
