package ru.relex.itschool.security.filter;

import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import ru.relex.itschool.db.repository.IRcMemberRepository;
import ru.relex.itschool.security.model.AuthFilterBuilder;
import ru.relex.itschool.security.service.ITokenService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author : sasha
 */
public class JWTRefreshFilter extends AbstractAuthenticationProcessingFilter {

    public static Builder builder() {
        return new Builder();
    }

    private ITokenService tokenService;
    private IRcMemberRepository repository;

    private JWTRefreshFilter(final String defaultFilterProcessesUrl) {
        super(defaultFilterProcessesUrl);
    }

    @Override
    public Authentication attemptAuthentication(final HttpServletRequest request, final HttpServletResponse response)
            throws AuthenticationException, IOException, ServletException {
        var token = tokenService.readToken(request);

        if (token == null || !token.getBody().containsKey("refresh")) {
            throw new AuthenticationCredentialsNotFoundException("Cannot find refresh token");
        }

        String subject = token.getBody().getSubject();
        return repository
                .findByEmail(subject)
                .map(x -> new UsernamePasswordAuthenticationToken(x.getEmail(), null, List.of()))
                .orElseThrow(() -> new UsernameNotFoundException("User with given ID not found"));
    }
    private void setTokenService(ITokenService tokenService) {
        this.tokenService = tokenService;
    }

    private void setRepository(final IRcMemberRepository repository) {
        this.repository = repository;
    }


    public static class Builder extends
            AuthFilterBuilder<JWTRefreshFilter, Builder> {

        private ITokenService tokenService;
        private IRcMemberRepository repository;

        private Builder() {
        }

        public Builder withTokenService(ITokenService tokenService) {
            this.tokenService = tokenService;
            return this;
        }

        public Builder withUserRepository(IRcMemberRepository repository) {
            this.repository = repository;
            return this;
        }

        @Override
        protected JWTRefreshFilter getInstance(final String uri) {
            return new JWTRefreshFilter(uri);
        }

        @Override
        public JWTRefreshFilter build() throws RuntimeException {
            if (tokenService == null) {
                throw new RuntimeException("Token service not initialized");
            }

            if (repository == null) {
                throw new RuntimeException("User repository not initialized");
            }
            JWTRefreshFilter filter = super.build();
            filter.setTokenService(tokenService);
            filter.setRepository(repository);
            return filter;
        }
    }

}
