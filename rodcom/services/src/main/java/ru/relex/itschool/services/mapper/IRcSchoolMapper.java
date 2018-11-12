package ru.relex.itschool.services.mapper;

import java.util.List;
import org.mapstruct.*;
import org.mapstruct.ReportingPolicy;
import ru.relex.itschool.db.entity.RcSchool;
import ru.relex.itschool.services.modelDto.RcSchoolDto;

@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR, componentModel = "spring")
public interface IRcSchoolMapper {

    @Mappings({
            @Mapping(target = "groups", ignore = true),
            @Mapping(target = "notices", ignore = true)
    })
  RcSchool fromDto(RcSchoolDto schoolDto);

  RcSchoolDto toDto(RcSchool school);

  List<RcSchool> fromDto(List<RcSchoolDto> dto);

  List<RcSchoolDto> toDto(List<RcSchool> schools);
}
