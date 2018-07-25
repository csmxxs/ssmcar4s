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
			<li><a href="#">当前页:首页</a><li>
		</ul>
	</div>
	<form action="${_cxt}/fittings/add.do" method="post">			
			<table class="table table-bordered">
			     <tr><td colspan="4">配件信息添加页面</td></tr>
				<tr>
				    
					<td width="10%" align="right" bgcolor="#f1f1f1">配件名称:</td>
					<td width="23%"><input type="text" name="name" id="input18" class="ipt" /></td>
					<td width="10%" align="right" bgcolor="#f1f1f1">单位:</td>
					<td width="23%"><mt:select name="unit" data="${applicationScope.VENDER }" cssClass="ipt" header="0:----请选择----"></mt:select></td>
				</tr>
				<tr>
				    <td width="10%" align="right" bgcolor="#f1f1f1">型号:</td>
				    <td width="23%"><input type="text" name="type" class="ipt" ></td>
				    <td width="10%" align="right" bgcolor="#f1f1f1">品牌:</td>
				    <td width="23%"><input type="text" name="brand" class="ipt" ></td>			    
				</tr>			
				<tr>				   
				    <td width="10%" align="right" bgcolor="#f1f1f1">价格(元):</td>
				    <td width="23%"><input type="text" name="price" class="ipt" ></td>
				    <td width="10%" align="right" bgcolor="#f1f1f1">备注:</td>
				    <td width="23%"><input type="text" name="remark" class="ipt" ></td>	
				    		    
				</tr>					
			</table>
		<table align="right">
			<tr>
				<td class="text-center"><input type="submit" value="确定"
					class="btn btn-info " style="width:50px;" /> <input type="reset"
					value="重置" class="btn btn-info "
					style="width:50px;" /> <input type="button" value="返回"
					onclick="location.href='${_cxt}/fittings/list.do'"
					class="btn btn-info " style="width:50px;" /></td>
			</tr>		
		</table>
	</form>
</body>
</html>