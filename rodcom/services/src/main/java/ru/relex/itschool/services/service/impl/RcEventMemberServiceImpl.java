package ru.relex.itschool.services.service.impl;

import org.springframework.stereotype.Service;
import ru.relex.itschool.db.entity.RcEventMember;
import ru.relex.itschool.db.entity.RcMember;
import ru.relex.itschool.db.repository.IRcEventMemberRepository;
import ru.relex.itschool.db.repository.IRcMemberRepository;
import ru.relex.itschool.services.mapper.IEventMemberMapper;
import ru.relex.itschool.services.modelDto.RcEventMemberDto;
import ru.relex.itschool.services.service.IRcEventMemberService;

import java.util.List;
import java.util.Optional;

@Service
public class RcEventMemberServiceImpl implements IRcEventMemberService {
    final private IRcEventMemberRepository repository;
    final private IRcMemberRepository iRcMemberRepository;
    final private IEventMemberMapper mapper;

    public RcEventMemberServiceImpl(IRcEventMemberRepository repository, IRcMemberRepository iRcMemberRepository, IEventMemberMapper mapper) {
        this.repository = repository;
        this.iRcMemberRepository = iRcMemberRepository;
        this.mapper = mapper;
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
    public RcEventMemberDto createEventMember(RcEventMemberDto rcEventMemberDto) {
        RcEventMember rcEventMember= mapper.fromDto(rcEventMemberDto);
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
}
