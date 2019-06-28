package com.bolen.dbUtils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.tomcat.jdbc.pool.DataSource;

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
		DataSource dataSource = new DataSource();
		Connection connection = dataSource.getConnection();
	}
}
