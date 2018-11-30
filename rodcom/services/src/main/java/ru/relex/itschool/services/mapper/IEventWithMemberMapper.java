package ru.relex.itschool.services.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import ru.relex.itschool.db.entity.RcMember;
import ru.relex.itschool.services.modelDto.RcMemberDto;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IEventWithMemberMapper {
    @Mappings({
            @Mapping(target = "toMessages", ignore = true),
            @Mapping(target = "fromMessages", ignore = true),
            @Mapping(target = "password", ignore = true)
    })
    public abstract RcMember fromDto(RcMemberDto memberDto);

    @Mapping(target = "password", ignore = true)
    public abstract RcMemberDto toDto(RcMember member);
}

