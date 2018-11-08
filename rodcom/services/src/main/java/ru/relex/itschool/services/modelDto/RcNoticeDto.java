package ru.relex.itschool.services.modelDto;

import ru.relex.itschool.db.entity.RcNoticeType;
import ru.relex.itschool.db.entity.RcSchool;


import java.util.Calendar;

/**
 * @author : sasha
 */
public class RcNoticeDto {
    private Integer id;


    private RcSchool school;


    private RcNoticeType type;


    private Calendar date;

    private String text;
    private String agenda;

    public RcNoticeDto() {
    }

    public RcNoticeDto(RcSchool school, RcNoticeType type, Calendar date, String text, String agenda) {
        this.school = school;
        this.type = type;
        this.date = date;
        this.text = text;
        this.agenda = agenda;
    }

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public RcSchool getSchool() {
        return school;
    }

    public void setSchool(RcSchool school) {
        this.school = school;
    }

    public RcNoticeType getType() {
        return type;
    }

    public void setType(RcNoticeType type) {
        this.type = type;
    }

    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getAgenda() {
        return agenda;
    }

    public void setAgenda(String agenda) {
        this.agenda = agenda;
    }
}
