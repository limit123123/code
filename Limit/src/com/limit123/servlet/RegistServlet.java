package com.limit123.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/RegistServlet")
public class RegistServlet extends HttpServlet {


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pr = request.getParameter("code");
		System.out.println(pr);
		String word = (String)this.getServletContext().getAttribute("checkCode");
		//������������
		response.setContentType("text/html;charset=UTF-8");
		if(word.equals(pr)) {
			response.getWriter().write("ע��ɹ���");
		}
		else {
			response.getWriter().write("��֤�����");
			response.setHeader("refresh","3,url=/Limit/Code.html");
			
		}
		
	}

}
