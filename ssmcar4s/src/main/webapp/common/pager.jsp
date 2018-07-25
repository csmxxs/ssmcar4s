<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 引入标签库 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<style>
center a {
	/*去掉下划线  */
	text-decoration: none;
}

b {
	color: red;
}
</style>
<script type="text/javascript">
	//跳到第i页 	
	function gotoPage(i) {
		var currentForm = document.getElementById("fm1");
		var currentPage = document.getElementById("currentPage");
		currentPage.value = i;//改变当前页的值
		currentForm.submit(); //提交表单 
	}
	function cgotoPage(i) {
		var currentPage = document.getElementById("currentPage");
		currentPage.value = i;//改变当前页的值
	}
	function csubmit() {
		var currentForm = document.getElementById("fm1");
		currentForm.submit(); //提交表单 
	}
</script>
<center>
	<!--隐藏域  -->
	<input id="currentPage" type="hidden" name="page" value="1">
	<c:choose>
		<c:when test="${page.currentPage == 1}">首页</c:when>
		<c:otherwise>
			<a href="#" onclick="gotoPage(1)">首页</a>
		</c:otherwise>
	</c:choose>
	<c:choose>
		<c:when test="${page.hasPrevious}">
			<a href="#" onclick="gotoPage(${page.prePage})">上一页</a>
		</c:when>
		<c:otherwise>上一页</c:otherwise>
	</c:choose>
	<c:choose>
		<c:when test="${page.hasNext}">
			<a href="#" onclick="gotoPage(${page.nextPage})">下一页</a>
		</c:when>
		<c:otherwise>下一页</c:otherwise>
	</c:choose>
	<c:set var="i" value="${page.totalPages}" scope="page"></c:set>
	<c:choose>
		<c:when test="${page.currentPage == i}">末页</c:when>
		<c:otherwise>
			<a href="#" onclick="gotoPage(${page.totalPages})">未页</a>
		</c:otherwise>
	</c:choose>
	当前第<b>${page.currentPage}</b>页 总记录数:<b>${page.totalRows}</b>条 总页数:<b>${page.totalPages}</b>页
	&nbsp;&nbsp;&nbsp;每页 <select name="rowsPerPage" style="width:45px">
		<option ${page.rowsPerPage == '5' ? "selected='selected'" : ""}
			value="5">5</option>
		<option ${page.rowsPerPage == '8' ? "selected='selected'" : ""}
			value="8">8</option>
		<option ${page.rowsPerPage == '10' ? "selected='selected'" : ""}
			value="10">10</option>
	</select> 条记录&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;前往 <select style="width:80px"
		onchange="cgotoPage(this.value)">
		<c:forEach var="i" begin="1" end="${page.totalPages}" step="1"
			varStatus="idx">
			<c:set var="i" value="${i}" scope="page"></c:set>
			<option ${page.currentPage == i ? "selected='selected'" : ""}
				value="${i }">第${i }页</option>
		</c:forEach>
	</select> <input type="button" value="GO>>" onclick="csubmit()" style="background-color:green">
</center>

