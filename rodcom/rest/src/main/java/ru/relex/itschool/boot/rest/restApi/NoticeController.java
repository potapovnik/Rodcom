package ru.relex.itschool.boot.rest.restApi;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.relex.itschool.services.modelDto.RcNoticeTypeDto;
import ru.relex.itschool.services.service.INoticeTypeService;

/**
 * @author : sasha
 */
@RestController
@RequestMapping("/notice")
public class NoticeController {

    private final INoticeTypeService noticeTypeService;

    public NoticeController(INoticeTypeService noticeTypeService) {
        this.noticeTypeService = noticeTypeService;
    }

    @GetMapping("/getType")
    RcNoticeTypeDto getById(int id){

        RcNoticeTypeDto rcNoticeTypeDto = noticeTypeService.getById(id);
        if (rcNoticeTypeDto == null)
            throw  new NullPointerException();
        return rcNoticeTypeDto;
    }

    @PostMapping(value = "/CUType", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    RcNoticeTypeDto createNoticeType(@RequestBody RcNoticeTypeDto rcNoticeTypeDto) {
        /*
        * Можно ручками вписать (из InsertToDbInitImpl)
        * RcNoticeType noticeType = new RcNoticeType(1, "информация");
        * и вставить в createUpdateNoticeType, а @RequestBody убрать, но это только для тестирования
        * */
        return noticeTypeService.createUpdateNoticeType(rcNoticeTypeDto);
    }

    @DeleteMapping("/deleteType")
    boolean deleteNoticeType(@RequestBody RcNoticeTypeDto rcNoticeTypeDto){
        return noticeTypeService.deleteNoticeType(rcNoticeTypeDto);
    }
}
