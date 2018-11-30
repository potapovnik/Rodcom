package ru.relex.itschool.security.service.impl;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.relex.itschool.db.entity.RcMember;
import ru.relex.itschool.db.repository.IRcMemberRepository;

import java.util.Collection;
import java.util.stream.Collectors;

/**
 * @author : sasha
 */
@Service
public class MemberDetailsServiceImpl  implements UserDetailsService {

    private final IRcMemberRepository repository;

    public MemberDetailsServiceImpl(IRcMemberRepository repository) {
        this.repository = repository;
    }


    @Override
    @Transactional
    public UserDetails loadUserByUsername(final String email) throws UsernameNotFoundException {
        return repository
                .findByEmail(email)
                .map(Details::new)
                .orElseThrow(
                        () -> new UsernameNotFoundException("Member " + email + "not found"));
    }

    private class Details implements UserDetails {

        private final String email;
        private final String password;
        //private final Collection<SimpleGrantedAuthority> authorities;

        private Details(RcMember member) {
            email = member.getEmail();
            password = new String(member.getPassword());

            /*authorities = user
                    .getRole()
                    .getPermissions()
                    .stream()
                    .map(Permission::of)
                    .map(SimpleGrantedAuthority::new)
                    .collect(Collectors.toUnmodifiableSet());*/
        }

        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            return null/*authorities*/;
        }

        @Override
        public String getPassword() {
            return password;
        }

        @Override
        public String getUsername() {
            return email;
        }

        @Override
        public boolean isAccountNonExpired() {
            return true;
        }

        @Override
        public boolean isAccountNonLocked() {
            return true;
        }

        @Override
        public boolean isCredentialsNonExpired() {
            return true;
        }

        @Override
        public boolean isEnabled() {
            return true;
        }
    }

}
