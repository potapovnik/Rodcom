package ru.relex.itschool.services.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import ru.relex.itschool.db.entity.RcEvent;
import ru.relex.itschool.db.entity.RcEventMember;
import ru.relex.itschool.services.modelDto.RcEventMemberDto;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR, componentModel = "spring")
public interface IEventMemberMapper {
        RcEventMember fromDto(RcEventMemberDto rcEventMemberDto);
        RcEventMemberDto toDto(RcEventMember rcEventMember);
        List<RcEventMember> fromDto(List<RcEventMemberDto> rcEventMemberDtos);
        List <RcEventMemberDto> toDto(List<RcEventMember> rcEventMembers);
}

