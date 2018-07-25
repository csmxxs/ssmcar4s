<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/header.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>  
    <title>welcome</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  </head>
  
  <body>

<form action="${_cxt}/role/update.do" method="post">
     <!-- 临时变量 -->
      <c:set var="v" value="${role}" scope="page"/>
      <%-- 隐藏域 --%>
      <input type="hidden" name="commit" value="true">
      <input type="hidden" name="id" value="${v.id}">
      <fieldset class="fset">
        <legend>角色更新</legend>
        <table border="0" width="100%">
           <tr>
             <td align="right" width="15%">角色名称:</td>
             <td width="35%">
                <input type="text" name="name" class="ipt" value="${v.name}" class="span1-1">
             </td>
			<td align="right" width="15%"></td>
             <td width="35%"></td>
           </tr>
           <tr>
             <td align="right"></td>
             <td></td>
             <td align="right"></td>
             <td>
                <input type="submit" value="更新">
                <input type="button" value="重置" onclick="clean()">
                <input type="button" value="返回"  onclick="location.href='${_cxt}/role/list.do'">
             </td>
           </tr>
        </table>
      </fieldset>
     </form>
  </body>
</html>
