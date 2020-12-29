package com.ex.project_1.servlets;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class ManagerHomeServlet extends HttpServlet {

    private static final Logger logger = LogManager.getLogger(ManagerHomeServlet.class);

    /**
     * The doGet method renders the managerHome page
     * @param req
     * @param res
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.getRequestDispatcher("managerHome.jsp").forward(req, res);
        logger.info("Manager has reached the Manager Home Page");
    }
}
