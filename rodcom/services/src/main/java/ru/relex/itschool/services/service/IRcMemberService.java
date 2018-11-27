package ru.relex.itschool.services.service;

import ru.relex.itschool.services.modelDto.RcMemberDto;
import java.util.List;

public interface IRcMemberService {
    public RcMemberDto getById(int id);
    public RcMemberDto getByEmail(String email);
    public RcMemberDto createMember(RcMemberDto member);
    public boolean updateMember(RcMemberDto member);
    public boolean deleteMember(int id);
    public List<RcMemberDto> getAllMembers();
}
