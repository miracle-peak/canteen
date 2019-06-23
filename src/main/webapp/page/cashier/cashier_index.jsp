<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/base/base.jsp"%>
<!DOCTYPE html>
<html lang="zh-cn">
	<head>
	    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
	    <meta name="renderer" content="webkit">
	    <title>食堂管理系统</title>  
	    <link rel="stylesheet" href="css/pintuer.css">
	    <link rel="stylesheet" href="css/admin.css">
	    <link rel="shortcut icon" href="images/logo.jpg">
	    <script src="js/jquery.js"></script>   
	</head>
	<body style="background-color:#f2f9fd;">
		<div class="header bg-main">
		  <div class="logo margin-big-left fadein-top">
		    <h1><img src="images/logo.jpg" class="radius-circle rotate-hover" height="50" alt="" />食堂管理系统</h1>
		  </div>
		  <div class="head-l" ><a href="" target="_blank" style="color:#FFF" ><span class="icon-user"></span> 欢迎食堂出纳员 </a>&nbsp;&nbsp;<a class="button button-little bg-red" href="login.jsp"><span class="icon-power-off"></span> 退出登录</a> </div>
		</div>
		<div class="leftnav">
		  <div class="leftnav-title"><strong><span class="icon-list"></span>菜单列表</strong></div>    
		    <h2><span class="icon-user"></span>食堂出纳员管理</h2>
		  <ul>
		    <li><a href="Purchase_openExamine.action" target="right"><span class="icon-caret-right">审核采购清单</span></a></li>
		  </ul> 
		  
		</div>
		<script type="text/javascript">
			$(function(){
			  $(".leftnav h2").click(function(){
				  $(this).next().slideToggle(200);	
				  $(this).toggleClass("on"); 
			  })
			  $(".leftnav ul li a").click(function(){
				    $("#a_leader_txt").text($(this).text());
			  		$(".leftnav ul li a").removeClass("on");
					$(this).addClass("on");
			  })
			});
		</script>
		<ul class="bread">
		  <li><a href="##" id="a_leader_txt">欢迎界面</a></li>
		</ul>
		<div class="admin">
		  <iframe scrolling="auto" rameborder="0" src="page/welcome.jsp" name="right" width="100%" height="100%"></iframe>
		</div>
	</body>
</html>