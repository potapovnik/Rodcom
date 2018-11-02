package ru.relex.itschool;

import ru.relex.itschool.core.DAO.DAOGroup;
import ru.relex.itschool.core.entity.Rc_group;
import ru.relex.itschool.core.entity.Rc_school;
import ru.relex.itschool.core.services.EMFactory;

import javax.persistence.EntityManager;


/**
 * Hello world!
 *
 */
public class App 
{


    public static void main( String[] args )
    {

//        EntityManager em = sessionFactory.createEntityManager();
//        em.getTransaction().begin();
//
//        Rc_school school = new Rc_school("МБОУ СОШ №123");
//        em.persist(school);
//
//        Rc_member member = new Rc_member("Председатель родительского комитета", new Date(), "Иван", "Иванович", "Иванов", "+7-903-111-11-11", "222-22-22",
//        		                         "г. Воронеж, ул. Бахметьева, д. 2б", "ivanov@relex.ru", "ivanovii", "vk_ivanov", "ok_ivanov", "twit_ivanov");
//        em.persist(member);
//
//        Rc_role role = new Rc_role();
//        role.setRoleName("role");
//        em.persist(role);
//
//        Rc_group group = new Rc_group();
//        group.setSchool(school);
//        group.setGroupType("group type");
//        group.setGroupName("group name");
//        group.setGroupDesc("group description");
//        group.setEnabled(true);
//        em.persist(group);
//
//        Rc_message message = new Rc_message("test message", "text for test message", new Date(), "urgent");
//        message.setTo_member(member);
//        message.setFrom_member(member);
//        message.setTo_group(group);
//        em.persist(message);
//
//        Rc_group_member group_member = new Rc_group_member(group.getGroupId(), member.getMember_id(), role.getRoleId(), true, true);
//        em.persist(group_member);
//
//        // Perform finds, execute queries,
//        // update entities, etc.
//        em.getTransaction().commit();
//        em.close();

        DAOGroup daoGroup = new DAOGroup();

        Rc_group myGroup = new Rc_group();

        myGroup.setEnabled(true);
        myGroup.setGroupDesc("dao saved group description");
        myGroup.setGroupName("dao group");
        myGroup.setGroupType("dao");

        //эта часть кода тоже должна использовать DAO
        EntityManager em = EMFactory.getEntityManager();
        Rc_school school = em.find(Rc_school.class, 1);
        em.close();
        //эта часть кода тоже должна использовать DAO

        myGroup.setSchool(school);
        daoGroup.save(myGroup);

        myGroup = daoGroup.findById(2);
        myGroup.setGroupName("NEW NAME FROM DAO");
        daoGroup.update(myGroup);

        myGroup = daoGroup.findById(2);
        System.out.println(myGroup.getGroupName().equals("NEW NAME FROM DAO") );

        daoGroup.delete(myGroup);


    }
}
