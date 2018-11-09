package ru.relex.itschool.db.entity;

import javax.persistence.*;

import java.util.Set;
import java.util.HashSet;

/**
 * @author Anton
 *
 */

@Entity
@Table(name = "rc_group", schema = "public", catalog = "postgres")
public class RcGroup {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="rc_group_seq_gen")
    @SequenceGenerator(name="rc_group_seq_gen", sequenceName="RC_GROUP_SEQ", allocationSize = 1)
    @Column(name = "group_id")
    private int    groupId;

    @Basic
    @Column(name = "group_type")
    private String groupType;

    @Basic
    @Column(name = "group_name")
    private String groupName;

    @Basic
    @Column(name = "group_desc")
    private String groupDesc;

    @Basic
    @Column(name = "is_enabled")
    private Boolean isEnabled;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "school_id")
    private RcSchool school;

    @OneToMany(mappedBy = "to_group")
    private Set<RcMessage> messages = new HashSet<RcMessage>();


    //groupId
    public int getGroupId() {
        return groupId;
    }
    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    //groupType
    public String getGroupType() {
        return groupType;
    }
    public void setGroupType(String groupType) {
        this.groupType = groupType;
    }

    //groupName
    public String getGroupName() {
        return groupName;
    }
    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    //groupDesc
    public String getGroupDesc() {
        return groupDesc;
    }
    public void setGroupDesc(String groupDesc) {
        this.groupDesc = groupDesc;
    }

    //enabled
    public Boolean getEnabled() {
        return isEnabled;
    }
    public void setEnabled(Boolean enabled) {
        isEnabled = enabled;
    }

    //school
    public RcSchool getSchool() {
        return this.school;
    }
    public void setSchool(RcSchool school) {
        this.school = school;
    }

    //messages
    public Set<RcMessage> getMessages() {
        return this.messages;
    }
    public void setMessages(Set<RcMessage> m) {
        this.messages = m;
    }
    public void addMessage(RcMessage m) {
       m.setTo_group(this);
       getMessages().add(m);
    }
    public void removeMessage(RcMessage m) {
       getMessages().remove(m);
    }

    //IDE generated methods
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RcGroup that = (RcGroup) o;

        if (groupId != that.groupId) return false;
        if (groupType != null ? !groupType.equals(that.groupType) : that.groupType != null) return false;
        if (groupName != null ? !groupName.equals(that.groupName) : that.groupName != null) return false;
        if (groupDesc != null ? !groupDesc.equals(that.groupDesc) : that.groupDesc != null) return false;
        if (isEnabled != null ? !isEnabled.equals(that.isEnabled) : that.isEnabled != null) return false;

        return true;
    }
    @Override
    public int hashCode() {
        int result = groupId;
        result = 31 * result + (groupType != null ? groupType.hashCode() : 0);
        result = 31 * result + (groupName != null ? groupName.hashCode() : 0);
        result = 31 * result + (groupDesc != null ? groupDesc.hashCode() : 0);
        result = 31 * result + (isEnabled != null ? isEnabled.hashCode() : 0);
        return result;
    }
}
