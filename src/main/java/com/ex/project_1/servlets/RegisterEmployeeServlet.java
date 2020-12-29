package com.ex.project_1.servlets;

import com.ex.project_1.dao.EmployeeDAOImpl;
import com.ex.project_1.model.Employee;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterEmployeeServlet extends HttpServlet {

    private static final Logger logger = LogManager.getLogger(RegisterEmployeeServlet.class);

    /**
     * The doGet method renders the page where an employee can register a new employee
     * @param req
     * @param res
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.getRequestDispatcher("managerEmployeeFunctions.jsp");
        logger.info("Manager has navigated to the Manager functions page");
    }


    /**
     * The doPost method registers a new employee to the database
     * @param req
     * @param res
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String email = req.getParameter("email");
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String password = req.getParameter("password");

        Employee employee = new Employee(firstName, lastName, email, password);
        EmployeeDAOImpl dao = new EmployeeDAOImpl();
        dao.addEmployee(employee);
        logger.info("The manager has added a new employee record");

        res.sendRedirect("managerEmployeeFunctions.jsp");

    }
}
