package com.ex.project_1.servlets;

import com.ex.project_1.dao.EmployeeDAOImpl;
import com.ex.project_1.dao.ReimbursementDAOImpl;
import com.ex.project_1.model.Employee;
import com.ex.project_1.model.Manager;
import com.ex.project_1.model.Reimbursement;
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

@WebServlet(urlPatterns="/all-reimbursements")
public class GetReimbursementsServlet extends HttpServlet {

    private static final Logger logger = LogManager.getLogger(GetReimbursementsServlet.class);

    /**
     * The doGet method retrieves a list of Reimbursement Requests
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ReimbursementDAOImpl rDao = new ReimbursementDAOImpl();
        List<Reimbursement> reimbursements = rDao.getAllReimbursements();
        logger.info("List of Reimbursement Requests retrieved");

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(reimbursements);
        resp.getWriter().write(json);
        logger.info("Reimbursement records converted to JSON");
    }
}
