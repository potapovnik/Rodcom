package ru.relex.itschool.boot.rest.restApi;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.relex.itschool.db.entity.RcGroup;
import ru.relex.itschool.db.entity.RcSchool;
import ru.relex.itschool.services.modelDto.GroupDto;
import ru.relex.itschool.services.service.IGroupService;

/**
 * @author Anton
 *
 */

@RestController
@RequestMapping("/group")
public class GroupController {


    private final IGroupService service;
    public GroupController(IGroupService service) {
        this.service = service;
    }

    @GetMapping(value = "/{id}")
    GroupDto getById(@PathVariable("id") int id){
        GroupDto rcGroup = service.getById(id);
        if (rcGroup == null)
            return null;
        return rcGroup;
    }

    @PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    GroupDto create(GroupDto groupDto) {
        return service.createGroup(groupDto);
    }

}
