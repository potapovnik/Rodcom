package ru.relex.itschool.core.model;

import java.util.Date;
import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

import java.util.Set;
import java.util.HashSet;

@Entity
public class Rc_member {
	
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
        private Set<Rc_message> to_messages = new HashSet<Rc_message>();
        private Set<Rc_message> from_messages = new HashSet<Rc_message>();
        private Set<Rc_group_member> group_memberSet = new HashSet<>();

	@OneToMany(mappedBy = "member", cascade = CascadeType.ALL, orphanRemoval = true)
	public Set<Rc_group_member> getGroup_memberSet() {
		return group_memberSet;
	}

	public void setGroup_memberSet(Set<Rc_group_member> group_memberSet) {
		this.group_memberSet = group_memberSet;
	}

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

        @OneToMany(mappedBy = "to_member")
        public Set<Rc_message> getTo_messages() {
            return this.to_messages;
        }

        public void setTo_messages(Set<Rc_message> m) {
            this.to_messages = m;
        }

        public void addTo_message(Rc_message m) {
           m.setTo_member(this);
           getTo_messages().add(m);
        }

        public void removeTo_message(Rc_message m) {
           getTo_messages().remove(m);
        }

        @OneToMany(mappedBy = "from_member")
        public Set<Rc_message> getFrom_messages() {
            return this.from_messages;
        }

        public void setFrom_messages(Set<Rc_message> m) {
            this.from_messages = m;
        }

        public void addFrom_message(Rc_message m) {
           m.setFrom_member(this);
           getFrom_messages().add(m);
        }

        public void removeFrom_message(Rc_message m) {
           getFrom_messages().remove(m);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Rc_member member = (Rc_member) o;

            if (member_id != member.member_id) 
                return false;
            if (annotation != null ? !annotation.equals(member.annotation) : member.annotation != null) 
                return false;
            if (actual_date != null ? !actual_date.equals(member.actual_date) : member.actual_date != null) 
                return false;
            if (first_name != null ? !first_name.equals(member.first_name) : member.first_name != null) 
                return false;
            if (middle_name != null ? !middle_name.equals(member.middle_name) : member.middle_name != null) 
                return false;
            if (last_name != null ? !last_name.equals(member.last_name) : member.last_name != null) 
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
            int result = member_id;
            result = 31 * result + (annotation != null ? annotation.hashCode() : 0);
            result = 31 * result + (actual_date != null ? actual_date.hashCode() : 0);
            result = 31 * result + (first_name != null ? first_name.hashCode() : 0);
            result = 31 * result + (middle_name != null ? middle_name.hashCode() : 0);
            result = 31 * result + (last_name != null ? last_name.hashCode() : 0);
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