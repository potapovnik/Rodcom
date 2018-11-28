package ru.relex.itschool.boot.rest.restApi;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.relex.itschool.services.modelDto.RcRoleDto;
import ru.relex.itschool.services.service.IRcRoleService;
import java.util.List;

/**
 * @author Anton
 *
 */

@RestController
@RequestMapping("/roles")
public class RoleController {

    private final IRcRoleService service;
    public RoleController(IRcRoleService roleService) {
        this.service = roleService;
    }

    @GetMapping("/get")
    RcRoleDto getById(int id) {
        RcRoleDto roleDto = service.getById(id);
        if(roleDto == null)
            throw new IllegalArgumentException();

        return roleDto;
    }

    @GetMapping("/get_all")
    List<RcRoleDto> getAll() {
        List<RcRoleDto> rolesDto = service.getAll();
        if (rolesDto == null)
            throw new IllegalArgumentException();
        return rolesDto;
    }

    @PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    RcRoleDto createRole(@RequestBody RcRoleDto roleDto) {
        return service.createRole(roleDto);
    }

    @PutMapping("/update")
    boolean updateRole(@RequestBody RcRoleDto roleDto){
        return service.updateRole(roleDto);
    }

    @DeleteMapping("/delete")
    boolean deleteRole(int id) {
        return service.deleteRole(id);
    }
}
