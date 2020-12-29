package com.ex.project_1.dao;

import com.ex.project_1.model.Reimbursement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Implementation of the ReimbursementDAO, performs database querying for Reimbursement
 * Request objects using Hibernate Query Language (HQL)
 */
public class ReimbursementDAOImpl extends GenericDAO implements ReimbursementDAO {
    private static final Logger logger = LogManager.getLogger(ReimbursementDAOImpl.class);
    Session session = null;

    /**
     * The method getAllReimbursements() returns a list of all reimbursement
     * requests in the database
     * @return List of reimbursement requests
     */
    @Override
    public List<Reimbursement> getAllReimbursements() {
        GenericDAO.config();
        Session session = sessionFactory.openSession();
        List<Reimbursement> reimbursements = null;

        try {
            session = sessionFactory.openSession();
            String hql = "from requests";
            Query query = session.createQuery(hql);
            logger.info("Executing HQL statement");
            reimbursements = query.list();
            logger.info("List of reimbursements retrieved");
        } finally {
            session.close();
            logger.info("Session closed");
        }
        return reimbursements;
    }

    //------------------------------------------------------------------------------

    /**
     * The method getReimbursementById retrieves a list of employee reimbursement
     * requests by the employee's unique ID
     * @param employeeId
     * @return List of Reimbursement requests by Employee ID
     */
    @Override
    public List<Reimbursement> getReimbursementById(int employeeId) {
        GenericDAO.config();
        Session session = sessionFactory.openSession();
        List<Reimbursement> reimbursements = null;

        try {
            session = sessionFactory.openSession();
            String hql = "from requests Where employee_id =  '"+employeeId+"'";
            Query query = session.createQuery(hql);
            logger.info("Getting Reimbursement Requests by Employee ID");
            reimbursements = query.list();
            logger.info("List of Reimbursements by Employee ID retrieved");
        } finally {
            session.close();
            logger.info("Session closed");
        }
        return reimbursements;
    }

    //------------------------------------------------------------------------------

    /**
     * The method getPendingReimbursements retrieves all pending reimbursements
     * that have not been approved
     * @return
     */
    @Override
    public List<Reimbursement> getPendingReimbursements() {
        GenericDAO.config();
        Session session = sessionFactory.openSession();
        List<Reimbursement> reimbursements = null;

        try {
            session = sessionFactory.openSession();
            String hql = "from requests Where approved = false";
            Query query = session.createQuery(hql);
            logger.info("Getting pending reimbursement requests");
            reimbursements = query.list();
            logger.info("List of pending reimbursements requests retrieved");
        } finally {
            session.close();
            logger.info("Session closed");
        }
        return reimbursements;
    }

    //------------------------------------------------------------------------------

    /**
     * The getResolvedReimbursements method gets a list of all reimbursements that
     * were resolved
     * @return
     */
    @Override
    public List<Reimbursement> getResolvedReimbursements() {
        GenericDAO.config();
        Session session = sessionFactory.openSession();
        List<Reimbursement> reimbursements = null;

        try {
            session = sessionFactory.openSession();
            String hql = "from requests Where approved = true";
            Query query = session.createQuery(hql);
            logger.info("Getting resolved reimbursement requests");
            reimbursements = query.list();
            logger.info("List of resolved reimbursement requests retrieved");
        } finally {
            session.close();
            logger.info("Session closed");
        }
        return reimbursements;
    }

    //------------------------------------------------------------------------------

    /**
     * The getResolvedReimbursements method gets a list of all reimbursements that
     * were resolved
     * @return
     */
    @Override
    public List<Reimbursement> getReimbursementByAmount(int amount) {
        GenericDAO.config();
        Session session = sessionFactory.openSession();
        List<Reimbursement> reimbursements = null;

        try {
            session = sessionFactory.openSession();
            String hql = "from requests Where amount = 75";
            Query query = session.createQuery(hql);
            logger.info("Getting reimbursement requests by amount");
            reimbursements = query.list();
            logger.info("List of reimbursement requests by amount retrieved");
        } finally {
            session.close();
            logger.info("Session closed");
        }
        return reimbursements;
    }

    //------------------------------------------------------------------------------



    /**
     * The method addReimbursement adds a new Reimbursement Request record to
     * the database
     * @param reimbursement
     */
    @Override
    public boolean addReimbursement(Reimbursement reimbursement) {
        GenericDAO.config();
        Session session = sessionFactory.openSession();
        Transaction tx = null;

        try {
            tx = session.getTransaction();
            tx.begin();
            session.save(reimbursement);
            tx.commit();
            logger.info("Reimbursement Request added");
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
            logger.info("Session closed");
        }
        return true;
    }

    //------------------------------------------------------------------------------


    @Override
    public boolean deleteReimbursement(int expenseId) {
        GenericDAO.config();
        Session session = sessionFactory.openSession();
        Transaction tx = null;

        try {
            tx = session.getTransaction();
            tx.begin();
            String hql = "delete from requests where expense_id =  '"+expenseId+"'";
            Query query = session.createQuery(hql);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return true;
    }

}
