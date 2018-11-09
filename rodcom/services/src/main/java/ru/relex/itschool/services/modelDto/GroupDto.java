package ru.relex.itschool.services.modelDto;

import ru.relex.itschool.db.entity.Rc_message;
import ru.relex.itschool.db.entity.Rc_school;

import java.util.HashSet;
import java.util.Set;

public class GroupDto {
    private int    groupId;


    private String groupType;


    private String groupName;


    private String groupDesc;


    private Boolean isEnabled;


    private Rc_school school;


    private Set<Rc_message> messages = new HashSet<Rc_message>();



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

    //school
    public Rc_school getSchool() {
        return school;
    }
    public void setSchool(Rc_school school) {
        this.school = school;
    }

    //messages
    public Set<Rc_message> getMessages() {
        return messages;
    }
    public void setMessages(Set<Rc_message> messages) {
        this.messages = messages;
    }
}
