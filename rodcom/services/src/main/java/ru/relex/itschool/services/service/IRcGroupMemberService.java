package ru.relex.itschool.services.service;

import ru.relex.itschool.db.entity.RcGroup;
import ru.relex.itschool.services.modelDto.RcGroupMemberDto;

import java.security.PublicKey;
import java.util.List;

public interface IRcGroupMemberService {
    public RcGroupMemberDto getById(int groupMemberId);
    public List<RcGroupMemberDto> getByGroup(int groupId);
    public RcGroupMemberDto createGroupMember(RcGroupMemberDto rcGroupMemberDto);
    public boolean updateGroupMember(RcGroupMemberDto rcGroupMemberDto);
    public boolean deleteGroupMember(RcGroupMemberDto rcGroupMemberDto);
}
