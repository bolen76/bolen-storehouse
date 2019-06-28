package com.bolen.web;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class UploadServlet
 */
@WebServlet("/UploadServlet")
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UploadServlet() {
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
		response.setContentType("text/html;charset=utf-8");
		DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
		ServletFileUpload servletFileUpload = new ServletFileUpload(
				diskFileItemFactory);
		servletFileUpload.setHeaderEncoding("utf-8");
		try {
			List<FileItem> list = servletFileUpload.parseRequest(request);
			for (FileItem item : list) {
				if (item.isFormField()) {
					String name = item.getName();
					String fieldName = item.getFieldName();
					System.out.println(fieldName+":"+name);
					
						response.getWriter().print("用户名：" + item.getString()+"<br/>");
					

				} else {
					String name = item.getName();
					if (name == null || name.isEmpty()) {
						continue;
					}
					String fieldName = item.getFieldName();
					String realPath = this.getServletContext().getRealPath("/WEB-INF/uploads");
					System.out.println(realPath);
					File file=new File(realPath,name);
					item.write(file);
					PrintWriter writer = response.getWriter();
					System.out.println(fieldName+":"+name);
					writer.print("上传文件名："+name+"<br/>");
					writer.print("上传文件大小："+item.getSize()+"<br/>");
					writer.print("上传文件类型："+item.getContentType()+"<br/>");
					/*System.out.println(item.getString("utf-8"));*/
				}
				
			}
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
