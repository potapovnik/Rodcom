package ru.relex.itschool.services.service.impl;

import org.springframework.stereotype.Service;
import ru.relex.itschool.db.entity.RcEvent;
import ru.relex.itschool.db.repository.IRcEventRepository;
import ru.relex.itschool.services.modelDto.RcEventDto;
import ru.relex.itschool.services.service.IRcEventService;

import java.util.Optional;

@Service
public class RcEventServiceImpl implements IRcEventService {
    private final IRcEventRepository repository;

    public RcEventServiceImpl(IRcEventRepository repository) {
        this.repository = repository;
    }

    @Override
    public RcEventDto getById(int id) {
       Optional <RcEvent> rcEvent=repository.findById(id);
        if (!rcEvent.isPresent()){
            return null;
        }
        RcEvent ev=rcEvent.get();
        return new RcEventDto(ev.getEvent_id(),ev.getGroup_id(),ev.getSchool_id(),ev.getEvent_type(),
                ev.getEvent_name(),ev.getEvent_desc(),ev.getEvent_time(),ev.getEvent_status());
    }

    @Override
    public RcEventDto createEvent(RcEventDto rcEventDto) {
        RcEvent rcEvent=new RcEvent(rcEventDto.getEvent_id(),rcEventDto.getGroup_id(),
                rcEventDto.getSchool_id(),rcEventDto.getEvent_type(),rcEventDto.getEvent_name(),
                rcEventDto.getEvent_desc(),rcEventDto.getEvent_time(),rcEventDto.getEvent_status());
        rcEvent=repository.save(rcEvent);
        rcEventDto.setEvent_id(rcEvent.getEvent_id());
        return rcEventDto;
    }

    @Override
    public boolean updateEvent(RcEventDto rcEventDto) {
        Optional<RcEvent> rcEventOptional=repository.findById(rcEventDto.getEvent_id());
        if (!rcEventOptional.isPresent()){return false;}
        RcEvent rcEvent=rcEventOptional.get();
        rcEvent.setGroup_id(rcEventDto.getGroup_id());
        rcEvent.setSchool_id(rcEventDto.getSchool_id());
        rcEvent.setEvent_type(rcEventDto.getEvent_type());
        rcEvent.setEvent_name(rcEventDto.getEvent_name());
        rcEvent.setEvent_desc(rcEventDto.getEvent_desc());
        rcEvent.setEvent_time(rcEventDto.getEvent_time());
        rcEvent.setEvent_status(rcEventDto.getEvent_status());
        repository.save(rcEvent);
        return true;
    }

    @Override
    public boolean deleteEvent(RcEventDto rcEventDto) {
        Optional<RcEvent> rcEventOptional=repository.findById(rcEventDto.getEvent_id());
        if(!rcEventOptional.isPresent()){
            return false;
        }
        repository.delete(rcEventOptional.get());
        return true;
    }
}
