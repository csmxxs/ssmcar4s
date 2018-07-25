<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>汽车管理系统</title>
<style>
center a {
	/*去掉下划线  */
	text-decoration: none;
}

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
<!-- 引入弹出窗口JS库 -->
<script type="text/javascript" src="${_js }/jquery-1.9.0.min.js"></script>
<script type="text/javascript"
	src="${_plugins}/lhgdialog/lhgdialog.min.js?self=true&skin=blue"></script>
<script type="text/javascript">
	function showPic(filePath) {//显示图片
		if (filePath != '') {
			$.dialog({
				title : '查询图片',
				width : '350px',
				height : '300px',
				content : '<img src="${_cxt}/Userimages/'+ filePath +'" />'
			});
		}

	}
</script>
</head>
<body>
	<div>
		<ul class="breadcrumb">
			<li><a href="#">当前页:首页</a></li>
		</ul>
	</div>
	<form action="${_cxt}/user/list.do" method="post" id="fm1">
		<table class="table table-bordered">
			<tr>
				<td colspan="4">查询条件</td>
			</tr>
			<tr>
				<td id="test">用户姓名:</td>
				<td id="value"><input type="text" name="name" id="input18"
					class="ipt" value="${param.name}" /></td>
				<td id="test">用户账号:</td>
				<td id="value"><input type="text" name="username" id=""
					class="ipt" value="${param.username}" /></td>
			</tr>
			<tr>
				<td id="test">所属部门:</td>
				<td id="value"><mt:select name="deptId"
						data="${applicationScope.deptMap}" header="0:----请选择----"
						cssClass="ipt" value="${param.deptId}"></mt:select></td>
				<td id="test">用户状态:</td>
				<td id="value"><mt:select name="loginFlag"
						data="${applicationScope.SYS_LOGIN_FLAG}" header="0:---所有状态---"
						cssClass="ipt" value="${param.loginFlag}"></mt:select></td>
			</tr>
		</table>
		<div style="text-align:right;">
			<input type="submit" value="查询" class="btn btn-info " /> <input
				type="button" value="重置" onclick="clean1();" class="btn btn-info " />
			<input type="button" value="添加"
				onclick="location.href='${_cxt}/user/add.jsp'" class="btn btn-info " />
		</div>
		<table class="table table-bordered">
			<tr>
				<th colspan="12" style="font-size: 20px">用户列表
					<div style="float: right;margin-right: 10px;color: red;">${msg}</div>
				</th>
			</tr>
			<tr>
				<th>记录ID</th>
				<th>用户姓名:</th>
				<th>用户账号:</th>
				<th>状态:</th>
				<th>所属部门:</th>
				<th>性别:</th>
				<th>入职日期:</th>
				<th>出生日期:</th>
				<th>申请状态:</th>
				<th>角色名称:</th>
				<th>创建日期</th>
				<th>操作</th>
			</tr>
			<c:forEach var="v" items="${list}" varStatus="vs">
				<tr style="text-align:center" class="tr${vs.count%2}">
					<td>${v.id}</td>
					<td><a href="javascript:showPic('${v.filePath}')">${v.name}</a></td>
					<td>${v.username}</td>
					<td><mt:tran value="${v.loginFlag}"
							data="${applicationScope.SYS_LOGIN_FLAG}"></mt:tran></td>
					<td><mt:tran value="${v.deptId}"
							data="${applicationScope.deptMap }"></mt:tran></td>
					<td><mt:tran value="${v.sex}"
							data="${applicationScope.SYS_SEX }"></mt:tran></td>
					<td><fmt:formatDate value="${v.entryDate}"
							pattern="yyyy-MM-dd" /></td>
					<td><fmt:formatDate value="${v.birthday}" pattern="yyyy-MM-dd" /></td>
					<td><mt:tran value="${v.applyState}"
							data="${applicationScope.APPLY_STATE}"></mt:tran></td>
					<td><mt:tran value="${v.roleId }"
							data="${applicationScope.roleMap}"></mt:tran></td>
					<td>${v.createDate}</td>
					<td><a href="${_cxt}/user/delete.do?id=${v.id}"
						onclick="return confirm('确定删除吗？')">删除</a> | <a
						href="${_cxt}/user/update.do?id=${v.id}">更新</a></td>
				</tr>
			</c:forEach>
		</table>
		<%@ include file="/common/pager.jsp"%>
	</form>
</body>
</html>