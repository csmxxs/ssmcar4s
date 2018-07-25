<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>汽车管理系统</title>
<!-- 引入弹出窗口JS库 -->
<script type="text/javascript"
	src="${_plugins}/lhgdialog/lhgdialog.min.js?self=true&skin=igreen"></script>
<script type="text/javascript">
	function tconfirm() {
		var objs = $("input[name=select]:checked");
		if (objs.size() == 0) {
			alert("请选择一个配件");
			return;
		} else {
			//parent代表父窗口对象
			parent.closeDialogf(objs.eq(0).val());
		}
	}
</script>
</head>
<body>
	<form action="${_cxt}/fittings/slist.do" method="post" id="fm1">
		<input type="hidden" name="commom" value="true">
		<table class="table table-bordered">
			<tr>
				<td colspan="4">查询条件</td>
			</tr>
			<tr>
				<td width="10%" align="right" bgcolor="#f1f1f1">配件名称:</td>
				<td width="23%"><input type="text" name="name" class="ipt"
					value="${param.name}" /></td>
				<td width="10%" align="right" bgcolor="#f1f1f1">供应商:</td>
				<td width="23%"><mt:select name="unit"
						data="${applicationScope.VENDER }" header="0:----请选择----"
						cssClass="ipt" value="${param.unit}"></mt:select></td>
			</tr>
			<tr>
				<td width="10%" align="right" bgcolor="#f1f1f1">型号:</td>
				<td width="23%"><input type="text" name="type" class="ipt"
					value="${param.type}"></td>
			</tr>
		</table>
		<table align="right">
			<tr>
				<td><input class="btn btn-info" type="submit" value="查询">
					<input class="btn btn-info" type="button" value="确认"
					onclick="tconfirm();"></td>
			</tr>
		</table>
		<table class="table table-bordered">
			<tr>
				<th colspan="12" style="font-size: 20px">配件信息列表</th>
			</tr>
			<tr>
				<th>请选择</th>
				<th>记录ID</th>
				<th>配件名称</th>
				<th>供应商</th>
				<th>品牌</th>
				<th>价格</th>
				<th>型号</th>
				<th>创建日期</th>
				<th>备注:</th>
			</tr>
			<c:forEach var="v" items="${list}" varStatus="vs">
				<tr style="text-align:center" class="tr${vs.count%2}">
					<td><input type="radio" name="select"
						value="${v.id},${v.name}"></td>
					<td>${v.id}</td>
					<td>${v.name}</td>
					<td><mt:tran value="${v.unit }"
							data="${applicationScope.VENDER }"></mt:tran></td>
					<td>${v.brand}</td>
					<td>${v.price }</td>
					<td>${v.type}</td>
					<td><fmt:formatDate value="${v.createDate}"  pattern="yyyy-MM-dd"/></td>
					<td>${v.remark}</td>
				</tr>
			</c:forEach>
		</table>
		<%@ include file="/common/pager.jsp"%>
	</form>
</body>
</html>