package com.bolen.dbutils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class JdbcUtil {
    
    private static Properties prop;
    
    static {
        InputStream stream = JdbcUtil.class.getResourceAsStream("/application.properties");
        prop = new Properties();
        try {
            prop.load(stream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        
        try {
            Class.forName(prop.getProperty("spring.datasource.driver-class-name"));
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(prop.getProperty("spring.datasource.url"),
                prop.getProperty("spring.datasource.username"), prop.getProperty("spring.datasource.password"));
    }
    
}
