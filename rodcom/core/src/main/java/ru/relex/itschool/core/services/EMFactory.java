package ru.relex.itschool.core.services;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


/**
 * Author: Trokhin
 *
 * Этот сервис обеспечивает нам создание EntityManager-ов, так как их создание фабрики
 * является тяжеловесной операцией, то она объявлена как статик, чтобы она создалась лишь 1 раз.
 *
 * Минусом этой реализацией является неор
 */
public final class EMFactory {


    private static final String persistenceUN;

    private static final EntityManagerFactory sessionFactory;

    static {
        persistenceUN = "RODCOM";
        sessionFactory = Persistence.createEntityManagerFactory(persistenceUN);
    }


    // конструктор не статический на случай, если мы будем использовать разные базы данных или настройки
    // но даже при такой раскладе фабрика создается лишь 1 раз, так как в setUp() происходит проверка
    // и если фабрики нет она создается, а если есть, то игнорируется

    /*public EMFactory(String persistenceUnitName) {
        persistenceUN = persistenceUnitName;
        setUp();
        entityManager = sessionFactory.createEntityManager();
    }

    private void setUp() throws IllegalArgumentException {
        if(persistenceUN == null)
            throw new IllegalArgumentException("NULL persistence Unit Name");
        if(sessionFactory == null)
            sessionFactory = Persistence.createEntityManagerFactory(persistenceUN);
    }*/

    public static EntityManager getEntityManager() {
        return sessionFactory.createEntityManager();
    }

    public static void close() {
        sessionFactory.close();
    }
}
