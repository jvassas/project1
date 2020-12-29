package com.ex.project_1.dao;

import com.ex.project_1.model.Employee;
import com.ex.project_1.model.Reimbursement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Implementation of the EmployeeDAO, performs database querying for Employee
 * objects using Hibernate Query Language (HQL)
 */

public class EmployeeDAOImpl extends GenericDAO implements EmployeeDAO {

    private static final Logger logger = LogManager.getLogger(EmployeeDAOImpl.class);

    Session session = null;
    Employee employee = null;

    /**
     * The method getAllEmployees returns a list of employees
     * @return List of Employees
     */
    @Override
    public List<Employee> getAllEmployees() {
        GenericDAO.config();
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        List<Employee> employees = null;

        try {
            session = sessionFactory.openSession();
            String hql = "from Employee";
            Query query = session.createQuery(hql);
            logger.info("HQL statement Executing...");
            employees = query.list();
            logger.info("Employee List Returned");
        } finally {
            session.close();
            logger.info("Session closed");
        }
        return employees;
    }

    //------------------------------------------------------------------------------


    /**
     * The method getEmployeeByEmail returns the Employee object given
     * the employees email address
     * @param email
     * @return employee
     */
    @Override
    public Employee getEmployeeByEmail(String email) {
        GenericDAO.config();
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        Employee employee = null;

        try {
            tx = session.getTransaction();
            tx.begin();
            String hql = "from Employee E where E.email = '"+email+"'";
            Query query = session.createQuery(hql);
            logger.info("HQL Statement Executing...");
            employee = (Employee)query.uniqueResult();
            logger.info("Employee record found by email");
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

        return employee;

    }
    //------------------------------------------------------------------------------


    /**
     * The method getEmployeeById retrieves employee information by id
     * @param id
     * @return employee record
     */
    @Override
    public Employee getEmployeeById(int id) {
        GenericDAO.config();
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        Employee employee = null;

        try {
            tx = session.getTransaction();
            tx.begin();
            String hql = "from Employee E where E.id = '"+id+"'";
            Query query = session.createQuery(hql);
            logger.info("Getting employee by ID");
            employee = (Employee)query.uniqueResult();
            logger.info("Employee record found by ID");
            tx.commit();
        } catch (Exception e) {
            if(tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return employee;
    }
    //------------------------------------------------------------------------------

    /**
     * The method authenticate checks to see if the email and password exist for
     * an Employee in the database and then checks to see if the fields
     * entered match
     * @param email
     * @param password
     */
    @Override
    public boolean authenticate(String email, String password) {
        Employee employee = getEmployeeByEmail(email);

        if(employee != null && employee.getEmail().equals(email) &&
        employee.getPassword().equals(password)) {
            return true;
        } else {
            return false;
        }
    }
    //------------------------------------------------------------------------------


    /**
     * The method addEmployee adds a new Employee object into the database
     * @param employee
     */
    @Override
    public boolean addEmployee(Employee employee) {

        GenericDAO.config();
        Session session = sessionFactory.openSession();
        Transaction tx = null;

        try {
            tx = session.getTransaction();
            tx.begin();
            session.save(employee);
            tx.commit();
            logger.info("New Employee added");
        } finally {
            session.close();
            logger.info("Session closed");
        }
        return true;
    }
    //------------------------------------------------------------------------------


    /**
     * The method deleteEmployee deletes an Employee record from the database
     * @param email
     */
    @Override
    public boolean deleteEmployee(String email) {
        GenericDAO.config();
        Session session = sessionFactory.openSession();
        Transaction tx = null;

        try {
            tx = session.getTransaction();
            tx.begin();
            String hql = "delete from Employee E where E.email =  '"+email+"'";
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
