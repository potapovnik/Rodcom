package ru.relex.itschool.db.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "rc_event", schema = "public", catalog = "postgres")
public class RcEvent {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="rc_event_seq_gen")
    @SequenceGenerator(name="rc_event_seq_gen", sequenceName="RC_event_SEQ", allocationSize = 1)
    private int event_id;
    private int school_id;
    private String event_type;
    private String event_name;
    private String event_desc;
    private Date event_time;
    private String event_status;
    @ManyToMany(cascade = { CascadeType.ALL },fetch = FetchType.EAGER)
    @JoinTable(
            name = "rc_event_member",
            joinColumns = { @JoinColumn(name = "event_id") },
            inverseJoinColumns = { @JoinColumn(name = "member_id") }
    )
    private Set<RcMember> members = new HashSet<>();
     public RcEvent(){}

    public RcEvent(int event_id,int school_id,
                   String event_type,String event_name,
                   String event_desc,Date event_time,
                   String event_status,Set<RcMember> members){
        super();
        this.members=members;
        this.event_id=event_id;

        this.school_id=school_id;
        this.event_type=event_type;
        this.event_name=event_name;
        this.event_desc=event_desc;
        this.event_time=event_time;
        this.event_status=event_status;
    }

    public int getEvent_id(){return event_id;}
    public void setEvent_id(int id){this.event_id=id;}


    public int getSchool_id() { return school_id; }
    public void setSchool_id(int school_id){this.school_id=school_id;}

    public String getEvent_name(){return event_name;}
    public void setEvent_name(String event_name){this.event_name=event_name;}


    public String getEvent_desc(){return event_desc;}
    public void setEvent_desc(String event_desc){this.event_desc=event_desc;}


    public String getEvent_type(){return event_type;}
    public void setEvent_type(String event_type){this.event_type=event_type;}

    public Date getEvent_time(){return event_time;}
    public void setEvent_time(Date event_time){this.event_time=event_time;}

    public String getEvent_status(){return event_status;}
    public void setEvent_status(String event_status){this.event_status=event_status;}

    public Set<RcMember> getMembers() {
        return members;
    }

    public void setMembers(Set<RcMember> members) {
        this.members = members;
    }
}
