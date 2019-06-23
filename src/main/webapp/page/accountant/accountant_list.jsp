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
		<script src="<%= basePath%>/laydate/laydate.js"></script>
		<script src="<%= basePath%>/js/pintuer.js"></script>
	</head>
	<body>
		<form method="post" action="Accountant_list.action" id="listform">
		  <div class="panel admin-panel">
		    <div class="panel-head"><strong class="icon-reorder">订餐信息列表</strong> <a href="" style="float:right; display:none;">添加字段</a></div>
		    <div class="padding border-bottom">
		      <ul class="search" style="padding-left:10px;">
		        <li>
		          <input type="text" placeholder="请输入工作人员工号"  name="workerId" class="input" style="width:250px; line-height:17px;display:inline-block" />
		          <input type="text" placeholder="请输入开始时间" id="startTime" name="startTime" class="input" style="width:200px; line-height:17px;display:inline-block" />
		          <input type="text" placeholder="请输入结束时间" id="endTime" name="endTime" class="input" style="width:200px; line-height:17px;display:inline-block" />
		          <input type="submit" class="button border-main icon-search" value="查询工作人员订餐信息"></li>
		          <li> <input type = "button" class = "button border-main icon-plus-square" value = "导出Excel" onclick="tableToExcel('order_table','员工费用清单')"> </li>
		      </ul>
		    </div>
		    <table id = "order_table" class="table table-hover text-center">
		    	<tr>
		          	<td colspan="4">总费用： ${totalCost }</td>
		          	<td>用餐次数： ${totalNumber }</td>
		      	</tr>
		      <tr>
		      	<th>订餐编号</th>
		      	<th>工作人员工号</th>
		      	<th>菜品套餐编号</th>
		      	<th>菜品套餐名称</th>
		        <th>菜品套餐价格</th>
		        <th>订餐数量</th>
		        <th>订餐时间</th>
		      </tr>
				<s:iterator value="list">
				<tr>
					<td>${orderId }</td>
					<td>${workerId }</td>
					<td>${mealId }</td>
					<td>${mealName }</td>
		          	<td>${mealPrice }</td>
		          	<td>${orderNumber }</td>
		          	<td>${orderTime }</td>
		        </tr>
		        </s:iterator>
<!-- 		        <tr> -->
<%-- 		          	<td colspan="4">总费用： ${totalCost }</td> --%>
<%-- 		          	<td>用餐次数： ${totalNumber }</td> --%>
<!-- 		        </tr> -->
		      <tr>
		      	<%-- <td colspan="8">
			        <div class="pagelist"> 
			        	共${result.totalRecord }条记录共${result.totalPage }页&nbsp;&nbsp;当前第${result.currentPage }页
			        	<a href="#" onclick="first();">首页</a><a href="#" onclick="previousPage();">上一页</a> <a href="#" onclick="nextPage();">下一页</a><a href="#" onclick="lastPage()">尾页</a> 
			        </div>
		        </td> --%>
		        <td colspan="8"><div class="pagelist"> <a href="">上一页</a> <span class="current">1</span><a href="">2</a><a href="">3</a><a href="">下一页</a><a href="">尾页</a> </div></td>
		      </tr>
		    </table>
		  </div>
		</form>
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
	</body>
	<script type="text/javascript">
			function base64 (content) {
			       return window.btoa(unescape(encodeURIComponent(content)));         
			    }
			    function tableToExcel(tableID,fileName){
			        var table = document.getElementById(tableID);
			      var excelContent = table.innerHTML;
			      var excelFile = "<html xmlns:o='urn:schemas-microsoft-com:office:office' xmlns:x='urn:schemas-microsoft-com:office:excel' xmlns='http://www.w3.org/TR/REC-html40'>";
			      excelFile += "<head><!--[if gte mso 9]><xml><x:ExcelWorkbook><x:ExcelWorksheets><x:ExcelWorksheet><x:Name>{worksheet}</x:Name><x:WorksheetOptions><x:DisplayGridlines/></x:WorksheetOptions></x:ExcelWorksheet></x:ExcelWorksheets></x:ExcelWorkbook></xml><![endif]--></head>";
			      excelFile += "<body><table>";
			      excelFile += excelContent;
			      excelFile += "</table></body>";
			      excelFile += "</html>";
			      var link = "data:application/vnd.ms-excel;base64," + base64(excelFile);
			      var a = document.createElement("a");
			      a.download = fileName+".xlsx";
			      a.href = link;
			      a.click();
			    }
		</script>
		<script type="text/javascript">
			function order(mealId) {
				 layer.open({
					  type: 2,
					  title: '订餐',
					  shadeClose: true,
					  shade: 0.8,
					  area: ['66%', '90%'],
					  content: 'Order_openOrder.action?mealId='+mealId
					}); 
			}
		</script>
	</body>
		<script type="text/javascript">
		var url = "Accountant_listPage.action";
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