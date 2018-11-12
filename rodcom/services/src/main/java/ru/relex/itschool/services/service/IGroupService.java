package ru.relex.itschool.services.service;

import ru.relex.itschool.services.modelDto.GroupDto;

import java.util.List;

/**
 * @author Anton
 *
 */
public interface IGroupService {
    /**
     *
     * @param id - id группы
     * @return {@code GroupDto} объект либо {@code null}, если объекта с таким id нет в системе
     */
    public GroupDto getById(int id);

    /**
     *
     * @param group - объект {@code GroupDto} в виде группы, которую надо создать и добавить в бд
     * @return {@code GroupDto} объект, созданной группы
     */
    public GroupDto createGroup(GroupDto group);

    /**
     *
     * @param group - объект {@code GroupDto} в виде группы, которую надо обновить и сохранить в бд,
     *             (в нем обязательно должен содержаться id)
     * @return {@code GroupDto} объект, обновленной группы
     */
    public GroupDto updateGroup(GroupDto group);

    /**
     *
     * @param group - объект {@code GroupDto} в виде группы, которую надо удалить из бд
     *             (в нем обязательно должен содержаться id)
     * @return {@code GroupDto} объект, удаленной группы
     */
    public GroupDto deleteGroup(GroupDto group);

    /**
     *
     * @param id - id удаляемого объекта Group
     * @return {@code GroupDto} объект удаленной группы
     */
    public GroupDto deleteGroup(int id);

    /**
     *
     * @return {@code List} объект параметризованный объектом {@code GroupDto}, содержащий список всех групп в системе
     */
    public List<GroupDto> getAll();
}
