package ru.relex.itschool.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import ru.relex.itschool.db.repository.IRcMemberRepository;
import ru.relex.itschool.security.filter.JWTFilter;
import ru.relex.itschool.security.filter.JWTRefreshFilter;
import ru.relex.itschool.security.filter.RelexAuthenticationFilter;
import ru.relex.itschool.security.handler.LoginSuccessHandler;
import ru.relex.itschool.security.model.Roles;
import ru.relex.itschool.security.service.IMemberSecurityService;
import ru.relex.itschool.security.service.ITokenService;
import ru.relex.itschool.security.utils.Url;

/**
 * @author : sasha
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final ITokenService tokenService;
    private final IRcMemberRepository repository;
    private final UserDetailsService service;
    private final IMemberSecurityService securityService;

    private final PasswordEncoder passwordEncoder = new Pbkdf2PasswordEncoder("SFaefcvx3redsfs342", 201023, 512);

    public SecurityConfig(final ITokenService tokenService, final IRcMemberRepository repository,
                          final UserDetailsService service, IMemberSecurityService securityService) {
        this.tokenService = tokenService;
        this.repository = repository;
        this.service = service;
        this.securityService = securityService;
    }

    @Override
    protected void configure(final AuthenticationManagerBuilder auth) {
        var dao = new DaoAuthenticationProvider();
        dao.setPasswordEncoder(passwordEncoder());
        dao.setUserDetailsService(service);
        auth.authenticationProvider(dao);
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return passwordEncoder;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        var successHandler = new LoginSuccessHandler(tokenService);

        var configuration = http
                .csrf().disable()
                .cors().disable()
                .authorizeRequests()
                .antMatchers(Url.LOGIN).not().authenticated()
                .antMatchers(Url.REFRESH).not().authenticated();

        /*if (repository.count() == 0) {
            configuration = configuration.antMatchers(Url.INITIALIZE).permitAll();
        }*/

        configuration.anyRequest().not().authenticated()//access(Roles.ADMIN)
                .and()
                .addFilter(RelexAuthenticationFilter.builder()
                        .withURI(Url.LOGIN)
                        .withAuthenticationManager(authenticationManager())
                        .withSuccessHandler(successHandler)
                        .build())
                .addFilterBefore(new JWTFilter(tokenService, securityService), RelexAuthenticationFilter.class)
                .addFilterBefore(JWTRefreshFilter.builder()
                        .withAuthenticationManager(authenticationManager())
                        .withURI(Url.REFRESH)
                        .withTokenService(tokenService)
                        .withUserRepository(repository)
                        .withSuccessHandler(successHandler)
                        .build(), JWTFilter.class);
    }
}
