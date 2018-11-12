package ru.relex.itschool.services.service;

import ru.relex.itschool.services.modelDto.RoleDto;

import java.util.List;

/**
 * @author Anton
 *
 */
public interface IRoleService {
    /**
     *
     * @param id - id группы
     * @return RoleDto объект либо {@code null}, если объекта с таким id нет в системе
     */
    public RoleDto getById(int id);

    /**
     *
     * @param role - объект RoleDto в виде роли, которую надо создать и добавить в бд
     * @return RoleDto объект, созданной роли
     */
    public RoleDto createRole(RoleDto role);

    /**
     *
     * @param role - объект RoleDto в виде роли, которую надо обновить и сохранить в бд,
     *             (в нем обязательно должен содержаться id)
     * @return RoleDto объект, обновленной роли
     */
    public RoleDto updateRole(RoleDto role);

    /**
     *
     * @param role - объект RoleDto в виде роли, которую надо удалить из бд
     *             (в нем обязательно должен содержаться id)
     * @return RoleDto объект, удаленной роли
     */
    public RoleDto deleteRole(RoleDto role);

    /**
     *
     * @param id - id удаляемого объекта Role
     * @return RoleDto объект удаленной роли
     */
    public RoleDto deleteRole(int id);

    /**
     *
     * @return List объект параметризованный объектом RoleDto, содержащий список всех ролей в системе
     */
    public List<RoleDto> getAll();
}