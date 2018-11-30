package ru.relex.itschool.services.service.impl;

import org.springframework.stereotype.Service;
import ru.relex.itschool.db.entity.RcGroupMember;
import ru.relex.itschool.db.entity.RcMember;
import ru.relex.itschool.db.repository.IRcGroupMemberRepository;
import ru.relex.itschool.db.repository.IRcMemberRepository;
import ru.relex.itschool.services.mapper.IGroupMemberMapper;
import ru.relex.itschool.services.modelDto.RcGroupMemberDto;
import ru.relex.itschool.services.service.IRcGroupMemberService;

import java.util.List;
import java.util.Optional;

@Service
public class RcGroupMemberServiceImpl implements IRcGroupMemberService {
    final private IRcGroupMemberRepository repository;
    final private IRcMemberRepository iRcMemberRepository;
    final private IGroupMemberMapper mapper;

    public RcGroupMemberServiceImpl(IRcGroupMemberRepository repository, IRcMemberRepository iRcMemberRepository, IGroupMemberMapper mapper) {
        this.repository = repository;
        this.iRcMemberRepository = iRcMemberRepository;
        this.mapper = mapper;
    }

    @Override
    public RcGroupMemberDto getById(int groupMemberId) {
        Optional<RcGroupMember> rcGroupMemberOptional=repository.findById(groupMemberId);
        if (!rcGroupMemberOptional.isPresent()){
            return null;
        }
        RcGroupMember rEM=rcGroupMemberOptional.get();
        return mapper.toDto(rEM);
    }

    @Override
    public List<RcGroupMemberDto> getByGroup(int groupId) {
        List<RcGroupMember> members = repository.findByGroupId(groupId);
        return mapper.toDto(members);
    }

    @Override
    public RcGroupMemberDto createGroupMember(RcGroupMemberDto rcGroupMemberDto) {
        RcGroupMember rcGroupMember= mapper.fromDto(rcGroupMemberDto);
        rcGroupMember= repository.save(rcGroupMember);
        rcGroupMemberDto.setGroup_member_id(rcGroupMember.getGroup_member_id());
        return rcGroupMemberDto;
    }

    @Override
    public boolean updateGroupMember(RcGroupMemberDto rcGroupMemberDto) {
        Optional<RcGroupMember> rcGroupMemberOptional=repository.findById(rcGroupMemberDto.getGroup_member_id());
        if (!rcGroupMemberOptional.isPresent()){
            return false;
        }
        RcGroupMember rcGroupMember=rcGroupMemberOptional.get();
        rcGroupMember=mapper.fromDto(rcGroupMemberDto);
        repository.save(rcGroupMember);
        return true;
    }

    @Override
    public boolean deleteGroupMember(RcGroupMemberDto rcGroupMemberDto) {
      Optional <RcGroupMember> rcGroupMemberOptional= repository.findById(rcGroupMemberDto.getGroup_member_id());
      if(!rcGroupMemberOptional.isPresent()){
          return false;
      }
      repository.delete(rcGroupMemberOptional.get());
      return true;
    }
}
