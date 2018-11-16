package ru.relex.itschool.db.entity;

import java.util.Date;
import javax.persistence.*;


@Entity
@Table(name = "rc_message", schema = "public", catalog = "postgres")
public class RcMessage {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="rc_message_seq_gen")
    @SequenceGenerator(name="rc_message_seq_gen", sequenceName="RC_MESSAGE_SEQ", allocationSize = 1)
    @Column(name = "message_id")
    private int    messageId;

    @Column(name = "message_type")
    private String messageType;

    private String message;

    @Column(name = "message_time")
    private Date   messageTime;

    @Column(name = "message_status")
    private String messageStatus;

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

    public RcMessage(String messageType,
                     String message, Date messageTime, String messageStatus) {
        super();
        this.messageType = messageType;
        this.message = message;
        this.messageTime = messageTime;
        this.messageStatus = messageStatus;
    }

    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int id) {
        this.messageId = id;
    }

    public void setMessageType(String s) {
        this.messageType = s;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessage(String s) {
        this.message = s;
    }

    public String getMessage() {
        return message;
    }

    public Date getMessageTime() {
        return messageTime;
    }

    public void setMessageTime(Date d) {
        this.messageTime = d;
    }

    public String getMessageStatus() {
        return messageStatus;
    }

    public void setMessageStatus(String s) {
        this.messageStatus = s;
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