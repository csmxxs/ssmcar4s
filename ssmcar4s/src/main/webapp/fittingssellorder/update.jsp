<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>汽车管理系统</title>
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
<!-- 引入弹出窗口JS库 -->
<script type="text/javascript"
	src="${_plugins}/lhgdialog/lhgdialog.min.js?self=true&skin=igreen"></script>
<script type="text/javascript">
	//客户弹出框
	var dialog2;
	function openDialog2() {//打开弹出窗口
		dialog2 = $.dialog({
			title : '选择一个配件',
			width : '750px',
			height : '460px',
			content : 'url:${_cxt}/customer/slist.do'
		});
	}
	//result格式: 配件ID,配件名称
	function closeDialog2(result) {//关闭窗口
		//alert(result);
		var arr = result.split(",");
		$("input[name=customerId]").val(arr[0]);
		$("input[name=customername]").val(arr[1]);
		dialog2.close();//关闭窗口
	}

	//配件弹出框
	var dialogf;
	function openDialogf() {//打开弹出窗口
		dialogf = $.dialog({
			title : '选择一个配件',
			width : '900px',
			height : '460px',
			content : 'url:${_cxt}/fittings/slist.do'
		});
	}
	function closeDialogf(result) {//关闭窗口
		//alert(result);
		var arr = result.split(",");
		$("input[name=fittingsId]").val(arr[0]);
		$("input[name=fittingsname]").val(arr[1]);
		dialogf.close();//关闭窗口
	}
</script>
</head>
<body>
	<div>
		<ul class="breadcrumb">
			<li><a href="#">当前页:首页</a></li>
		</ul>
	</div>
	<form action="${_cxt}/fittingssellorder/update.do" method="post">
		<c:set var="v" value="${fittingssellorder}" scope="page"></c:set>
		<input type="hidden" name="id" value="${v.id}">
		<table class="table table-bordered">
			<tr>
				<th colspan="4" style="font-size: 20px ;text-align: center;">配件销售单修改页面</th>
			</tr>
			<tr>

				<td id="test">配件信息:</td>
				<td><input type="hidden" name="fittingsId"
					value="${v.fittingsId }" /> <input type="text" name="fittingsname"
					readonly="readonly" class="ipt" value="${v.fittingsname}" /> <!--连接对应窗口,需安装控件才能实现  -->
					<a href="javascript:openDialogf();">请选择...</a></td>
				<td id="test">客户信息:</td>
				<td><input type="hidden" name="customerId"
					value="${v.customerId }" /><input type="text" name="customername"
					readonly="readonly" class="ipt" value="${v.customername}" /> <!--连接对应窗口,需安装控件才能实现  -->
					<a href="javascript:openDialog2();">请选择...</a></td>
			</tr>
			<tr>
				<td id="test">销售数量:</td>
				<td id="value"><input type="text" name="count" class="ipt"
					value="${v.count}"></td>
				<td id="test">销售单价(元):</td>
				<td id="value"><input type="text" name="sellPrice" class="ipt"
					value="${v.sellPrice }"></td>
			</tr>
			<tr>
				<td id="test">销售员:</td>
				<td id="value" colspan="4"><input type="text" name="salesman"
					class="ipt" value="${v.salesman}"></td>
			</tr>
			<tr>
				<td colspan="4">
					<div style="float: right;color: red">${msg }</div>
				</td>
			</tr>
		</table>
		<div class="text-center">
			<input type="submit" value="确定" class="btn btn-info " /> <input
				type="reset" value="重置" class="btn btn-info " /> <input
				type="button" value="返回"
				onclick="location.href='${_cxt}/fittingssellorder/list.do'"
				class="btn btn-info " />
		</div>
	</form>
</body>
</html>