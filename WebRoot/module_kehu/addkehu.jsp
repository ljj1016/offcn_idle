<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%
	String path = request.getContextPath() + "/";
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<base href="<%=basePath%>"/>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>无标题文档</title>
	<link href="<%=basePath %>css/style.css" rel="stylesheet" type="text/css" />
</head>

<body>

<div class="place">
	<span>位置：</span>
	<ul class="placeul">
		<li><a href="#">客户信息管理</a></li>
		<li><a href="#">添加客户</a></li>
	</ul>
</div>

<form action="addkehu" method="post">
	<div class="formbody">
		<div class="formtitle"><span>客户信息</span></div>
		<ul class="forminfo">
			<li>
				<label>客户名称</label>
				<input name="u_nickname" type="text" class="dfinput" />
				<i>名称不能超过20个字符</i>
			</li>
			<li>
				<label>手机号码</label>
				<input name="u_phonenum" type="text" class="dfinput" />
				
			</li>
			
			<li>
				<label>账号</label>
				<input name="u_account" type="text" class="dfinput" />
			</li>
			
			<li>
				<label>密码</label>
				<input name="u_password" type="text" class="dfinput" />
				<i></i>
			</li>
			<li>
				<label>生日</label>
				<input name="u_birthday" type="text" class="dfinput" />
				<i></i>
			</li>
			<li>
				<label>所属省</label>
				<input name="u_province" type="text" class="dfinput" />
				<i></i>
			</li>
			<li>
				<label>所属城市</label>
				<input name="u_city" type="text" class="dfinput" />
				<i></i>
			</li>
			<li>
				<label>所属区</label>
				<input name="u_district" type="text" class="dfinput" />
				<i></i>
			</li>		
			<li>
				<label>&nbsp;</label>
				<input name="" type="submit" class="btn" value="确认添加"/>
			</li>
		</ul>
	</div>
</form>

<script src="<%=basePath %>js/upload.js"></script>
<script type="text/javascript" src="<%=basePath %>js/jQuery/jquery.js"></script>
</body>
</html>
	