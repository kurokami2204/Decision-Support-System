package com.example.hetrogiupluachonmonan;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class SQLConnect {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/dss_food?characterEncoding=utf8";
    private static String userName = "root";
    private  static DataSource dataSource;
    static  {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(DB_URL);
        config.setUsername(userName);
        config.setMaximumPoolSize(5);
        config.setMinimumIdle(1);
        dataSource = new HikariDataSource(config);
    }

    public static Connection getConnection(){
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
