package com.ex.project_1.servlets;


import com.ex.project_1.dao.ManagerDAOImpl;
import com.ex.project_1.model.Manager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ManagerLoginServlet extends HttpServlet {

    private static final Logger logger = LogManager.getLogger(ManagerLoginServlet.class);

    /**
     * The doPost method handles how a manager can login to the application
     * @param req
     * @param res
     * @throws ServletException
     * @throws IOException
     */
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        ManagerDAOImpl dao = new ManagerDAOImpl();
        boolean isLogin = dao.authenticate(email, password);
        Manager manager = dao.getManagerByEmail(email);

        if (isLogin == true) {
            req.getSession().setAttribute("manager", manager);
            res.sendRedirect("managerHome.jsp");
            logger.info("Manager has logged in");

        } else {
            res.sendRedirect("managerLogin.jsp");
            logger.info("Manager Login Unsuccessful");

        }
    }
}


