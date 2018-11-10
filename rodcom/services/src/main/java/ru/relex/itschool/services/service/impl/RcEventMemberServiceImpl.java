package ru.relex.itschool.services.service.impl;

import org.springframework.stereotype.Service;
import ru.relex.itschool.db.entity.RcEvent;
import ru.relex.itschool.db.entity.RcEventMember;
import ru.relex.itschool.db.repository.IRcEventMemberRepository;
import ru.relex.itschool.services.modelDto.RcEventMemberDto;
import ru.relex.itschool.services.service.IRcEventMemberService;

import java.util.Optional;

@Service
public class RcEventMemberServiceImpl implements IRcEventMemberService {
    final private IRcEventMemberRepository repository;

    public RcEventMemberServiceImpl(IRcEventMemberRepository repository) {
        this.repository = repository;
    }


    @Override
    public RcEventMemberDto getById(int id) {
        Optional<RcEventMember> rcEventMemberOptional=repository.findById(id);
        if (!rcEventMemberOptional.isPresent()){
            return null;
        }
        RcEventMember rEM=rcEventMemberOptional.get();
        return new RcEventMemberDto(rEM.getEvent_id(),rEM.getMember_id(),rEM.getRole_id(),
                rEM.isIs_enabled(),rEM.getIs_notify(),rEM.getChoice());
    }

    @Override
    public RcEventMemberDto createEventMember(RcEventMemberDto rcEventMemberDto) {
        RcEventMember rcEventMember= new RcEventMember(rcEventMemberDto.getEvent_id(),
                rcEventMemberDto.getMember_id(),rcEventMemberDto.getRole_id(),
                rcEventMemberDto.isIs_enabled(),rcEventMemberDto.getIs_notify(),
                rcEventMemberDto.getChoice());
        rcEventMember= repository.save(rcEventMember);
        rcEventMemberDto.setEvent_member_id(rcEventMember.getEvent_member_id());
        return rcEventMemberDto;
    }

    @Override
    public boolean updateEventMember(RcEventMemberDto rcEventMemberDto) {
        Optional<RcEventMember> rcEventMemberOptional=repository.findById(rcEventMemberDto.getEvent_member_id());
        if (!rcEventMemberOptional.isPresent()){
            return false;
        }
        RcEventMember rcEventMember=rcEventMemberOptional.get();
        rcEventMember.setEvent_id(rcEventMemberDto.getEvent_id());
        rcEventMember.setMember_id(rcEventMember.getMember_id());
        rcEventMember.setChoice(rcEventMemberDto.getChoice());
        rcEventMember.setIs_enabled(rcEventMemberDto.isIs_enabled());
        rcEventMember.setIs_notify(rcEventMemberDto.getIs_notify());
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
}
