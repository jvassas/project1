package com.ex.project_1.servlets;

import com.ex.project_1.dao.EmployeeDAO;
import com.ex.project_1.dao.EmployeeDAOImpl;
import com.ex.project_1.dao.ReimbursementDAOImpl;
import com.ex.project_1.model.Employee;
import com.ex.project_1.model.Reimbursement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


public class EmployeeRequestServlet extends HttpServlet {

    private static final Logger logger = LogManager.getLogger(EmployeeRequestServlet.class);


    EmployeeDAOImpl eDao = new EmployeeDAOImpl();

    /**
     * The doGet method sets the session to the current employee and determines which page to render
     * @param req
     * @param res
     * @throws ServletException
     * @throws IOException
     */
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Employee employee = (Employee) session.getAttribute("employee");

        if(employee != null) {
            req.setAttribute("employee", employee);
            req.getRequestDispatcher("employeeRequests.jsp").forward(req, res);
        } else {
            res.sendRedirect(req.getContextPath() + "employeeLogin.jsp");
        }
    }


    /**
     * The doPost method adds a new Reimbursement Request to the database
     * @param req
     * @param res
     * @throws ServletException
     * @throws IOException
     */
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        HttpSession session = req.getSession();
        Employee employee = (Employee) session.getAttribute("employee");

        if (employee != null) {
            req.setAttribute("employee", employee);
            int employeeId = employee.getId();
            String employeeEmail = employee.getEmail();
            Long amount = Long.parseLong(req.getParameter("amount"));
            String description = req.getParameter("description");
            boolean approved = false;

            // Come up with way to set employeeId to the current employee that is logged in
            Reimbursement reimbursement = new Reimbursement(employeeId, employeeEmail, description, amount, approved);


            ReimbursementDAOImpl dao = new ReimbursementDAOImpl();
            boolean result = dao.addReimbursement(reimbursement);

            if(result) {
                logger.info("Reimbursement record added");
                res.sendRedirect("employeeRequests.jsp");
            } else {
                logger.info("Reimbursement record was not added");
                res.sendRedirect("employeeRequests.jsp");

            }
        }

    }
}
