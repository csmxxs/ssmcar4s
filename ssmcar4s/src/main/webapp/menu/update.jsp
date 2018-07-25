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
<form action="${_cxt }/menu/update.do"  method="post">
<!-- 隐藏域 -->
    <c:set var="v" value="${menu}" scope="page"></c:set>
   <input type="hidden" name="id"  value="${v.id}"/>
	<!-- 隐藏域 -->
       <table class="table table-bordered">
         <tr>
     <td width="20%" align="right" bgcolor="#f1f1f1">菜单名称：</td>
     <td width="30%"><input type="text" name="name" id="name" class="span1-1" value="${v.name }"/></td>
     <td width="20%" align="right" bgcolor="#f1f1f1">URL：</td>
     <td width="30%"><input type="text" name="url" id="url"  class="span1-1" value="${v.url }" /></td>
     </tr>
     <tr>
     <td width="20%" align="right" bgcolor="#f1f1f1">父菜单：</td>
     <td width="30%">
     	<mt:select name="parentId" data="${applicationScope.pmenuMap }" 
     	cssClass="span1-1" value="${v.parentId }"></mt:select>
     </td>
     <td width="20%" align="right" bgcolor="#f1f1f1">菜单级别：</td>
      <td width="30%">
     	<mt:select name="menuLevel" data="${applicationScope.SYS_MENU_LEVEL }" 
     	cssClass="span1-1" value="${v.menuLevel }"></mt:select>
     </td>
     </tr>
     <tr>
     	<td width="20%" align="right" bgcolor="#f1f1f1">可用标签：</td>
     <td width="30%" colspan="3">
     	<mt:select name="useFlag" data="${applicationScope.SYS_USE_FLAG }" 
     	cssClass="span1-1"  value="${v.useFlag }"></mt:select>
     </td>
     </tr>
     <tr>
      <td align="right" colspan="4"><input type="submit" value="更新" class="btn btn-info " style="width:50px;" />
       <input type="button" value="清空" class="btn btn-info " onclick="clean()" style="width:50px;" />
       <input type="button" value="返回" class="btn btn-info " style="width:50px;" onclick="location.href='${_cxt}/menu/list.do'"/>
      </td>
     </tr>
       </table>  
   </form>
  </body>
</html>
