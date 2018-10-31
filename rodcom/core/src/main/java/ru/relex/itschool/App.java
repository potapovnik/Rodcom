package ru.relex.itschool;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import java.util.Date;

import ru.relex.itschool.core.model.Rc_group_member;
import ru.relex.itschool.core.model.Rc_member;
import ru.relex.itschool.core.model.Rc_school;
import ru.relex.itschool.core.model.Rc_message;
import ru.relex.itschool.core.model.Rc_group;
import ru.relex.itschool.core.model.Rc_role;


/**
 * Hello world!
 *
 */
public class App 
{
	static EntityManagerFactory sessionFactory; 


	protected static void setUp() throws Exception {
		sessionFactory = Persistence.createEntityManagerFactory("RODCOM");
	}


    public static void main( String[] args )
    {
        try {
			setUp();
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
        
        EntityManager em = sessionFactory.createEntityManager();
        em.getTransaction().begin();

        Rc_school school = new Rc_school("МБОУ СОШ №123");
        em.persist(school);
        
        Rc_member member = new Rc_member("Председатель родительского комитета", new Date(), "Иван", "Иванович", "Иванов", "+7-903-111-11-11", "222-22-22", 
        		                         "г. Воронеж, ул. Бахметьева, д. 2б", "ivanov@relex.ru", "ivanovii", "vk_ivanov", "ok_ivanov", "twit_ivanov");
        em.persist(member);

        Rc_role role = new Rc_role();
        role.setRoleName("role");
        em.persist(role);
        
        Rc_group group = new Rc_group();
        group.setSchool(school);
        group.setGroupType("group type");
        group.setGroupName("group name");
        group.setGroupDesc("group description");
        group.setEnabled(true);
        em.persist(group);

        Rc_message message = new Rc_message(member.getMember_id(), member.getMember_id(), group.getGroupId(), 
        		                            "test message", "text for test message", new Date(), "urgent");
        em.persist(message);

        Rc_group_member group_member = new Rc_group_member(group.getGroupId(), member.getMember_id(), role.getRoleId(), true, true);
        em.persist(group_member);

        // Perform finds, execute queries,
        // update entities, etc.
        em.getTransaction().commit();
        em.close();
        sessionFactory.close();
    }
}
