package com.bolen.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ResponseServlet
 */
@WebServlet("/ResponseServlet")
public class ResponseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ResponseServlet() {
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
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*response.setContentType("text/html;charset=utf-8");
		PrintWriter writer = response.getWriter();
		writer.print("小楼一夜听春雨");
		response.flushBuffer();
		System.out.println("hello world......");*/
		/*response.sendError(404, "您要查找的资源不存在......");*/
		/*String contextPath = request.getContextPath();
		System.out.println(contextPath);
		response.sendRedirect(contextPath+"/index.jsp");*/
		String realPath = this.getServletContext().getRealPath("/a.txt");
		String realPath2 = this.getServletContext().getRealPath("a.txt");
		System.out.println(realPath);
		System.out.println(realPath2);
		
	}

}
