package ru.relex.itschool.db.entity;

/**
  @author : sasha
 */

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Тип объявления
 * id - идентификатор
 * name - название
 *
 * Может быть: информационное, уведомительное о собрании
 */
@Entity
@Table(name = "rc_notice_type")
public class RcNoticeType {

    @Id
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "type")
    private Set<RcNotice> notices = new HashSet<RcNotice>();

    public RcNoticeType() {
    }

    public RcNoticeType(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<RcNotice> getNotices() {
        return notices;
    }

    public void setNotices(Set<RcNotice> notices) {
        this.notices = notices;
    }
}
