package com.ex.project_1.utilities;

import com.ex.project_1.model.Employee;
import com.ex.project_1.model.Manager;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TestHibernateInsert {

//    public static void main(String[] args) {
//        Session session = HibernateUtil.getSessionFactory().openSession();
//        session.beginTransaction();

//        //Add new emp
//        Employee emp = new Employee();
//        emp.setFirstName("Jake");
//        emp.setLastName("Vassas");
//        emp.setEmail("jv@gmail.com");
//        emp.setPassword("password");
//
//        session.save(emp);
//        session.flush();
//        session.getTransaction().commit();


//        Manager mgr = new Manager();
//        mgr.setFirstName("Thomas");
//        mgr.setLastName("Maday");
//        mgr.setEmail("tommymaday@gmail.com");
//        mgr.setPassword("pw");
//
//        session.save(mgr);
//        session.flush();
//        session.getTransaction().commit();
//        HibernateUtil.shutdown();
//    }
}
