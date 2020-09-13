package com.john.limit.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
@WebServlet("/RegServlet")

public class RegServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServletConfig Servletconf; 
	private String username;
	private String userpassword;
	private String email;
	private String msg;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		
		response.setContentType("text/html;charset=UTF-8");
		username = request.getParameter("username");
		userpassword = request.getParameter("userpassword");
		email=request.getParameter("email");
		System.out.println(username+email+userpassword);
		
	      // 发件人电子邮箱
	      String from = "1044549853@qq.com";
	      // 指定发送邮件的主机为 smtp.qq.com
	      String host = "smtp.qq.com";  //QQ 邮件服务器
	      // 获取系统属性
	      Properties properties = System.getProperties();
	      // 设置邮件服务器
	      properties.setProperty("mail.smtp.host", host);
	      properties.put("mail.smtp.auth", "true");
	      // 获取默认session对象
	      Session session = Session.getDefaultInstance(properties,new Authenticator(){
	        public PasswordAuthentication getPasswordAuthentication()
	        {
	         return new PasswordAuthentication("1044549853@qq.com", "loepjhhnrszrbdhj"); //发件人邮件用户名、授权码
	        }
	       });
	      try {
	    	  MimeMessage message = new MimeMessage(session);
	  	    
				String MailSubject="welcome my blog!!!";
		
			    String MailBody="欢迎您,"+username + "！\n"
			    		+ "请确认此邮件地址以激活您的账号。" +
			    		"	点击下方激活链接以完成注册。\n" +
			    		"	http://localhost/LimitBlog/ActiveServlet?userName="+username+
			    		"&userPassword="+userpassword+
			    		"&userEmail="+email;
			      message.setRecipients(Message.RecipientType.TO,
			    	        InternetAddress.parse(email));      //设置收件人邮箱地址
			      message.setFrom(new InternetAddress(from));
				  message.setSubject(MailSubject);
				  message.setContent(MailBody, "text/plain;charset=utf-8");   //生成邮件正文     
				   Transport.send(message);
			       System.out.println("Sent message successfully^--^");
			msg="<script>alert('发送激活账号到您的邮箱，请查收！')</script>"+"<script> window.location.href='login.jsp' </script>";
		
		} catch (MessagingException mex) {
			   mex.printStackTrace();
			msg="<script>alert('发送失败，请重试')</script>";
		} 
	  	toResponse(response,msg);
	 
}
	private void toResponse(HttpServletResponse response,String toString) throws IOException
	{
	//	response.setCharacterEncoding("gb2312");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		out.println(toString);
	}
}