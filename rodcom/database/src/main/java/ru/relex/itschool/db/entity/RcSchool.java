package ru.relex.itschool.db.entity;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "rc_school", schema = "public", catalog = "postgres")
public class RcSchool {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rc_school_seq_gen")
    @SequenceGenerator(name = "rc_school_seq_gen", sequenceName = "RC_SCHOOL_SEQ", allocationSize = 1)
    @Column(name = "school_id")
    private int schoolId;

    @Column(name = "school_name")
    private String schoolName;

    @OneToMany(mappedBy = "school", fetch =  FetchType.LAZY)
    private Set<RcGroup> groups = new HashSet<RcGroup>();

    @OneToMany(mappedBy = "school")
    private Set<RcNotice> notices = new HashSet<RcNotice>();

    public RcSchool() {
    }


    public RcSchool(String schoolName) {
        super();
        this.schoolName = schoolName;
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

    public void setSchoolName(String s) {
        this.schoolName = s;
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

        if (schoolId != school.schoolId)
            return false;
        if (schoolName != null ? !schoolName.equals(school.schoolName) : school.schoolName != null)
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = schoolId;
        result = 31 * result + (schoolName != null ? schoolName.hashCode() : 0);
        return result;
    }
}