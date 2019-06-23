<%@page import="java.io.IOException"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%!
  public void process(HttpServletRequest request,HttpServletResponse resp,String url)throws ServletException,IOException{
  
     RequestDispatcher rd=request.getRequestDispatcher(url);
      rd.forward(request, resp);
  }

%>