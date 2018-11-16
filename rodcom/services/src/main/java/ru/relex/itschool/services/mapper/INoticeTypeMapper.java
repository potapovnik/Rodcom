package ru.relex.itschool.services.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import ru.relex.itschool.db.entity.RcNoticeType;
import ru.relex.itschool.services.modelDto.RcNoticeTypeDto;

/**
 * @author : sasha
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR, componentModel = "spring")
public interface INoticeTypeMapper {

    @Mapping(target = "notices", ignore = true)
    RcNoticeType fromDto (RcNoticeTypeDto noticeTypeDto);

    RcNoticeTypeDto toDto (RcNoticeType noticeType);
}
