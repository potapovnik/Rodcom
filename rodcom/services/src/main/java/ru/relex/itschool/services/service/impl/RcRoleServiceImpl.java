package ru.relex.itschool.services.service.impl;

import org.springframework.stereotype.Service;
import ru.relex.itschool.db.entity.RcRole;
import ru.relex.itschool.db.repository.IRcRoleRepository;
import ru.relex.itschool.services.mapper.IRoleMapper;
import ru.relex.itschool.services.modelDto.RcRoleDto;
import ru.relex.itschool.services.service.IRcRoleService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author Anton
 *
 */

@Service
public class RcRoleServiceImpl implements IRcRoleService {


    private final IRcRoleRepository roleRepository;
    private final IRoleMapper roleMapper;

    public RcRoleServiceImpl(IRcRoleRepository roleRepository, IRoleMapper roleMapper) {
        this.roleRepository = roleRepository;
        this.roleMapper = roleMapper;
    }

    public RcRole getRoleById(int id) {
        Optional<RcRole> roleOptional = roleRepository.findById(id);
        if (!roleOptional.isPresent())
            return null;
        return roleOptional.get();
    }

    @Override
/*
    public RcRoleDto getById(int id) {
        Optional<RcRole> roleOptional = roleRepository.findById(id);
        if (!roleOptional.isPresent()) {
            return null;
        }
        return roleOptional.get();
        return roleToDTO(role);
    }
*/
    public RcRoleDto getById(int id) {
        RcRole r = getRoleById(id);
        if (r == null)
            return null;
        return roleMapper.toDto(r);
    }

    @Override
    public RcRoleDto createRole(RcRoleDto role) {
        RcRole newRole = roleFromDTO(role);
        newRole = roleRepository.save(newRole);


        role.setRoleId(newRole.getRoleId());
        return role;
    }

    @Override
    public boolean updateRole(RcRoleDto roleDto) {
        RcRole role = getRoleById(roleDto.getRoleId());
        if(role == null)
            return false;

        role.setRoleName(roleDto.getRoleName());
        role = roleRepository.save(role);
        return true;
    }

    @Override
    public boolean deleteRole(RcRoleDto role) {
        return deleteRole(role.getRoleId());
    }

    @Override
    public boolean deleteRole(int id) {
        RcRole role = getRoleById(id);
        if(role == null)
            return false;

        roleRepository.delete(role);
        return true;
    }
/*
        RcSchool school = getSchoolById(id);
        if (school == null)
            return false;
        repository.delete(school);
        return true;
*/


    @Override
    public List<RcRoleDto> getAll() {
        List<RcRole> list = roleRepository.findAll();
        List<RcRoleDto> result = new ArrayList<>();

        for (RcRole role : list) {
            result.add(roleToDTO(role));
        }
        return result;
    }

    private RcRole roleFromDTO(RcRoleDto roleDto) {
        return roleMapper.fromDto(roleDto);
    }
    private RcRoleDto roleToDTO(RcRole rcRole) {
        return roleMapper.toDto(rcRole);
    }
}
