package ru.relex.itschool.db.entity;

import javax.persistence.*;
import java.util.Calendar;

/**
 * @author : sasha
 *
 * Объявления
 * id - идентификатор
 * school - к какой школе относится
 * type - тип (из rc_notice_type)
 * date - дата создания
 * text - текст
 * agenda - повестка
 */
@Entity
@Table(name = "rc_notice")
public class RcNotice {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "rc_notice_seq_gen")
    @SequenceGenerator(name = "rc_notice_seq_gen", sequenceName = "RC_NOTICE_SEQ", allocationSize = 1)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "school_id", referencedColumnName = "school_id")
    private Rc_school school;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "type_id", referencedColumnName = "id")
    private RcNoticeType type;

    @Column(name = "date")
    private Calendar date;

    private String text;
    private String agenda;

    public RcNotice() {
    }

    public RcNotice(Rc_school school, RcNoticeType type, Calendar date, String text, String agenda) {
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

    public Rc_school getSchool() {
        return school;
    }

    public void setSchool(Rc_school school) {
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
