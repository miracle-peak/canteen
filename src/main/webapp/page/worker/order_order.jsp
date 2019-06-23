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
		<title></title>
		<link rel="stylesheet" href="<%=path %>/css/pintuer.css">
		<link rel="stylesheet" href="<%=path %>/css/admin.css">
		<script src="<%= basePath%>/js/jquery.js"></script>
		<script src="<%= basePath%>/js/pintuer.js"></script>
		<script src="<%= basePath%>/laydate/laydate.js"></script>
	</head>
	<body>
		<div class="panel admin-panel">
		  <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>订餐信息</strong></div>
		  <div class="body-content">
		    <form method="post" class="form-x" action="Order_saveOrder.action" target="_parent">  
		      <div class="form-group">
		        <div class="label">
		          <label>菜品套餐编号：</label>
		        </div>
		        <div class="field">
		          <input type="text" class="input w50" value="${meal.mealId }" name="mealId" readonly="readonly"/>
		          <div class="tips"></div>
		        </div>
		      </div>
		      <div class="form-group">
		      	<div class="label">
		          <label>手机号码：</label>
		        </div>
		        <div class="field">
		          <input type="text" class="input w50"  value="" name="telephone" data-validate="required:请输入手机号码,length#<=11:请输入正确的手机号码"/>
		          <div class="tips"></div>
		        </div>
		      </div>
		      <div class="form-group">
		      	<div class="label">
		          <label>菜品套餐名称：</label>
		        </div>
		        <div class="field">
		          <input type="text" class="input w50" value="${meal.mealName }" name="mealName" readonly="readonly"/>
		          <div class="tips"></div>
		        </div>
		      </div>
		      <div class="form-group">
		      	<div class="label">
		          <label>菜品套餐价格：</label>
		        </div>
		        <div class="field">
		          <input type="text" class="input w50" value="${meal.mealPrice }" name="mealPrice" readonly="readonly"/>
		          <div class="tips"></div>
		        </div>
		      </div>
		      <div class="form-group">
		      	<div class="label">
		          <label>订餐数量：</label>
		        </div>
		        <div class="field">
		          <input type="text" class="input w50"  name="orderNumber" data-validate="required:请输入订餐数量,length#<3:订餐数量不能超过100份" />
		          <div class="tips"></div>
		        </div>
		      </div>
		      <%-- <div class="form-group">
		      	<div class="label">
		          <label>订餐时间：</label>
		        </div>
		        <div class="field">
		          <input type="text" class="input w50" value="" value="${order.orderTime }" name="orderTime" data-validate="required:请输入订餐时间"/>
		          <div class="tips"></div>
		        </div>
		      </div> --%>
		      <div class="form-group">
		        <div class="label">
		          <label></label>
		        </div>
		        <div class="field">
		          <button  class="button bg-main icon-check-square-o" type="submit"> 提交</button>
		        </div>
		      </div>
		    </form>
		  </div>
		</div>
	</body>
</html>