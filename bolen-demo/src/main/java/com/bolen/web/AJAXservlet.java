package com.bolen.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bolen.pojo.Person;

import net.sf.json.JSONArray;

/**
 * Servlet implementation class AJAXservlet
 */
@WebServlet("/AJAXservlet")
public class AJAXservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AJAXservlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	/*	JSONObject jsobj = new JSONObject();*/
		JSONArray jsa = new JSONArray();
		Person p1 = new Person("zhangzhoujun", 31, "male");
		Person p2 = new Person("ta", 18, "female");
		jsa.add(p1);
		jsa.add(p2);
		String str = jsa.toString();
		System.out.println(str);

		/*response.getWriter().print(str);
		response.getWriter().print("HELLO");*/
		response.getWriter().print(str);
	}

}
