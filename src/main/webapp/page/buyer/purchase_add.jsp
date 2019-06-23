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
	</head>
	<body>
		<div class="panel admin-panel">
		  <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>填写采购清单</strong></div>
		  <div class="body-content">
		    <form method="post" class="form-x" action="Purchase_save.action">  
		      	<!-- <div class="form-group">
		          <div class="label">
		            <label>采购人：</label>
		          </div>
		          <div class="field">
			          <input type="text" class="input w50" value="" name="buyer" data-validate="required:请输入采购人"/>
			          <div class="tips"></div>
			        </div>
		        </div> -->
		   		<div class="form-group">
			        <div class="label">
			          <label>食材名称：</label>
			        </div>
			        <div class="field">
			          <input type="text" class="input w50" value="" name="foodName" data-validate="required:请输入食材名称"/>
			          <div class="tips"></div>
			        </div>
		      	</div>
		      	<div class="form-group">
			        <div class="label">
			          <label>单价：</label>
			        </div>
			        <div class="field">
			          <input type="text" class="input w50" value="" name="foodPrice" data-validate="required:请输入单价"/>
			          <div class="tips"></div>
			        </div>
		      	</div>
		      	<div class="form-group">
			        <div class="label">
			          <label>数量：</label>
			        </div>
			        <div class="field">
			          <input type="text" class="input w50" value="" name="number" data-validate="required:请输入数量"/>
			          <div class="tips"></div>
			        </div>
		      	</div>
		      	<div class="form-group">
		          <div class="label">
		            <label>总金额：</label>
		          </div>
		          <div class="field">
			          <input type="text" class="input w50" value="" name="totalAmount" data-validate="required:请输入总金额"/>
			          <div class="tips"></div>
			        </div>
		        </div>
		      	<div class="form-group">
			        <div class="label">
			          <label>供应商：</label>
			        </div>
			        <div class="field">
			          <input type="text" class="input w50" value="" name="supplier" data-validate="required:请输入供应商"/>
			          <div class="tips"></div>
			        </div>
		      	</div>
		      	<div class="form-group">
			        <div class="label">
			          <label>采购日期：</label>
			        </div>
			        <div class="field">
			          <input type="text" class="input w50" value="" id="purchaseTime" name="purchaseTime" data-validate="required:请输入采购日期"/>
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
		       elem: '#purchaseTime'
		      ,type: 'datetime'
		     });
		</script>
	</body>
</html>