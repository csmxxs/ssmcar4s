<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/header.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>welcome</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

</head>

<body>
	<div>
		<ul class="breadcrumb">
			<li><a href="#">当前页:首页</a></li>
		</ul>
	</div>
		<form action="${_cxt }/dict/list.do" method="post" id="fm1">
			<table class="table table-bordered">
				<tr>
					<td width="20%" align="right" bgcolor="#f1f1f1">字典名称：</td>
					<td width="30%"><input type="text" name="dictName"
						id="dictName" class="span1-1" value="${param.dictName }" /></td>
					<td width="20%" align="right" bgcolor="#f1f1f1">可用标签：</td>
					<td width="30%"><mt:select name="useFlag"
							data="${applicationScope.SYS_USE_FLAG }" cssClass="span1-1"
							header="0:--请选择--" value="${param.useFlag }"></mt:select></td>
				</tr>
				<tr>
					<td width="20%" align="right" bgcolor="#f1f1f1">字典key：</td>
					<td width="30%"><input type="text" name="key" id="key"
						class="span1-1" value="${param.key }" /></td>

					<td width="20%" align="right" bgcolor="#f1f1f1">字典value：</td>
					<td width="30%"><input type="text" name="value" id="value"
						class="span1-1" value="${param.value }" /></td>
				</tr>
			</table>
			<table align="right">
				<tr>
					<td class="text-center"><input type="submit" value="查询"
						class="btn btn-info " style="width:50px;" /> <input type="button"
						value="清空" class="btn btn-info " onclick="clean()"
						style="width:50px;" /> <input type="button" value="新增"
						onclick="location.href='${_cxt}/dict/add.jsp'"
						class="btn btn-info " style="width:50px;" /></td>
				</tr>
			</table>
			<br />
			<br />
			<table class="table table-bordered"
				style="text-align:center;font-size: 16px">
				<tr>
					<th colspan="7" style="font-size: 26px;">菜单信息列表
						<div style="color:red;float:right;font-size: 16px;">${msg}</div>
					</th>
				</tr>
				<tr>
					<th>记录ID</th>
					<th>字典名称</th>
					<th>字典key</th>
					<th>字典value</th>
					<th>可用标志</th>
					<th>创建日期</th>
					<th>操作</th>
				</tr>
				<c:forEach var="v" items="${requestScope.list}" varStatus="vs">
					<tr style="text-align:center" class="tr${vs.count%2}">
						<td>${v.id}</td>
						<td>${v.dictName}</td>
						<td>${v.key}</td>
						<td>${v.value}</td>
						<td><mt:tran data="${applicationScope.SYS_USE_FLAG}"
								value="${v.useFlag}" /></td>
						<td><fmt:formatDate value="${v.createDate}" pattern="yyyy-MM-dd" /></td>
						<td><a href="${_cxt}/dict/delete.do?id=${v.id}"
							onclick="return confirm('确认删除吗?');">删除</a>｜ <a
							href="${_cxt}/dict/update.do?dictId=${v.id}">更新</a></td>
					</tr>
				</c:forEach>
			</table>
			<%-- 分页标签 --%>
			<%@ include file="/common/pager.jsp"%>
		</form>
</body>
</html>
