package ru.relex.itschool.services.modelDto;

import ru.relex.itschool.db.entity.RcMessage;
import java.util.*;

public class RcMessageDto {

    private int         messageId;
    private String      messageType;
    private String      message;
    private Date        messageTime;
    private String      messageStatus;
    private RcMemberDto fromMember;
    private RcMemberDto toMember;
    private GroupDto    toGroup;

    public RcMessageDto() {
    }

    public RcMessageDto(String messageType,
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

    public GroupDto getToGroup() {
        return this.toGroup;
    }
 
    public void setToGroup(GroupDto g) {
        this.toGroup = g;
    }

    public RcMemberDto getToMember() {
        return this.toMember;
    }
 
    public void setToMember(RcMemberDto m) {
        this.toMember = m;
    }

    public RcMemberDto getFromMember() {
        return this.fromMember;
    }
 
    public void setFromMember(RcMemberDto m) {
        this.fromMember = m;
    }
}
