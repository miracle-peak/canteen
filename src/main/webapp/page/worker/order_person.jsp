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
		<script src="<%= basePath%>/js/pintuer.js"></script>
		<script src="<%= basePath%>/laydate/laydate.js"></script>
	</head>
	<body>
		<form method="post" action="Order_person.action" id="listform">
		  <div class="panel admin-panel">
		    <div class="panel-head"><strong class="icon-reorder">个人订餐信息列表</strong> <a href="" style="float:right; display:none;">添加字段</a></div>
		    <div class="padding border-bottom">
		      <ul class="search" style="padding-left:10px;">
		        <li>
		         <input type="text" placeholder="请输入开始时间" id="startTime" name="startTime" class="input" style="width:200px; line-height:17px;display:inline-block" />
		          <input type="text" placeholder="请输入结束时间" id="endTime" name="endTime" class="input" style="width:200px; line-height:17px;display:inline-block" />
<!-- 		          <input type="button" id="btn_q" class="button border-main icon-search" value="查询个人订餐信息"></li> -->
		          <input type="submit" id="btn_q" class="button border-main icon-search" value="查询个人订餐信息"></li>
		      </ul>
		    </div>
		    <table id = "meal_table" class="table table-hover text-center">
		      <tr>
		      	<th>订餐编号</th>
		      	<th>手机号码</th>
		      	<th>菜品套餐编号</th>
		      	<th>菜品套餐名称</th>
		        <th>菜品套餐价格</th>
		      	<th>订餐数量</th>
		      	<th>订餐时间</th>
		      	<th width="310">操作</th>
		      </tr>
				<s:iterator value="pagerOrder.list">
				<tr>
					<td>${orderId }</td>
					<td>${telephone }</td>
					<td>${mealId }</td>
					<td>${mealName }</td>
		          	<td>${mealPrice }</td>
					<td>${orderNumber }</td>
					<td>${orderTime }</td>
					<td><div class="button-group"> <a class="button border-red" href="Order_deleteOrder.action?orderId=${orderId }" onclick="return del()"><span class="icon-trash-o"></span> 删除</a> </div></td>
		        </tr>
		        </s:iterator>
		      <tr>
		      	<td colspan="8">
			        <div class="pagelist"> 
			        	共${result.totalRecord }条记录共${result.totalPage }页&nbsp;&nbsp;当前第${result.currentPage }页
			        	<a href="#" onclick="first();">首页</a><a href="#" onclick="previousPage();">上一页</a> <a href="#" onclick="nextPage();">下一页</a><a href="#" onclick="lastPage()">尾页</a> 
			        </div>
		        </td>
<%-- 		        <td colspan="8"><div class="pagelist"> <a href="">上一页</a> <span class="current">1</span><a href="">2</a><a href="">3</a><a href="">下一页</a><a href="">尾页</a> </div></td> --%>
		      </tr>
		    </table>
		  </div>
		</form>
	</body>
		<script type="text/javascript">
			function del(){
				var r = confirm("您确定要删除吗?");
				if(r==true){
					alert("删除成功");
					return r;
				}else{
					return r;
	
				}
			}
		</script>
		<script type="text/javascript">
			laydate.render({
				elem:'#startTime',
				type:'datetime'
			});
		</script>
		<script type="text/javascript">
			laydate.render({
				elem:'#endTime',
				type:'datetime'
			});
		</script>
		<%-- <script type="text/javascript">
			$("#btn_q").on('click',function(){
				console.log("点击");
				$.ajax({
					type:'post',
					url:'Order_person.action',
					data:{
						'startTime':$('#startTime').val(),
						'endTime':$('#endTime').val(),
					},
					dataType:'JSON',
					async:true,
				});
				console.log("6");
			});
		</script> --%>
		<script type="text/javascript">
		var url = "Order_person.action";
		var currentPage = ${result.currentPage};
		var totalPage = ${result.totalPage};
// 		上一页
		function previousPage(){
			console.log("上一页=="+currentPage);
			if(currentPage > 1){
		    	window.location.href  = url+"?pageNumber="+(currentPage-1);
			}
			/* $.ajax({
				url:url,
				type:"post",
				data:{
					"pageNumber":(currentPage-1),
				},
				dataType:"JSON",
				

				}); */
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
			/* $.ajax({
				url:url,
				type:"post",
				data:{
					"pageNumber":(currentPage+1),
				},
				dataType:"JSON",
				

				}); */
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