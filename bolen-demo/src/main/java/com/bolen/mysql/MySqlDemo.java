package com.bolen.mysql;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Random;
import java.util.UUID;

import org.junit.Test;

import com.bolen.dbUtils.JdbcUtil;

/**
 * mysql研究
 * 
 * @author zhangzhoujun
 *
 */
public class MySqlDemo {

	@Test
	public void test01() throws SQLException {
		Connection conn = JdbcUtil.getConnection();
		conn.setAutoCommit(false);
		String sql = "INSERT INTO USER(name,sex,height,weight,birthdaty,card_id ) " + "VALUES(?,?,?,?,?,?) ";
		PreparedStatement pstm = conn.prepareStatement(sql);

		
		LocalDateTime ldt = LocalDateTime.now();
		System.out.println(ldt);
		Instant now = Instant.now();
		System.out.println(now);
		ZoneId zoneId = ZoneId.systemDefault();
		System.out.println(zoneId);
		ZonedDateTime zd = ldt.atZone(zoneId);
		System.out.println(zd);
		Instant instant2 = zd.toInstant();
		
		for (int i = 0; i < 1000000; i++) {
			pstm.setObject(1, "bolen" + "_" + i);
			Random rd = new Random();
			int year = rd.nextInt(100);
			int month = rd.nextInt(12);
			int day = rd.nextInt(30);
			int hour = rd.nextInt(24);
			int minute = rd.nextInt(60);
			int second = rd.nextInt(60);
			int nextHeiht = rd.nextInt(20);
			pstm.setObject(2,year%2==1?"M":"F");
			pstm.setObject(3, 170+nextHeiht);
			pstm.setObject(4, 60+nextHeiht);
			LocalDateTime minus = ldt.minus(year, ChronoUnit.YEARS).minus(month, ChronoUnit.MONTHS).minus(day, ChronoUnit.DAYS)
			.minus(hour, ChronoUnit.HOURS).minus(minute, ChronoUnit.MINUTES).minus(second, ChronoUnit.SECONDS);
			ZoneId systemDefault = ZoneId.systemDefault();
			
			ZonedDateTime zdt = minus.atZone(systemDefault);
			Instant instant = zdt.toInstant();
			pstm.setObject(5, Date.from(instant));
			pstm.setObject(6, UUID.randomUUID().toString().replace("-", ""));
			/*
			 * prepareStatement.execute(); prepareStatement.clearParameters();
			 */
			pstm.executeUpdate();
			System.out.println(i);
		}
		conn.commit();
		pstm.close();
		 conn.close(); 
	}

	@Test
	public <T> void test02() throws SQLException {
		T[] arr = (T[]) new Object[10];
		Connection conn = JdbcUtil.getConnection();
		String sql = "INSERT INTO myperformance(id,tag,name) VALUES(?,?,?) ";
		PreparedStatement prepareStatement = conn.prepareStatement(sql);

		for (int i = 1020000; i < 2000000; i++) {
			prepareStatement.setObject(1, i);
			prepareStatement.setObject(2, UUID.randomUUID().toString().replace("-", ""));
			prepareStatement.setObject(3, "bolen" + "_" + i);
			prepareStatement.execute();
			prepareStatement.clearParameters();
			System.out.println(i);
			/* prepareStatement.addBatch(); */
		}
		/* prepareStatement.executeBatch(); */

		// prepareStatement.close();
		/* conn.close(); */
	}

	@Test
	public void test03() {

		Random rd = new Random(47);

		int nextInt = rd.nextInt(100);
		int nextInt2 = rd.nextInt(100);
		System.out.println(nextInt);
		System.out.println(nextInt2);
	}

	@Test
	public void test04() {
		LocalDateTime ldt = LocalDateTime.now();
		System.out.println(ldt);
		LocalDateTime minus = ldt.minus(1, ChronoUnit.YEARS).minus(2, ChronoUnit.MONTHS).minus(3, ChronoUnit.DAYS)
		.minus(4, ChronoUnit.HOURS).minus(5, ChronoUnit.MINUTES).minus(6, ChronoUnit.SECONDS);
		LocalDate localDate = minus.toLocalDate();
		LocalTime localTime = minus.toLocalTime();
		System.out.println(minus);
		System.out.println(localDate);
		System.out.println(localTime);
		ZoneId systemDefault = ZoneId.systemDefault();
		
		ZonedDateTime zdt = minus.atZone(systemDefault);
		Instant instant = zdt.toInstant();
	}
}
