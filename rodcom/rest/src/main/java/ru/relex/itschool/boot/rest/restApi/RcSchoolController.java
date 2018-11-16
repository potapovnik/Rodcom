package ru.relex.itschool.boot.rest.restApi;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.relex.itschool.services.modelDto.RcSchoolDto;
import ru.relex.itschool.services.service.IRcSchoolService;

import java.util.List;

@RestController
@RequestMapping("/school")
public class RcSchoolController {

    private final IRcSchoolService service;

    public RcSchoolController(IRcSchoolService service) {
        this.service = service;
    }

    @GetMapping("/get")
    RcSchoolDto getById(int id){
        RcSchoolDto schoolDto = service.getById(id);
        if (schoolDto == null)
            throw  new IllegalArgumentException();
        return schoolDto;
    }

    @GetMapping("/get_all")
    List<RcSchoolDto> getAll(){
        List<RcSchoolDto> schoolsDto = service.getAllSchools();
        if (schoolsDto == null)
            throw new IllegalArgumentException();
        return schoolsDto;
    }


    @PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    RcSchoolDto createSchool(@RequestBody RcSchoolDto schoolDto) {
        return service.createSchool(schoolDto);
    }

    @PutMapping("/update")
    boolean updateSchool(@RequestBody RcSchoolDto schoolDto){
        return service.updateSchool(schoolDto);
    }

    @DeleteMapping("/delete")
    boolean deleteSchool(@RequestBody RcSchoolDto schoolDto){
        return service.deleteSchool(schoolDto);
    }
}
