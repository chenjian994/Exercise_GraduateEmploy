<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
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

		<title>管理员</title>
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
		<div class="container" style="height: 500px;">
			<div class="header">
				<div class="header_title">
					毕业生就业管理系统
				</div>
				<div style="height:27px;">
				<div class="header_menu header_link">
					<a href="admin.jsp">首页</a>
					<a href="admin!regInfoVerify">注册信息审核</a>
					<a href="#">毕业生离校审核</a>
				</div>
				<div class="header_exit header_link">
					欢迎你&nbsp;&nbsp;<s:property value="#session.username"/>
					<a href="logout">退出系统</a>
				</div>
				</div>
				<!-- end .header -->
			</div>

			<!-- end .container -->
		</div>
	</body>
</html>
