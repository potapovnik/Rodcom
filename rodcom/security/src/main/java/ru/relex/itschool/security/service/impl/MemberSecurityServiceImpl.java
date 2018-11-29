package ru.relex.itschool.security.service.impl;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;
import ru.relex.itschool.db.entity.RcMember;
import ru.relex.itschool.db.entity.RcNotice;
import ru.relex.itschool.db.repository.IRcMemberRepository;
import ru.relex.itschool.security.service.IMemberSecurityService;

import java.util.stream.Collectors;

/**
 * @author : sasha
 */
@Service
public class MemberSecurityServiceImpl implements IMemberSecurityService {

    private final IRcMemberRepository repository;

    public MemberSecurityServiceImpl(IRcMemberRepository repository) {
        this.repository = repository;
    }


    @Override
    public UsernamePasswordAuthenticationToken findById(int id) {
        return repository.findById(id).map(MemberSecurityServiceImpl::toToken).orElse(null);
    }

    private static UsernamePasswordAuthenticationToken toToken(RcMember member) {
        return new UsernamePasswordAuthenticationToken(member.getEmail(), null, null//,
                /*user.getRole().getPermissions()
                        .stream()
                        .map(Permission::of)
                        .map(SimpleGrantedAuthority::new)
                        .collect(Collectors.toSet())*/);
    }
}
