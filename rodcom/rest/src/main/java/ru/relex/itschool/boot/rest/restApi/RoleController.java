package ru.relex.itschool.boot.rest.restApi;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.relex.itschool.services.modelDto.RoleDto;
import ru.relex.itschool.services.service.IRoleService;
import java.util.List;

/**
 * @author Anton
 *
 */

@RestController
@RequestMapping("/roles")
public class RoleController {

    private final IRoleService service;
    public RoleController(IRoleService roleService) {
        this.service = roleService;
    }

    @GetMapping(path = "/{id}")
    RoleDto getRoleById(@PathVariable("id") int id) {

        RoleDto roleDto = service.getById(id);
        if(roleDto == null)
            throw new IllegalArgumentException();

        return roleDto;
    }
    @GetMapping(path = "/all")
    List<RoleDto> getAllRoles() {
        return service.getAll();
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    RoleDto createRole(@RequestBody RoleDto roleDto) {
        return service.createRole(roleDto);
    }

    @PutMapping(path = "/{id}")
    RoleDto updateRole(@PathVariable("id") int id, @RequestBody RoleDto roleDto) {
        roleDto.setRoleId(id);
        return service.updateRole(roleDto);
    }

    @DeleteMapping(path = "/{id}")
    RoleDto deleteRole(@PathVariable("id") int id) {
        return service.deleteRole(id);
    }
}
