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
		<strong>部门添加页面</strong>
	</div>
	<form action="${_cxt}/dept/add.do" method="post">
		<table class="table table-bordered">
         <tr>
     <td id="test">部门名称：</td>
     <td id="value"><input type="text" name="name" /></td>
     <td id="test">负责人：</td>
     <td id="value"><input type="text" name="charger" /></td>
     <td id="test">联系电话：</td>
     <td id="value"><input type="text" name="contactTel" /></td>
     </tr>
       </table>
     	<div style="text-align:right" ><input type="submit" value="添加" class="btn btn-info " />
       <input type="button" value="清空" class="btn btn-info "  onclick="clean1();"/>
       <input type="button" value="返回" onclick="location.href='${_cxt}/dept/list.do'" class="btn btn-info " />
       </div>
	</form>
</body>
</html>