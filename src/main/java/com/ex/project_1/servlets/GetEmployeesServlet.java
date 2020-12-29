package com.ex.project_1.servlets;

import com.ex.project_1.dao.EmployeeDAOImpl;
import com.ex.project_1.model.Employee;
import com.ex.project_1.model.Manager;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns="/all-employees")
public class GetEmployeesServlet extends HttpServlet {

    private static final Logger logger = LogManager.getLogger(GetEmployeesServlet.class);

    /**
     * The doGet method retrieves a list of employees
     * @param req
     * @param res
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        EmployeeDAOImpl eDao = new EmployeeDAOImpl();
        List<Employee> employees = eDao.getAllEmployees();
        logger.info("List of all employees was retrieved");

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(employees);
        res.getWriter().write(json);
        logger.info("Employee records converted to JSON");
    }
}
