//自定义公共输入校验框架
var is = true;//校验是否全部通过
//obj表示文本框对象
function cfocus(obj){
	obj.className = "focus";//修改样式类
}
//错误提示
function cerr(obj,msg){
   var err = document.createElement("span");
   err.setAttribute("class","err");
   err.innerHTML = msg;
   //下下个兄弟，注意中间的文本节点
   if(obj.nextSibling.nextSibling){//不存在返回false
	   obj.parentNode.removeChild(obj.nextSibling.nextSibling); 
   }
   //插入到文本框末尾
   obj.parentNode.appendChild(err);
   is = is && false;
   return false;
}
//校验成功
function csuc(obj){
	//下下个兄弟，注意中间的文本节点
	if(obj.nextSibling.nextSibling){//不存在返回false
	   obj.parentNode.removeChild(obj.nextSibling.nextSibling); 
	}
	obj.className = "ipt";//修改样式类
	return true;
}
//非空校验(obj表示文本框对象)
function creq(obj){
	var v = obj.value.trim();
	var a = obj.alt.split(":");
	if(v.length == 0){
	  return cerr(obj,a[0] + "不能为空");
	}
	return csuc(obj);
}
//正则校验(obj表示文本框对象)
function cregex(obj){
	var v = obj.value.trim();
	var a = obj.alt.split(":");//字段中文名:正则表达式
	var regex = eval(a[1]);//创建正则表达式对象
	if(v.length == 0){
		return cerr(obj,a[0]+"不能为空");
	}else if(!regex.test(v)){
		return cerr(obj,a[0]+"格式有误");
	}
	return csuc(obj);
}
//当前页面所有待校验的文本框name的数组
var names = null;
//初始化当前页面的所有校验功能
function cinit(arr){
   names = arr;
   for ( var i = 0; i < names.length; i++) {
	   var a = names[i].split(":");//标签Name:校验方法名
	   var objs = document.getElementsByName(a[0]);
	   if(objs.length>0){
		  cerr(objs[0],"*");//必填符号*
	      objs[0].onfocus = function(){cfocus(this);};//事件处理绑定
	      if(a.length==1){//默认非空校验
	    	  objs[0].onblur  = function(){eval("creq(this);");};
	      }else if(a[1]=="cregex"){
	    	  objs[0].onblur  = function(){eval("cregex(this);");};
	      }		  
	   }	
   }
}
//校验所有
function checkAll(){
	is = true;
	for ( var i = 0; i < names.length; i++) {
		   var a = names[i].split(":");//标签Name:校验方法名
		   var objs = document.getElementsByName(a[0]);
		   if(objs.length>0){
			 objs[0].focus();//触发获取焦点事件
			 if(a.length==1){//默认非空校验
			    creq(objs[0]);//调用校验方法 
		     }else if(a[1]=="cregex"){
		    	cregex(objs[0]);
		     }
		   }
	}
	return is;
}




