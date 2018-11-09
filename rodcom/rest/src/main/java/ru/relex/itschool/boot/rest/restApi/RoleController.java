package ru.relex.itschool.boot.rest.restApi;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.relex.itschool.services.modelDto.RoleDto;
import ru.relex.itschool.services.service.IRoleService;

/**
 * @author Anton
 *
 */

@RestController
@RequestMapping("/role")
public class RoleController {

    private final IRoleService service;
    public RoleController(IRoleService roleService) {
        this.service = roleService;
    }

    @GetMapping(value = "/{id}")
    RoleDto getRoleById(@PathVariable("id") int id) {
        RoleDto roleDto = service.getById(id);
        if(roleDto == null)
            return null;
        return roleDto;
    }

    @PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    RoleDto createRole(@RequestBody RoleDto roleDto) {
        return service.createGroup(roleDto);
    }

    @PutMapping(value = "/update")
    boolean updateRole(@RequestBody RoleDto roleDto) {
        return service.updateGroup(roleDto);
    }

    @DeleteMapping(value = "/delete")
    boolean deleteRole(@RequestBody RoleDto roleDto) {
        return service.deleteGroup(roleDto);
    }
}
