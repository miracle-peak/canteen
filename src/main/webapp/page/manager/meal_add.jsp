<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import = "java.text.SimpleDateFormat, java.util.Date,
    java.util.Random"%>
<%@ include file="/base/base.jsp" %>
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
		<script type="text/javascript" src="<%=path %>/layer/layer.js"></script>
	</head>
	<body>
		<div class="panel admin-panel">
		  <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>增加菜品套餐</strong></div>
		  <div class="body-content">
		    <form method="post" class="form-x" action="Meal_save.action">  
		    	<div class="form-group">
			        <div class="label">
			          <label>菜品套餐名称：</label>
			        </div>
			        <div class="field">
			          <input type="text" class="input w50" value="" name="mealName" data-validate="required:请输入菜品套餐名称"/>
			          <div class="tips"></div>
			        </div>
		      	</div>
		      	<div class="form-group">
		          <div class="label">
		            <label>菜品套餐价格：</label>
		          </div>
		          <div class="field">
		            <input type="text" class="input w50" value="" name="mealPrice" data-validate="required:请输入菜品套餐价格"/>
			          <div class="tips"></div>
		          </div>
		        </div>
				<div class="form-group">
					<div class="label">
					  <label>菜品套餐描述：</label>
					</div>
					<div class="field">
					  <textarea name="mealDescribe" class="input" style="height:450px; border:1px solid #ddd;" data-validate="required:请输入菜品套餐描述"></textarea>
					    <div class="tips"></div>
					  </div>
				</div>
		      	<div class="form-group">
		        <div class="label">
		          <label></label>
		        </div>
		        <div class="field">
		          <button class="button bg-main icon-check-square-o" type="submit"> 提交</button>
		        </div>
		      </div>
		    </form>
		  </div>
		</div>
		<script src="<%= basePath%>/laydate/laydate.js"></script>
		<script type="text/javascript">
		     laydate.render({
		       elem: '#time'
		      ,type: 'datetime'
		     });
		</script>
	</body>
</html>