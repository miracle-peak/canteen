<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
	    <meta name="renderer" content="webkit">
	    <title>登录</title>  
	    <link rel="stylesheet" href="css/pintuer.css">
	    <link rel="stylesheet" href="css/admin.css">
	    <link rel="shortcut icon" href="images/logo.jpg">
	    <script src="js/jquery.js"></script>
	    <script src="js/pintuer.js"></script> 
	</head>
	<body>
		<div class="bg"></div>
		<div class="line bouncein">
			<div class="xs6 xm4 xs3-move xm4-move">
				<div style="height:150px;"></div>
		        <div class="media media-y margin-big-bottom"></div>
				<div class="panel loginbox">
					<div class="text-center margin-big padding-big-top"><h1>对不起登录失败，不存在该用户或密码错误</h1></div>
					<a href = "login.jsp" style = "color:red;font-size:26px ; ">重新登录</a><br>
				</div>
			</div>
		</div>
	</body>
</html>