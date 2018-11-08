package ru.relex.itschool.db.entity;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "rc_school", schema = "public", catalog = "postgres")
public class RcSchool {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rc_school_seq_gen")
    @SequenceGenerator(name = "rc_school_seq_gen", sequenceName = "RC_SCHOOL_SEQ", allocationSize = 1)
    private int school_id;
    private String school_name;

    @OneToMany(mappedBy = "school")
    private Set<RcGroup> groups = new HashSet<RcGroup>();

    @OneToMany(mappedBy = "school")
    private Set<RcNotice> notices = new HashSet<RcNotice>();

    public RcSchool() {
    }


    public RcSchool(String school_name) {
        super();
        this.school_name = school_name;
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

    public void setSchool_name(String s) {
        this.school_name = s;
    }

    public Set<RcGroup> getGroups() {
        return this.groups;
    }

    public void setGroups(Set<RcGroup> s) {
        this.groups = s;
    }

    public void addGroup(RcGroup g) {
        g.setSchool(this);
        getGroups().add(g);
    }

    public void removeGroup(RcGroup g) {
        getGroups().remove(g);
    }


    public Set<RcNotice> getNotices() {
        return notices;
    }

    public void setNotices(Set<RcNotice> notices) {
        this.notices = notices;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RcSchool school = (RcSchool) o;

        if (school_id != school.school_id)
            return false;
        if (school_name != null ? !school_name.equals(school.school_name) : school.school_name != null)
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = school_id;
        result = 31 * result + (school_name != null ? school_name.hashCode() : 0);
        return result;
    }
}