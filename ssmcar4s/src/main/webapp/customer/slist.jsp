<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<title>客户弹出框页面</title>
<style type="text/css">
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
		   alert("请选择一个客户");
		   return;
	   }else{
		  //parent代表父窗口对象
		  parent.closeDialog2(objs.eq(0).val());
	   }
   }
</script>
</head>
<body>

<div class="title_right"><strong>查询页面</strong></div>
   <form action="${_cxt}/customer/slist.do" method="post" id="fm1" >
       <table class="table table-bordered">
         <tr>
     <td id="test">客户姓名：</td>
     <td id="value"><input type="text" name="name" /></td>
     <td id="test">性别：</td>
      <td>
      <mt:select name="sex" data="${applicationScope.SYS_SEX}"  header="0:--请选择--"
      ></mt:select>
     </td>
     </tr>
     <tr>
     <td id="test">身份证：</td>
     <td id="value"><input type="text" name="idNo"/></td>
     <td id="test">联系电话：</td>
     <td id="value"><input type="tel" name="contactTel" /></td>
     </tr>
       </table>

     	<div style="text-align:right" >
     	<input class="btn btn-info" type="submit" value="查询"> 
     	<input class="btn btn-info" type="button" value="确定" onclick="tconfirm();">                      
      	</div>
     <table class="table table-bordered">
     	<tr>
            <th>选择</th>
            <th>客户姓名:</th>
            <th>性别:</th>
            <th>身份证：</th>
            <th>联系电话：</th>
        </tr>
        <c:forEach var="v" items="${slist}" varStatus="vs">
        <tr style="text-align:center" class="tr${vs.count%2}">        
        	<td><input type="radio" name="select" value="${v.id},${v.name}"></td>
        	<td>${v.name}</td>
        	<td><mt:tran value="${v.sex}" data="${applicationScope.SYS_SEX }"></mt:tran></td>        	
        	<td>${v.idNo}</td>
        	<td>${v.contactTel}</td>        
        </tr>
        </c:forEach>
     </table>
     <%@ include file="/common/pager.jsp"%>
    </form>
</body>
</html>