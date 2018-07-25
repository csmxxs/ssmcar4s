<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/header.jsp"%>
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
#birthday{
width:173px;
height:20px;
  
}
</style>
</head>
<body>
	<div style="text-align:center;padding:30px">
		<strong>用户修改页面</strong>
	</div>
	<%-- 只要是做上传，表单form必须加enctype="multipart/form-data" --%>
	<form action="${_cxt}/user/gotoupdate.do" method="post"
		enctype="multipart/form-data">
		<c:set var="v" value="${user}" scope="page"></c:set>
		<input type="hidden"  name="id" value="${v.id}"/>
		<table class="table table-bordered">		    
			<tr>				
				<td id="test">用户姓名:</td>
				<td id="value"><input type="text" name="name" id="input18" value="${v.name}"/></td>
				<td id="test">用户性别:</td>
				<td id="value"><mt:select name="sex" data="${applicationScope.SYS_SEX }" cssClass="ipt" value="${v.sex}"></mt:select></td>
				<td id="test">出生日期:</td>
				<td id="value"><input type="Date" name="birthday" id="birthday" /></td>
			</tr>
			<tr>
			    <td id="test">入职日期:</td>
				<td id="value"><input type="Date" name="entryDate" /></td>
				<td id="test">所属部门:</td>
				<td id="value"><mt:select name="deptId" data="${applicationScope.deptMap}" cssClass="ipt" value="${v.deptId}"></mt:select> </td>
				<td id="test">角色名称:</td>
				<td id="value"><mt:select name="roleId" data="${applicationScope.roleMap}" cssClass="ipt" value="${v.roleId }"></mt:select></td>				
			</tr>
			<tr>
				<td id="test">用户密码:</td>
				<td id="value"><input type="text" name="password" value="${v.password}" /></td>
				<td id="test">用户状态:</td>
				<td id="value"><mt:select name="loginFlag" data="${applicationScope.SYS_LOGIN_FLAG}" value="${v.loginFlag}" cssClass="ipt"></mt:select></td>
				<td id="test">申请状态:</td>
				<td id="value"><mt:select name="applyState" data="${applicationScope.APPLY_STATE}" value="${v.applyState}" cssClass="ipt"></mt:select></td>
			</tr>
			<tr>
			    <td id="test">用户账户:</td>
				<td id="value"><input type="text" name="username" value="${v.username}" /></td>			
				<td id="test">图片上传:</td>
				<td id="value"><input type="file" name="file" value="${v.filePath}" /></td>
				<td colspan="2"><span style="color:red">${msg}</span></td>
			</tr>
		</table>
		<div style="text-align:right;">
			<input type="submit" value="确定" class="btn btn-info" /> <input
				type="reset" value="清空" class="btn btn-info" /> <input
				type="button" value="返回"
				onclick="location.href='${_cxt}/user/list.do'" class="btn btn-info" />
		</div>
	</form>
</html>