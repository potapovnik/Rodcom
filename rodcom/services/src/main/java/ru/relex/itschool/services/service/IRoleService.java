package ru.relex.itschool.services.service;

import ru.relex.itschool.services.modelDto.RoleDto;

/**
 * @author Anton
 *
 */
public interface IRoleService {
    public RoleDto getById(int id);
    public RoleDto createGroup(RoleDto role);
    public boolean updateGroup(RoleDto role);
    public boolean deleteGroup(RoleDto role);
}