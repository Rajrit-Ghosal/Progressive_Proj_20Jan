package com.wecp.progressive.config;
import java.util.*;
import java.sql.*;

public class DatabaseConnectionManager {
    public static final String JDBC_URL="jdbc:mysql://localhost:3306/banksafe_wecp";
    public static final String USERNAME="root";
    public static final String PASSWORD="root";

    public static Connection getConnection() throws SQLException
    {
        return DriverManager.getConnection(JDBC_URL,USERNAME,PASSWORD);
    }

}
