package ru.relex.itschool.boot.rest.restApi;


import net.bytebuddy.dynamic.scaffold.FieldLocator;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.relex.itschool.services.modelDto.RcEventDto;
import ru.relex.itschool.services.modelDto.RcEventMemberDto;
import ru.relex.itschool.services.service.IRcEventMemberService;

@RestController
@RequestMapping("/eventMember")
public class RcEventMemberController {
    private final IRcEventMemberService service;

    public RcEventMemberController(IRcEventMemberService service) {
        this.service = service;
    }
    @GetMapping("/")
    RcEventMemberDto getEventMember(int id){
        RcEventMemberDto rcEventMemberDto=service.getById(id);
        if (rcEventMemberDto==null){
            throw new IllegalArgumentException();
        }
        return rcEventMemberDto;
    }
    @PostMapping(value = "/",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    RcEventMemberDto postEventMember(@RequestBody RcEventMemberDto rcEventMemberDto){
        return service.createEventMember(rcEventMemberDto);
    }
    @PutMapping(value = "/",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    boolean putEventMember(@RequestBody RcEventMemberDto rcEventMemberDto){
        return service.updateEventMember(rcEventMemberDto);
    }
    @DeleteMapping(value = "/",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    boolean deleteEventMember(@RequestBody RcEventMemberDto rcEventMemberDto){
        return service.deleteEventMember(rcEventMemberDto);
    }
}
