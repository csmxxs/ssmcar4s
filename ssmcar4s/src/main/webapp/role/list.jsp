<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/header.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>  
    <title>welcome</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- 引入外部JS文件 -->
<script type="text/javascript" src="${_plugins}/jquery/jquery-1.7.2.js"></script>
<!-- 引入弹出窗口JS库 -->
<script type="text/javascript" 
         src="${_plugins}/lhgdialog/lhgdialog.min.js?self=true&skin=blue"></script>
<script type="text/javascript">
  var dialog;
  //把url对应页面在弹出窗口中打开
  function showDialog(url,title){
     dialog = $.dialog({
        title:title,
     	width: '400px',
    	height:'450px',
    	content: 'url:'+url
	 });
  }
  //关闭
  function closeDialog(result){
    dialog.close();
    $("#result_show").html(result);	
  }
  
</script>
  </head>
  <body>
<div class="right" id="mainFrame">
	<ul class="breadcrumb">
		<li><a href="#">当前位置：首页</a></li>
	</ul>
  <form id="fm1" action="${_cxt}/role/list.do" method="post">
<!-- 隐藏域 -->
       <table class="table table-bordered">
         <tr>
     <td width="20%" align="right" bgcolor="#f1f1f1">角色名称：</td>
     <td width="30%"><input type="text" name="name" id="name" class="span1-1" value="${param.name }"/></td>
     	<td class="text-center" ><input type="submit" value="查询" class="btn btn-info " style="width:50px;" />
       <input type="button" value="清空" class="btn btn-info " onclick="clean()" style="width:50px;" />
       <input type="button" value="新增" onclick="location.href='${_cxt}/role/add.jsp'" class="btn btn-info " style="width:50px;" /></td>
     </tr>
     </table><br /><br />
     <table class="table table-bordered" style="text-align:center;">
     	<tr>
              <th colspan="5" style="font-size: 24px;">角色信息列表
				<div style="color:red;float:right;font-size: 20px;" id="result_show">${msg}</div>
              </th>
           </tr>
           <tr>
              <th>记录ID</th>
              <th>角色名称</th>              
              <th>创建日期</th>
              <th>操作</th>
           </tr>
           <c:forEach var="v" items="${list}" varStatus="vs">	
             <tr style="text-align:center" class="tr${vs.count%2}">
	              <td>${v.id}</td>
	              <td>${v.name}</td>
	              <td><fmt:formatDate value="${v.createDate}" pattern="yyyy-MM-dd"/></td>
	              <td>
                 <a href="${_cxt}/role/delete.do?id=${v.id}" 
                    onclick="return confirm('确认删除吗?');" >删除</a>｜
                 <a href="${_cxt}/role/update.do?roleId=${v.id}">更新</a>｜
                 <a href="javascript:showDialog('${_cxt}/role/menuTree.do?roleId=${v.id}','正在为角色分配权限');">分配权限</a>
              </td>
              </tr>
            </c:forEach>
     </table>      
</form>
    </div>
  </body>
</html>
