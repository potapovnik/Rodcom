package ru.relex.itschool.services.mapper;

import java.util.List;
import org.mapstruct.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.relex.itschool.db.entity.RcMember;
import ru.relex.itschool.services.modelDto.RcMemberDto;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class IRcMemberMapper {

  @Autowired
  private PasswordEncoder passwordEncoder;

  @Named("encode")
  protected char[] encode(char[] password) {
    return passwordEncoder.encode(new String(password)).toCharArray();
  }

  @Mappings({
          @Mapping(target = "toMessages", ignore = true),
          @Mapping(target = "fromMessages", ignore = true),
          @Mapping(target = "password", qualifiedByName = "encode", source = "password")
  })

  @Mapping(target = "password", qualifiedByName = "encode", source = "password")
  public abstract RcMember fromDto(RcMemberDto memberDto);

  @Mapping(target = "password", ignore = true)
  public abstract RcMemberDto toDto(RcMember member);

  public abstract List<RcMember> fromDto(List<RcMemberDto> dto);

  public abstract List<RcMemberDto> toDto(List<RcMember> members);
}
