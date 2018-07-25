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
	<div class="right_cont">
		<ul class="breadcrumb">
			<li><a href="#">当前页:首页</a></li>
		</ul>
	</div>
	<form action="${_cxt}/fittingsInorder/list.do" method="post" id="fm1">
		<table class="table table-bordered">
			<tr>
				<td colspan="4">查询条件</td>
			</tr>
			<tr>
				<td id="test">配件名称：</td>
				<td id="value"><input type="text" name="fittingsname"
					value="${param.fittingsname}" class="ipt" /></td>
				<td id="test">入库状态：</td>
				<td id="value"><mt:select name="inState"
						data="${applicationScope.FITTINGS_OUT_STATE}"
						header="0:---所有状态---" cssClass="ipt" value="${param.inState}">
					</mt:select></td>
				<td id="test">供应商:</td>
				<td id="value"><mt:select name="supplierId"
						data="${applicationScope.VENDER }" header="0:----所有----"
						cssClass="ipt" value="${param.supplierId}"></mt:select></td>
			</tr>
		</table>
		<div style="text-align:right">
			<input type="submit" value="查询" class="btn btn-info "/> <input type="button" value="重置"
				onclick="clean1();" class="btn btn-info " /> <input
				type="button" value="添加"
				onclick="location.href='${_cxt}/fittingsInorder/add.jsp'"
				class="btn btn-info "/>
		</div>
		<br />
		<table class="table table-bordered">
			<tr>
				<th colspan="12" style="font-size: 20px">配件进货单列表
					<div style="float: right;font-size: 20px;color: red;">${msg}</div>
				</th>
			</tr>
			<tr>
				<th>记录ID</th>
				<th>配件名称:</th>
				<th>供应商:</th>
				<th>进货单价:</th>
				<th>数量:</th>
				<th>总价:</th>
				<th>填单日期:</th>
				<th>提货日期:</th>
				<th>提货状态:</th>
				<th>备注:</th>
				<th>操作</th>
			</tr>
			<c:forEach var="v" items="${list}" varStatus="vs">
				<tr style="text-align:center" class="tr${vs.count%2}">
					<td>${v.id}</td>
					<td>${v.fittingsName}</td>
					<td>${v.supplierName}</td>
					<td>${v.inPrice}</td>
					<td>${v.count}</td>
					<td>${v.total}</td>
					<td><fmt:formatDate value="${v.createDate}"
							pattern="yyyy-MM-dd" /></td>
					<td>${v.inDate}</td>
					<td><mt:tran value="${v.inState}"
							data="${applicationScope.FITTINGS_OUT_STATE }"></mt:tran></td>
					<td>${v.remark}</td>
					<td><a href="${_cxt}/fittingsInorder/delete.do?id=${v.id}"
						onclick="return confirm('确定删除吗？')">删除</a> | <a
						href="${_cxt}/fittingsInorder/update.do?fittingsInorderId=${v.id}">更新</a>|
						<a href="#">提货入库</a></td>
				</tr>
			</c:forEach>
		</table>
		<%@ include file="/common/pager.jsp"%>
	</form>
</body>
</html>