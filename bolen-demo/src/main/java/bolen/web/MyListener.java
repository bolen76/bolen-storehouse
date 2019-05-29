/*package bolen.web;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

*//**
 * Application Lifecycle Listener implementation class MyListener
 * 
 *//*
@WebListener
public class MyListener implements ServletContextListener, HttpSessionListener,
		ServletRequestListener {

	*//**
	 * Default constructor.
	 *//*
	public MyListener() {
		// TODO Auto-generated constructor stub
	}

	public void requestInitialized(ServletRequestEvent sre) {
		System.out.println("request attribute:"
				+ sre.getServletRequest().getAttribute("id"));
		System.out.println("request Initialized....");
	}

	public void requestDestroyed(ServletRequestEvent sre) {
		System.out.println("request attribute:"
				+ sre.getServletRequest().getAttribute("id"));
		System.out.println("request destroyed....");
	}

	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("context Initialized...");
	}

	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("context Destroyed...");
	}

	public void sessionCreated(HttpSessionEvent se) {
		System.out.println("sessionname:"
				+ se.getSession().getAttribute("hello"));
		System.out.println("session Created...");
	}

	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println("sessionname:"
				+ se.getSession().getAttribute("hello"));
		System.out.println("session Destroyed...");
	}

}
*/