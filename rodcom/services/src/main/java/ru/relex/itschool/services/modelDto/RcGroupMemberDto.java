package ru.relex.itschool.services.modelDto;

import javax.persistence.*;

public class RcGroupMemberDto {
        private int group_member_id;
        private int group_id;
        private int member_id;
        private int role_id;
        private boolean is_enabled;
        private boolean is_notify;

        public RcGroupMemberDto(){}

        public RcGroupMemberDto(int group_id,int member_id, int role_id,boolean is_enabled,boolean is_notify){

            this.group_id=group_id;
            this.member_id=member_id;
            this.role_id=role_id;
            this.is_enabled=is_enabled;
            this.is_notify=is_notify;
        }
    public RcGroupMemberDto(int group_member_id,int group_id,int member_id, int role_id,boolean is_enabled,boolean is_notify){
        this.group_member_id=group_member_id;
        this.group_id=group_id;
        this.member_id=member_id;
        this.role_id=role_id;
        this.is_enabled=is_enabled;
        this.is_notify=is_notify;
    }

        public int getGroup_id(){return group_id;}
        public void setGroup_id(int group_id){this.group_id=group_id;}

        public int getMember_id(){return member_id;}
        public void setMember_id(int member_id){this.member_id=member_id;}

        public int getRole_id(){return role_id;}
        public void setRole_id(int role_id){this.role_id=role_id;}

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
