package com.bolen.tomcat;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bolen.util.HttpClientUtil;

public class TomcatTestClient {
	private static final AtomicInteger num=new AtomicInteger(0);
	
	private final static Logger log=LoggerFactory.getLogger(TomcatTestClient.class);
	
	public static void main(String[] args) {
		/*
		 * <Connector connectionTimeout="20000" maxThreads="50" maxConnections="100"
		 * acceptCount="80" port="8080" protocol="HTTP/1.1" redirectPort="8443"/>
		 * 
		 * 以上配置，300次访问，服务端返回180次，其它直接拒绝了
		 */
		
		int total =300;
		
		for(int i=0;i<total;i++) {
			log.info("==========准备第:"+i+"次访问");
			/*
			 * try { //Thread.sleep(10); } catch (InterruptedException e) { // TODO
			 * Auto-generated catch block e.printStackTrace(); }
			 */
			int incrementAndGet = num.incrementAndGet();
			Thread thd=new Thread(new VisitorTask(incrementAndGet));
			thd.start();
		}
		
	}
	
	
	
	
	private static class VisitorTask implements Runnable{
		Integer number;
		
		public VisitorTask(Integer number) {
			super();
			this.number = number;
		}

		@Override
		public void run() {
			Map param = new HashMap<>();
			param.put("number", number.toString());
			String doGet = HttpClientUtil.doGet("http://localhost:8080/bolen-demo/tomcat/test", param);
			log.info("==========客户端收到的第"+doGet+"次返回");
			
		}
		
	}
}
