<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>汽车管理系统</title>

</head>
<body>
	<div>
		<ul class="breadcrumb">			
			<li><a href="#">当前页:首页</a></li>
		</ul>
	</div>
	<form action="${_cxt}/fittings/list.do" method="post" id="fm1">
			<table class="table table-bordered">
			     <tr><td colspan="4">查询条件</td></tr>
				<tr>
				    
					<td width="10%" align="right" bgcolor="#f1f1f1">配件名称:</td>
					<td width="23%"><input type="text" name="name" class="ipt" value="${param.name}"/></td>
					<td width="10%" align="right" bgcolor="#f1f1f1">单位:</td>
					<td width="23%"><mt:select name="unit" data="${applicationScope.VENDER }" header="0:----请选择----" cssClass="ipt" value="${param.unit }"></mt:select></td>
				</tr>
				<tr>
				    <td width="10%" align="right" bgcolor="#f1f1f1">型号:</td>
				    <td width="23%"><input type="text" name="type" class="ipt" value="${param.type}"></td>
				</tr>
			</table>
		<table align="right">
			<tr>
				<td class="text-center"><input type="submit" value="查询"
					class="btn btn-info " style="width:50px;" /> <input type="button"
					value="重置" onclick="clean1();" class="btn btn-info "
					style="width:50px;" /> <input type="button" value="添加"
					onclick="location.href='${_cxt}/fittings/add.jsp'"
					class="btn btn-info " style="width:50px;" /></td>
			</tr>		
		</table>
		<table class="table table-bordered">
			<tr>
				<th colspan="12" style="font-size: 20px">配件信息列表<div style="float: right;margin-right: 10px;color: red;">${msg}</div></th>				
			</tr>
			<tr>
				<th>记录ID</th>
				<th>配件名称:</th>
				<th>供应商:</th>				
				<th>价格:</th>
				<th>品牌:</th>
				<th>型号:</th>
				<th>创建日期:</th>
				<th>备注:</th>
				<th>操作</th>
			</tr>
			<c:forEach var="v" items="${list}" varStatus="vs">
				<tr style="text-align:center" class="tr${vs.count%2}">
					<td>${v.id}</td>
					<td>${v.name}</td>
					<td><mt:tran value="${v.unit }" data="${applicationScope.VENDER }"></mt:tran></td>
					<td>${v.price }</td>
					<td>${v.brand}</td>
					<td>${v.type}</td>
					<td><fmt:formatDate value="${v.createDate}"  pattern="yyyy-MM-dd"/></td>
					<td>${v.remark}</td>					
					<td><a href="${_cxt}/fittings/delete.do?id=${v.id}"
						onclick="return confirm('确定删除吗？')">删除</a> | <a
						href="${_cxt}/fittings/update.do?fittingsId=${v.id}">更新</a></td>
				</tr>
			</c:forEach>
		</table>
		<%@ include file="/common/pager.jsp"%>
	</form>
</body>
</html>