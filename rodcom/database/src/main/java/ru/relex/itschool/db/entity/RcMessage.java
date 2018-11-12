package ru.relex.itschool.db.entity;

import java.util.Date;
import javax.persistence.*;


@Entity
@Table(name = "rc_message", schema = "public", catalog = "postgres")
public class RcMessage {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="rc_message_seq_gen")
    @SequenceGenerator(name="rc_message_seq_gen", sequenceName="RC_MESSAGE_SEQ", allocationSize = 1)
    private int   message_id;
    private String message_type;
    private String message;
    private Date   message_time;
    private String message_status;

    @ManyToOne
    @JoinColumn(name = "from_member_id")
    private RcMember fromMember;

    @ManyToOne
    @JoinColumn(name = "to_member_id")
    private RcMember toMember;

    @ManyToOne
    @JoinColumn(name = "to_group_id")
    private RcGroup toGroup;
    

    public RcMessage() {
    }

    public RcMessage(String message_type,
                     String message, Date message_time, String message_status) {
        super();
        this.message_type = message_type;
        this.message = message;
        this.message_time = message_time;
        this.message_status = message_status;
    }

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

    public RcGroup getToGroup() {
        return this.toGroup;
    }
 
    public void setToGroup(RcGroup g) {
        this.toGroup = g;
    }

    public RcMember getToMember() {
        return this.toMember;
    }
 
    public void setToMember(RcMember m) {
        this.toMember = m;
    }

    public RcMember getFromMember() {
        return this.fromMember;
    }
 
    public void setFromMember(RcMember m) {
        this.fromMember = m;
    }
}