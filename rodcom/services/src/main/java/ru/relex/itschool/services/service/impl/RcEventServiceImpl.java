package ru.relex.itschool.services.service.impl;

import org.springframework.stereotype.Service;
import ru.relex.itschool.db.entity.RcEvent;
import ru.relex.itschool.db.repository.IRcEventRepository;
import ru.relex.itschool.services.mapper.IEventMapper;
import ru.relex.itschool.services.modelDto.RcEventDto;
import ru.relex.itschool.services.service.IRcEventService;

import java.util.Optional;

@Service
public class RcEventServiceImpl implements IRcEventService {
    private final IRcEventRepository repository;
    private final IEventMapper mapper;

    public RcEventServiceImpl(IRcEventRepository repository, IEventMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public RcEventDto getById(int id) {
       Optional <RcEvent> rcEvent=repository.findById(id);
        if (!rcEvent.isPresent()){
            return null;
        }
        RcEvent ev=rcEvent.get();
        return mapper.toDto(ev);
    }

    @Override
    public RcEventDto createEvent(RcEventDto rcEventDto) {
        RcEvent rcEvent=mapper.fromDto(rcEventDto);
        rcEvent=repository.save(rcEvent);
        rcEventDto.setEvent_id(rcEvent.getEvent_id());
        return rcEventDto;
    }

    @Override
    public boolean updateEvent(RcEventDto rcEventDto) {
        Optional<RcEvent> rcEventOptional=repository.findById(rcEventDto.getEvent_id());
        if (!rcEventOptional.isPresent()){return false;}
        RcEvent rcEvent=rcEventOptional.get();
        rcEvent=mapper.fromDto(rcEventDto);
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
