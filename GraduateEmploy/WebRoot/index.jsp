<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
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

		<title>系统登陆</title>
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
			<div class="content_login">
				<s:fielderror fieldName="loginErr"/>
				<s:debug></s:debug>
				<form method="post" action="login" >
				<table class="login_tab">
					<tr>
						<td>用户名：</td>
						<td><input type="text" name="username"/></td>
					</tr>
					<tr>
						<td>密码：</td>
						<td><input type="password" name="password"/></td>
					</tr>
					<tr>
						<td colspan="2"><input type="radio" name="identity" value="0" checked="checked"/>管理员
						<input type="radio" name="identity" value="1"/>企业
						<input type="radio" name="identity" value="2"/>毕业生</td>
					</tr>
					<tr>
						<td colspan="2"><a href="register.jsp" style="font-size:12px;">注册</a>
						<input type="submit" value="登  陆" style="height:30px; width:60px;"/></td>
					</tr>
				</table>
				<!-- end .content -->
				</form>
			</div>
			<!-- end .container -->
		</div>
	</body>
</html>
