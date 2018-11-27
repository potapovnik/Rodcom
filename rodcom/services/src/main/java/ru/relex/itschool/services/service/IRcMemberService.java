package ru.relex.itschool.services.service;

import ru.relex.itschool.services.modelDto.RcMemberDto;
import java.util.List;

public interface IRcMemberService {
    RcMemberDto getById(int id);
    RcMemberDto getByEmail(String email);
    RcMemberDto createMember(RcMemberDto member);
    boolean updateMember(RcMemberDto member);
    boolean deleteMember(RcMemberDto member);
    List<RcMemberDto> getAllMembers();
}
