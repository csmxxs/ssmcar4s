//清空查询条件
function clean(){
	//文本框清空
	$("input[class=span1-1]").val("");
	//下拉框重置为0
	$("select[class=span1-1]>option[value=0]").attr("selected",true);
	//清空完提交查询请求
	$("#fm1").submit();
}
function clean1(){
	//文本框清空
	$("input[class=ipt]").val("");
	//下拉框重置为0
	$("select[class=ipt]>option[value=0]").attr("selected",true);
	//清空完提交查询请求
	$("#fm1").submit();
}

