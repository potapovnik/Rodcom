package ru.relex.itschool.boot.rest.restApi;


import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.relex.itschool.services.modelDto.RcEventDto;
import ru.relex.itschool.services.service.IRcEventMemberService;
import ru.relex.itschool.services.service.IRcEventService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/event")
public class RcEventController {
    private final IRcEventService service;
    private final IRcEventMemberService iRcEventMemberService;

    public RcEventController(IRcEventService service, IRcEventMemberService iRcEventMemberService) {
        this.service = service;
        this.iRcEventMemberService = iRcEventMemberService;
    }

    @GetMapping("/")
    RcEventDto getEvent(int id) {
        RcEventDto rcEventDto = service.getById(id);
        if (rcEventDto == null)
            throw new IllegalArgumentException();
        return rcEventDto;
    }

    @PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    RcEventDto createEvent(@RequestBody @Valid RcEventDto rcEventDto) {
        return service.createEvent(rcEventDto);
    }

    @PutMapping(value = "/", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    boolean PutEvent(@RequestBody RcEventDto rcEventDto) {
        return service.updateEvent(rcEventDto);
    }

    @DeleteMapping(value = "/delete", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    boolean deleteEvent(@RequestParam int id) {
        return service.deleteEvent(id);
    }

    @GetMapping("/allEvent")
    List<RcEventDto> getAllEvent() {
        List<RcEventDto> rcEventDto = service.getAllEvent();
        return rcEventDto;
    }

    @GetMapping("/allMyEvent")
    List<RcEventDto> getAllMyEvent(int id) {
        return null;

    }


}
