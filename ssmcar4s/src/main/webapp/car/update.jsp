<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/header.jsp"%>
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

#birthday {
	width: 173px;
	height: 20px;
}
</style>
</head>
<body>
	<div style="text-align:center;padding:30px">
		<strong>整车信息修改页面</strong>
	</div>
	<%-- 只要是做上传，表单form必须加enctype="multipart/form-data" --%>
	<form action="${_cxt}/car/gotoupdate.do" method="post"
		enctype="multipart/form-data">
		<!--临时存放变量  -->
		<c:set var="v" value="${car}" scope="page"></c:set>
		<input type="hidden" value="${ v.id}" name="id"/>
		<table class="table table-bordered">
			<tr>
				<td id="test">品牌:</td>
				<td id="value"><input type="text" name="brand" class="ipt"
					value="${v.brand}" /></td>
				<td id="test">车系:</td>
				<td id="value"><input type="text" name="series" class="ipt"
					value="${v.series}" /></td>
			</tr>
			<tr>
				<td id="test">车型:</td>
				<td id="value"><mt:select name="type"
						data="${applicationScope.CAR_TYPE}" value="${v.type }"
						cssClass="ipt"></mt:select></td>
				<td id="test">排量:</td>
				<td id="value"><input type="text" name="volume" class="ipt"
					value="${v.volume }"></td>
			</tr>
			<tr>
				<td id="test">颜色:</td>
				<td><input type="text" name="color" class="ipt"
					value="${v.color }"></td>
				<td id="test">产地:</td>
				<td><input type="text" name="proPlace" class="ipt"
					value="${v.proPlace }"></td>
			</tr>
			<tr>
				<td id="test">价格:</td>
				<td><input type="text" name="price" class="ipt"
					value="${v.price}"></td>
				<td id="test">上市日期:</td>
				<td><input type="Date" name="createDate"/></td>
			</tr>
			<tr>
				<td id="test">备注:</td>
				<td><input type="text" name="remark" class="ipt"
					value="${v.remark}"></td>
				<td id="test">汽车图片:</td>
				<td><input type="file" name="file" ></td>
			</tr>
			<tr>
				<td colspan="4">
					<div style="float: right;color:red;">${msg}</div>
				</td>
			</tr>
		</table>
		<div style="text-align:right;">
			<input type="submit" value="确定" class="btn btn-info" /> <input
				type="reset" value="清空" class="btn btn-info" /> <input
				type="button" value="返回"
				onclick="location.href='${_cxt}/car/list.do'" class="btn btn-info" />
		</div>
	</form>
</body>
</html>