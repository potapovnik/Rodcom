package ru.relex.itschool.services.service.impl;

import org.springframework.stereotype.Service;
import ru.relex.itschool.db.entity.RcSchool;
import ru.relex.itschool.db.repository.IRcSchoolRepository;
import ru.relex.itschool.services.modelDto.RcSchoolDto;
import ru.relex.itschool.services.service.IRcSchoolService;

import java.util.Optional;

@Service
public class RcSchoolServiceImpl implements IRcSchoolService {

    private final IRcSchoolRepository repository;

    public RcSchoolServiceImpl(IRcSchoolRepository repository) {
        this.repository = repository;
    }

    public RcSchool getSchoolById(int id) {
        Optional<RcSchool> schoolOptional = repository.findById(id);
        if (!schoolOptional.isPresent())
            return null;
        return schoolOptional.get();
    }

    @Override
    public RcSchoolDto getById(int id) {
        RcSchool s = getSchoolById(id);
        if (s == null)
            return null;
        return new RcSchoolDto(s.getSchool_id(), s.getSchool_name());
    }

    @Override
    public RcSchoolDto createSchool(RcSchoolDto schoolDto) {
        RcSchool school = new RcSchool(schoolDto.getSchool_name());
        school = repository.save(school);
        schoolDto.setSchool_id(school.getSchool_id());
        return schoolDto;
    }

    @Override
    public boolean updateSchool(RcSchoolDto schoolDto) {
        RcSchool school = getSchoolById(schoolDto.getSchool_id());
        if (school == null)
            return false;
        school.setSchool_name(schoolDto.getSchool_name());
        school = repository.save(school);
        return true;
    }

    @Override
    public boolean deleteSchool(RcSchoolDto schoolDto) {
        RcSchool school = getSchoolById(schoolDto.getSchool_id());
        if (school == null)
            return false;
        repository.delete(school);
        return true;
    }
}
