<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/header.jsp"%>
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
	var dialog;
	function openDialog() {//打开弹出窗口
		dialog = $.dialog({
			title : '选择一个整车',
			width : '800px',
			height : '500px',
			content : 'url:${_cxt}/car/slist.do'
		});
	}
	//result格式: 汽车品牌,车系
	function closeDialog(result) {//关闭窗口
		//alert(result);
		var arr = result.split(",");
		$("input[name=carId]").val(arr[0]);
		$("input[name=brand]").val(arr[1]);
		dialog.close();//关闭窗口
	}
</script>
</head>
<body>
	<div>
		<ul class="breadcrumb">
			<li><a href="#">当前页:首页</a>
			<li>
		</ul>
	</div>
	<form action="${_cxt}/carInorder/update.do" method="post">
		<c:set var="v" value="${carinorder}" scope="page"></c:set>
		<!-- 隐藏域 -->
		<input type="hidden" name="id" value="${v.id}">
		<table class="table table-bordered">
			<tr>
				<th colspan="4" style="font-size: 20px">修改页面</th>
			</tr>
			<tr>
				<td id="test">整车信息:</td>
				<td id="value"><input type="hidden" name="carId" class="ipt" />
					<input type="text" name="brand" readonly="readonly" class="ipt"
					value="${v.carName}" /> <a href="javascript:openDialog();">请选择...</a>
				</td>
				<td id="test">供应商:</td>
				<td id="value"><mt:select name="supplierId"
						value="${v.supplierId }" data="${applicationScope.VENDER }"
						cssClass="ipt"></mt:select></td>
			</tr>
			<tr>
				<td id="test">数量(单位:台):</td>
				<td id="value"><input type="text" name="count"
					value="${v.count }" class="ipt" /></td>
				<td id="test">单价(单位:元):</td>
				<td id="value"><input type="text" name="inPrice"
					value="${v.inPrice }" class="ipt" /></td>
			</tr>
			<tr>
				<td id="test">备注:</td>
				<td id="value" colspan="4"><input type="text" name="remark"
					value="${v.remark }" class="ipt" /></td>
			</tr>
		</table>
		<div style="text-align:center">
			<input type="submit" value="确定" class="btn btn-info" /> <input
				type="button" value="清空" class="btn btn-info" onclick="clean1();" />
			<input type="button" value="返回" class="btn btn-info "
				onclick="location.href='${_cxt}/carInorder/list.do'" />
		</div>
	</form>
</body>
</html>