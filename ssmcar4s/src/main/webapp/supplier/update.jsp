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
		<strong>供应商修改页面</strong>
	</div>
	<form action="${_cxt}/supplier/update.do" method="post">
		<c:set var="v" value="${supplier}" scope="page"></c:set>
		<input type="hidden" name="id" value="${v.id}">
		<table class="table table-bordered">
			<tr>
				<td id="test">供应商名称:</td>
				<td id="value"><input type="text" name="name" value="${v.name}"
					class="ipt" /></td>
				<td id="test">联系电话:</td>
				<td id="value"><input type="text" name="contactTel"
					value="${v.contactTel}" class="ipt" /></td>
			</tr>
			<tr>
				<td id="test">联系人:</td>
				<td id="value"><input type="text" name="contacts"
					value="${v.contacts}" class="ipt" /></td>
				<td id="test">开户银行:</td>
				<td id="value"><input type="text" name="bankName"
					value="${v.bankName}" class="ipt" /></td>
			</tr>
			<tr>
				<td id="test">银行账号:</td>
				<td id="value"><input type="text" name="bankAccount"
					value="${v.bankAccount}" class="ipt" /></td>
				<td id="test">备注:</td>
				<td id="value"><input type="text" name="remark"
					value="${v.remark}" class="ipt"></td>
			</tr>
		</table>
		<div style="text-align:right">
			<input type="submit" value="确定" class="btn btn-info " /> <input
				type="button" value="清空" onclick="clean1();" class="btn btn-info " />
			<input type="button" value="返回"
				onclick="location.href='${_cxt}/supplier/list.do'"
				class="btn btn-info " />
		</div>
	</form>
</body>
</html>