package ru.relex.itschool.services.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.relex.itschool.db.entity.RcRole;
import ru.relex.itschool.db.repository.IRoleRepository;
import ru.relex.itschool.services.modelDto.RoleDto;
import ru.relex.itschool.services.service.IRoleService;

import java.util.Optional;

/**
 * @author Anton
 *
 */

@Service
public class RoleServiceImpl implements IRoleService {

    @Autowired
    IRoleRepository roleRepository;


    @Override
    public RoleDto getById(int id) {
        Optional<RcRole> roleOptional = roleRepository.findById(id);
        if (roleOptional.isEmpty()) {
            return null;
        }
        RcRole role = roleOptional.get();

        return toDTO(role);
    }

    @Override
    public RoleDto createRole(RoleDto role) {
        RcRole newRole = fromDTO(role);
        newRole = roleRepository.save(newRole);


        role.setRoleId(newRole.getRoleId());
        return role;
    }

    @Override
    public RoleDto updateRole(RoleDto role) {
        RcRole rcRole = roleRepository.getOne(role.getRoleId());
        if(rcRole == null)
            return null;

        rcRole = fromDTO(role);
        rcRole.setRoleId(role.getRoleId());
        rcRole = roleRepository.save(rcRole);

        return toDTO(rcRole);
    }

    @Override
    public RoleDto deleteRole(RoleDto role) {
        RcRole rcRole = roleRepository.getOne(role.getRoleId());
        if(rcRole == null)
            return null;

        roleRepository.delete(rcRole);

        return toDTO(rcRole);
    }

    public RcRole fromDTO(RoleDto roleDto) {
        RcRole rcRole = new RcRole();

        rcRole.setRoleName(roleDto.getRoleName());

        return rcRole;
    }
    public RoleDto toDTO(RcRole rcRole) {
        RoleDto roleDto = new RoleDto();

        roleDto.setRoleId(rcRole.getRoleId());
        roleDto.setRoleName(rcRole.getRoleName());

        return roleDto;
    }
}
