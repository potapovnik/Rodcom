package ru.relex.itschool.services.service;

import ru.relex.itschool.services.modelDto.GroupDto;

/**
 * @author Anton
 *
 */
public interface IGroupService {
    public GroupDto getById(int id);
    public GroupDto createGroup(GroupDto group);
    public boolean updateGroup(GroupDto group);
    public boolean deleteGroup(GroupDto group);
}
