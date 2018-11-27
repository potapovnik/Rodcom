package ru.relex.itschool.services.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
import ru.relex.itschool.db.entity.RcRole;
import ru.relex.itschool.services.modelDto.RcRoleDto;

/**
 * @author Anton
 *
 */

@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR, componentModel = "spring")
public interface IRoleMapper {

    //IRoleMapper INSTANCE = Mappers.getMapper(IRoleMapper.class);

    @Mappings({
            @Mapping(target = "roleId", ignore = true)
    })
    RcRole fromDto(RcRoleDto roleDto);

    RcRoleDto toDto(RcRole role);
}
