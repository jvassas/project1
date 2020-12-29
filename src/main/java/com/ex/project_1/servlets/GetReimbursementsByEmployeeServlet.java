package com.ex.project_1.servlets;

import com.ex.project_1.dao.ReimbursementDAOImpl;
import com.ex.project_1.model.Employee;
import com.ex.project_1.model.Reimbursement;
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
import java.util.List;

@WebServlet(urlPatterns="/request-by-emp")
public class GetReimbursementsByEmployeeServlet extends HttpServlet {

    private static final Logger logger = LogManager.getLogger(GetReimbursementsByEmployeeServlet.class);

    /**
     * The doGetMethod retrieves a list of Employee Reimbursement Requests by Employee ID
     * @param req
     * @param res
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Employee employee = (Employee) session.getAttribute("employee");

        ReimbursementDAOImpl rDao = new ReimbursementDAOImpl();

        if (employee != null) {
            req.setAttribute("employee", employee);
            int employeeId = employee.getId();
            List<Reimbursement> reimbursements = rDao.getReimbursementById(employeeId);
            logger.info("List of Employee requests was retrieved by ID");

            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(reimbursements);
            res.getWriter().write(json);
            logger.info("Employee request records converted to JSON");
        }
    }
}
