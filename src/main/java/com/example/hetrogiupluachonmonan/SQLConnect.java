package com.example.hetrogiupluachonmonan;

import java.sql.Connection;
import java.sql.DriverManager;


public class SQLConnect {
    public static String DB_URL = "jdbc:mysql://localhost:3306/dss_food?characterEncoding=utf8";
    public static String userName = "root";
    public static String password = "";

    public static Connection getConnection(){
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(DB_URL,userName,password);
            System.out.print("connected");
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return connection;
    }
}
