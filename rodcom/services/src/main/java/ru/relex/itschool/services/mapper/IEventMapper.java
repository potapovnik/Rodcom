package ru.relex.itschool.services.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
import ru.relex.itschool.db.entity.RcEvent;
import ru.relex.itschool.services.modelDto.RcEventDto;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR, componentModel = "spring",uses = IRcMemberMapper.class)
public interface IEventMapper {
    @Mappings({
            @Mapping( target = "members" , ignore = true)

    })
    RcEvent fromDto(RcEventDto rcEventDto);

    @Mappings({
            @Mapping(source = "members", target = "members")
    })
    RcEventDto toDto(RcEvent rcEvent);

    List<RcEvent> fromDto(List<RcEventDto> rcEventDtos);

    List<RcEventDto> toDto(List<RcEvent> rcEventList);

}
