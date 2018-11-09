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
        return toDTO(roleRepository.getOne(id));
    }

    @Override
    public RoleDto createGroup(RoleDto role) {
        RcRole newRole = fromDTO(role);
        roleRepository.save(newRole);

        return toDTO(newRole);
    }

    @Override
    public boolean updateGroup(RoleDto role) {
        RcRole rcRole = roleRepository.getOne(role.getRoleId());
        if(rcRole == null)
            return false;

        rcRole = fromDTO(role);
        rcRole.setRoleId(role.getRoleId());
        roleRepository.save(rcRole);

        return true;
    }

    @Override
    public boolean deleteGroup(RoleDto role) {
        RcRole rcRole = roleRepository.getOne(role.getRoleId());
        if(rcRole == null)
            return false;

        roleRepository.delete(rcRole);

        return true;
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
