package ru.relex.itschool;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import java.util.Date;

import ru.relex.itschool.core.model.Rc_school;
import ru.relex.itschool.core.model.Rc_member;

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

        // Perform finds, execute queries,
        // update entities, etc.
        em.getTransaction().commit();
        em.close();
        sessionFactory.close();
    }
}
