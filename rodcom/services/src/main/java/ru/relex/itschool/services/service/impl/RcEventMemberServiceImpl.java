package ru.relex.itschool.services.service.impl;

import org.springframework.stereotype.Service;
import ru.relex.itschool.db.entity.RcEvent;
import ru.relex.itschool.db.entity.RcEventMember;
import ru.relex.itschool.db.repository.IRcEventMemberRepository;
import ru.relex.itschool.db.repository.IRcMemberRepository;
import ru.relex.itschool.services.mapper.IEventMapper;
import ru.relex.itschool.services.mapper.IEventMemberMapper;
import ru.relex.itschool.services.modelDto.RcEventDto;
import ru.relex.itschool.services.modelDto.RcEventMemberDto;
import ru.relex.itschool.services.service.IRcEventMemberService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RcEventMemberServiceImpl implements IRcEventMemberService {
    final private IRcEventMemberRepository repository;
    final private IRcMemberRepository iRcMemberRepository;
    final private IEventMemberMapper mapper;
    final private IEventMapper iEventMapper;

    public RcEventMemberServiceImpl(IRcEventMemberRepository repository, IRcMemberRepository iRcMemberRepository, IEventMemberMapper mapper, IEventMapper iEventMapper) {
        this.repository = repository;
        this.iRcMemberRepository = iRcMemberRepository;
        this.mapper = mapper;
        this.iEventMapper = iEventMapper;
    }

    @Override
    public RcEventMemberDto getById(int id) {
        Optional<RcEventMember> rcEventMemberOptional=repository.findById(id);
        if (!rcEventMemberOptional.isPresent()){
            return null;
        }
        RcEventMember rEM=rcEventMemberOptional.get();
        return mapper.toDto(rEM);
    }

    @Override
    public RcEventMemberDto createEventMember(int id, RcEventDto rcEventDto) {
            RcEventMember rcEventMember = new RcEventMember();
            RcEvent rcEvent= iEventMapper.fromDto(rcEventDto);
            rcEventMember.setEvent_id(rcEvent.getEvent_id());
            rcEventMember.setMember_id(id);
            rcEventMember.setRole_id(1);
            rcEventMember.setIs_enabled(false);
            rcEventMember.setIs_notify(false);
                    repository.save(rcEventMember);
                    return mapper.toDto(rcEventMember);
    }


    @Override
    public boolean updateEventMember(RcEventMemberDto rcEventMemberDto) {
        Optional<RcEventMember> rcEventMemberOptional=repository.findById(rcEventMemberDto.getEvent_member_id());
        if (!rcEventMemberOptional.isPresent()){
            return false;
        }
        RcEventMember rcEventMember=rcEventMemberOptional.get();
        rcEventMember=mapper.fromDto(rcEventMemberDto);
        repository.save(rcEventMember);
        return true;
    }

    @Override
    public boolean deleteEventMember(RcEventMemberDto rcEventMemberDto) {
      Optional <RcEventMember> rcEventMemberOptional= repository.findById(rcEventMemberDto.getEvent_member_id());
      if(!rcEventMemberOptional.isPresent()){
          return false;
      }
      repository.delete(rcEventMemberOptional.get());
      return true;
    }

    @Override
    public boolean DeleteByIdUserAndEvent(int idUser, int idEvent) {
        List<RcEventMember> rcEventMembers=repository.findAll();
        RcEventMember rcEventMembersDop=new RcEventMember();
        for (int i=0;i<rcEventMembers.size();i++){
            if (rcEventMembers.get(i).getEvent_id()==idEvent&&rcEventMembers.get(i).getMember_id()==idUser){
                rcEventMembersDop.setEvent_member_id(rcEventMembers.get(i).getEvent_member_id());
                rcEventMembersDop.setIs_notify(rcEventMembers.get(i).getIs_notify());
                rcEventMembersDop.setIs_enabled(rcEventMembers.get(i).getIs_enabled());
            }
        }
        repository.delete(rcEventMembersDop);
        return true;
    }
}
