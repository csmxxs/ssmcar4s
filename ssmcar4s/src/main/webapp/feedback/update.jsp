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
			title : '选择一个客户',
			width : '800px',
			height : '460px',
			content : 'url:${_cxt}/customer/slist.do'
		});
	}
	function closeDialog2(result) {//关闭窗口
		//alert(result);
		var arr = result.split(",");
		$("input[name=customerId]").val(arr[0]);
		$("input[name=customername]").val(arr[1]);
		dialog.close();//关闭窗口
	}	
</script>
</head>
<body>
	<div>
		<ul class="breadcrumb">
			<li><a href="#">当前页:首页</a></li>
		</ul>
	</div>
	<div class="title_right">
		<strong>用户修改页面</strong>
	</div>
	<!-- 临时存放 -->
	<c:set var="v" value="${feedback}" scope="page"></c:set>
	<form action="${_cxt}/feedback/update.do" method="post">
		<!-- 隐藏域 -->
		<input type="hidden" name="id" value="${v.id}" />
		<table class="table table-bordered">
			<tr>
				<td colspan="4">查询条件</td>
			</tr>
			<tr>

				<td id="test">反馈主题:</td>
				<td id="value"><input type="text" name="title" value="${v.title }"/></td>
				<td id="test">客户姓名:</td>
				<td id="value"><input type="hidden" name="customerId"
					class="ipt"> <input type="text" name="customername"
					readonly="readonly" class="ipt" value="${v.customername }"/> <a
					href="javascript:openDialog();">选择</a></td>
			</tr>
			<tr>
				<td id="test">反馈信息</td>
				<td>
				<input type="hidden" value="${v.info}" id="info"/>
				<textarea id="text" name="info" rows="2" cols="3" class="ipt">
				</textarea>
				</td>
			</tr>
		</table>
		<div style="text-align:right">
			<input type="submit" value="更新" class="btn btn-info" /> <input
				type="button" value="清空" onclick="clean1();" class="btn btn-info" />
			<input type="button" value="返回"
				onclick="location.href='${_cxt}/feedback/list.do'"
				class="btn btn-info" />
		</div>
	</form>
<script>
 var text = document.getElementById("info").value;
 document.getElementById("text").innerHTML=text;
</script>	
	
</body>
</html>