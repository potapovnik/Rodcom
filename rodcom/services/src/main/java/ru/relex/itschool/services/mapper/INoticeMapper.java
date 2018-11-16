package ru.relex.itschool.services.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
import ru.relex.itschool.db.entity.RcNotice;
import ru.relex.itschool.services.modelDto.RcNoticeDto;

/**
 * @author : sasha
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR, componentModel = "spring")
public interface INoticeMapper {

    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "school", ignore = true),
            @Mapping(target = "type", ignore = true)
    })
    RcNotice fromDto(RcNoticeDto noticeDto);

    @Mappings({
            @Mapping(source = "school.schoolId", target = "school"),
            @Mapping(source = "type.id", target = "type")
    })
    RcNoticeDto toDto(RcNotice notice);
}
