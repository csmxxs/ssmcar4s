<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>汽车管理系统</title>
<link rel="stylesheet" href="${_css}/bootstrap.css" />
<link rel="stylesheet" href="${_css}/css.css" />
<script type="text/javascript" src="${_js }/jquery-1.9.0.min.js"></script>
<script type="text/javascript" src="${_js }/bootstrap.min.js"></script>
<script type="text/javascript" src="${_js }/sdmenu.js"></script>
<script type="text/javascript" src="${_js }/laydate/laydate.js"></script>
</head>
<frameset rows="9%,*" bordercolor="bule" border="1"  noresize="noresize">
       <frame src="${_cxt}/common/top.jsp" name="top"/>
   <frameset cols="13.4%,*"  noresize="noresize">
       <frame src="${_cxt}/common/left.jsp" name="left"/>
       <frame src="${_cxt}/common/welcome.jsp" name="main"/>
   </frameset>
</frameset>
</html>
