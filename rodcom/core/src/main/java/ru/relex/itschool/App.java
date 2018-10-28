package ru.relex.itschool;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import java.util.Date;

import ru.relex.itschool.core.model.Rc_group;
import ru.relex.itschool.core.model.Rc_role;
import ru.relex.itschool.core.model.Rc_school;
import ru.relex.itschool.core.model.Rc_member;

/**
 * Hello world!
 *
 */
public class App 
{
	static EntityManagerFactory sessionFactory; 


	protected static void setUp() {
		sessionFactory = Persistence.createEntityManagerFactory("RODCOM");
	}


    public static void main( String[] args )
    {
        setUp();

        EntityManager em = sessionFactory.createEntityManager();
        em.getTransaction().begin();

        Rc_group group = new Rc_group();
        group.setGroupId(2);
        group.setSchoolId(1);
        group.setGroupType("group type");
        group.setGroupName("group name");
        group.setGroupDesc("group description");
        group.setEnabled(true);

        em.persist(group);

        Rc_role role = new Rc_role();
        role.setRoleId(1);
        role.setRoleName("role");

        em.persist(role);

        // Perform finds, execute queries,
        // update entities, etc.
        em.getTransaction().commit();
        em.close();
        sessionFactory.close();
    }
}
