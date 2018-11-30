package ru.relex.itschool.boot.rest.restApi;

import net.bytebuddy.dynamic.scaffold.FieldLocator;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.relex.itschool.services.modelDto.GroupDto;
import ru.relex.itschool.services.modelDto.RcGroupMemberDto;
import ru.relex.itschool.services.service.IRcGroupMemberService;
import java.util.*;

@RestController
@RequestMapping("/groupMember")
public class RcGroupMemberController {
    private final IRcGroupMemberService service;

    public RcGroupMemberController(IRcGroupMemberService service) {
        this.service = service;
    }
    @GetMapping("/")
    RcGroupMemberDto getGroupMember(int groupMemberId){
        RcGroupMemberDto rcGroupMemberDto=service.getById(groupMemberId);
        if (rcGroupMemberDto==null){
            throw new IllegalArgumentException();
        }
        return rcGroupMemberDto;
    }

    @GetMapping("/get_all")
    List<RcGroupMemberDto> getAll(int groupId){
        List<RcGroupMemberDto> memberDtos = service.getByGroup(groupId);
        if (memberDtos == null)
            throw new IllegalArgumentException();
        return memberDtos;
    }
    
    @PostMapping(value = "/",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    RcGroupMemberDto postGroupMember(@RequestBody RcGroupMemberDto rcGroupMemberDto){
        return service.createGroupMember(rcGroupMemberDto);
    }
    @PutMapping(value = "/",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    boolean putGroupMember(@RequestBody RcGroupMemberDto rcGroupMemberDto){
        return service.updateGroupMember(rcGroupMemberDto);
    }
    @DeleteMapping(value = "/",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    boolean deleteGroupMember(@RequestBody RcGroupMemberDto rcGroupMemberDto){
        return service.deleteGroupMember(rcGroupMemberDto);
    }
}
