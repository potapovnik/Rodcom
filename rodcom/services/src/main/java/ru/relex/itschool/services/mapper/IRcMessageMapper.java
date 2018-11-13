package ru.relex.itschool.services.mapper;

import java.util.List;
import org.mapstruct.*;
import org.mapstruct.ReportingPolicy;
import ru.relex.itschool.db.entity.RcMessage;
import ru.relex.itschool.db.entity.RcMember;
import ru.relex.itschool.services.modelDto.RcMessageDto;
import ru.relex.itschool.services.modelDto.RcMemberDto;

@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR, componentModel = "spring")
public interface IRcMessageMapper {

  @Mappings({
            @Mapping(target = "toGroup", ignore = true),
            @Mapping(target = "toMember.toMessages", ignore = true),
            @Mapping(target = "toMember.fromMessages", ignore = true),
            @Mapping(target = "fromMember.toMessages", ignore = true),
            @Mapping(target = "fromMember.fromMessages", ignore = true),
            @Mapping(target = "toGroup.messages", ignore = true)
  })
  RcMessage fromDto(RcMessageDto messageDto);

  @Mappings({
            @Mapping(target = "toGroup.schoolId", ignore = true),
            @Mapping(target= "toGroup.messages", ignore = true)
  })
  RcMessageDto toDto(RcMessage message);

  List<RcMessage> fromDto(List<RcMessageDto> dto);

  List<RcMessageDto> toDto(List<RcMessage> messages);
}
