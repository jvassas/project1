package com.ex.project_1;

import com.ex.project_1.utilities.DAOUtilities;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {

    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {

        Connection conn = null;

        try {
            conn = DAOUtilities.getConnection();
            System.out.println("Connection successful");

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Connection UNSUCCESSFUL :(");
        }


    }
}
