package com.john.limit.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.john.limit.dao.ActiveDao;
import com.john.limit.domain.User;


@WebServlet("/ActiveServlet")
public class ActiveServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("userName");
		byte[] bytes = userName.getBytes("ISO-8859-1");
		userName = new String(bytes,"UTF-8");
		System.out.println(userName);
		request.setCharacterEncoding("UTF-8");
		//response.setContentType("text/html;charset=UTF-8");
	
		
	
		System.out.println(userName);
		//userName=new String(userName.getBytes("UTF-8"));
		
	//	userName=new String(userName.getBytes("ISO-8859-1"),"UTF-8");//里面的是与数据库对应的编码，外面是其他编码
		System.out.println(userName);

		
	
		
		

		
		
		
	
		String userPassword = request.getParameter("userPassword");
		String userEmail = request.getParameter("userEmail");
		
		User user = new User();
        user.setUserName(userName);
        user.setUserPassword(userPassword);
        user.setUserEmail(userEmail);

        ActiveDao active=new ActiveDao();
        active.addUser(user);
        response.sendRedirect("login.jsp");
	
	}
/*
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.setContentType("text/html");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.println("不支持post方式访问！！！");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}
	*/

}
