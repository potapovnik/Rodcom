package ru.relex.itschool.security.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import ru.relex.itschool.security.model.AuthFilterBuilder;
import ru.relex.itschool.security.model.AuthRequest;

import java.io.IOException;
import java.util.stream.Collectors;

/**
 * @author : sasha
 */
public class RelexAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    private final ObjectMapper objectMapper = new ObjectMapper();

    public static final Builder builder() {
        return new Builder();
    }

    @Override
    public Authentication attemptAuthentication(javax.servlet.http.HttpServletRequest request,
                                                javax.servlet.http.HttpServletResponse response) throws AuthenticationException {
        try (var reader = request.getReader()) {
            String result = reader.lines().collect(Collectors.joining());
            var authRequest = objectMapper.readValue(result, AuthRequest.class);
            Authentication auth = new UsernamePasswordAuthenticationToken(authRequest.getUsername(),
                    new String(authRequest.getPassword()));
            return getAuthenticationManager().authenticate(auth);
        } catch (IOException e) {
            throw new BadCredentialsException("Cannot read authentication data", e);
        }
    }

    public static class Builder extends AuthFilterBuilder<RelexAuthenticationFilter, Builder> {

        @Override
        protected RelexAuthenticationFilter getInstance(final String uri) {
            return new RelexAuthenticationFilter();
        }
    }
}
