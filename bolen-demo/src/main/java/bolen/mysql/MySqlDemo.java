package bolen.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.UUID;

import org.junit.Test;

import bolen.dbUtils.JdbcUtil;

public class MySqlDemo {

	@Test
	public void test01() throws SQLException {
		Integer j=10;
		Connection conn = JdbcUtil.getConnection();
		String sql = "INSERT INTO myperformance(id,tag,name) VALUES(?,?,?) ";
		PreparedStatement prepareStatement = conn.prepareStatement(sql);
		
		Runnable runnable = new Runnable() {
			
			@Override
			public void run() {
				MySqlDemo demo = new MySqlDemo();
				try {
					demo.test02();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		};
		Thread t=new Thread(runnable);
		t.start();
		
		for (int i = 100000; i < 1000000; i++) {
			prepareStatement.setObject(1, i);
			prepareStatement.setObject(2,
					UUID.randomUUID().toString().replace("-", ""));
			prepareStatement.setObject(3, "bolen" + "_" + i);
			/*prepareStatement.execute();
			prepareStatement.clearParameters();*/
			System.out.println(i);
			prepareStatement.addBatch();
		}
		prepareStatement.executeBatch();

		//prepareStatement.close();
		/*conn.close();*/
	}
	
	
	@Test
	public <T> void  test02() throws SQLException {
		T[] arr=(T[]) new Object[10];
		Connection conn = JdbcUtil.getConnection();
		String sql = "INSERT INTO myperformance(id,tag,name) VALUES(?,?,?) ";
		PreparedStatement prepareStatement = conn.prepareStatement(sql);

		for (int i = 1020000; i < 2000000; i++) {
			prepareStatement.setObject(1, i);
			prepareStatement.setObject(2,
					UUID.randomUUID().toString().replace("-", ""));
			prepareStatement.setObject(3, "bolen" + "_" + i);
			prepareStatement.execute();
			prepareStatement.clearParameters();
			System.out.println(i);
		/*	prepareStatement.addBatch();*/
		}
		/*prepareStatement.executeBatch();*/

		//prepareStatement.close();
		/*conn.close();*/
	}

}
