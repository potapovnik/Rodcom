package ru.relex.itschool.services.service;

import ru.relex.itschool.services.modelDto.RcEventDto;
import ru.relex.itschool.services.modelDto.RcMemberDto;

public interface IRcEventService{
        public RcEventDto getById(int id);
        public RcEventDto createEvent(RcEventDto rcEventDto);
        public boolean updateEvent(RcEventDto rcEventDto);
        public boolean deleteEvent(RcEventDto rcEventDto);
}
