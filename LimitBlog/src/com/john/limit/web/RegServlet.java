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
		
	      // �����˵�������
	      String from = "1044549853@qq.com";
	      // ָ�������ʼ�������Ϊ smtp.qq.com
	      String host = "smtp.qq.com";  //QQ �ʼ�������
	      // ��ȡϵͳ����
	      Properties properties = System.getProperties();
	      // �����ʼ�������
	      properties.setProperty("mail.smtp.host", host);
	      properties.put("mail.smtp.auth", "true");
	      // ��ȡĬ��session����
	      Session session = Session.getDefaultInstance(properties,new Authenticator(){
	        public PasswordAuthentication getPasswordAuthentication()
	        {
	         return new PasswordAuthentication("1044549853@qq.com", "loepjhhnrszrbdhj"); //�������ʼ��û�������Ȩ��
	        }
	       });
	      try {
	    	  MimeMessage message = new MimeMessage(session);
	  	    
				String MailSubject="welcome my blog!!!";
		
			    String MailBody="��ӭ��,"+username + "��\n"
			    		+ "��ȷ�ϴ��ʼ���ַ�Լ��������˺š�" +
			    		"	����·��������������ע�ᡣ\n" +
			    		"	http://localhost/LimitBlog/ActiveServlet?userName="+username+
			    		"&userPassword="+userpassword+
			    		"&userEmail="+email;
			      message.setRecipients(Message.RecipientType.TO,
			    	        InternetAddress.parse(email));      //�����ռ��������ַ
			      message.setFrom(new InternetAddress(from));
				  message.setSubject(MailSubject);
				  message.setContent(MailBody, "text/plain;charset=utf-8");   //�����ʼ�����     
				   Transport.send(message);
			       System.out.println("Sent message successfully^--^");
			msg="<script>alert('���ͼ����˺ŵ��������䣬����գ�')</script>"+"<script> window.location.href='login.jsp' </script>";
		
		} catch (MessagingException mex) {
			   mex.printStackTrace();
			msg="<script>alert('����ʧ�ܣ�������')</script>";
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