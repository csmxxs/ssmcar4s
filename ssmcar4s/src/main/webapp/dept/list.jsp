<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>汽车管理系统</title>
<!-- 引入弹出窗口JS库 -->
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
	<form action="${_cxt}/dept/list.do" method="post" id="fm1">
		<!-- 隐藏域 -->
		<table class="table table-bordered">
			<tr>
				<td colspan="4">查询条件</td>
			</tr>
			<tr>
				<td id="test">部门名称：</td>
				<td id="value"><input type="text" name="name" /></td>
				<td id="test">负责人：</td>
				<td id="value"><input type="text" name="charger" /></td>
				<td id="test">联系电话：</td>
				<td><input type="text" name="contactTel" /></td>
			</tr>
		</table>
		<div style="text-align:right">
			<input type="submit" value="查询" class="btn btn-info " /> <input
				type="button" value="清空" class="btn btn-info " onclick="clean1();" />
			<input type="button" value="新增"
				onclick="location.href='${_cxt}/dept/add.jsp'" class="btn btn-info " />
		</div>
		<br />
		<table class="table table-bordered">
			<tr>
				<th  colspan="12"  style="font-size: 20px;text-align:center">部门列表
					<div style="float: right;margin-right: 10px;color: red;">${msg}</div>
				</th>
			</tr>
			<tr>
				<th>记录ID</th>
				<th>部门名称:</th>
				<th>负责人:</th>
				<th>联系电话:</th>
				<th>创建日期</th>
				<th>操作</th>
			</tr>
			<c:forEach var="v" items="${list}" varStatus="vs">
				<tr style="text-align:center" class="tr${vs.count%2}">
					<td>${v.id}</td>
					<td>${v.name}</td>
					<td>${v.charger}</td>
					<td>${v.contactTel}</td>
					<td><fmt:formatDate value="${v.createDate}"
							pattern="yyyy-MM-dd" /></td>
					<td><a href="${_cxt}/dept/delete.do?id=${v.id}"
						onclick="return confirm('确定删除吗？')">删除</a> | <a
						href="${_cxt}/dept/update.do?deptId=${v.id}">更新</a></td>
			</c:forEach>
		</table>
		<%@ include file="/common/pager.jsp"%>
	</form>
</body>
</html>