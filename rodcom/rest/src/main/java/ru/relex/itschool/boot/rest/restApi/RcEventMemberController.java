package ru.relex.itschool.boot.rest.restApi;


import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.relex.itschool.services.modelDto.RcEventDto;
import ru.relex.itschool.services.modelDto.RcEventMemberDto;
import ru.relex.itschool.services.service.IRcEventMemberService;
import ru.relex.itschool.services.service.IRcEventService;

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
    @PostMapping(value = "subscribe/{id}",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    RcEventMemberDto postEventMember(@PathVariable("id") int id ,@RequestBody RcEventDto rcEventDto){
        return service.createEventMember(id,rcEventDto);
    }
    @PutMapping(value = "/",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    boolean putEventMember(@RequestBody RcEventMemberDto rcEventMemberDto){
        return service.updateEventMember(rcEventMemberDto);
    }
    @DeleteMapping(value = "/",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    boolean deleteEventMember(@RequestBody RcEventMemberDto rcEventMemberDto){
        return service.deleteEventMember(rcEventMemberDto);
    }
    @DeleteMapping(value = "unsubscribe/",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    boolean deleteEventMemberByID(@RequestParam("idUser") int idUser,@RequestParam("idEvent") int idEvent){
        return service.DeleteByIdUserAndEvent(idUser,idEvent);
    }
}
