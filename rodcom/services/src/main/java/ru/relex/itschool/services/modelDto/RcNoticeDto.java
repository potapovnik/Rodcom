package ru.relex.itschool.services.modelDto;

import ru.relex.itschool.db.entity.RcNoticeType;
import java.util.Calendar;

/**
 * @author : sasha
 */
public class RcNoticeDto {
    private int id;


    private int school;

    private int type;


    private Calendar date;

    private String text;
    private String agenda;

    public RcNoticeDto() {
    }

    public RcNoticeDto(int id, int school, int type, Calendar date, String text, String agenda) {
        this.id = id;
        this.school = school;
        this.type = type;
        this.date = date;
        this.text = text;
        this.agenda = agenda;
    }

    public int getId() {
        return id;
    }

    public void setId(java.lang.Integer id) {
        this.id = id;
    }

    public int getSchool() {
        return school;
    }

    public void setSchool(int school) {
        this.school = school;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
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
