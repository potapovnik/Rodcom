package ru.relex.itschool.core.model;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Rc_group_member {

    private int group_member_id;
    private Rc_group group;
    private Rc_member member;
    private Rc_role role;
    private boolean is_enabled;
    private boolean is_notify;

    public Rc_group_member() {
    }

    public Rc_group_member(Rc_group group, Rc_member member, Rc_role role,
                           boolean is_enabled, boolean is_notify) {
        super();
        this.group = group;
        this.member = member;
        this.role = role;
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

    @ManyToOne
    @JoinColumn(name = "group_id")
    public Rc_group getGroup() {
        return group;
    }

    public void setGroup(Rc_group group) {
        this.group = group;
    }

    @ManyToOne
    @JoinColumn(name = "member_id")
    public Rc_member getMember() {
        return member;
    }

    public void setMember(Rc_member member) {
        this.member = member;
    }

    @ManyToOne
    @JoinColumn(name = "role_id")
    public Rc_role getRole() {
        return role;
    }

    public void setRole(Rc_role role) {
        this.role = role;
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