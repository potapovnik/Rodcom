package ru.relex.itschool.services.modelDto;

import javax.persistence.*;

public class RcEventMemberDto {
        private int event_id;

        private int member_id;
        private int role_id;
        private boolean is_enabled;
        private boolean is_notify;
        private String choice;

        public RcEventMemberDto(){}

        public RcEventMemberDto(int event_id,int member_id, int role_id,boolean is_enabled,boolean is_notify,String choice){

            this.event_id=event_id;
            this.member_id=member_id;
            this.role_id=role_id;
            this.is_enabled=is_enabled;
            this.is_notify=is_notify;
            this.choice=choice;
        }

        public int getEvent_id(){return event_id;}
        public void setEvent_id(int event_id){this.event_id=event_id;}

        public int getMember_id(){return event_id;}
        public void setMember_id(int member_id){this.member_id=member_id;}

        public int getRole_id(){return role_id;}
        public void setRole_id(int role_id){this.role_id=role_id;}

        public boolean isIs_enabled(){return is_enabled;}
        public void setIs_enabled(boolean is_enabled){this.is_enabled=is_enabled;}

        public boolean getIs_notify(){return is_notify;}
        public void setIs_notify(boolean is_notify){this.is_notify=is_notify;}

        public String getChoice(){return choice;}
        public void setChoice(String choice){this.choice=choice;}
}
