package ru.relex.itschool.services.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.data.domain.Sort;
import ru.relex.itschool.db.entity.RcSchool;
import ru.relex.itschool.db.repository.IRcSchoolRepository;
import ru.relex.itschool.services.modelDto.RcSchoolDto;
import ru.relex.itschool.services.service.IRcSchoolService;
import ru.relex.itschool.services.mapper.IRcSchoolMapper;

import java.util.List;
import java.util.Optional;

@Service
public class RcSchoolServiceImpl implements IRcSchoolService {

    private final IRcSchoolRepository repository;
    private final IRcSchoolMapper schoolMapper;

    public RcSchoolServiceImpl(IRcSchoolRepository repository, IRcSchoolMapper schoolMapper) {
        this.repository = repository;
        this.schoolMapper = schoolMapper;
    }

    public RcSchool getSchoolById(int id) {
        Optional<RcSchool> schoolOptional = repository.findById(id);
        if (!schoolOptional.isPresent())
            return null;
        return schoolOptional.get();
    }

    public List<RcSchoolDto> getAllSchools() {
        List<RcSchool> schools = repository.findAll(new Sort(Sort.Direction.ASC, "schoolName"));
        return schoolMapper.toDto(schools);
    }


    @Override
    public RcSchoolDto getById(int id) {
        RcSchool s = getSchoolById(id);
        if (s == null)
            return null;
        return schoolMapper.toDto(s);
    }

    @Override
    public RcSchoolDto createSchool(RcSchoolDto schoolDto) {
        RcSchool school = schoolMapper.fromDto(schoolDto);
        school = repository.save(school);
        schoolDto.setSchoolId(school.getSchoolId());
        return schoolDto;
    }

    @Override
    public boolean updateSchool(RcSchoolDto schoolDto) {
        RcSchool school = getSchoolById(schoolDto.getSchoolId());
        if (school == null)
            return false;
        school.setSchoolName(schoolDto.getSchoolName());
        school = repository.save(school);
        return true;
    }

    @Override
    public boolean deleteSchool(int id) {
        RcSchool school = getSchoolById(id);
        if (school == null)
            return false;
        repository.delete(school);
        return true;
    }
}
