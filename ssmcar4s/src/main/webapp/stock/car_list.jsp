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
	<form action="${_cxt}/stock/car_list.do" method="post" id="fm1">
		<table class="table table-bordered">
			<tr>
				<td colspan="4">查询条件</td>
			</tr>
			<tr>

				<td id="test">品牌:</td>
				<td id="value"><input type="text" name="carbrand" class="ipt"
					value="${param.carbrand}" /></td>
				<td id="test">车系:</td>
				<td id="value"><input type="text" name="carseries" class="ipt"
					value="${param.carseries }"></td>
			</tr>
			<tr>
				<td id="test">类型:</td>
				<td id="value"><mt:select name="cartype"
						data="${applicationScope.CAR_TYPE}" cssClass="ipt"
						header="0:----所有----" value="${param.cartype}"></mt:select></td>
				<td id="test">排量:</td>
				<td id="value"><input type="text" name="carvolume" class="ipt"
					value="${param.carvolume}"></td>
			</tr>
		</table>

		<div style="text-align:center">
			<input type="submit" value="查询" class="btn btn-info " /> <input
				type="button" value="重置" onclick="clean1();" class="btn btn-info " />
		</div>

		<table class="table table-bordered">
			<tr>
				<th colspan="12" style="font-size: 20px">整车库存列表</th>
			</tr>
			<tr>
				<th>记录ID</th>
				<th>汽车品牌:</th>
				<th>车系:</th>
				<th>类型:</th>
				<th>排量:</th>
				<th>颜色:</th>
				<th>库存量:</th>
				<th>库存告警:</th>
			</tr>
			<c:forEach var="v" items="${carstock}"
				varStatus="vs">
				<tr style="text-align:center" class="tr${vs.count%2}">
					<td>${v.id}</td>
					<td>${v.carbrand }</td>
					<td>${v.carseries}</td>
					<td><mt:tran value="${v.cartype}"
							data="${applicationScope.CAR_TYPE}"></mt:tran></td>
					<td>${v.carvolume}</td>
					<td>${v.carcolor}</td>
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