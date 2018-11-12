package ru.relex.itschool.services.modelDto;

import ru.relex.itschool.db.entity.RcMember;
import java.util.*;

public class RcMemberDto {
    private int    memberId;
    private String annotation;
    private Date   actualDate;
    private String firstName;
    private String middleName;
    private String lastName;
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

    public RcMemberDto(String annotation, Date actualDate, String firstName, String middleName, 
                       String lastName, String phone, String phone2, String address, String email, 
                       String skype, String vk, String ok, String twit) {
    	this.annotation = annotation;
    	this.actualDate = actualDate;
    	this.firstName = firstName;
    	this.middleName = middleName;
    	this.lastName = lastName; 
    	this.phone = phone;     
    	this.phone2 = phone2;    
    	this.address = address;   
    	this.email = email;     
    	this.skype = skype;     
    	this.vk = vk;        
    	this.ok = ok;        
    	this.twit = twit;    
    }

    public RcMemberDto(int id, String annotation, Date actualDate, String firstName, String middleName, 
                       String lastName, String phone, String phone2, String address, String email, 
                       String skype, String vk, String ok, String twit) {
    	this.memberId = id;
    	this.annotation = annotation;
    	this.actualDate = actualDate;
    	this.firstName = firstName;
    	this.middleName = middleName;
    	this.lastName = lastName; 
    	this.phone = phone;     
    	this.phone2 = phone2;    
    	this.address = address;   
    	this.email = email;     
    	this.skype = skype;     
    	this.vk = vk;        
    	this.ok = ok;        
    	this.twit = twit;    
    }

    public int getMemberId() {
    	return memberId;
    }
    
    public void setMemberId(int id) {
    	this.memberId = id;
    }
    
    public String getAnnotation() {
    	return annotation;
    }

    public void setAnnotation(String s) {
    	this.annotation = s;
    }

    public Date getActualDate() {
    	return actualDate;
    }

    public void setActualDate(Date d) {
    	this.actualDate = d;
    }

    public String getFirstName() {
    	return firstName;
    }

    public void setFirstName(String s) {
    	this.firstName = s;
    }

    public String getMiddleName() {
    	return middleName;
    }

    public void setMiddleName(String s) {
    	this.middleName = s;
    }

    public String getLastName() {
    	return lastName;
    }

    public void setLastName(String s) {
    	this.lastName = s;
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
