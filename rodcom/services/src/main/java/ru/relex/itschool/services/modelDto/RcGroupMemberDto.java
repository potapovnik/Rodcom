package ru.relex.itschool.services.modelDto;

import javax.persistence.*;

public class RcGroupMemberDto {
        private int group_member_id;
        private int groupId;
        private int member_id;
        private int roleId;
        private boolean is_enabled;
        private boolean is_notify;

        public RcGroupMemberDto(){}

        public RcGroupMemberDto(int groupId,int member_id, int roleId,boolean is_enabled,boolean is_notify){

            this.groupId=groupId;
            this.member_id=member_id;
            this.roleId=roleId;
            this.is_enabled=is_enabled;
            this.is_notify=is_notify;
        }
    public RcGroupMemberDto(int group_member_id,int groupId,int member_id, int roleId,boolean is_enabled,boolean is_notify){
        this.group_member_id=group_member_id;
        this.groupId=groupId;
        this.member_id=member_id;
        this.roleId=roleId;
        this.is_enabled=is_enabled;
        this.is_notify=is_notify;
    }

        public int getGroupId(){return groupId;}
        public void setGroupId(int groupId){this.groupId=groupId;}

        public int getMember_id(){return member_id;}
        public void setMember_id(int member_id){this.member_id=member_id;}

        public int getRoleId(){return roleId;}
        public void setRoleId(int roleId){this.roleId=roleId;}

        public boolean isIs_enabled(){return is_enabled;}
        public void setIs_enabled(boolean is_enabled){this.is_enabled=is_enabled;}

        public boolean getIs_notify(){return is_notify;}
        public void setIs_notify(boolean is_notify){this.is_notify=is_notify;}

    public int getGroup_member_id() {
        return group_member_id;
    }

    public void setGroup_member_id(int group_member_id) {
        this.group_member_id = group_member_id;
    }
}
