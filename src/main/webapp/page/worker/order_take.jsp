<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
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
		<script src="<%= basePath%>/layer/layer.js"></script>
		<script src="<%= basePath%>/js/pintuer.js"></script>
	</head>
	<body>
		<form method="post" action="Order_takeOrder.action" id="listform">
		  <div class="panel admin-panel">
		    <div class="panel-head"><strong class="icon-reorder">订餐信息列表</strong> <a href="" style="float:right; display:none;">添加字段</a></div>
		    <div class="padding border-bottom">
		    	<ul class="search" style="padding-left:10px;">
		        <li>
		          <input type="text" placeholder="请输入订餐编号" name="orderId" class="input" style="width:250px; line-height:17px;display:inline-block" />
		          <input type="submit" class="button border-main icon-search" value="查询订餐信息"></li>
		      </ul>
		    </div>
		    <table id = "meal_table" class="table table-hover text-center">
		      <tr>
		      	<th>订餐编号</th>
		      	<th>菜品套餐编号</th>
		      	<th>菜品套餐名称</th>
		        <th>菜品套餐价格</th>
		      	<th>订餐数量</th>
		      	<th>订餐时间</th>
		      	<th>取餐状态</th>
		      	<th width="310">操作</th>
		      </tr>
				<s:iterator value="pagerOrder.list">
				<tr>
					<td>${orderId }</td>
					<td>${mealId }</td>
					<td>${mealName }</td>
		          	<td>${mealPrice }</td>
					<td>${orderNumber }</td>
					<td>${orderTime }</td>
					<td>${status }</td>
					<td><div class="button-group"> <button id ="preview_btn" class="button border-main" type="button" onclick = "order(${orderId })" >生成二维码</button> </div></td>
		        </tr>
		        </s:iterator>
		      <tr>
		      	<td colspan="8">
			        <div class="pagelist"> 
			        	共${result.totalRecord }条记录共${result.totalPage }页&nbsp;&nbsp;当前第${result.currentPage }页
			        	<a href="#" onclick="first();">首页</a><a href="#" onclick="previousPage();">上一页</a> <a href="#" onclick="nextPage();">下一页</a><a href="#" onclick="lastPage()">尾页</a> 
			        </div>
		        </td>
		      </tr>
		    </table>
		  </div>
		</form>
		<script type="text/javascript">
			function order(orderId) {
				 layer.open({
					  type: 2,
					  title: '取餐',
					  shadeClose: true,
					  shade: 0.8,
					  area: ['460px', '440px'],
					  content: 'Order_getCode.action?orderId='+orderId
					});
					$.ajax({
						type:"post",
						data:{
							"filePath":"http://localhost:8080/canteen/images/二维码"+orderId+".jpg",
						},
						dataType:"JSON",
						url:"<%=basePath %>/page/worker/order_code.jsp",	
// 						url:"/page/worker/order_info.jsp",	
						async:false,
						success:function(data){
							console.log(data);
							},
						error:function(){
							console.log("错误");
							}
						}); 
			}
		</script>
	</body>
	<script type="text/javascript">
		var url = "Order_takeOrder.action";
		var currentPage = ${result.currentPage};
		var totalPage = ${result.totalPage};
// 		上一页
		function previousPage(){
			console.log("上一页=="+currentPage);
			if(currentPage > 1){
		    	window.location.href  = url+"?pageNumber="+(currentPage-1);
			}
		}
		//首页
		function first(){
		   window.location.href  = url+"?pageNumber=1";
		}
		//下一页
		function nextPage(){
			console.log("上一页"+currentPage);
			console.log("下一页"+totalPage);
			if(currentPage < totalPage){
				window.location.href  = url+"?pageNumber="+(currentPage+1);
			}
		}
		//尾页
		function lastPage(){
			if(currentPage == totalPage){
				return;
			}else{
				window.location.href  = url+"?pageNumber="+totalPage;
			}
		}
	</script>
</html>