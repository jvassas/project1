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

public class EmployeeLoginServlet extends HttpServlet {

    private static final Logger logger = LogManager.getLogger(EmployeeLoginServlet.class);

    /**
     * The doPost method handles a the employee can login to the application
     * @param req
     * @param res
     * @throws ServletException
     * @throws IOException
     */
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        EmployeeDAOImpl dao = new EmployeeDAOImpl();
        boolean isLogin = dao.authenticate(email, password);
        Employee employee = dao.getEmployeeByEmail(email);

        req.setAttribute("employee", employee);

        if (isLogin == true) {
            req.getSession().setAttribute("employee", employee);
            res.sendRedirect("employeeHome.jsp");
            logger.info("Employee has logged in");
        } else {
            res.sendRedirect("employeeLogin.jsp");
            logger.info("Employee Login Unsuccessful");
        }
    }
}
