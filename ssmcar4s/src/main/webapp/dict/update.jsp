<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ include file="/common/header.jsp"%>
<html>
<head>
<title>welcome</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

</head>

<body>
	<form action="${_cxt }/dict/update.do" method="post">
		<c:set var="v" value="${dict}" scope="page"></c:set>
		<input type="hidden" name="id" value="${v.id }">
		<table class="table table-bordered">
			<tr>
				<td width="20%" align="right" bgcolor="#f1f1f1">字典名称：</td>
				<td width="30%"><input type="text" name="dictName"
					id="dictName" class="span1-1" value="${v.dictName }" /></td>
				<td width="20%" align="right" bgcolor="#f1f1f1">可用标签：</td>
				<td width="30%"><mt:select name="useFlag"
						data="${applicationScope.SYS_USE_FLAG }" cssClass="span1-1"
						value="${v.useFlag }"></mt:select></td>
			</tr>
			<tr>
				<td width="20%" align="right" bgcolor="#f1f1f1">字典key：</td>
				<td width="30%"><input type="text" name="key" id="key"
					class="span1-1" value="${v.key }" /></td>

				<td width="20%" align="right" bgcolor="#f1f1f1">字典value：</td>
				<td width="30%"><input type="text" name="value" id="value"
					class="span1-1" value="${v.value }" /></td>
			</tr>
		</table>
		<table align="right">
			<tr>
				<td class="text-center"><input type="submit" value="更新"
					class="btn btn-info " style="width:50px;" /> <input type="button"
					value="清空" class="btn btn-info" onclick="clean()"
					style="width:50px;" /> <input type="button" value="返回"
					onclick="location.href='${_cxt}/dict/list.do'"
					class="btn btn-info " style="width:50px;" /></td>
			</tr>
		</table>
	</form>
</body>
</html>
