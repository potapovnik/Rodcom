package ru.relex.itschool.services.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.relex.itschool.db.entity.RcGroup;
import ru.relex.itschool.db.repository.IGroupRepository;
import ru.relex.itschool.db.repository.IRcSchoolRepository;
import ru.relex.itschool.services.mapper.IGroupMapper;
import ru.relex.itschool.services.modelDto.GroupDto;
import ru.relex.itschool.services.service.IGroupService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author Anton
 *
 */

@Service
public class GroupServiceImpl implements IGroupService {

    private final IGroupRepository groupRepository;
    private final IRcSchoolRepository schoolRepository;
    private final IGroupMapper groupMapper;

    @Autowired
    public GroupServiceImpl(IGroupRepository groupRepository,
                            IRcSchoolRepository schoolRepository, IGroupMapper groupMapper) {
        this.groupRepository = groupRepository;
        this.schoolRepository = schoolRepository;
        this.groupMapper = groupMapper;
    }

    // Ace not tested
    public RcGroup getGroupById(int id) {
        Optional<RcGroup> groupOptional = groupRepository.findById(id);
        if (!groupOptional.isPresent())
            return null;
        return groupOptional.get();
    }

    @Override
    public GroupDto getById(int id) {
        Optional<RcGroup> group = groupRepository.findById(id);

        if(group.isPresent())
            return groupToDTO(groupRepository.getOne(id));

        return null;
    }

    @Override
    public GroupDto createGroup(GroupDto group) {
        RcGroup newGroup = groupFromDTO(group);
        groupRepository.save(newGroup);

        return groupToDTO(newGroup);
    }

    @Override
    public GroupDto updateGroup(GroupDto group) {
        RcGroup rcGroup = groupRepository.getOne(group.getGroupId());
        if(rcGroup == null)
            return null;

        rcGroup = groupFromDTO(group);
        rcGroup.setGroupId(group.getGroupId());
        rcGroup = groupRepository.save(rcGroup);

        return groupToDTO(rcGroup);
    }

    @Override
    public GroupDto deleteGroup(GroupDto group) {
       return deleteGroup(group.getGroupId());
    }

    @Override
    public GroupDto deleteGroup(int id) {
        RcGroup rcGroup = groupRepository.getOne(id);
        if(rcGroup == null)
            return null;

        groupRepository.delete(rcGroup);

        //не уверен, что здесь понадобится возвращать что-то кроме null, но тут небольшая ошибка была
        return null;
    }

    @Override
    public List<GroupDto> getAll() {
        List<RcGroup> list = groupRepository.findAll();
        List<GroupDto> result = new ArrayList<>();

        for (RcGroup group : list) {
            result.add(groupToDTO(group));
        }
        return result;
    }


    public RcGroup groupFromDTO(GroupDto group) {
        RcGroup rcGroup = groupMapper.fromDto(group);
        rcGroup.setSchool(schoolRepository.getOne(group.getSchoolId()));

        return rcGroup;
    }
    public GroupDto groupToDTO(RcGroup rcGroup) {
        GroupDto group = groupMapper.toDto(rcGroup);

        return group;
    }
}
