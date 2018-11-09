package ru.relex.itschool.services.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.relex.itschool.db.entity.RcGroup;
import ru.relex.itschool.db.repository.IGroupRepository;
import ru.relex.itschool.services.modelDto.GroupDto;
import ru.relex.itschool.services.service.IGroupService;

import java.util.Optional;

/**
 * @author Anton
 *
 */

@Service
public class GroupServiceImpl implements IGroupService {

    @Autowired
    IGroupRepository groupRepository;


    @Override
    public GroupDto getById(int id) {
        Optional<RcGroup> group = groupRepository.findById(id);

        if(group.isPresent())
            return toDTO(groupRepository.getOne(id));

        return null;
    }

    @Override
    public GroupDto createGroup(GroupDto group) {
        RcGroup newGroup = fromDTO(group);
        groupRepository.save(newGroup);

        return toDTO(newGroup);
    }

    @Override
    public boolean updateGroup(GroupDto group) {
        RcGroup rcGroup = groupRepository.getOne(group.getGroupId());
        if(rcGroup == null)
            return false;

        rcGroup = fromDTO(group);
        rcGroup.setGroupId(group.getGroupId());
        groupRepository.save(rcGroup);

        return true;
    }

    @Override
    public boolean deleteGroup(GroupDto group) {
        RcGroup rcGroup = groupRepository.getOne(group.getGroupId());
        if(rcGroup == null)
            return false;

        groupRepository.delete(rcGroup);

        return true;
    }


    public RcGroup fromDTO(GroupDto group) {
        RcGroup rcGroup = new RcGroup();

        //rcGroup.setGroupId();
        rcGroup.setEnabled(group.getEnabled());
        rcGroup.setGroupDesc(group.getGroupDesc());
        rcGroup.setGroupName(group.getGroupName());
        rcGroup.setGroupType(group.getGroupType());
        rcGroup.setMessages(group.getMessages());
        rcGroup.setSchool(group.getSchool());

        return rcGroup;
    }
    public GroupDto toDTO(RcGroup rcGroup) {
        GroupDto group = new GroupDto();

        group.setGroupId(rcGroup.getGroupId());
        group.setEnabled(rcGroup.getEnabled());
        group.setGroupDesc(rcGroup.getGroupDesc());
        group.setGroupName(rcGroup.getGroupName());
        group.setGroupType(rcGroup.getGroupType());
        group.setMessages(rcGroup.getMessages());
        group.setSchool(rcGroup.getSchool());

        return group;
    }
}
