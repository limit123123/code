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
	  1.��ȡ�������
    2.ʹ��dbutils���ӵ����ݿ⵱��
    3.����û����������Ƿ���ȷ
    4.��¼�ɹ�����ʾ�û�������Ϣ
    5.��¼ʧ�ܸ�һ��������ʾ
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("LoginServlet");
		// 1.��ȡ�������
		String name = request.getParameter("username");
		String pwd = request.getParameter("password");
		// 2.ʹ��dbutils���ӵ����ݿ⵱��
		QueryRunner qr = new QueryRunner(JdbcUtil.ds);
		// 3.����û����������Ƿ���ȷ
		String sql="select * from user where name=? and pwd=?";
		User user=null;
		try {
			//BeanHandler��װ����
			 user = qr.query(sql, new BeanHandler<User>(User.class),name,pwd);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		//����û���Ϊ�յĻ�
		if(user!=null) {
			response.getWriter().write("login success");
		}
			else {
				response.getWriter().write("login fail");
		}

	}
}