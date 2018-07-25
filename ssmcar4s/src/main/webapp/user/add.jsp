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
	<div class="title_right">
		<strong>用户添加页面</strong>
	</div>
	<%-- 只要是做上传，表单form必须加enctype="multipart/form-data" --%>
	<form action="${_cxt}/user/add.do" method="post"
		enctype="multipart/form-data">
		<table class="table table-bordered">
			<tr>
				<td id="test">用户姓名：</td>
				<td id="value"><input type="text" name="name" id="input18" /></td>
				<td id="test">用户性别：</td>
				<td id="value"><mt:select name="sex"
						data="${applicationScope.SYS_SEX}" cssClass="ipt"
						header="0:----请选择----"></mt:select></td>
				<td id="test">出生日期：</td>
				<td id="value"><input type="Date" name="birthday" id="birthday" /></td>
			</tr>
			<tr>

				<td id="test">用户账户：</td>
				<td id="value"><input type="text" name="username" /></td>

				<td id="test">角色名称：</td>
				<td id="value"><mt:select name="roleId"
						data="${applicationScope.roleMap}" cssClass="ipt"
						header="0:----请选择----"></mt:select></td>

				<td id="test">所属部门：</td>
				<td id="value"><mt:select name="deptId"
						data="${applicationScope.deptMap }" header="0:----请选择----"
						cssClass="ipt"></mt:select></td>
			</tr>
			<tr>
				<td id="test">用户密码：</td>
				<td id="value"><input type="password" name="password" /></td>
				<td id="test">用户状态：</td>
				<td id="value"><mt:select name="loginFlag"
						data="${applicationScope.SYS_LOGIN_FLAG}" cssClass="ipt"
						header="0:----请选择----"></mt:select></td>
				<td id="test">申请状态：</td>
				<td id="value"><mt:select name="applyState"
						data="${applicationScope.APPLY_STATE}" cssClass="ipt"
						header="0:----请选择----"></mt:select></td>
			</tr>
			<tr>
				<td id="test">入职日期：</td>
				<td id="value"><input type="Date" name="entryDate" /></td>
				<td id="test">图片上传：</td>
				<td id="value"><input type="file" name="file" id="" /></td>
				<td id="test" colspan="2"><span style="color:red">${msg}</span></td>
			</tr>
		</table>
		<div style="text-align:right;">
			<input type="submit" value="确定" class="btn btn-info" /> <input
				type="reset" value="清空" class="btn btn-info" /> <input type="button"
				value="返回" onclick="location.href='${_cxt}/user/list.do'"
				class="btn btn-info" />
		</div>
	</form>
</body>
</html>