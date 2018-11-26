package ru.relex.itschool.services.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
import ru.relex.itschool.db.entity.RcGroup;
import ru.relex.itschool.services.modelDto.GroupDto;


/**
 * @author Anton
 *
 */

@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR, componentModel = "spring")
public interface IGroupMapper {


    @Mappings({
            @Mapping(target = "groupId", ignore = true),
            @Mapping(target = "school", ignore = true),
            @Mapping(target = "messages", ignore = true)
    })
    RcGroup fromDto(GroupDto groupDto);

    @Mappings({
            @Mapping(source = "school.schoolId", target = "schoolId"),
            @Mapping(target= "messages", ignore = true)
    })
    GroupDto toDto(RcGroup group);


}
