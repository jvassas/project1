package com.ex.project_1.servlets;

import com.ex.project_1.dao.EmployeeDAOImpl;
import com.ex.project_1.model.Employee;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns="/current-employee")
public class GetSingleEmployeeServlet extends HttpServlet {

    private static final Logger logger = LogManager.getLogger(GetSingleEmployeeServlet.class);

    /**
     * The doGet method sets the session to the current employee who is logged in and returns the
     * current employee record
     * @param req
     * @param res
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
       HttpSession session = req.getSession();
        Employee employee = (Employee)session.getAttribute("employee");

        req.setAttribute("employee", employee);
        int employeeId = employee.getId();

        EmployeeDAOImpl eDao = new EmployeeDAOImpl();
        employee = eDao.getEmployeeById(employeeId);
        logger.info("Employee record retrieved");

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(employee);
        res.getWriter().write(json);
        logger.info("Employee record converted to JSON");


    }
}
