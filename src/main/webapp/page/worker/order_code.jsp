<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/base/base.jsp"%>
<%
	String URL= (String)request.getAttribute("path");
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>取餐二维码</title>
	</head>
	<body>
		 <img src="${path }">
<%-- 		 <img alt="" src="<%=URL%>"> --%>
	</body>
</html>