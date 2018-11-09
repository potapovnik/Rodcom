package ru.relex.itschool.services.modelDto;

import ru.relex.itschool.db.entity.RcMessage;
import ru.relex.itschool.db.entity.RcSchool;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Anton
 *
 */

public class GroupDto {
    private int    groupId;


    private String groupType;


    private String groupName;


    private String groupDesc;


    private Boolean isEnabled;


    private RcSchool school;
    //если здесь оставлять Rc_School то запрос циклится выдавая по очереди, то группу
    //то школу


    private Set<RcMessage> messages = new HashSet<RcMessage>();



    //groupID
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

    //schoolId
    public RcSchool getSchool() {
        return school;
    }
    public void setSchool(RcSchool schoolId) {
        this.school = schoolId;
    }

    //messages
    public Set<RcMessage> getMessages() {
        return messages;
    }
    public void setMessages(Set<RcMessage> messages) {
        this.messages = messages;
    }
}
