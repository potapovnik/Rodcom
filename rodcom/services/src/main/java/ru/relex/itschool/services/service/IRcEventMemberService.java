package ru.relex.itschool.services.service;

import ru.relex.itschool.db.entity.RcEvent;
import ru.relex.itschool.services.modelDto.RcEventMemberDto;

import java.security.PublicKey;
import java.util.List;

public interface IRcEventMemberService {
    public RcEventMemberDto getById(int id);
    public RcEventMemberDto createEventMember(RcEventMemberDto rcEventMemberDto);
    public boolean updateEventMember(RcEventMemberDto rcEventMemberDto);
    public boolean deleteEventMember(RcEventMemberDto rcEventMemberDto);
}
