package ru.relex.itschool;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import java.util.Date;

import ru.relex.itschool.core.model.Rc_group_member;
import ru.relex.itschool.core.model.Rc_member;
import ru.relex.itschool.core.model.Rc_school;
import ru.relex.itschool.core.model.Rc_message;


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

        Rc_message message = new Rc_message(new Long(1), new Long(1), new Long(1), "test message", "text for test message", new Date(), "urgent");
        em.persist(message);

        Rc_group_member group_member = new Rc_group_member(new Long(1), new Long(1), new Long(1), true, true);
        em.persist(group_member);

        // Perform finds, execute queries,
        // update entities, etc.
        em.getTransaction().commit();
        em.close();
        sessionFactory.close();
    }
}
