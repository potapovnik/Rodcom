package ru.relex.itschool.services.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.relex.itschool.db.entity.RcGroup;
import ru.relex.itschool.db.repository.IGroupRepository;
import ru.relex.itschool.db.repository.IRcSchoolRepository;
import ru.relex.itschool.services.modelDto.GroupDto;
import ru.relex.itschool.services.service.IGroupService;

import java.util.Optional;

/**
 * @author Anton
 *
 */

@Service
public class GroupServiceImpl implements IGroupService {

    private final IGroupRepository groupRepository;
    private final IRcSchoolRepository schoolRepository;

    @Autowired
    public GroupServiceImpl(IGroupRepository groupRepository,
                            IRcSchoolRepository schoolRepository) {
        this.groupRepository = groupRepository;
        this.schoolRepository = schoolRepository;
    }


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
    public GroupDto updateGroup(GroupDto group) {
        RcGroup rcGroup = groupRepository.getOne(group.getGroupId());
        if(rcGroup == null)
            return null;

        rcGroup = fromDTO(group);
        rcGroup.setGroupId(group.getGroupId());
        rcGroup = groupRepository.save(rcGroup);

        return toDTO(rcGroup);
    }

    @Override
    public GroupDto deleteGroup(GroupDto group) {
        RcGroup rcGroup = groupRepository.getOne(group.getGroupId());
        if(rcGroup == null)
            return null;

        groupRepository.delete(rcGroup);

        return toDTO(rcGroup);
    }


    public RcGroup fromDTO(GroupDto group) {
        RcGroup rcGroup = new RcGroup();

//        rcGroup.setGroupId();
        rcGroup.setEnabled(group.getEnabled());
        rcGroup.setGroupDesc(group.getGroupDesc());
        rcGroup.setGroupName(group.getGroupName());
        rcGroup.setGroupType(group.getGroupType());
//        rcGroup.setMessages(group.getMessages());
        rcGroup.setSchool(schoolRepository.getOne(group.getSchoolId()));

        return rcGroup;
    }
    public GroupDto toDTO(RcGroup rcGroup) {
        GroupDto group = new GroupDto();

        group.setGroupId(rcGroup.getGroupId());
        group.setEnabled(rcGroup.getEnabled());
        group.setGroupDesc(rcGroup.getGroupDesc());
        group.setGroupName(rcGroup.getGroupName());
        group.setGroupType(rcGroup.getGroupType());
//        group.setMessages(rcGroup.getMessages());
        group.setSchoolId(rcGroup.getSchool().getSchool_id());

        return group;
    }
}
