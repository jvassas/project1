package com.ex.project_1.dao;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 * This abstract class configures the connection to the database
 * using Hibernate
 */
public abstract class GenericDAO {

    public static SessionFactory sessionFactory = null;

    public static void config() {
        Configuration config = new Configuration().configure();
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(config.getProperties());
        sessionFactory = config.buildSessionFactory(builder.build());
    }
}
