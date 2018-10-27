package ru.relex.itschool.core.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.GenericGenerator;


@Entity
public class Rc_member {
	
	private Long   member_id;
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

	public Rc_member() {
	}
	
	
	public Rc_member(String annotation, Date actual_date, String first_name, String middle_name, 
	                 String last_name, String phone, String phone2, String address, String email, 
	                 String skype, String vk, String ok, String twit) {
		super();
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
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="rc_member_seq_gen")
	@SequenceGenerator(name="rc_member_seq_gen", sequenceName="RC_MEMBER_SEQ", allocationSize = 1)
	public Long getMember_Id() {
		return member_id;
	}
	
	public void setMember_Id(Long id) {
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

	public void setPhone2(String s) {
		this.phone2 = s;
	}

	public String getPhone2() {
		return phone2;
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