<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>汽车管理系统</title>
<style type="text/css">
center a {
	/*去掉下划线  */
	text-decoration: none;
}

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

</head>
<body>
	<div>
		<ul class="breadcrumb">
			<li><a href="#">当前页:首页</a></li>
		</ul>
	</div>
	<form action="${_cxt}/customer/list.do" method="post" id="fm1">
		<table class="table table-bordered">
			<tr>
				<td id="test">客户姓名：</td>
				<td id="value"><input type="text" name="name" /></td>
				<td id="test">性别：</td>
				<td><mt:select name="sex" header="0:--请选择--"
						data="${applicationScope.SYS_SEX}" /></td>
				<td id="test">身份证：</td>
				<td id="value"><input type="text" name="idNo" /></td>
			</tr>
		</table>
		<div style="text-align:center">
			<input type="submit" value="查询" class="btn btn-info " /> <input
				type="button" value="清空" class="btn btn-info " onclick="clean();" />
			<input type="button" value="新增"
				onclick="location.href='${_cxt}/customer/add.jsp'"
				class="btn btn-info " />
		</div>
		<br />
		<br />
		<table class="table table-bordered">
		    <tr>
		      <th colspan="12" style="font-size: 20px">
		      <div style="float: right;margin-right: 10px;color: red;">${msg}</div>
		        客户信息列表
		      </th>
		    </tr>
			<tr>
				<th>记录ID</th>
				<th>客户姓名:</th>
				<th>性别:</th>
				<th>身份证：</th>
				<th>职业:</th>
				<th>工作地点:</th>
				<th>联系地址:</th>
				<th>联系电话：</th>
				<th>创建日期：</th>
				<th>操作</th>
			</tr>
			<c:forEach var="v" items="${list}" varStatus="vs">
				<tr style="text-align:center" class="tr${vs.count%2}">
					<td>${v.id}</td>
					<td>${v.name}</td>
					<td><mt:tran value="${v.sex}"
							data="${applicationScope.SYS_SEX }"></mt:tran></td>
					<td>${v.idNo}</td>
					<td>${v.vocation}</td>
					<td>${v.workunit}</td>
					<td>${v.address}</td>
					<td>${v.contactTel}</td>
					<td><fmt:formatDate value="${v.createDate}"  pattern="yyyy-MM-dd" /></td>
					<td><a href="${_cxt}/customer/delete.do?id=${v.id}"
						onclick="return confirm('确定删除吗？')">删除</a> | <a
						href="${_cxt}/customer/update.do?customerId=${v.id}">更新</a></td>
				</tr>
			</c:forEach>
		</table>
		<%@ include file="/common/pager.jsp"%>
	</form>
</body>
</html>