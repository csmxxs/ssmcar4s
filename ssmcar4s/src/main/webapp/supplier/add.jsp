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
</head>

<body>
	<div class="right_cont">
		<ul class="breadcrumb">
			<li><a href="#">当前页:首页</a></li>
		</ul>
	</div>
	<div class="title_right">
		<strong>供应商添加页面</strong>
	</div>
	<form action="${_cxt}/supplier/add.do" method="post">
		<table class="table table-bordered">
			<tr>
				<td id="test">供应商名称:</td>
				<td id="value"><input type="text" name="name" /></td>
				<td id="test">联系电话:</td>
				<td id="value"><input type="text" name="contactTel"
					id="input18" /></td>
			</tr>
			<tr>
				<td id="test">联系人:</td>
				<td id="value"><input type="text" name="contacts" /></td>
				<td id="test">开户银行:</td>
				<td id="value" colspan="4"><input type="text" name="bankName"
					id="" /></td>
			</tr>
			<tr>
				<td id="test">银行账号:</td>
				<td id="value"><input type="text" name="bankAccount"  /></td>
				<td id="test">备注:</td>
				<td id="value" colspan="4"><input type="text" name="remark"></td>
			</tr>
		</table>
		<div style="text-align:right">
			<input type="submit" value="确定" class="btn btn-info" /> <input
				type="reset" value="清空" class="btn btn-info" /> <input type="button"
				value="返回" onclick="location.href='${_cxt}/supplier/list.do'"
				class="btn btn-info " />
		</div>
	</form>
</body>
</html>