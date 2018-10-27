package ru.relex.itschool.core.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Rc_school {
	
	private Long school_id;
	private String school_name;

	public Rc_school() {
	}
	

	public Rc_school(String school_name) {
		super();
		this.school_name = school_name;
	}


	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="rc_school_seq_gen")
	@SequenceGenerator(name="rc_school_seq_gen", sequenceName="RC_SCHOOL_SEQ", allocationSize = 1)
	public Long getSchool_Id() {
		return school_id;
	}

	public void setSchool_Id(Long id) {
		this.school_id = id;
	}

	public String getSchool_Name() {
		return school_name;
	}

	public void setSchool_Name(String name) {
		this.school_name = name;
	}

}