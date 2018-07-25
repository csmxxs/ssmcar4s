<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>整车销售订单</title>
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

.able table-bordered input{

   
}
</style>
</head>
<body>
	<ul class="breadcrumb">
		<li><a href="#">当前位置：首页</a></li>
	</ul>
	<form action="${_cxt }/carsellorder/list.do" method="post" id="fm1">
		<table class="table table-bordered">
			<tr>
				<td id="test">汽车品牌：</td>
				<td id="value"><input type="text" class="ipt" name="carName" value="${param.carName }" /></td>
				<td id="test">提车状态：</td>
				<td id="value">
				   <mt:select name="outState"
						data="${applicationScope.SYS_OUT_STATE }" header="0:--请选择--" cssClass="ipt" value="${param.outState }">
				   </mt:select>
				</td>
			</tr>
			<tr>
				<td id="test">车系：</td>
				<td id="value"><input type="text" name="carSeries" class="ipt"
					value="${param.carSeries }" /></td>
				<td id="test">销售人员：</td>
				<td id="value"><input type="text" name="salesman" class="ipt" 
					value="${param.salesman }" /></td>
			</tr>
		</table>

		<div style="text-align:right;">
			<input type="submit" value="查询" class="btn btn-info " />
			<input type="button" value="重置" class="btn btn-info " onclick="clean1();" />
			<input type="button" value="新增" class="btn btn-info" 
				onclick="location.href='${_cxt}/carsellorder/add.jsp'"/>
		</div>

		<table class="table table-bordered" style="text-align:center;">
			<tr>
				<th colspan="11" style="font-size: 26px;">销售信息列表
					<div style="color:red;float:right;font-size: 20px;">${msg}</div>
				</th>
			</tr>
			<tr>
				<th>记录ID</th>
				<th>汽车品牌</th>
				<th>车系</th>
				<th>客户名称</th>
				<th>销售价(单位：万元)</th>
				<th>数量</th>
				<th>总价(单位：万元)</th>
				<th>填单日期</th>
				<th>提车日期</th>
				<th>提车状态</th>
				<th>销售人员</th>
				<th>操作</th>
			</tr>
			<c:forEach var="v" items="${list}" varStatus="vs">
				<tr style="text-align:center" class="tr${vs.count%2}">
					<td>${v.id}</td>
					<td>${v.carName}</td>
					<td>${v.carSeries}</td>
					<td>${v.customerName}</td>
					<td>${v.sellPrice}</td>
					<td>${v.count}</td>
					<td>${v.total}</td>
					<td><fmt:formatDate value="${v.sellDate}" pattern="yyyy-MM-dd" /></td>
					<td><fmt:formatDate value="${v.outDate}" pattern="yyyy-MM-dd" /></td>
					<td><mt:tran data="${applicationScope.SYS_OUT_STATE}"
							value="${v.outState}" /></td>
					<td>${v.salesman}</td>
					<td>
					    <c:if test="${v.outState==2}">
							<span style="color:red">无操作</span>
					    </c:if> 
					    <c:if test="${v.outState==1}">
							<a href="${_cxt}/carsellorder/delete.do?id=${v.id}"
								onclick="return confirm('确认删除吗?');">删除</a>｜
		                 	<a href="${_cxt}/carsellorder/update.do?carsellorderId=${v.id}">更新</a>｜
		                 	<a href="${_cxt}/carsellorder/buyCar.do?id=${v.id}"
								onclick="return confirm('确认提车吗?');">付款提车</a>
						</c:if>
					</td>
				</tr>
			</c:forEach>
		</table>
		<%-- 分页标签 --%>
		<%@ include file="/common/pager.jsp"%>
	</form>
</body>
</html>
