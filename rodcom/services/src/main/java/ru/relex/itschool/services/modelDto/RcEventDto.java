package ru.relex.itschool.services.modelDto;

//import ru.relex.itschool.services.validation.Event_name;

import ru.relex.itschool.services.validation.Event_name;

import javax.persistence.*;
import java.util.Date;

public class RcEventDto {
        private int event_id;
        private int group_id;
        private int school_id;
        private String event_type;
   //    @Event_name
        private String event_name;
        private String event_desc;
        private Date event_time;
        private String event_status;

        public RcEventDto(){}

        public RcEventDto(int event_id,int group_id,int school_id,
                       String event_type,String event_name,
                       String event_desc,Date event_time,
                       String event_status){
            super();
            this.event_id=event_id;
            this.group_id=group_id;
            this.school_id=school_id;
            this.event_type=event_type;
            this.event_name=event_name;
            this.event_desc=event_desc;
            this.event_time=event_time;
            this.event_status=event_status;
        }

    public RcEventDto(int group_id,int school_id,
                      String event_type,String event_name,
                      String event_desc,Date event_time,
                      String event_status){
        this.group_id=group_id;
        this.school_id=school_id;
        this.event_type=event_type;
        this.event_name=event_name;
        this.event_desc=event_desc;
        this.event_time=event_time;
        this.event_status=event_status;
    }

        public int getEvent_id(){return event_id;}
        public void setEvent_id(int id){this.event_id=id;}

        public int getGroup_id(){return group_id;}
        public void setGroup_id(int group_id){this.group_id=group_id;}

        public int getSchool_id() { return school_id; }
        public void setSchool_id(int school_id){this.school_id=school_id;}

        public String getEvent_name(){return event_name;}
        public void setEvent_name(String event_name){this.event_name=event_name;}


        public String getEvent_desc(){return event_desc;}
        public void setEvent_desc(String event_desc){this.event_desc=event_desc;}


        public String getEvent_type(){return event_type;}
        public void setEvent_type(String event_type){this.event_type=event_type;}

        public Date getEvent_time(){return event_time;}
        public void setEvent_time(Date event_time){this.event_time=event_time;}

        public String getEvent_status(){return event_status;}
        public void setEvent_status(String event_status){this.event_status=event_status;}

}
