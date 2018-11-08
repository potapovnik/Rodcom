package ru.relex.itschool.services.modelDto;

import ru.relex.itschool.db.entity.RcMember;
import java.util.*;

public class RcMemberDto {
    private int    member_id;
    private String annotation;
    private Date   actual_date;
    private String first_name;
    private String middle_name;
    private String last_name;
    private String phone;
    private String phone2;
    private String address;
    private String email;
    private String skype;
    private String vk;
    private String ok;
    private String twit;

    public RcMemberDto() {
    }

    public RcMemberDto(String annotation, Date actual_date, String first_name, String middle_name, 
                       String last_name, String phone, String phone2, String address, String email, 
                       String skype, String vk, String ok, String twit) {
    	this.annotation = annotation;
    	this.actual_date = actual_date;
    	this.first_name = first_name;
    	this.middle_name = middle_name;
    	this.last_name = last_name; 
    	this.phone = phone;     
    	this.phone2 = phone2;    
    	this.address = address;   
    	this.email = email;     
    	this.skype = skype;     
    	this.vk = vk;        
    	this.ok = ok;        
    	this.twit = twit;    
    }

    public RcMemberDto(int id, String annotation, Date actual_date, String first_name, String middle_name, 
                       String last_name, String phone, String phone2, String address, String email, 
                       String skype, String vk, String ok, String twit) {
    	this.member_id = id;
    	this.annotation = annotation;
    	this.actual_date = actual_date;
    	this.first_name = first_name;
    	this.middle_name = middle_name;
    	this.last_name = last_name; 
    	this.phone = phone;     
    	this.phone2 = phone2;    
    	this.address = address;   
    	this.email = email;     
    	this.skype = skype;     
    	this.vk = vk;        
    	this.ok = ok;        
    	this.twit = twit;    
    }

    public int getMember_id() {
    	return member_id;
    }
    
    public void setMember_id(int id) {
    	this.member_id = id;
    }
    
    public String getAnnotation() {
    	return annotation;
    }

    public void setAnnotation(String s) {
    	this.annotation = s;
    }

    public Date getActual_date() {
    	return actual_date;
    }

    public void setActual_date(Date d) {
    	this.actual_date = d;
    }

    public String getFirst_name() {
    	return first_name;
    }

    public void setFirst_name(String s) {
    	this.first_name = s;
    }

    public String getMiddle_name() {
    	return middle_name;
    }

    public void setMiddle_name(String s) {
    	this.middle_name = s;
    }

    public String getLast_name() {
    	return last_name;
    }

    public void setLast_name(String s) {
    	this.last_name = s;
    }

    public String getPhone() {
    	return phone;
    }

    public void setPhone(String s) {
    	this.phone = s;
    }

    public String getPhone2() {
    	return phone2;
    }

    public void setPhone2(String s) {
    	this.phone2 = s;
    }

    public String getAddress() {
    	return address;
    }

    public void setAddress(String s) {
    	this.address = s;
    }

    public String getEmail() {
    	return email;
    }

    public void setEmail(String s) {
    	this.email = s;
    }

    public String getSkype() {
    	return skype;
    }

    public void setSkype(String s) {
    	this.skype = s;
    }

    public String getVk() {
    	return vk;
    }

    public void setVk(String s) {
    	this.vk = s;
    }

    public String getOk() {
    	return ok;
    }

    public void setOk(String s) {
    	this.ok = s;
    }

    public void setTwit(String s) {
    	this.twit = s;
    }

    public String getTwit() {
    	return twit;
    }
}
