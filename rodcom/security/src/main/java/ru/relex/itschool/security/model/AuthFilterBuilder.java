package ru.relex.itschool.security.model;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

/**
 * @author : sasha
 */
public abstract class AuthFilterBuilder<T extends AbstractAuthenticationProcessingFilter, B extends AuthFilterBuilder<T, B>>  {

    private String uri;
    private AuthenticationSuccessHandler successHandler;
    private AuthenticationFailureHandler failureHandler;
    private AuthenticationManager authenticationManager;

    protected AuthFilterBuilder() {
    }

    @SuppressWarnings("unchecked")
    public B withURI(String uri) {
        this.uri = uri;
        return (B) this;
    }

    @SuppressWarnings("unchecked")
    public B withSuccessHandler(AuthenticationSuccessHandler handler) {
        this.successHandler = handler;
        return (B) this;
    }

    @SuppressWarnings("unchecked")
    public B withFailureHandler(AuthenticationFailureHandler handler) {
        this.failureHandler = handler;
        return (B) this;
    }

    @SuppressWarnings("unchecked")
    public B withAuthenticationManager(AuthenticationManager manager) {
        this.authenticationManager = manager;
        return (B) this;
    }

    public T build() throws RuntimeException {

        T instance = getInstance(uri);
        instance.setAllowSessionCreation(false);
        instance.setAuthenticationManager(authenticationManager);

        if (uri != null) {
            instance.setFilterProcessesUrl(uri);
        }

        if (successHandler != null) {
            instance.setAuthenticationSuccessHandler(successHandler);
        }

        if (failureHandler != null) {
            instance.setAuthenticationFailureHandler(failureHandler);
        }
        return instance;
    }

    protected abstract T getInstance(final String uri);

}
