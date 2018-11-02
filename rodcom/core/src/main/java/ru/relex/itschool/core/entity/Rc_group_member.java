package ru.relex.itschool.core.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Rc_group_member {

    private int group_member_id;
    private int group_id;
    private int member_id;
    private int role_id;
    private boolean is_enabled;
    private boolean is_notify;

    public Rc_group_member() {
    }

    public Rc_group_member(int group_id, int member_id, int role_id,
                           boolean is_enabled, boolean is_notify) {
        super();
        this.group_id = group_id;
        this.member_id = member_id;
        this.role_id = role_id;
        this.is_enabled = is_enabled;
        this.is_notify = is_notify;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="rc_group_member_seq_gen")
    @SequenceGenerator(name="rc_group_member_seq_gen", sequenceName="RC_GROUP_MEMBER_SEQ", allocationSize = 1)
    public int getGroup_member_id() {
        return group_member_id;
    }
    
    public void setGroup_member_id(int id) {
    	this.group_member_id = id;
    }

    public int getGroup_Id() {
    	return group_id;
    }

    public void setGroup_Id(int id) {
        this.group_id = id;
    }

    public int getMember_Id() {
        return member_id;
    }

    public void setMember_Id(int id) {
        this.member_id = id;
    }

    public int getRole_Id() {
        return role_id;
    }

    public void setRole_Id(int id) {
        this.role_id = id;
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