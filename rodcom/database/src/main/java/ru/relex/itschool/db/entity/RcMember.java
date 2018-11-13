package ru.relex.itschool.db.entity;

import java.util.*;
import javax.persistence.*;

@Entity
@Table(name = "rc_member", schema = "public", catalog = "postgres")
public class RcMember {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="rc_member_seq_gen")
	@SequenceGenerator(name="rc_member_seq_gen", sequenceName="RC_MEMBER_SEQ", allocationSize = 1)
	@Column(name = "member_id")
	private int    memberId;

	private String annotation;

	@Basic
	@Column(name = "actual_date")
	private Date   actualDate;

	@Basic
	@Column(name = "first_name")
	private String firstName;

	@Basic
	@Column(name = "middle_name")
	private String middleName;

	@Basic
	@Column(name = "last_name")
	private String lastName;
	private String phone;
	private String phone2;
	private String address;
	private String email;
	private String skype;
	private String vk;
	private String ok;
	private String twit;

        @OneToMany(mappedBy = "toMember")
        private Set<RcMessage> toMessages = new HashSet<RcMessage>();

        @OneToMany(mappedBy = "fromMember")
        private Set<RcMessage> fromMessages = new HashSet<RcMessage>();

	public RcMember() {
	}
	
	public RcMember(int memberId) {
	    this.memberId = memberId;
	}
	
	public RcMember(String annotation, Date actualDate, String firstName, String middleName, 
	                String lastName, String phone, String phone2, String address, String email, 
	                String skype, String vk, String ok, String twit) {
		super();
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

        public Set<RcMessage> getToMessages() {
            return this.toMessages;
        }

        public void setToMessages(Set<RcMessage> m) {
            this.toMessages = m;
        }

        public void addToMessage(RcMessage m) {
           m.setToMember(this);
           getToMessages().add(m);
        }

        public void removeToMessage(RcMessage m) {
           getToMessages().remove(m);
        }

        public Set<RcMessage> getFromMessages() {
            return this.fromMessages;
        }

        public void setFromMessages(Set<RcMessage> m) {
            this.fromMessages = m;
        }

        public void addFromMessage(RcMessage m) {
           m.setFromMember(this);
           getFromMessages().add(m);
        }

        public void removeFromMessage(RcMessage m) {
           getFromMessages().remove(m);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            RcMember member = (RcMember)o;

            if (memberId != member.memberId) 
                return false;
            if (annotation != null ? !annotation.equals(member.annotation) : member.annotation != null) 
                return false;
            if (actualDate != null ? !actualDate.equals(member.actualDate) : member.actualDate != null) 
                return false;
            if (firstName != null ? !firstName.equals(member.firstName) : member.firstName != null) 
                return false;
            if (middleName != null ? !middleName.equals(member.middleName) : member.middleName != null) 
                return false;
            if (lastName != null ? !lastName.equals(member.lastName) : member.lastName != null) 
                return false;
            if (phone != null ? !phone.equals(member.phone) : member.phone != null) 
                return false;
            if (phone2 != null ? !phone2.equals(member.phone2) : member.phone2 != null) 
                return false;
            if (address != null ? !address.equals(member.address) : member.address != null) 
                return false;
            if (email != null ? !email.equals(member.email) : member.email != null) 
                return false;
            if (skype != null ? !skype.equals(member.skype) : member.skype != null) 
                return false;
            if (vk != null ? !vk.equals(member.vk) : member.vk != null) 
                return false;
            if (ok != null ? !ok.equals(member.ok) : member.ok != null) 
                return false;
            if (twit != null ? !twit.equals(member.twit) : member.twit != null) 
                return false;

            return true;
        }

        @Override
        public int hashCode() {
            int result = memberId;
            result = 31 * result + (annotation != null ? annotation.hashCode() : 0);
            result = 31 * result + (actualDate != null ? actualDate.hashCode() : 0);
            result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
            result = 31 * result + (middleName != null ? middleName.hashCode() : 0);
            result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
            result = 31 * result + (phone != null ? phone.hashCode() : 0);
            result = 31 * result + (phone2 != null ? phone2.hashCode() : 0);
            result = 31 * result + (address != null ? address.hashCode() : 0);
            result = 31 * result + (email != null ? email.hashCode() : 0);
            result = 31 * result + (skype != null ? skype.hashCode() : 0);
            result = 31 * result + (vk != null ? vk.hashCode() : 0);
            result = 31 * result + (ok != null ? ok.hashCode() : 0);
            result = 31 * result + (twit != null ? twit.hashCode() : 0);
            return result;
        }
}