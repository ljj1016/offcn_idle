<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%
	String path = request.getContextPath() + "/";
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<base href="<%=basePath%>" target="rightFrame"/>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>无标题文档</title>
	<link href="<%=basePath %>css/style.css" rel="stylesheet" type="text/css" />
</head>

<body style="background:#f0f9fd;">

<div class="lefttop"><span></span>工作台</div>
<dl class="leftmenu">
	
	<!-- 一个模块开始 -->
	<dd>
		<div class="title">
			<span><img src="<%=basePath %>images/leftico01.png"/></span>系统首页
		</div>
		<ul class="menuson">
			<li class="active"><cite></cite><a href="index/welcome.jsp" >首页1</a><i></i></li>
		</ul>
	</dd>
	<!-- 一个模块结束 -->
	
	<!-- 一个模块开始 -->
	<dd>
		<div class="title">
			<span><img src="<%=basePath %>images/leftico01.png"/></span>闲置信息管理
		</div>
		<ul class="menuson">
			<li><cite></cite><a href="module_idle/addidle.jsp">录入闲置信息</a><i></i></li>
			<li><cite></cite><a href="queryList">查看信息</a><i></i></li>
			<li><cite></cite><a href="module_idle/selectkeyword.jsp">关键字筛选</a><i></i></li>
		</ul>    
	</dd>
	<!-- 一个模块结束 -->
		<!-- 一个模块开始 -->
	<dd>
		<div class="title">
			<span><img src="<%=basePath %>images/leftico01.png"/></span>用户信息管理
		</div>
		<ul class="menuson">
			<li><cite></cite><a href="module_geren/updateinfo.jsp">修改用户信息</a><i></i></li>
			<li><cite></cite><a href="module_geren/updatepassword.jsp">修改密码</a><i></i></li>
		</ul>    
	</dd>
	<!-- 一个模块结束 -->
		<!-- 一个模块开始 -->
	<dd>
		<div class="title">
			<span><img src="<%=basePath %>images/leftico01.png"/></span>客户信息管理
		</div>
		<ul class="menuson">
			<li><cite></cite><a href="queryKehu">查看客户信息</a><i></i></li>
			<li><cite></cite><a href="module_kehu/addkehu.jsp">添加客户</a><i></i></li>
			<li><cite></cite><a href="countprovince">客户省份统计</a><i></i></li>
		</ul>    
	</dd>
	<!-- 一个模块结束 -->
		<!-- 一个模块开始 -->
	<dd>
		<div class="title">
			<span><img src="<%=basePath %>images/leftico01.png"/></span>订单信息管理
		</div>
		<ul class="menuson">
			<li><cite></cite><a href="queryOrder">查看订单信息</a><i></i></li>
		</ul>    
	</dd>
	<!-- 一个模块结束 -->
</dl>

<script type="text/javascript" src="<%=basePath %>js/jQuery/jquery.js"></script>
<script type="text/javascript">
$(function(){	
	//导航切换
	$(".menuson li").click(function(){
		$(".menuson li.active").removeClass("active")
		$(this).addClass("active");
	});
	
	$('.title').click(function(){
		var $ul = $(this).next('ul');
		$('dd').find('ul').slideUp();
		if($ul.is(':visible')){
			$(this).next('ul').slideUp();
		}else{
			$(this).next('ul').slideDown();
		}
	});
})	
</script>
<script type="text/javascript">
	/**
	 * 这个使用的单选框选择判断
	 */
	function toUpdate(){
		var id = $("input[name='id']:checked").val();
		if(!id){
			alert("请选择要操作的记录");
			return false;
		}else{
			alert( "您操作的值为："+$("input[name='id']:checked").val())
		}
	}
	$(function(){
		$('.tablelist tbody tr:odd').addClass('odd');
		
		$("#formtitle").click(function(){
			$("#forminfo").slideToggle("slow");
		});
	});
</script>




</body>
</html>
