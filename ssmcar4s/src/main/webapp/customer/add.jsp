<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>汽车管理系统</title>
<style type="text/css">
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
	<div class="title_right">
		<strong>客户添加页面</strong>
	</div>
	<form action="${_cxt}/customer/add.do" method="post">
		<table class="table table-bordered">
			<tr>
				<td id="test">客户姓名：</td>
				<td id="value"><input type="text" name="name" /></td>
				<td id="test">性别：</td>
				<td><mt:select name="sex" header="0:---请选择---"
						data="${applicationScope.SYS_SEX}" ></mt:select>
				</td>
			</tr>
			<tr>
				<td id="test">身份证号：</td>
				<td id="value"><input type="text" name="idNo" /></td>
				<td id="test">联系电话：</td>
				<td id="value"><input type="tel" name="contactTel" /></td>
			</tr>
			<tr>
				<td id="test">职业：</td>
				<td id="value"><input type="text" name="vocation" /></td>
				<td id="test">工作单位：</td>
				<td id="value"><input type="text" name="workunit" /></td>
			</tr>
			<tr>
				<td id="test">联系地址：</td>
				<td id="value"><input type="text" name="address" /></td>
				<td id="test">备注：</td>
				<td id="value"><input type="text" name="remark" /></td>
			</tr>
		</table>
		<div style="text-align:center">
			<input type="submit" value="添加" class="btn btn-info " /> <input
				type="button" value="清空" onclick="clean1();" class="btn btn-info " />
			<input type="button" value="返回"
				onclick="location.href='${_cxt}/customer/list.do'"
				class="btn btn-info " />
		</div>

	</form>
</body>
</html>