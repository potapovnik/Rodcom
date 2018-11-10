package ru.relex.itschool.services.service;

import ru.relex.itschool.services.modelDto.RoleDto;

/**
 * @author Anton
 *
 */
public interface IRoleService {
    public RoleDto getById(int id);
    public RoleDto createRole(RoleDto role);
    public RoleDto updateRole(RoleDto role);
    public RoleDto deleteRole(RoleDto role);
}