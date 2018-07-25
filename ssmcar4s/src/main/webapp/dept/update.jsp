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

#birthday {
	width: 173px;
	height: 20px;
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
		<strong>用户修改页面</strong>
	</div>
	<form action="${_cxt}/dept/update.do" method="post">
		<!--临时存放变量  -->
		<c:set var="v" value="${dept}" scope="page"></c:set>
		<!--为servlet层提供id-->
		<input type="hidden" name="id" value="${v.id}">
		<!--为serlet层提供初始化用户参数  -->
		<table class="table table-bordered">
			<tr>
				<td id="test">部门名称：</td>
				<td id="value"><input type="text" name="name" value="${v.name }"/></td>
				<td id="test">负责人：</td>
				<td id="value"><input type="text" name="charger" value="${v.charger }" /></td>
				<td id="test">联系电话：</td>
				<td id="value"><input type="text" name="contactTel" value="${v.contactTel }"/></td>
			</tr>
		</table>

		<div style="text-align:right">
			<input type="submit" value="更新" class="btn btn-info " /> <input
				type="button" value="清空" class="btn btn-info " onclick="clean1();" />
			<input type="button" value="返回" class="btn btn-info "
				onclick="location.href='${_cxt}/dept/list.do'" />
		</div>
	</form>
</body>
</html>