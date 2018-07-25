<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>welcome</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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

.able table-bordered input {
	
}
</style>

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
			width : '800px',
			height : '460px',
			content : 'url:${_cxt}/car/slist.do'
		});
	}
	//result格式: 车辆ID,名称
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
			width : '650px',
			height : '460px',
			content : 'url:${_cxt}/customer/slist.do'
		});
	}
	//result格式: 班级ID,班级名称
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
	<form action="${_cxt }/carsellorder/update.do" method="post">
		<c:set var="v" value="${carsellorder}" scope="page"></c:set>
		<!-- 隐藏域 -->
		<input type="hidden" name="id" value="${v.id}" />
		<table class="table table-bordered">
			<tr>
				<th colspan="4" style="font-size: 20px">修改页面</th>
			</tr>
			<tr>
				<td id="test">整车信息:</td>
				<td id="value"><input type="hidden" name="carId"
					class="span1-1" value="${v.carId }" /> <input type="text"
					name="carName" class="span1-1" readonly="readonly"
					value="${v.carName }" /> <!-- 转到javascript:openDialog() --> <a
					href="javascript:openDialog();">选择</a></td>
				<td id="test">客户名称:</td>
				<td id="value"><input type="hidden" name="customerId"
					class="span1-1" value="${v.customerId }" /> <input type="text"
					name="customerName" class="span1-1" readonly="readonly"
					value="${v.customerName }" /><a
					href="javascript:openDialog2();">选择</a></td>
			</tr>
			<tr>
				<td id="test">数量:</td>
				<td id="value"><input type="text" name="count" class="span1-1"
					value="${v.count }" /></td>
				<td id="test">销售价(单位:元):</td>
				<td id="value"><input type="text" name="sellPrice"
					class="span1-1" value="${v.sellPrice }" /></td>
			</tr>
			<tr>
				<td id="test">销售人员:</td>
				<td id="value"><input type="text" name="salesman"
					class="span1-1" value="${v.salesman }" /></td>
				<td id="test">备注:</td>
				<td id="value"><input type="text" name="remark"
					value="${v.remark }" class="ipt"></td>
			</tr>
			<tr>
				<td style="text-align:right" colspan="4"><input type="submit"
					value="更新" class="btn btn-info " /> <input type="button"
					value="清空" class="btn btn-info " onclick="clean()" /> <input
					type="button" value="返回" class="btn btn-info "
					onclick="location.href='${_cxt}/carsellorder/list.do'" /></td>
			</tr>
		</table>
	</form>
</body>
</html>
