<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/header.jsp"%>
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


</style>
<!-- 引入弹出窗口JS库 -->
<script type="text/javascript"
	src="${_plugins}/lhgdialog/lhgdialog.min.js?self=true&skin=igreen"></script>
<script type="text/javascript">
	function showPic(filePath) {//显示图片
		if (filePath != '') {
			$.dialog({
				title : '查询图片',
				width : '350px',
				height : '300px',
				content : '<img src="${_cxt}/Carimages/'+ filePath +'" />'
			});
		}

	}
</script>
</head>
<body>
	<div>
		<ul class="breadcrumb">
			<li><a href="#">当前页:首页</a></li>
		</ul>
	</div>
	<form action="${_cxt}/car/list.do" method="post" id="fm1">
		<table class="table table-bordered">
			<tr>
				<td colspan="4">查询条件</td>
			</tr>
			<tr>

				<td id="test">汽车品牌:</td>
				<td id="value"><input type="text" name="brand" class="ipt"
					value="${param.brand}" /></td>
				<td id="test">汽车系列:</td>
				<td id="value"><input type="text" name="series" class="ipt"
					value="${param.series}" /></td>
			</tr>
			<tr>
				<td id="test">汽车类型:</td>
				<td id="value"><mt:select name="type"
						data="${applicationScope.CAR_TYPE}" cssClass="ipt"
						header="0:----所有车系----" value="${param.type}"></mt:select></td>
				<td id="test">汽车排量:</td>
				<td id="value"><input type="text" name="volume" class="ipt"
					value="${param.volume}"></td>
			</tr>
		</table>

			<div style="text-align:right;">
				<input type="submit" value="查询"
					class="btn btn-info " /> <input type="button"
					value="重置" onclick="clean1();" class="btn btn-info"/> <input type="button" value="添加"
					onclick="location.href='${_cxt}/car/add.jsp'" class="btn btn-info" />
			</div>

		<table class="table table-bordered">
			<tr>
				<th colspan="12" style="font-size: 20px">整车信息列表
					<div style="float: right;margin-right: 10px;color: red;">${msg}</div>
				</th>
			</tr>
			<tr>
				<th>记录ID</th>
				<th>汽车品牌-车系:</th>
				<th>厂家名称:</th>
				<th>类型:</th>
				<th>排量:</th>
				<th>颜色:</th>
				<th>产地:</th>
				<th>价格:</th>
				<th>上市时间:</th>
				<th>备注:</th>
				<th>操作</th>
			</tr>
			<c:forEach var="v" items="${list}" varStatus="vs">
				<tr style="text-align:center" class="tr${vs.count%2}">
					<td>${v.id}</td>
					<td><a href="javascript:showPic('${v.filePath}')">${v.series}</a></td>
					<td>${v.brand}</td>
					<td><mt:tran value="${v.type}"
							data="${applicationScope.CAR_TYPE}"></mt:tran></td>
					<td>${v.volume}</td>
					<td>${v.color}</td>
					<td>${v.proPlace}</td>
					<td>${v.price}</td>
					<td><fmt:formatDate value="${v.createDate}" pattern="yyyy-MM-dd" /></td>
					<td>${v.remark}</td>
					<td><a href="${_cxt}/car/delete.do?id=${v.id}"
						onclick="return confirm('确定删除吗？')">删除</a> | <a
						href="${_cxt}/car/update.do?id=${v.id}">更新</a></td>
				</tr>
			</c:forEach>
		</table>
		<%@ include file="/common/pager.jsp"%>
	</form>
</body>
</html>