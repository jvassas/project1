package com.ex.project_1.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAOUtilities {

    private static final String CONNECTION_USERNAME = "";
    private static final String CONNECTION_PASSWORD = "";
    private static final String CONNECTION_URL = "";
    private static Connection connection;

    /**
     * This method connects to the database using JDBC with the database credentials CONNECTION_USERNAME, CONNECTION_PASSWORD
     *  AND CONNECTION_URL
     *
     * @return connection
     * @throws SQLException
     */
    public static synchronized Connection getConnection() throws SQLException {
        if (connection == null) {
            try {
                Class.forName("org.postgresql.Driver");
            } catch (ClassNotFoundException e) {
                System.out.println("Could not register driver");
                e.printStackTrace();
            }
            connection = DriverManager.getConnection(CONNECTION_URL, CONNECTION_USERNAME, CONNECTION_PASSWORD);
        }

        if (connection.isClosed()) {
            System.out.println("Loading...");
            connection = DriverManager.getConnection(CONNECTION_URL, CONNECTION_USERNAME, CONNECTION_PASSWORD);
        }
        return connection;
    }
}
