<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/header.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>  
    <title>welcome</title>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  </head>
  <body>
<ul class="breadcrumb"><li><a href="#">当前位置：首页</a></li></ul>
<form action="${_cxt }/menu/list.do" method="post" id="fm1">
<!-- 隐藏域 -->
       <table class="table table-bordered">
         <tr>
     <td width="20%" align="right" bgcolor="#f1f1f1">菜单名称：</td>
     <td width="30%"><input type="text" name="name" id="name" class="span1-1" value="${param.name }"/></td>
     <td width="20%" align="right" bgcolor="#f1f1f1">可用标签：</td>
     <td width="30%">
     	<mt:select name="useFlag" data="${applicationScope.SYS_USE_FLAG }" 
     	cssClass="span1-1" header="0:--请选择--" value="${param.useFlag }"></mt:select>
     </td>
    	 </tr>
    	 <tr>
     <td width="20%" align="right" bgcolor="#f1f1f1">父菜单：</td>
     	<td width="30%">
     	<mt:select name="parentId" data="${applicationScope.pmenuMap }" 
     	cssClass="span1-1" header="0:--请选择--" value="${param.parentId }"></mt:select>
     </td>
     <td width="20%" align="right" bgcolor="#f1f1f1">菜单级别：</td>
      <td width="30%">
     	<mt:select name="menuLevel" data="${applicationScope.SYS_MENU_LEVEL }" 
     	cssClass="span1-1" header="0:--请选择--" value="${param.menuLevel }"></mt:select>
     </td>
    	 </tr>
       </table>
       <table align="right">
        <tr>
     	<td class="text-center" ><input type="submit" value="查询" class="btn btn-info " style="width:50px;" />
       <input type="button" value="重置" onclick="clean()" class="btn btn-info " style="width:50px;" />
       <input type="button" value="新增" onclick="location.href='${_cxt}/menu/add.jsp'" class="btn btn-info " style="width:50px;" /></td>
     </tr>
     </table><br /><br />
     <table class="table table-bordered" style="text-align:center;">
     	<tr>
              <th colspan="8" style="font-size: 26px;">菜单信息列表
				<div style="color:red;float:right;font-size: 20px;">${msg}</div>
              </th>
           </tr>
           <tr>
              <th>记录ID</th>
              <th>菜单名称</th>
              <th>菜单URL</th>
              <th>父菜单</th>
              <th>菜单级别</th>
              <th>可用标志</th>
              <th>创建日期</th>
              <th>操作</th>
           </tr>
           <c:forEach var="v" items="${list}" varStatus="vs">
             <tr style="text-align: center;" class="tr${vs.count%2}">          			
	              <td>${v.id}</td>
	              <td>${v.name}</td>
	              <td>${v.url}</td>
	              <td><mt:tran data="${applicationScope.pmenuMap}" value="${v.parentId}"/></td>
	              <td><mt:tran data="${applicationScope.SYS_MENU_LEVEL}" value="${v.menuLevel}"/></td>
	              <td><mt:tran data="${applicationScope.SYS_USE_FLAG}" value="${v.useFlag}"/></td>  
	              <td><fmt:formatDate value="${v.createDate}" pattern="yyyy-MM-dd"/></td>
	              <td>
                 <a href="${_cxt }/menu/delete.do?id=${v.id}" 
                    onclick="return confirm('确认删除吗?');" >删除</a>｜
                 <a href="${_cxt }/menu/update.do?menuId=${v.id}">更新</a>
              </td>              
              </tr>     
            </c:forEach>
     </table> 
     <%-- 分页标签 --%>
      <%@ include file="/common/pager.jsp" %>     
</form>
  </body>
</html>
