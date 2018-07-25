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
	<div class="title_right">
		<strong>增加页面</strong>
	</div>
	<form action="${_cxt}/role/add.do" method="post">
		<fieldset class="fset">
			<legend>角色新增</legend>
			<table border="0" width="100%">
				<tr>
					<td align="right" width="15%">角色名称:</td>
					<td width="35%"><input type="text" name="name" class="span1-1">
					</td>
					<td align="right" width="15%"></td>
					<td width="35%"></td>
				</tr>
				<tr>
					<td align="right"></td>
					<td></td>
					<td align="right"></td>
					<td><input type="submit" value="新增"> <input
						type="button" value="重置" onclick="clean()"> <input
						type="button" value="返回"
						onclick="location.href='${_cxt}/role/list.jsp'"></td>
				</tr>
			</table>
		</fieldset>
	</form>
</body>
</html>
