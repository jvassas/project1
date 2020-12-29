package com.ex.project_1.dao;

import com.ex.project_1.model.Manager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Implementation of the ManagerDAO, performs database querying for Manager
 * objects using Hibernate Query Language (HQL)
 */
public class ManagerDAOImpl extends GenericDAO implements ManagerDAO {

    private static final Logger logger = LogManager.getLogger(ManagerDAOImpl.class);
    Session session = null;
    Manager manager = null;

    /**
     * The method getManagerByEmail returns the Manager object given
     * the Managers email address
     * @param email
     * @return manager
     */
    @Override
    public Manager getManagerByEmail(String email) {
        GenericDAO.config();
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        Manager manager = null;

        try {
            tx = session.getTransaction();
            tx.begin();
            String hql = "from Manager M where M.email = '"+email+"'";
            Query query = session.createQuery(hql);
            logger.info("Executing HQL statement");
            manager = (Manager)query.uniqueResult();
            logger.info("Manager record found by email");
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
            logger.info("Session closed");
        }

        return manager;
    }
    //------------------------------------------------------------------------------

    /**
     * The method authenticate checks to see if the email and password for
     * a manager exist in the database and then checks to see if the fields
     * entered match
     * @param email
     * @param password
     */
    @Override
    public boolean authenticate(String email, String password) {
        Manager manager = getManagerByEmail(email);

        if (manager != null && manager.getEmail().equals(email) &&
        manager.getPassword().equals(password)) {
            return true;
        } else {
            return false;
        }
    }

}
