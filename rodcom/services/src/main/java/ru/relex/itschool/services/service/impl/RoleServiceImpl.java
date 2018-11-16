package ru.relex.itschool.services.service.impl;

import org.springframework.stereotype.Service;
import ru.relex.itschool.db.entity.RcRole;
import ru.relex.itschool.db.repository.IRoleRepository;
import ru.relex.itschool.services.mapper.IRoleMapper;
import ru.relex.itschool.services.modelDto.RoleDto;
import ru.relex.itschool.services.service.IRoleService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author Anton
 *
 */

@Service
public class RoleServiceImpl implements IRoleService {


    private final IRoleRepository roleRepository;
    private final IRoleMapper roleMapper;

    public RoleServiceImpl(IRoleRepository roleRepository, IRoleMapper roleMapper) {
        this.roleRepository = roleRepository;
        this.roleMapper = roleMapper;
    }


    @Override
    public RoleDto getById(int id) {
        Optional<RcRole> roleOptional = roleRepository.findById(id);
        if (!roleOptional.isPresent()) {
            return null;
        }
        RcRole role = roleOptional.get();

        return roleToDTO(role);
    }

    @Override
    public RoleDto createRole(RoleDto role) {
        RcRole newRole = roleFromDTO(role);
        newRole = roleRepository.save(newRole);


        role.setRoleId(newRole.getRoleId());
        return role;
    }

    @Override
    public RoleDto updateRole(RoleDto role) {
        RcRole rcRole = roleRepository.getOne(role.getRoleId());
        if(rcRole == null)
            return null;

        rcRole = roleFromDTO(role);
        rcRole.setRoleId(role.getRoleId());
        rcRole = roleRepository.save(rcRole);

        return roleToDTO(rcRole);
    }

    @Override
    public RoleDto deleteRole(RoleDto role) {
        return deleteRole(role.getRoleId());
    }

    @Override
    public RoleDto deleteRole(int id) {
        RcRole rcRole = roleRepository.getOne(id);
        if(rcRole == null)
            return null;

        roleRepository.delete(rcRole);

        return roleToDTO(rcRole);
    }

    @Override
    public List<RoleDto> getAll() {
        List<RcRole> list = roleRepository.findAll();
        List<RoleDto> result = new ArrayList<>();

        for (RcRole role : list) {
            result.add(roleToDTO(role));
        }
        return result;
    }

    private RcRole roleFromDTO(RoleDto roleDto) {
        return roleMapper.fromDto(roleDto);
    }
    private RoleDto roleToDTO(RcRole rcRole) {
        return roleMapper.toDto(rcRole);
    }
}
