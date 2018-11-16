package ru.relex.itschool.boot.rest.restApi;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.relex.itschool.db.entity.RcGroup;
import ru.relex.itschool.db.entity.RcSchool;
import ru.relex.itschool.services.modelDto.GroupDto;
import ru.relex.itschool.services.service.IGroupService;

import java.util.List;

/**
 * @author Anton
 *
 */

@RestController
@RequestMapping("/groups")
public class GroupController {


    private final IGroupService service;
    public GroupController(IGroupService service) {
        this.service = service;
    }

    @GetMapping(path = "/{id}")
    GroupDto getById(@PathVariable("id") int id){
        GroupDto rcGroup = service.getById(id);
        if (rcGroup == null)
            throw new NullPointerException();

        return rcGroup;
    }

    @GetMapping(path = "/all")
    List<GroupDto> getAll(){
        return service.getAll();
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    GroupDto createGroup(@RequestBody GroupDto groupDto) {
        return service.createGroup(groupDto);
    }

    @PutMapping(path = "/{id}")
    GroupDto updateGroup(@PathVariable("id") int id, @RequestBody GroupDto groupDto) {
        groupDto.setGroupId(id);
        return service.updateGroup(groupDto);
    }

    @DeleteMapping(path = "/{id}")
    GroupDto deleteGroup(@PathVariable("id") int id) {
        return service.deleteGroup(id);
    }

}
