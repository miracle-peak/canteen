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
		<script src="<%=path %>/layer/layer.js"></script>
		<script src="<%= basePath%>/js/pintuer.js"></script>
	</head>
	<body>
		<form method="post" action="Purchase_findBypage.action" id="listform" >
		  <div class="panel admin-panel">
		    <div class="panel-head"><strong class="icon-reorder">采购清单列表</strong> <a href="" style="float:right; display:none;">添加字段</a></div>
		    <div class="padding border-bottom">
		      <ul class="search" style="padding-left:10px;">
		        <li>
		          <input type="text" placeholder="请输入采购员" name="buyer" class="input" style="width:250px; line-height:17px;display:inline-block" />
		          <input type="submit" class="button border-main icon-search" value="查询采购员清单信息"></li>
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
		      </tr>
				<s:iterator value="pager.list">
				<tr>
					<td>${purchaseId }</td>
					<td>${buyer }</td>
					<td>${totalAmount }</td>
					<td>${foodName }</td>
		          	<td>${foodPrice }</td>
					<td>${number }</td>
					<td>${Supplier }</td>
		          	<td>${purchaseTime }</td>
		          	<td>${status }</td>
		          	<td>${opinion }</td>
		          	<td>
		          	<td><div class="button-group"> <button id ="preview_btn" class="button border-main" type="button" onclick="examine(${purchaseId })" >审核</button></div></td>
		        </tr>
		        </s:iterator>
		      <tr>
		      	<td colspan="10">
			        <div class="pagelist"> 
			        	共${result.totalRecord }条记录共${result.totalPage }页&nbsp;&nbsp;当前第${result.currentPage }页
			        	<a href="#" onclick="first();">首页</a><a href="#" onclick="previousPage();">上一页</a> <a href="#" onclick="nextPage();">下一页</a><a href="#" onclick="lastPage()">尾页</a> 
			        </div>
		        </td>
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
			
			function examine(purchaseId) {
				console.log("test");
				console.log()
				 layer.open({
					  type: 2,
					  title: '审核采购清单',
					  shadeClose: true,
					  shade: 0.8,
					  area: ['66%', '90%'],
					  content: 'Purchase_examine.action?purchaseId='+purchaseId
					}); 
			}
		</script>
		</form>
	</body>
	<script type="text/javascript">
		var url = "Purchase_findBypage.action";
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