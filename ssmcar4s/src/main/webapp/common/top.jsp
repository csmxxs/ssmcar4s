<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>汽车管理系统</title>
<script type="text/javascript">
	  function showTime(){
		var times;
	    var	date=new Date;
		this.y=date.getFullYear();
		this.M=(date.getMonth()+1)<10? "0"+(date.getMonth()+1):(date.getMonth()+1);
		this.d= date.getDate() < 10 ? "0" + date.getDate() : date.getDate();
		this.hour = date.getHours() < 10 ? "0" + date.getHours() : date.getHours();
		this.minute = date.getMinutes() < 10 ? "0" + date.getMinutes() : date.getMinutes();
		this.second = date.getSeconds() < 10 ? "0" + date.getSeconds() : date.getSeconds();
		this.w = new Array("星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六")[date.getDay()];	
	    times=this.y+"年\t"+this.M+"月\t"+this.d+"日\t"+this.hour+":"+this.minute+":"+this.second+"\t"+this.w;
        //根据di获取DIV容器对象,然后设置显示的内容
        document.getElementById("timeid").innerHTML=times;
	  }
	  window.setInterval("showTime();",1000);
	</script>
</head>
<body>
	<div class="header">
		<div id="timeid" style="float:right;margin-top: 20px;color: white;padding-right: 15px"></div>
		<div class="logo">
			<h3 style="color:white;">&nbsp;&nbsp;&nbsp;&nbsp;驰骋汽车4S店管理系统</h3>
		</div>	
		<div class="header-right">
		
			 <i class="icon-off icon-white"></i> <a id="modal-973558"
				href="${_cxt}/loginout.do" target="_top">注销</a> <i
				class="icon-envelope icon-white"></i> <a href="#">发送短信</a>
			<i class="icon-user icon-white"></i><a href="#">当前用户:${sessionScope.user.name }</a>
		</div>		
	</div>
		 
</body>
</html>
