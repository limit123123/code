package com.limit123.servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.fabric.xmlrpc.base.Array;

/**
 * Servlet implementation class GetPicServlet
 */
@WebServlet("/GetPicServlet")
public class GetPicServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.设置图片的路径
		String path=this.getServletContext().getRealPath("grade.png");
		//2.读取文件
		FileInputStream in = new FileInputStream(path);
		//3.获取一个输出流
		ServletOutputStream out = response.getOutputStream();
		byte [] buffer=new byte[1024];
		int len=0;
		while((len=in.read(buffer))!=-1) {
			//System.out.println(len);
			//System.out.println(Arrays.toString(buffer));
		out.write(buffer, 0, len);
		}
	
	
	}

}
