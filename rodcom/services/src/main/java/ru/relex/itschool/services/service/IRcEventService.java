package ru.relex.itschool.services.service;

import ru.relex.itschool.services.modelDto.RcEventDto;
import ru.relex.itschool.services.modelDto.RcMemberDto;

public interface IRcEventService{
        public RcEventDto getById(int id);
        public RcEventDto createMember(RcEventDto rcEventDto);
        public boolean updateMember(RcEventDto rcEventDto);
        public boolean deleteMember(RcEventDto rcEventDto);
}
