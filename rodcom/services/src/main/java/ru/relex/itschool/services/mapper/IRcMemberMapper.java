package ru.relex.itschool.services.mapper;

import java.util.List;
import org.mapstruct.*;
import org.mapstruct.ReportingPolicy;
import ru.relex.itschool.db.entity.RcMember;
import ru.relex.itschool.services.modelDto.RcMemberDto;

@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR, componentModel = "spring")
public interface IRcMemberMapper {

    @Mappings({
            @Mapping(target = "toMessages", ignore = true),
            @Mapping(target = "fromMessages", ignore = true)
    })
  RcMember fromDto(RcMemberDto memberDto);

  RcMemberDto toDto(RcMember member);

  List<RcMember> fromDto(List<RcMemberDto> dto);

  List<RcMemberDto> toDto(List<RcMember> members);
}
