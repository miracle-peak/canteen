<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import = "java.text.SimpleDateFormat, java.util.Date,
    java.util.Random"%>
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
	</head>
	<body>
		<div class="panel admin-panel">
		  <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>审核请假申请</strong></div>
		  <div class="body-content">
		    <form method="post" class="form-x" action="Purchase_updateExainme.action" target="_parent">  
		   		<div class="form-group">
			        <div class="label">
			          <label>采购单号：</label>
			        </div>
			        <div class="field">
			          <input type="text" class="input w50" value="${purchase.purchaseId }" name=purchaseId readonly="readonly"/>
			          <div class="tips"></div>
			        </div>
		      	</div>
		   		<div class="form-group">
			        <div class="label">
			          <label>采购人：</label>
			        </div>
			        <div class="field">
			          <input type="text" class="input w50" value="${purchase.buyer }" name="buyer" readonly="readonly"/>
			          <div class="tips"></div>
			        </div>
		      	</div>
				<div class="form-group">
			        <div class="label">
			          <label>总金额：</label>
			        </div>
			        <div class="field">
			          <input type="text" class="input w50" value="${purchase.totalAmount }" name="totalAmount" readonly="readonly"/>
			          <div class="tips"></div>
			        </div>
		      	</div>
		      	<div class="form-group">
			        <div class="label">
			          <label>食材名称：</label>
			        </div>
			        <div class="field">
			          <input type="text" class="input w50" value="${purchase.foodName }" name="foodName" readonly="readonly"/>
			          <div class="tips"></div>
			        </div>
		      	</div>	
		      	<div class="form-group">
			        <div class="label">
			          <label>单价：</label>
			        </div>
			        <div class="field">
			          <input type="text" class="input w50" value="${purchase.foodPrice }" name="foodPrice" readonly="readonly"/>
			          <div class="tips"></div>
			        </div>
		      	</div>	
		      	<div class="form-group">
			        <div class="label">
			          <label>数量：</label>
			        </div>
			        <div class="field">
			          <input type="text" class="input w50" value="${purchase.number }" name="number" readonly="readonly"/>
			          <div class="tips"></div>
			        </div>
		      	</div>
		      	<div class="form-group">
			        <div class="label">
			          <label>供应商：</label>
			        </div>
			        <div class="field">
			          <input type="text" class="input w50" value="${purchase.supplier }" name="supplier" readonly="readonly"/>
			          <div class="tips"></div>
			        </div>
		      	</div>
		      	<div class="form-group">
			        <div class="label">
			          <label>采购日期：</label>
			        </div>
			        <div class="field">
			          <input type="text" class="input w50" value="${purchase.purchaseTime }" name="purchaseTime" readonly="readonly"/>
			          <div class="tips"></div>
			        </div>
		      	</div>
		      	<div class="form-group">
			        <div class="label">
			          <label>审核状态：</label>
			        </div>
			        <div class="field">
			          <div class="button-group radio">
			          
			          <label class="button active">
			         	  <span class="icon icon-check"></span>             
			              <input name="status" value="1" type="radio" checked="checked">同意             
			          </label>             
			        
			          <label class="button active"><span class="icon icon-times"></span>          	
			              <input name="status" value="2"  type="radio" >不同意
			          </label>         
			           </div>       
			        </div>
			    </div>
			    <div class="form-group">
					<div class="label">
					  <label>审核意见：</label>
					</div>
					<div class="field">
					  <textarea name="opinion" class="input" style="height:260px; border:1px solid #ddd;"></textarea>
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
	</body>
</html>