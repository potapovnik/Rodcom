package ru.relex.itschool.services.service;

import ru.relex.itschool.services.modelDto.RcRoleDto;

import java.util.List;

/**
 * @author Anton
 *
 */
public interface IRcRoleService {
    /**
     *
     * @param id - id роли
     * @return {@code RcRoleDto} объект либо {@code null}, если объекта с таким id нет в системе
     */
    public RcRoleDto getById(int id);

    /**
     *
     * @param role - объект {@code RcRoleDto} в виде роли, которую надо создать и добавить в бд
     * @return {@code RcRoleDto} объект, созданной роли
     */
    public RcRoleDto createRole(RcRoleDto role);

    /**
     *
     * @param role - объект {@code RcRoleDto} в виде роли, которую надо обновить и сохранить в бд,
     *             (в нем обязательно должен содержаться id)
     * @return {@code RcRoleDto} объект, обновленной роли
     */
    public boolean updateRole(RcRoleDto role);

    /**
     *
     * @param role - объект {@code RcRoleDto} в виде роли, которую надо удалить из бд
     *             (в нем обязательно должен содержаться id)
     * @return {@code RcRoleDto} объект, удаленной роли
     */
    public boolean deleteRole(RcRoleDto role);

    /**
     *
     * @param id - id удаляемого объекта Role
     * @return {@code RcRoleDto} объект удаленной роли
     */
    public boolean deleteRole(int id);

    /**
     *
     * @return {@code List} объект параметризованный объектом {@code RcRoleDto}, содержащий список всех ролей в системе
     */
    public List<RcRoleDto> getAll();
}