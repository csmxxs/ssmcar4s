<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>汽车管理系统</title>
     <!-- 引入弹出窗口JS库 -->
<script type="text/javascript" 
        src="${_plugins}/lhgdialog/lhgdialog.min.js?self=true&skin=igreen"></script>
<script type="text/javascript">
	var dialog;
	function openDialog(){//打开弹出窗口
	   dialog = $.dialog({
	     title: '选择一个配件',
	     width: '650px',
	     height: '460px',
	     content: 'url:${_cxt}/fittings_slist.do'
	   });
	}
	//result格式: 班级ID,班级名称
	function closeDialog(result){//关闭窗口
	   //alert(result);
	   var arr = result.split(",");
	   $("input[name=fittingsId]").val(arr[0]);
	   $("input[name=name]").val(arr[1]);
	   $("input[name=type]").val(arr[2]);
	   $("input[name=volume]").val(arr[3]);
	   $("input[name=carId]").val(arr[4]);
	   dialog.close();//关闭窗口
    }
</script>
</head>
<body>
	<div class="title_right">
		<strong>整车进货单更新页面</strong>
	</div>
	<c:set var="v" value="${requestScope.obj }" scope="page"></c:set>
	<form action="${_cxt}/fittingsInorder_update.do" method="post">
	<!-- 隐藏域 -->
    <input type="hidden" name="id" value="${v.id}" >
    <!-- 判断是否提交更新 -->
    <input type="hidden" name="common" value="true">
		<table class="table table-bordered">
			<tr>
				<td width="10%" align="right" bgcolor="#f1f1f1">配件名称：</td>
				<td width="23%">
				  <input type="text" name="fittingsId"  value="${v.fittingsId }" class="ipt"/>
				  <a href="javascript:openDialog();">选择</a>
				</td>
				<td width="10%" align="right" bgcolor="#f1f1f1" >销售员：</td>
				<td width="23%">
				      <input type="text" name="supplierId" class="ipt"/> 
			    </td>
				<td width="10%" align="right" bgcolor="#f1f1f1">数量：</td>
				<td width="23%">
				    <input type="text" name="count" id="count" value="${v.count }" class="ipt"/>
				</td>
			</tr>
			<tr>
				<td width="10%" align="right" bgcolor="#f1f1f1">进货价：</td>
				<td width="23%">
				    <input type="text" name="inPrice" id="inPrice" value="${v.inPrice }" class="ipt"/>
				</td>
				<td width="10%" align="right" bgcolor="#f1f1f1">总价：</td>
				<td width="23%">
				    <input type="text" name="total" id="total"  value="${v.total }" class="ipt"/>
				</td>
				<td width="10%" align="right" bgcolor="#f1f1f1">删除标志：</td>
				<td width="23%">
				    <mt:select name="delFlag" data="${applicationScope.SYS_DEL_FLAG }" 
				    cssClass="ipt" header="0:---所有状态---">
				    </mt:select>
				</td>				
			</tr>
			<tr>
			  
				<td width="10%" align="right" bgcolor="#f1f1f1">填单日期：</td>
				<td width="23%">
				    <input type="text" name="createDate" id="createDate" value="${v.createDate }" class="ipt"/>
				</td>
				<td width="10%" align="right" bgcolor="#f1f1f1">入库日期：</td>
				<td width="23%"><input type="text" name="inDate" id="inDate"  value="${v.inDate }" class="ipt"/></td>
				<td width="10%" align="right" bgcolor="#f1f1f1">入库状态：</td>
				<td width="23%"><input type="text" name="inState" id="inState" value="${v.inState }" class="ipt"/></td>				
			</tr>
		</table>
		<table align="right">
		  
			<tr>
			    <td width="10%" align="right" bgcolor="#f1f1f1" >备注：</td>
				<td width="23%">
				    <input type="text" name="remark" id="" value="${v.remark }" style="height: 40px; width: 400px;"/>
				</td>
				<td class="text-center">
				  <input type="submit" value="确定" class="ipt" style="width:50px;" /> 
				  <input type="reset" value="清空" class="ipt" style="width:50px;" /> 
				  <input type="button" value="返回" onclick="location.href='${_cxt}/fiInorder/list.jsp'"
					class="btn btn-info " style="width:50px;" />
				</td>
			</tr>
		</table>
	</form>
  <script type="text/javascript">
    laydate.skin('molv');
    laydate({elem:'#inDate'});
    laydate({elem:'#createDate'});
  </script> 
</body>
</html>