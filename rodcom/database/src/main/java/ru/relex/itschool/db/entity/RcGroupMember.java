package ru.relex.itschool.db.entity;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "rc_group_member", schema = "public", catalog = "postgres")
public class RcGroupMember {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="rc_group_member_seq_gen")
    @SequenceGenerator(name="rc_group_member_seq_gen", sequenceName="RC_GROUP_MEMBER_SEQ", allocationSize = 1)
    private int group_member_id;
    @Column(name = "group_id")
    private int groupId;
    private int member_id;
    @Column(name = "role_id")
    private int roleId;
    private boolean is_enabled;
    private boolean is_notify;

    public RcGroupMember() {
    }

    public RcGroupMember(int groupId, int member_id, int roleId,
                         boolean is_enabled, boolean is_notify) {
        super();
        this.groupId = groupId;
        this.member_id = member_id;
        this.roleId = roleId;
        this.is_enabled = is_enabled;
        this.is_notify = is_notify;
    }

    public int getGroup_member_id() {
        return group_member_id;
    }
    
    public void setGroup_member_id(int id) {
    	this.group_member_id = id;
    }

    public int getGroupId() {
    	return groupId;
    }

    public void setGroupId(int id) {
        this.groupId = id;
    }

    public int getMember_id() {
        return member_id;
    }

    public void setMember_id(int id) {
        this.member_id = id;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int id) {
        this.roleId = id;
    }

    public boolean getIs_enabled() {
        return is_enabled;
    }

    public void setIs_enabled(boolean flag) {
        this.is_enabled = flag;
    }

    public boolean getIs_notify() {
        return is_notify;
    }

    public void setIs_notify(boolean flag) {
        this.is_notify = flag;
    }
}