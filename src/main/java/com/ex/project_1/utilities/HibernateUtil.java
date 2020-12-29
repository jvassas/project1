package com.ex.project_1.utilities;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

   protected static SessionFactory sessionFactory = null;

   public static void config() {

       Configuration configuration = new Configuration().configure();
       StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
               .applySettings(configuration.getProperties());
       sessionFactory = configuration.buildSessionFactory(builder.build());
   }

}




//public static void main(String[] args) {
//        HibernateUtil hibernateUtil = new HibernateUtil();
//        hibernateUtil.configure();
//        hibernateUtil.initEntities();
//    }
//
//    private void configure() {
//        Configuration config = new Configuration().configure();
//        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(config.getProperties());
//        this.sessionFactory = config.buildSessionFactory(builder.build());
//    }
//
//    private void initEntities() {
//        Manager mgr = new Manager();
//        mgr.setFirstName("Matthew");
//        mgr.setLastName("Kracker");
//        mgr.setEmail("mkracke@yahoo.com");
//        mgr.setPassword("mrkvegan");
//
//        //CODE THAT GOES INTO DAO
//        Session session = sessionFactory.openSession();
//        Transaction tx = session.beginTransaction();
//        session.save(mgr);
//        tx.commit();
//        session.close();