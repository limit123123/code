<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="UTF-8">
	<!--	窗口自适应-->
	<meta name="viewport" content="width=device-width, initial-scale=1">
<title>登录</title>

<link rel="stylesheet" href="css/font-awesome-4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="css/style.css">

</head>
<body>

<div class="materialContainer">
	<div class="box">
		<a href="regist.html" class="create-user">注册账号</a>
	<form action="/LimitBlog/UserServlet" id="login" method="post">
		
		<div class="title">登录</div>
			<span style="color:red">${err }</span>
		<div class="input">
			<label for="name">用户名</label>
			<input type="text" name="username" id="name">
			<span class="spin"></span>
		</div>
		<div class="input">
			<label for="pass">密码</label>
			<input type="password" name="password" id="pass">
			<span class="spin"></span>
		</div>
		<div class="button login">
			<button>
				<span>登录</span>
				<i class="fa fa-check"></i>
			</button>
		</div>
		<a href="javascript:" class="pass-forgot">忘记密码？</a>
			</form>
			
	</div>

</div>
<script src="js/jquery.min.js"></script>
<script src="js/index.js"></script>
</body>
</html>