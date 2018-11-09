package ru.relex.itschool.services.modelDto;

import ru.relex.itschool.db.entity.RcSchool;

public class RcSchoolDto {
    private int school_id;
    private String school_name;

    public RcSchoolDto() {
    }

    public RcSchoolDto(String name) {
        this.school_name = name;
    }

    public RcSchoolDto(int id, String name) {
        this.school_id = id;
        this.school_name = name;
    }

    public int getSchool_id() {
        return school_id;
    }

    public void setSchool_id(int id) {
        this.school_id = id;
    }

    public String getSchool_name() {
        return school_name;
    }

    public void setSchool_name(String name) {
        this.school_name = name;
    }
}
