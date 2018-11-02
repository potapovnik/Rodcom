package ru.relex.itschool.core.model;

import java.util.Date;
import javax.persistence.*;


@Entity
public class Rc_message {

    private int   message_id;
    private String message_type;
    private String message;
    private Date   message_time;
    private String message_status;
    private Rc_member from_member;
    private Rc_member to_member;
    private Rc_group to_group;
    

    public Rc_message() {
    }

    public Rc_message(String message_type,
                     String message, Date message_time, String message_status) {
        super();
        this.message_type = message_type;
        this.message = message;
        this.message_time = message_time;
        this.message_status = message_status;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="rc_message_seq_gen")
    @SequenceGenerator(name="rc_message_seq_gen", sequenceName="RC_MESSAGE_SEQ", allocationSize = 1)
    public int getMessage_id() {
        return message_id;
    }

    public void setMessage_id(int id) {
        this.message_id = id;
    }

    public void setMessage_type(String s) {
        this.message_type = s;
    }

    public String getMessage_type() {
        return message_type;
    }

    public void setMessage(String s) {
        this.message = s;
    }

    public String getMessage() {
        return message;
    }

    public Date getMessage_time() {
        return message_time;
    }

    public void setMessage_time(Date d) {
        this.message_time = d;
    }

    public String getMessage_status() {
        return message_status;
    }

    public void setMessage_status(String s) {
        this.message_status = s;
    }

    @ManyToOne
    @JoinColumn(name = "to_group_id")
    public Rc_group getTo_group() {
        return this.to_group;
    }
 
    public void setTo_group(Rc_group g) {
        this.to_group = g;
    }

    @ManyToOne
    @JoinColumn(name = "to_member_id")
    public Rc_member getTo_member() {
        return this.to_member;
    }
 
    public void setTo_member(Rc_member m) {
        this.to_member = m;
    }

    @ManyToOne
    @JoinColumn(name = "from_member_id")
    public Rc_member getFrom_member() {
        return this.from_member;
    }
 
    public void setFrom_member(Rc_member m) {
        this.from_member = m;
    }
}