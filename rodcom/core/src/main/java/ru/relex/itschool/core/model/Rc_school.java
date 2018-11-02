package ru.relex.itschool.core.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import java.util.Set;
import java.util.HashSet;

@Entity
public class Rc_school {
	
	private int    school_id;
	private String school_name;
	private Set<Rc_group> groups = new HashSet<Rc_group>();

	public Rc_school() {
	}
	

	public Rc_school(String school_name) {
		super();
		this.school_name = school_name;
	}


	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="rc_school_seq_gen")
	@SequenceGenerator(name="rc_school_seq_gen", sequenceName="RC_SCHOOL_SEQ", allocationSize = 1)
	public int getSchool_id() {
		return school_id;
	}

	public void setSchool_id(int id) {
		this.school_id = id;
	}

	public String getSchool_name() {
		return school_name;
	}

	public void setSchool_name(String s) {
		this.school_name = s;
	}

        @OneToMany(mappedBy = "school")
        public Set<Rc_group> getGroups() {
            return this.groups;
        }

        public void setGroups(Set<Rc_group> s) {
            this.groups = s;
        }

        public void addGroup(Rc_group g) {
           g.setSchool(this);
           getGroups().add(g);
        }

        public void removeGroup(Rc_group g) {
           getGroups().remove(g);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Rc_school school = (Rc_school) o;

            if (school_id != school.school_id) 
                return false;
            if (school_name != null ? !school_name.equals(school.school_name) : school.school_name != null) 
                return false;
            return true;
        }

        @Override
        public int hashCode() {
            int result = school_id;
            result = 31 * result + (school_name != null ? school_name.hashCode() : 0);
            return result;
        }
}