package ru.relex.itschool.services.service;

import ru.relex.itschool.services.modelDto.RcSchoolDto;

public interface IRcSchoolService {
    public RcSchoolDto getById(int id);
    public RcSchoolDto createSchool(RcSchoolDto school);
    public boolean updateSchool(RcSchoolDto school);
    public boolean deleteSchool(RcSchoolDto school);
}