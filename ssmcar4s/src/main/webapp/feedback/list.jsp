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
	src="${_plugins}/lhgdialog/lhgdialog.min.js?self=true&skin=igreen">
</script>
</head>
<body>
	<div>
		<ul class="breadcrumb">
			<li><a href="#">当前页:首页</a></li>
		</ul>
	</div>
	<form action="${_cxt}/feedback/list.do" method="post" id="fm1">
		<table class="table table-bordered">
			<tr>
				<td colspan="4">查询条件</td>
			</tr>
			<tr>

				<td id="test">反馈主题:</td>
				<td id="value"><input type="text" name="title" /></td>
				<td id="test">客户姓名:</td>
				<td id="value"><input type="text" name="customername" /></td>
			</tr>
		</table>

		<div style="text-align:right">
			<input type="submit" value="查询" class="btn btn-info " /> <input
				type="button" value="清空" onclick="clean1();" class="btn btn-info " />
			<input type="button" value="新增"
				onclick="location.href='${_cxt}/feedback/add.jsp'"
				class="btn btn-info " />
		</div>

		<table class="table table-bordered">
			<tr>
				<th colspan="12" style="font-size: 20px">用户列表
					<div style="float: right;margin-right: 10px;color: red;">${msg}</div>
				</th>
			</tr>
			<tr>
				<th>记录ID</th>
				<th>反馈主题</th>
				<th>客户姓名</th>
				<th>联系电话</th>
				<th>反馈信息</th>
				<th>创建日期</th>
				<th>操作</th>
			</tr>
			<c:forEach var="v" items="${list}" varStatus="vs">
				<tr style="text-align:center" class="tr${vs.count%2}">
					<td>${v.id}</td>
					<td>${v.title}</td>
					<td>${v.customername}</td>
					<td>${v.customertel}</td>
					<td>${v.info}</td>
					<td><fmt:formatDate value="${v.createDate}"  pattern="yyyy-MM-dd"/></td>
					<td><a href="${_cxt}/feedback/delete.do?id=${v.id}"
						onclick="return confirm('确定删除吗？')">删除</a> | <a
						href="${_cxt}/feedback/update.do?feedbackId=${v.id}">更新</a></td>
				</tr>
			</c:forEach>
		</table>
		<%@ include file="/common/pager.jsp"%>
	</form>
</body>
</html>