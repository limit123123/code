package com.limit123.servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sun.misc.BASE64Encoder;

@WebServlet("/DownloadServlet")
public class DownloadServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*******************1.接收请求参数***********************************/
		// 接收文件名参数
		String name = request.getParameter("filename");
		System.out.println(name);
		
		/*******************2.对接收的参数进行编码处理**************************/
		//获取参数  ，默认会对参数进行编码    ISO8859-1
		//把乱码转回二进制位
		/*
		byte[] bytes = name.getBytes("ISO8859-1");
		//再去使用UTF-8进行编码
		name = new String(bytes,"UTF-8");
		System.out.println(name);
		*/
		
		/*******************3.告诉浏览器响应的文件的类型*************************/
		// 根据文件名来获取mime类型
		String mimeType = this.getServletContext().getMimeType(name);
		// 设置 mimeType
		response.setContentType(mimeType);
		
		/*******************4.告诉浏览器以附件的形式下载*************************/		
		// 获取客户端信息
		String agent = request.getHeader("User-Agent");
		// 定义一个变量记录编码之后的名字
		String filenameEncoder = "";
		if (agent.contains("MSIE")) {
			// IE编码
			filenameEncoder = URLEncoder.encode(name, "utf-8");
			filenameEncoder = filenameEncoder.replace("+", " ");
		} else if (agent.contains("Firefox")) {
			// 火狐编码
			BASE64Encoder base64Encoder = new BASE64Encoder();
			filenameEncoder = "=?utf-8?B?" + base64Encoder.encode(name.getBytes("utf-8")) + "?=";
		} else {
			// 浏览器编码
			filenameEncoder = URLEncoder.encode(name, "utf-8");
		}
		
		// 告诉浏览器是以附件形式来下载 不要解析
		response.setHeader("Content-Disposition", "attachment;filename=" + filenameEncoder);
		
		/********************5.加载文件响应给浏览器*************************/
		// 拼接文件的路径
		String path = this.getServletContext().getRealPath("download/" + name);
		// 根据path加载文件
		FileInputStream in = new FileInputStream(path);
		// 获取响应的输出
		ServletOutputStream out = response.getOutputStream();
		byte[] buffer = new byte[1024];
		int len = 0;
		while ((len = in.read(buffer)) != -1) {
			// 写到响应当中
			out.write(buffer, 0, len);
		}
		// 关闭文件
		in.close();
	}
}
