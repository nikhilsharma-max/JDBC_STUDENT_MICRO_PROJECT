package org.dnm.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConfig {
    private static final String URL = "jdbc:mysql://localhost:3306/jdbc_project_student";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "Nikhil@9897";

    public static Statement getInstance(){
        try{
            Connection connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
            Statement statement = connection.createStatement();
            return statement;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnection(){
        try{
            Connection connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
            return connection;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
