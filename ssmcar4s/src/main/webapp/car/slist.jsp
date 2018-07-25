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
	   function tconfirm(){
		   var objs = $("input[name=select]:checked");
		   if(objs.size()==0){
			   alert("请选择一个整车");
			   return;
		   }else{
			  //parent代表父窗口对象
			  parent.closeDialog(objs.eq(0).val());
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
	<form action="${_cxt}/car/slist.do" method="post" id="fm1">			
			<table class="table table-bordered">
			     <tr><td colspan="4">查询条件</td></tr>
				<tr> 
					<td width="10%" align="right" bgcolor="#f1f1f1">汽车品牌:</td>
					<td width="23%"><input type="text" name="brand" id="input18" class="ipt" value="${param.brand}"/></td>
					<td width="10%" align="right" bgcolor="#f1f1f1">汽车系列:</td>
					<td width="23%"><input type="text" name="series" id="" class="ipt" value="${param.series}"/></td>
				</tr>
				<tr>
				    <td width="10%" align="right" bgcolor="#f1f1f1">汽车类型:</td>
				    <td width="23%"><mt:select name="type" data="${applicationScope.CAR_TYPE}" cssClass="ipt" header="0:----所有车系----" value="${param.type}" ></mt:select></td>
					<td width="10%" align="right" bgcolor="#f1f1f1">汽车排量:</td>
					<td width="23%">
					   <input type="text" name="volume" class="ipt" value="${param.volume}">
				    </td>
				</tr>
			</table>
		<table align="right">
			<tr>
				<td class="text-center" > <input type="button" value="确认" onclick="tconfirm();" class="btn btn-info ">                      
      		<input type="button" value="取消" onclick="parent.dialog.close();" class="btn btn-info "></td>
			</tr>		
		</table>
		<table class="table table-bordered">
			<tr>
				<th colspan="7" style="font-size: 20px">整车信息列表<div style="float: right;margin-right: 10px;color: red;">${msg}</div></th>				
			</tr>
			<tr>
				<th>选择</th>
				<th>汽车品牌-车系:</th>
				<th>厂家名称:</th>				
				<th>类型:</th>
				<th>排量:</th>
				<th>颜色:</th>
				<th>产地:</th>
			</tr>
			<c:forEach var="v" items="${list}" varStatus="vs">
				<tr style="text-align:center">
					<td><input type="radio" name="select" value="${v.id},${v.brand}"></td>
					<td><a href="javascript:showPic('${v.filePath}')">${v.series}</a></td>
					<td>${v.brand}</td>
					<td><mt:tran value="${v.type}" data="${applicationScope.CAR_TYPE}" ></mt:tran></td>
					<td>${v.volume}</td>
					<td>${v.color}</td>
					<td>${v.proPlace}</td>
				</tr>
			</c:forEach>
		</table>
		<%@ include file="/common/pager.jsp"%>
	</form>
</body>
</html>