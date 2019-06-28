package com.bolen.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.alibaba.druid.pool.DruidDataSource;

public class JdbcUtil {
	private static Properties prop;
	static {
		InputStream stream = JdbcUtil.class
				.getResourceAsStream("/jdbc.properties");
		prop = new Properties();
		try {
			prop.load(stream);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

		try {
			Class.forName(prop.getProperty("master.jdbc.driver"));
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(prop.getProperty("master.jdbc.url"),
				prop.getProperty("master.jdbc.username"), prop.getProperty("master.jdbc.password"));
	}
	
	
	public void test01() throws SQLException{
		DruidDataSource dataSource = new DruidDataSource();
		Connection connection = dataSource.getConnection();
	}
}
