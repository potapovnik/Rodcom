package ru.relex.itschool.services.service;

import ru.relex.itschool.services.modelDto.GroupDto;

/**
 * @author Anton
 *
 */
public interface IGroupService {
    public GroupDto getById(int id);
    public GroupDto createGroup(GroupDto group);
    public GroupDto updateGroup(GroupDto group);
    public GroupDto deleteGroup(GroupDto group);
}
