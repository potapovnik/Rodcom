package ru.relex.itschool.services.modelDto;

import ru.relex.itschool.db.entity.RcSchool;

public class RcSchoolDto {
    private int schoolId;
    private String schoolName;

    public RcSchoolDto() {
    }

    public RcSchoolDto(String name) {
        this.schoolName = name;
    }

    public RcSchoolDto(int id, String name) {
        this.schoolId = id;
        this.schoolName = name;
    }

    public int getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(int id) {
        this.schoolId = id;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String name) {
        this.schoolName = name;
    }
}
