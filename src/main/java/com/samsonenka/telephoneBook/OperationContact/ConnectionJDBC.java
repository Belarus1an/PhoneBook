package com.samsonenka.telephoneBook.OperationContact;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionJDBC {

    private static String URL = "jdbc:mysql://localhost:3306/telephonebook?useSSL=false";
    private static String USER = "root";
    private static String PASSWORD = "root";
    private static Connection connection;

    public ConnectionJDBC() throws SQLException, ClassNotFoundException {

        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static Connection getConnection(){

        return connection;
    }
}

