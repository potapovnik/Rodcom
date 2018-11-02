package ru.relex.itschool.core.DAO;

import ru.relex.itschool.core.entity.Rc_group;

import ru.relex.itschool.core.services.EMFactory;
import javax.persistence.EntityManager;

public class DAOGroup implements IDAO<Rc_group>{

    public Rc_group findById(int id) {
        EntityManager em = EMFactory.getEntityManager();

        em.getTransaction().begin();
        Rc_group group = em.find(Rc_group.class, id);
        em.getTransaction().commit();

//        EMFactory.close();
        em.close();

        return group;
    }

    public void save(Rc_group e) {
        EntityManager em = EMFactory.getEntityManager();

        em.getTransaction().begin();
        em.persist(e);
        em.getTransaction().commit();

//        EMFactory.close();
        em.close();
    }

    public void update(Rc_group e) {
        EntityManager em = EMFactory.getEntityManager();

        em.getTransaction().begin();
        em.merge(e);
        em.getTransaction().commit();

//        EMFactory.close();
        em.close();
    }

    public void delete(Rc_group e) {
        EntityManager em = EMFactory.getEntityManager();

        em.getTransaction().begin();
        em.remove(em.contains(e) ? e : em.merge(e));
        em.getTransaction().commit();

//        EMFactory.close();
        em.close();
    }
}
