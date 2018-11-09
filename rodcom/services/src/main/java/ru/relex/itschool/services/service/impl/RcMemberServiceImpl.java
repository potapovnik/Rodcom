package ru.relex.itschool.services.service.impl;

import org.springframework.stereotype.Service;
import ru.relex.itschool.db.entity.RcMember;
import ru.relex.itschool.db.repository.IRcMemberRepository;
import ru.relex.itschool.services.modelDto.RcMemberDto;
import ru.relex.itschool.services.service.IRcMemberService;

import java.util.Optional;

@Service
public class RcMemberServiceImpl implements IRcMemberService {

    private final IRcMemberRepository repository;

    public RcMemberServiceImpl(IRcMemberRepository repository) {
        this.repository = repository;
    }

    public RcMember getMemberById(int id) {
        Optional<RcMember> memberOptional = repository.findById(id);
        if (!memberOptional.isPresent())
            return null;
        return memberOptional.get();
    }

    @Override
    public RcMemberDto getById(int id) {
        RcMember m = getMemberById(id);
        if (m == null)
            return null;
        return new RcMemberDto(m.getMember_id(), m.getAnnotation(), m.getActual_date(), m.getFirst_name(), 
                               m.getMiddle_name(), m.getLast_name(), m.getPhone(), m.getPhone2(), m.getAddress(), 
                               m.getEmail(), m.getSkype(), m.getVk(), m.getOk(), m.getTwit());
    }

    @Override
    public RcMemberDto createMember(RcMemberDto memberDto) {
        RcMember member = new RcMember(memberDto.getAnnotation(), memberDto.getActual_date(), memberDto.getFirst_name(), memberDto.getMiddle_name(),
                                       memberDto.getLast_name(), memberDto.getPhone(), memberDto.getPhone2(), memberDto.getAddress(),
                                       memberDto.getEmail(), memberDto.getSkype(), memberDto.getVk(), memberDto.getOk(), memberDto.getTwit());
        member = repository.save(member);
        memberDto.setMember_id(member.getMember_id());
        return memberDto;
    }

    @Override
    public boolean updateMember(RcMemberDto memberDto) {
        RcMember member = getMemberById(memberDto.getMember_id());
        if (member == null)
            return false;
        member.setAnnotation(memberDto.getAnnotation());
        member.setActual_date(memberDto.getActual_date());
        member.setFirst_name(memberDto.getFirst_name());
        member.setMiddle_name(memberDto.getMiddle_name());
        member.setLast_name(memberDto.getLast_name());
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
        RcMember member = getMemberById(memberDto.getMember_id());
        if (member == null)
            return false;
        repository.delete(member);
        return true;
    }
}
