package com.bolen.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;

/**
 * Servlet implementation class DownloadServlet
 */
@WebServlet("/DownloadServlet")
public class DownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DownloadServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String filename = request.getParameter("path");
		filename = new String(filename.getBytes("ISO-8859-1"), "UTF-8");
		String filepath = this.getServletContext().getRealPath(
				"/WEB-INF/uploads/" + filename);
		File file = new File(filepath);
		if (!file.exists()) {
			response.getWriter().print("您要下载的文件不存在！");
			return;
		}
		response.setCharacterEncoding("utf-8");
		filename = new String(filename.getBytes("UTF-8"), "UTF-8");
		filename = new String(filename.getBytes("UTF-8"), "ISO-8859-1");
		filename = new String(filename.getBytes("ISO-8859-1"), "UTF-8");
		filename = new String(filename.getBytes("gbk"), "ISO-8859-1");
		response.addHeader("content-disposition", "attachment;filename="
				+ filename);
		IOUtils.copy(new FileInputStream(file), response.getOutputStream());
		
	}

}
