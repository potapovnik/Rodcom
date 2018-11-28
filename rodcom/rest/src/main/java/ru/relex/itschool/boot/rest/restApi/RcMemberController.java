package ru.relex.itschool.boot.rest.restApi;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.relex.itschool.services.modelDto.RcMemberDto;
import ru.relex.itschool.services.service.IRcMemberService;
import java.util.*;

@RestController
@RequestMapping("/member")
public class RcMemberController {

    private final IRcMemberService service;

    public RcMemberController(IRcMemberService service) {
        this.service = service;
    }

    @GetMapping("/get")
    RcMemberDto getById(int id){
        RcMemberDto memberDto = service.getById(id);
        if (memberDto == null)
            throw  new IllegalArgumentException();
        return memberDto;
    }

    @GetMapping("/get_by_email")
    RcMemberDto getById(String email){
        RcMemberDto memberDto = service.getByEmail(email);
        if (memberDto == null)
            throw  new IllegalArgumentException();
        return memberDto;
    }

    @GetMapping("/get_all")
    List<RcMemberDto> getAll(){
        List<RcMemberDto> membersDto = service.getAllMembers();
        if (membersDto == null)
            throw new IllegalArgumentException();
        return membersDto;
    }

    @PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    RcMemberDto createMember(@RequestBody RcMemberDto memberDto) {
        return service.createMember(memberDto);
    }

    @PutMapping("/update")
    boolean updateMember(@RequestBody RcMemberDto memberDto){
        return service.updateMember(memberDto);
    }

    @DeleteMapping("/delete")
    boolean deleteMember(int id){
        return service.deleteMember(id);
    }
}
