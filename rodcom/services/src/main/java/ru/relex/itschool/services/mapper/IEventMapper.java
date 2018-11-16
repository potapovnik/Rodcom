package ru.relex.itschool.services.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import ru.relex.itschool.db.entity.RcEvent;
import ru.relex.itschool.services.modelDto.RcEventDto;

@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR, componentModel = "spring")
public interface IEventMapper {
    RcEvent fromDto(RcEventDto rcEventDto);
    RcEventDto toDto(RcEvent rcEvent);
}
