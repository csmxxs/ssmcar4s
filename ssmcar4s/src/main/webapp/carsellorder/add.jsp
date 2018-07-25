<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>整车销售订单添加</title>
<style>
#test {
	width: 10%;
	text-align: center;
	background-color: #f1f1f1;
}

#value {
	width: 23%;
}

.btn btn-info {
	width: 50px;
}
</style>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<!-- 引入外部JS文件 -->
<script type="text/javascript" src="${_plugins}/jquery/jquery-1.7.2.js"></script>
<!-- 引入弹出窗口JS库 -->
<script type="text/javascript"
	src="${_plugins}/lhgdialog/lhgdialog.min.js?self=true&skin=blue"></script>
<script type="text/javascript">
	var dialog;
	function openDialog() {//打开弹出窗口
		dialog = $.dialog({
			title : '选择一个整车',
			width : '950px',
			height : '460px',
			content : 'url:${_cxt}/car/slist.do'
		});
	}
	//result格式: 车辆ID,名称名称
	function closeDialog(result) {//关闭窗口
		//alert(result);
		var arr = result.split(",");
		$("input[name=carId]").val(arr[0]);
		$("input[name=carName]").val(arr[1]);
		dialog.close();//关闭窗口
	}

	var dialog2;
	function openDialog2() {//打开弹出窗口
		dialog2 = $.dialog({
			title : '选择一个客户',
			width : '800px',
			height : '460px',
			content : 'url:${_cxt}/customer/slist.do'
		});
	}
	//result格式: 客户ID,名称
	function closeDialog2(result) {//关闭窗口
		//alert(result);
		var arr = result.split(",");
		$("input[name=customerId]").val(arr[0]);
		$("input[name=customerName]").val(arr[1]);
		dialog2.close();//关闭窗口
	}
</script>

<body>
	<div>
		<ul class="breadcrumb">
			<li><a href="#">当前页:首页</a>
			<li>
		</ul>
	</div>
	<br>
	<form action="${_cxt }/carsellorder/add.do"  method="post">
		<table class="table table-bordered">
			<tr>
				<td id="test">整车信息：</td>
				<td id="value"><input type="hidden" name="carId" /> <input type="text" name="carName"readonly="readonly" />
					<a href="javascript:openDialog();">选择</a></td>
				<td id="test">客户名称：</td>
				<td id="value"><input type="hidden" name="customerId" /> <input type="text" name="customerName" readonly="readonly" />
					<a href="javascript:openDialog2();">选择</a></td>
			</tr>
			<tr>
				<td id="test">数量：</td>
				<td id="value"><input type="text" name="count" />
				</td>
				<td id="test">单价(万)：</td>
				<td id="value"><input type="text" name="sellPrice" /></td>
			</tr>
			<tr>
				<td id="test">销售人员：</td>
				<td id="value"><input type="text" name="salesman" value="${sessionScope.user.name}" /></td>
				<td id="test">备注：</td>
				<td id="value"><input type="text" name="remark" ></td>
			</tr>
			<tr>
				<td  style="text-align:right" colspan="4"><input type="submit" value="添加"
					class="btn btn-info " /> <input type="button"
					value="清空" class="btn btn-info " onclick="clean()"/>
					 <input type="button" value="返回"
					class="btn btn-info " onclick="location.href='${_cxt}/carsellorder/list.do'" /></td>
			</tr>
		</table>
	</form>
</body>
</html>
