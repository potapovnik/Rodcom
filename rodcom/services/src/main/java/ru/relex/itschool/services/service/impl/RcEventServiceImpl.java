package ru.relex.itschool.services.service.impl;

import org.springframework.stereotype.Service;
import ru.relex.itschool.db.entity.RcEvent;
import ru.relex.itschool.db.repository.IRcEventMemberRepository;
import ru.relex.itschool.db.repository.IRcEventRepository;
import ru.relex.itschool.services.mapper.IEventMapper;
import ru.relex.itschool.services.mapper.IRcMemberMapper;
import ru.relex.itschool.services.modelDto.RcEventDto;
import ru.relex.itschool.services.modelDto.RcMemberDto;
import ru.relex.itschool.services.service.IRcEventService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RcEventServiceImpl implements IRcEventService {
    private final IRcEventRepository repository;
    private final IEventMapper mapper;
    private final IRcMemberMapper memberMapper;
    private final RcEventMemberServiceImpl serviceEventMember;

    public RcEventServiceImpl(IRcEventRepository repository, IEventMapper mapper, IRcEventMemberRepository iRcEventMemberRepository, IRcMemberMapper memberMapper, RcEventMemberServiceImpl service) {
        this.repository = repository;
        this.mapper = mapper;
        this.memberMapper = memberMapper;
        this.serviceEventMember = service;
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
    public List<RcEventDto> getAllEvent() {

        List<RcEvent> rcEvent=repository.findAll();
        List<RcEventDto> rcEventDto=mapper.toDto(rcEvent);
       /* for (int i=0;i<rcEvent.size();i++){
            RcEventDto rcEventDtos=mapper.toDto(rcEvent.get(i));
            List<RcMemberDto> rcMemberDtos=memberMapper.toDto(rcEvent.get(i).getMembers());
            rcEventDtos.setMembers(rcMemberDtos);
            rcEventDto.add(rcEventDtos);
        }*/
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
    public boolean deleteEvent(int id) {
        Optional<RcEvent> rcEventOptional=repository.findById(id);
        if(!rcEventOptional.isPresent()){
            return false;
        }
        repository.delete(rcEventOptional.get());
        return true;
    }
}
