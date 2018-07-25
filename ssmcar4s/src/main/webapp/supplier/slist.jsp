<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/header.jsp"%>
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
</style>

<script type="text/javascript">
   function tconfirm(){
	   var objs = $("input[name=select]:checked");
	   if(objs.size()==0){
		   alert("请选择一个供应商");
		   return;
	   }else{
		  //parent代表父窗口对象
		  parent.closeDialog1(objs.eq(0).val());
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
	<form action="${_cxt}/supplier/slist.do" method="post" id="fm1">
		<table class="table table-bordered">
			<tr>
				<td colspan="4">查询条件:</td>
			</tr>
			<tr>
				<td id="test">厂商名称:</td>
				<td id="value"><input type="text" name="name"
					value="${param.name}" class="ipt" /></td>
				<td id="test">联系人:</td>
				<td id="value"><input type="text" name="contacts"
					value="${param.contacts}" class="ipt" /></td>
			</tr>
			<tr>
				<td id="test">开户银行:</td>
				<td id="value" colspan="4"><input type="text" name="bankName"
					value="${param.bankName}" class="ipt" /></td>
			</tr>
		</table>

		<div style="text-align:right">
			<input type="submit" value="查询" class="btn btn-info " /> <input
				type="button" value="重置" onclick="clean1();" class="btn btn-info " />
			<input type="button" value="确定"
				onclick="tconfirm();"
				class="btn btn-info " />
		</div>

		<table class="table table-bordered">
			<tr>
				<th colspan="12" style="font-size: 20px">供应商信息列表
					<div style="float: right;margin-right: 10px;color: red;">${msg}</div>
				</th>
			</tr>
			<tr>
				<th>记录ID</th>
				<th>供应商名称:</th>
				<th>联系人:</th>
				<th>联系电话:</th>
				<th>开户银行:</th>
				<th>银行账户:</th>
				<th>创建日期:</th>
				<th>备注:</th>
			</tr>
			<c:forEach var="v" items="${list}" varStatus="vs">
				<tr style="text-align:center" class="tr${vs.count%2}">			  
					<c:if test="${v.delFlag==1}">
						<td><input type="radio" name="select" value="${v.id },${v.name}"/>${v.id}</td>
						<td>${v.name}</td>
						<td>${v.contacts}</td>
						<td>${v.contactTel}</td>
						<td>${v.bankName}</td>
						<td>${v.bankAccount}</td>
						<td><fmt:formatDate value="${v.createDate}" pattern="yyyy-MM-dd"/></td>
						<td>${v.remark}</td>
					</c:if>
				</tr>
			</c:forEach>
		</table>
		<%@ include file="/common/pager.jsp"%>
	</form>
</body>
</html>