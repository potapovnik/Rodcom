package ru.relex.itschool.services.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.data.domain.Sort;
import ru.relex.itschool.db.entity.RcMember;
import ru.relex.itschool.db.repository.IRcMemberRepository;
import ru.relex.itschool.services.modelDto.RcMemberDto;
import ru.relex.itschool.services.service.IRcMemberService;
import ru.relex.itschool.services.mapper.IRcMemberMapper;

import java.util.*;

@Service
public class RcMemberServiceImpl implements IRcMemberService {

    private final IRcMemberRepository repository;
    private final IRcMemberMapper memberMapper;

    public RcMemberServiceImpl(IRcMemberRepository repository, IRcMemberMapper memberMapper) {
        this.repository = repository;
        this.memberMapper = memberMapper;
    }

    public RcMember getMemberById(int id) {
        Optional<RcMember> memberOptional = repository.findById(id);
        if (!memberOptional.isPresent())
            return null;
        return memberOptional.get();
    }

    public List<RcMemberDto> getAllMembers() {
        List<RcMember> members = repository.findAll(new Sort(Sort.Direction.ASC, "lastName"));
        return memberMapper.toDto(members);
    }


    @Override
    public RcMemberDto getById(int id) {
        RcMember m = getMemberById(id);
        if (m == null)
            return null;
        return memberMapper.toDto(m);
    }

    @Override
    public RcMemberDto createMember(RcMemberDto memberDto) {
        RcMember member = memberMapper.fromDto(memberDto);
        member = repository.save(member);
        memberDto.setMemberId(member.getMemberId());
        return memberDto;
    }

    @Override
    public boolean updateMember(RcMemberDto memberDto) {
        RcMember member = getMemberById(memberDto.getMemberId());
        if (member == null)
            return false;
        member.setAnnotation(memberDto.getAnnotation());
        member.setActualDate(memberDto.getActualDate());
        member.setFirstName(memberDto.getFirstName());
        member.setMiddleName(memberDto.getMiddleName());
        member.setLastName(memberDto.getLastName());
        member.setPhone(memberDto.getPhone());
        member.setPhone2(memberDto.getPhone2());
        member.setAddress(memberDto.getAddress());
        member.setEmail(memberDto.getEmail());
        member.setSkype(memberDto.getSkype());
        member.setVk(memberDto.getVk());
        member.setOk(memberDto.getOk());
        member.setTwit(memberDto.getTwit());
        member = repository.save(member);
        return true;
    }

    @Override
    public boolean deleteMember(RcMemberDto memberDto) {
        RcMember member = getMemberById(memberDto.getMemberId());
        if (member == null)
            return false;
        repository.delete(member);
        return true;
    }
}
