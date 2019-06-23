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
	</head>
	<body>
		<form method="post" action="Purchase_list.action" id="listform">
		  <div class="panel admin-panel">
		    <div class="panel-head"><strong class="icon-reorder">采购清单列表</strong> <a href="" style="float:right; display:none;">添加字段</a></div>
		    <div class="padding border-bottom">
		      <ul class="search" style="padding-left:10px;">
		        <li> <a class="button border-main icon-plus-square-o" href="Purchase_add.action"> 增加采购清单</a> </li>
		        <li>
		          <input type="text" placeholder="请输入开始时间" id="startTime" name="startTime" class="input" style="width:200px; line-height:17px;display:inline-block" />
		          <input type="text" placeholder="请输入结束时间" id="endTime" name="endTime" class="input" style="width:200px; line-height:17px;display:inline-block" />
		          <input type="submit" class="button border-main icon-search" value="查询采购清单信息"></li>
		      </ul>
		    </div>
		    <table id = "meal_table" class="table table-hover text-center">
		      <tr>
		      	<th>采购单号</th>
		      	<th>采购人</th>
		      	<th>总金额</th>
		      	<th>食材名称</th>
		        <th>单价</th>
		      	<th>数量</th>
		      	<th>供应商</th>
		        <th>采购日期</th>
		        <th>状态</th>
<!-- 		        <th>意见</th> -->
		      	<th width="310">操作</th>
		      </tr>
<!-- 		      <volist name="list" id="vo"> -->
				<s:iterator value="pager.list">
				<tr>
					<td>${purchaseId }</td>
					<td>${buyer }</td>
					<td>${totalAmount }</td>
					<td>${foodName }</td>
		          	<td>${foodPrice }</td>
					<td>${number }</td>
					<td>${supplier }</td>
		          	<td>${purchaseTime }</td>
		          	<td>${status }</td>
<%-- 		          	<td>${opinion }</td> --%>
					<td><div class="button-group"> <a class="button border-main" href="Purchase_edit.action?purchaseId=${purchaseId }"><span class="icon-edit"></span> 修改</a> <a class="button border-red" href="Purchase_delete.action?purchaseId=${purchaseId }" onclick="return del()"><span class="icon-trash-o"></span> 删除</a> </div></td>
		        </tr>
		        </s:iterator>
		      <tr>
		      	<td colspan="10">
			        <div class="pagelist"> 
			        	共${result.totalRecord }条记录共${result.totalPage }页&nbsp;&nbsp;当前第${result.currentPage }页
			        	<a href="#" onclick="first();">首页</a><a href="#" onclick="previousPage();">上一页</a> <a href="#" onclick="nextPage();">下一页</a><a href="#" onclick="lastPage()">尾页</a> 
			        </div>
		        </td>
<%-- 		        <td colspan="8"><div class="pagelist"> <a href="">上一页</a> <span class="current">1</span><a href="">2</a><a href="">3</a><a href="">下一页</a><a href="">尾页</a> </div></td> --%>
		      </tr>
		    </table>
		  </div>
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
		</form>
	</body>
	<script type="text/javascript">
		var url = "Purchase_list.action";
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