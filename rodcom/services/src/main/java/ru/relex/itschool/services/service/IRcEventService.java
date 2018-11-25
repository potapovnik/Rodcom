package ru.relex.itschool.services.service;

import ru.relex.itschool.services.modelDto.RcEventDto;

import java.util.List;

public interface IRcEventService{
        public RcEventDto getById(int id);
        public RcEventDto createEvent(RcEventDto rcEventDto);
        public List<RcEventDto> getAllEvent();
/*        public List<RcEventDto> getAllMyEvent(int id);*/
        public boolean updateEvent(RcEventDto rcEventDto);
        public boolean deleteEvent(RcEventDto rcEventDto);

}
