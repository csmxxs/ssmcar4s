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
#createDate{
   width:173px;
}
</style>
</head>
<body>
	<div class="title_right">
		<strong>添加页面</strong>
	</div>
	<%-- 只要是做上传，表单form必须加enctype="multipart/form-data" --%>
	<form action="${_cxt}/car/add.do" method="post"
		enctype="multipart/form-data">
		<table class="table table-bordered">
			<tr>
				<td id="test">品牌:</td>
				<td id="value"><input type="text" name="brand" id="input18"
					class="ipt" /></td>
				<td id="test">车系:</td>
				<td id="value"><input type="text" name="series" id=""
					class="ipt" /></td>
			</tr>
			<tr>
				<td id="test">车型:</td>
				<td id="value"><mt:select name="type"
						data="${applicationScope.CAR_TYPE}" header="0:----请选择----"
						cssClass="ipt"></mt:select></td>
				<td id="test">排量:</td>
				<td id="value"><input type="text" name="volume" class="ipt">
				</td>
			</tr>
			<tr>
				<td id="test">颜色:</td>
				<td><input type="text" name="color" class="ipt"></td>
				<td id="test">产地:</td>
				<td id="value"><input type="text" name="proPlace" class="ipt"></td>
			</tr>
			<tr>
				<td id="test">价格:</td>
				<td id="value"><input type="text" name="price" class="ipt"></td>
				<td id="test">上市日期:</td>
				<td id="value"><input type="Date" name="createDate" id="createDate"></td>
			</tr>
			<tr>
				<td id="test">备注:</td>
				<td id="value"><input type="text" name="remark" class="ipt"></td>
				<td id="test">汽车图片:</td>
				<td id="value"><input type="file" name="file"/></td>
			</tr>
			<tr>
			
							<td id="test">供应商:</td>
				<td id="value"><mt:select name="supplierId"
						data="${applicationScope.VENDER}" header="0:----请选择----"
						cssClass="ipt"></mt:select></td>
			
			</tr>
			
			<tr>
				<td colspan="4">
					<div style="color:red ;float: right;">${msg}</div>
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