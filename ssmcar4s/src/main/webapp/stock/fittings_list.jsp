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
</head>
<body>
	<div>
		<ul class="breadcrumb">
			<li><a href="#">当前页:首页</a></li>
		</ul>
	</div>
	<form action="${_cxt}/stock/fittings_list.do" method="post" id="fm1">
		<table class="table table-bordered">
			<tr>
				<td colspan="4">查询条件</td>
			</tr>
			<tr>

				<td id="test">配件名称:</td>
				<td id="value"><input type="text" name="carstockname"
					class="ipt" value="${param.carstockname}" /></td>
				<td id="test">配件品牌:</td>
				<td id="value"><input type="text" name="carstockbrand"
					class="ipt" value="${param.carstockbrand}" /></td>
			</tr>
			<tr>
				<td id="test">配件型号:</td>
				<td id="value"><input type="text" name="carstocktype"
					class="ipt" value="${param.carstocktype}"></td>
			</tr>
		</table>

		<div class="text-center">
			<input type="submit" value="查询" class="btn btn-info " /> <input
				type="button" value="重置" onclick="clean1();" class="btn btn-info " />
		</div>

		<table class="table table-bordered">
			<tr>
				<th colspan="12" style="font-size: 20px">配件库存列表</th>
			</tr>
			<tr>
				<th>记录ID</th>
				<th>配件名称:</th>
				<th>品牌:</th>
				<th>型号:</th>
				<th>库存量:</th>
				<th>库存告警:</th>
			</tr>
			<c:forEach var="v" items="${fittingsstock}"
				varStatus="vs">
				<tr style="text-align:center" class="tr${vs.count%2}">
					<td>${v.id}</td>
					<td>${v.carstockname}</td>
					<td>${v.carstockbrand}</td>
					<td>${v.carstocktype}</td>
					<td>${v.count}</td>
					<td><c:if test="${v.count<10}">
							<span style="color:red">库存过低!</span>
						</c:if>
						<c:if test="${v.count>=10}">库存正常</c:if></td>
				</tr>
			</c:forEach>
		</table>
		<%@ include file="/common/pager.jsp"%>
	</form>
</body>
</html>