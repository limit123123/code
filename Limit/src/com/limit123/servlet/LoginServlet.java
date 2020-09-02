package com.limit123.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.alibaba.druid.util.JdbcUtils;
import com.limit123.domain.User;
import com.limit123.utils.JdbcUtil;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    public LoginServlet() {
      
    }
	/**
	  1.获取请求参数
    2.使用dbutils连接到数据库当中
    3.检查用户名与密码是否正确
    4.登录成功，显示用户所有信息
    5.登录失败给一个错误提示
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("LoginServlet");
		// 1.获取请求参数
		String name = request.getParameter("username");
		String pwd = request.getParameter("password");
		// 2.使用dbutils连接到数据库当中
		QueryRunner qr = new QueryRunner(JdbcUtil.ds);
		// 3.检查用户名与密码是否正确
		String sql="select * from user where name=? and pwd=?";
		User user=null;
		try {
			//BeanHandler封装对象！
			 user = qr.query(sql, new BeanHandler<User>(User.class),name,pwd);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		//如果用户不为空的话
		if(user!=null) {
			response.getWriter().write("login success");
		}
			else {
				response.getWriter().write("login fail");
		}

	}
}