package ru.relex.itschool.boot.rest.restApi;


import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.relex.itschool.db.entity.RcEventMember;
import ru.relex.itschool.services.modelDto.RcEventDto;
import ru.relex.itschool.services.service.IRcEventService;

import javax.print.attribute.standard.Media;

@RestController
@RequestMapping("/event")
public class RcEventController {
    private final IRcEventService service;

    public RcEventController(IRcEventService service) {
        this.service = service;
    }
    @GetMapping("/")
    RcEventDto getEvent(int id){
        RcEventDto rcEventDto=service.getById(id);
        if (rcEventDto == null)
            throw  new IllegalArgumentException();
        return rcEventDto;
    }
    @PostMapping(value = "/",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    RcEventDto createEvent(@RequestBody RcEventDto rcEventDto){
        return service.createEvent(rcEventDto);
    }
    @PutMapping(value = "/",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    boolean PutEvent(@RequestBody RcEventDto rcEventDto){
        return service.updateEvent(rcEventDto);
    }
    @DeleteMapping(value = "/",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    boolean deleteEvent(@RequestBody RcEventDto rcEventDto){
        return service.deleteEvent(rcEventDto);
    }
}
