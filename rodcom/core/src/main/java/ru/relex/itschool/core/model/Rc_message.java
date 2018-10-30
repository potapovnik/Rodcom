package ru.relex.itschool.core.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Rc_message {

    private int   message_id;
    private int   from_member_id;
    private int   to_member_id;
    private int   to_group_id;
    private String message_type;
    private String message;
    private Date   message_time;
    private String message_status;

    public Rc_message() {
    }

    public Rc_message(int from_member_id, int to_member_id, int to_group_id, String message_type,
                     String message, Date message_time, String message_status) {
        super();
        this.from_member_id = from_member_id;
        this.to_member_id = to_member_id;
        this.to_group_id = to_group_id;
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

    public int getFrom_member_id() {
        return from_member_id;
    }

    public void setFrom_member_id(int id) {
        this.from_member_id = id;
    }

    public int getTo_member_id() {
        return to_member_id;
    }

    public void setTo_member_id(int id) {
        this.to_member_id = id;
    }

    public int getTo_group_id() {
        return to_group_id;
    }

    public void setTo_group_id(int id) {
        this.to_group_id = id;
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

}