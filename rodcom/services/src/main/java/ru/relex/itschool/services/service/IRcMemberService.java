package ru.relex.itschool.services.service;

import ru.relex.itschool.services.modelDto.RcMemberDto;
import java.util.*;

public interface IRcMemberService {
    public RcMemberDto getById(int id);
    public RcMemberDto createMember(RcMemberDto school);
    public boolean updateMember(RcMemberDto school);
    public boolean deleteMember(RcMemberDto school);
    public List<RcMemberDto> getAllMembers();
}
