package ru.relex.itschool.services.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
//import ru.relex.itschool.db.entity.RcGroup;
import ru.relex.itschool.db.entity.RcGroupMember;
import ru.relex.itschool.services.modelDto.RcGroupMemberDto;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR, componentModel = "spring")
public interface IGroupMemberMapper {
        RcGroupMember fromDto(RcGroupMemberDto rcGroupMemberDto);
        RcGroupMemberDto toDto(RcGroupMember rcGroupMember);
        List<RcGroupMember> fromDto(List<RcGroupMemberDto> rcGroupMemberDtos);
        List <RcGroupMemberDto> toDto(List<RcGroupMember> rcGroupMembers);
}

