<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
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
	var dialogf;
	function openDialogf() {//打开弹出窗口
		dialogf = $.dialog({
			title : '选择一个配件',
			width : '800px',
			height : '460px',
			content : 'url:${_cxt}/fittings/slist.do'
		});
	}
	//result格式: 配件ID,配件名称
	function closeDialogf(result) {//关闭窗口
		//alert(result);
		var arr = result.split(",");
		$("input[name=fittingsId]").val(arr[0]);
		$("input[name=fittingsName]").val(arr[1]);
		dialogf.close();//关闭窗口
	}
	var dialogf1;
	function openDialogf1() {//打开弹出窗口
		dialogf1 = $.dialog({
			title : '选择一个供应商',
			width : '850px',
			height : '500px',
			content : 'url:${_cxt}/supplier/slist.do'
		});
	}
	//result格式: 供应商ID,配件名称
	function closeDialog1(result) {//关闭窗口
		//alert(result);
		var arr = result.split(",");
		$("input[name=supplierId]").val(arr[0]);
		$("input[name=supplierName]").val(arr[1]);
		dialogf1.close();//关闭窗口
	}
</script>
</head>

<body>
	<div class="title_right">
		<strong>配件进货单添加页面</strong>
	</div>
	<form action="${_cxt}/fittingsInorder/add.do" method="post">
		<table class="table table-bordered">
			<tr>
				<td id="test">配件名称：</td>
				<td id="value"><input type="hidden" name="fittingsId"
					class="ipt" /> <input type="text" name="fittingsName" class="ipt" />
					<a href="javascript:openDialogf();">请选择...</a></td>
				<td id="test">供应商</td>
				<td id="value"><input type="hidden" name="supplierId"
					class="ipt" /> <input type="text" name="supplierName" class="ipt">
					<a href="javascript:openDialogf1();">请选择...</a></td>
				<td id="test">数量：</td>
				<td id="value"><input type="text" name="count" id="count"
					class="ipt" /></td>
			</tr>
			<tr>
				<td id="test">进货价格：</td>
				<td id="value"><input type="text" name="inPrice" id="inPrice"
					class="ipt" /></td>
				<td id="test">总价：</td>
				<td id="value"><input type="text" name="total" id="total"
					class="ipt" /></td>
			</tr>
		</table>
		<div>
			备注：<input type="text" name="remark" id="remark"
				style="height: 40px; width: 400px" />
		</div>
		<div style="text-align:right;">
			<input type="submit" value="确定" class="ipt" /> <input type="reset"
				value="清空" class="ipt" /> <input type="button" value="返回"
				onclick="location.href='${_cxt}/fittingsInorder/list.do'"
				class="btn btn-info " />
		</div>
	</form>
</body>
</html>