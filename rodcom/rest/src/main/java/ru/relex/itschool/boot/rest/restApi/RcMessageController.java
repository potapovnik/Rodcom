package ru.relex.itschool.boot.rest.restApi;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.relex.itschool.services.modelDto.RcMessageDto;
import ru.relex.itschool.services.service.IRcMessageService;
import java.util.*;

@RestController
@RequestMapping("/message")
public class RcMessageController {

    private final IRcMessageService service;

    public RcMessageController(IRcMessageService service) {
        this.service = service;
    }

    @GetMapping("/get")
    RcMessageDto getById(int id){
        RcMessageDto messageDto = service.getById(id);
        if (messageDto == null)
            throw  new IllegalArgumentException();
        return messageDto;
    }

    @PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    RcMessageDto createMessage(@RequestBody RcMessageDto messageDto) {
        return service.createMessage(messageDto);
    }

    @PutMapping("/update")
    boolean updateMessage(@RequestBody RcMessageDto messageDto){
        return service.updateMessage(messageDto);
    }

    @DeleteMapping("/delete")
    boolean deleteMessage(@RequestBody RcMessageDto messageDto){
        return service.deleteMessage(messageDto);
    }
}
