package ru.relex.itschool.core.model;

import javax.persistence.*;

@Entity
@Table(name = "rc_group", schema = "public", catalog = "postgres")
public class Rc_group {
    private int    groupId;
    private int    schoolId;
    private String groupType;
    private String groupName;
    private String groupDesc;
    private Boolean isEnabled;

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="rc_group_seq_gen")
    @SequenceGenerator(name="rc_group_seq_gen", sequenceName="RC_GROUP_SEQ", allocationSize = 1)
    @Column(name = "group_id")
    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    @Basic
    @Column(name = "school_id")
    public int getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(int schoolId) {
        this.schoolId = schoolId;
    }

    @Basic
    @Column(name = "group_type")
    public String getGroupType() {
        return groupType;
    }

    public void setGroupType(String groupType) {
        this.groupType = groupType;
    }

    @Basic
    @Column(name = "group_name")
    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    @Basic
    @Column(name = "group_desc")
    public String getGroupDesc() {
        return groupDesc;
    }

    public void setGroupDesc(String groupDesc) {
        this.groupDesc = groupDesc;
    }

    @Basic
    @Column(name = "is_enabled")
    public Boolean getEnabled() {
        return isEnabled;
    }

    public void setEnabled(Boolean enabled) {
        isEnabled = enabled;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Rc_group that = (Rc_group) o;

        if (groupId != that.groupId) return false;
        if (schoolId != that.schoolId) return false;
        if (groupType != null ? !groupType.equals(that.groupType) : that.groupType != null) return false;
        if (groupName != null ? !groupName.equals(that.groupName) : that.groupName != null) return false;
        if (groupDesc != null ? !groupDesc.equals(that.groupDesc) : that.groupDesc != null) return false;
        if (isEnabled != null ? !isEnabled.equals(that.isEnabled) : that.isEnabled != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = groupId;
        result = 31 * result + schoolId;
        result = 31 * result + (groupType != null ? groupType.hashCode() : 0);
        result = 31 * result + (groupName != null ? groupName.hashCode() : 0);
        result = 31 * result + (groupDesc != null ? groupDesc.hashCode() : 0);
        result = 31 * result + (isEnabled != null ? isEnabled.hashCode() : 0);
        return result;
    }
}
