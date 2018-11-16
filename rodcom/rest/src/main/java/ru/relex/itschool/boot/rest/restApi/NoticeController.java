package ru.relex.itschool.boot.rest.restApi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.relex.itschool.services.modelDto.RcNoticeDto;
import ru.relex.itschool.services.modelDto.RcNoticeTypeDto;
import ru.relex.itschool.services.service.INoticeService;
import ru.relex.itschool.services.service.INoticeTypeService;

import java.util.List;

/**
 * @author : sasha
 */
@RestController
@RequestMapping("/notice")
public class NoticeController {

    public static final Logger logger = LoggerFactory.getLogger(NoticeController.class);

    private final INoticeTypeService noticeTypeService;
    private final INoticeService noticeService;

    public NoticeController(INoticeTypeService noticeTypeService, INoticeService noticeService) {
        this.noticeTypeService = noticeTypeService;
        this.noticeService = noticeService;
    }

    @GetMapping("/getNotice/{id}")
    RcNoticeDto getNoticeById(@PathVariable("id") int id){

        RcNoticeDto rcNoticeDto = noticeService.getById(id);
        if (rcNoticeDto == null)
            throw new IllegalArgumentException();
        return rcNoticeDto;
    }

    @GetMapping("/getNotices")
    List<RcNoticeDto> getNotices(){

        List<RcNoticeDto> notices = noticeService.getNotices();
        return notices;
    }

    @PostMapping(value = "/createNotice")
    RcNoticeDto createNotice(@RequestBody RcNoticeDto rcNoticeDto){
        return noticeService.createNotice(rcNoticeDto);
    }

    @PutMapping(value = "/updateNotice")
    RcNoticeDto updateNotice(@RequestBody RcNoticeDto rcNoticeDto){
        return noticeService.updateNotice(rcNoticeDto);
    }
    @DeleteMapping(value = "deleteNotice")
    boolean deleteNotice(@RequestBody RcNoticeDto rcNoticeDto){
        return noticeService.deleteNotice(rcNoticeDto);
    }


    @GetMapping("/getType/{id}")
    RcNoticeTypeDto getNoticeTypeById(@PathVariable("id") int id){

        RcNoticeTypeDto rcNoticeTypeDto = noticeTypeService.getById(id);
        if (rcNoticeTypeDto == null)
            throw  new IllegalArgumentException();
        return rcNoticeTypeDto;
    }

    @PostMapping(value = "/createType", produces = MediaType.APPLICATION_JSON_VALUE)
    RcNoticeTypeDto createNoticeType(@RequestBody RcNoticeTypeDto rcNoticeTypeDto) {

        return noticeTypeService.createUpdateNoticeType(rcNoticeTypeDto);
    }

    @PutMapping(value = "/updateType")
    RcNoticeTypeDto updateNoticeType(@RequestBody RcNoticeTypeDto rcNoticeTypeDto) {

        return noticeTypeService.createUpdateNoticeType(rcNoticeTypeDto);
    }

    @DeleteMapping("/deleteType")
    boolean deleteNoticeType(@RequestBody RcNoticeTypeDto rcNoticeTypeDto){
        return noticeTypeService.deleteNoticeType(rcNoticeTypeDto);
    }
}
