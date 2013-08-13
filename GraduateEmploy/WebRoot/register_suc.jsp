<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>注册提示</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
		<link href="style/style.css" rel="stylesheet" type="text/css" />
	</head>

	<body>
		<div class="container" style="height:500px;">
			<div class="header">
				<div class="header_title">
					毕业生就业管理系统
				</div>
				<!-- end .header -->
			</div>
			<div class="content_register">
				<font style="font-size:30px;">用户注册成功！</font>
				去<a href="index.jsp">登陆</a>
			</div>
			<!-- end .container -->
		</div>
	</body>
</html>
