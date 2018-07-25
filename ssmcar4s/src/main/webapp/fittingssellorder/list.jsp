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
	<form action="${_cxt}/fittingssellorder/list.do" method="post"
		id="fm1">
		<table class="table table-bordered">
			<tr>
				<td colspan="4">查询条件</td>
			</tr>
			<tr>
				<td id="test">配件名称:</td>
				<td id="value"><input type="text" name="fittingsname" class="ipt" value="${param.fittingsname}" /></td>
				<td id="test">配件品牌:</td>
				<td id="value"><input type="text" name="fittingsbrand"
					class="ipt" value="${param.fittingsbrand}" /></td>
			</tr>
			<tr>
				<td id="test">销售员:</td>
				<td id="value"><input type="text" name="salesman" class="ipt"
					value="${param.salesman}"></td>
				<td id="test">提货状态:</td>
				<td id="value"><mt:select name="outState"
					data="${applicationScope.FITTINGS_OUT_STATE }" cssClass="ipt"
					header="0:----请选择----" value="${param.outState }"></mt:select>
				</td>
			</tr>
		</table>

				<div style="text-align:center"><input type="submit" value="查询"
					class="btn btn-info " /> <input type="button"
					value="重置" onclick="clean1();" class="btn btn-info " /> <input type="button" value="添加"
					onclick="location.href='${_cxt}/fittingssellorder/add.jsp'"
					class="btn btn-info "/>
				</div>

		<table class="table table-bordered">
			<tr>
				<th colspan="12" style="font-size: 20px">配件销售单列表
					<div style="float: right;margin-right: 10px;color: red;">${msg}</div>
				</th>
			</tr>
			<tr>
				<th>记录ID</th>
				<th>配件名称</th>
				<th>配件品牌</th>
				<th>销售人员</th>
				<th>客户姓名</th>
				<th>销售价(单位:元)</th>
				<th>数量</th>
				<th>总价(单位:元)</th>
				<th>填单日期</th>
				<th>提货日期</th>
				<th>提货状态</th>
				<th>操作</th>
			</tr>
			<c:forEach var="v" items="${list}"
				varStatus="vs">
				<tr style="text-align:center" class="tr${vs.count%2}">
					<td>${v.id}</td>
					<td>${v.fittingsname}</td>
					<td>${v.fittingsbrand}</td>
					<td>${v.salesman}</td>
					<td>${v.customername}</td>
					<td>${v.sellPrice}</td>
					<td>${v.count}</td>
					<td>${v.total}</td>
					<td><fmt:formatDate value="${v.sellDate}"  pattern="yyyy-MM-dd" /></td>
					<td>${v.outDate}</td>
					<td><mt:tran value="${v.outState}"
							data="${applicationScope.FITTINGS_OUT_STATE }"></mt:tran></td>
					<td><c:if test="${v.outState<2}">
							<a href="${_cxt}/fittingssellorder/delete.do?id=${v.id}"
								onclick="return confirm('确定删除吗？')">删除</a> | 
						<a href="${_cxt}/fittingssellorder/update.do?fittingsSellorderId=${v.id}">更新</a>|
						<a href="${_cxt}/fittingssellorder/push.do?id=${v.id}"
								onclick="return confirm('确定提货吗？')">付款提货</a>
						</c:if> <c:if test="${v.outState>1}">
							<span style="color:red">无操作</span>
						</c:if></td>
				</tr>
			</c:forEach>
		</table>
		<%@ include file="/common/pager.jsp"%>
	</form>
</body>
</html>