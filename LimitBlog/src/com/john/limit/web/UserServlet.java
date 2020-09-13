package com.john.limit.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.john.limit.domain.User;
import com.john.limit.service.UserService;
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 
		request.setCharacterEncoding("utf-8");
		//�����ַ���
		response.setContentType("text/html;charset=UTF-8");
		String name = request.getParameter("username");
		String pwd = request.getParameter("password");
		System.out.println(name+pwd);
		UserService userService = new UserService();
		try {
			userService.login(name,pwd);
			System.out.println("login success!");
			User user = new User();
			//1.���û����浽session����
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			//2.��ת��̨��ҳ
			response.sendRedirect("index.html");
		} catch (Exception e) {
			if(e.getMessage().equals("�û������������")) {
				//���Դ�����Ϣ
				request.setAttribute("err", e.getMessage());
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
			else {
				e.printStackTrace();
			}
		
		}
	}

}