<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
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

		<title>用户注册</title>
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
				<!-- end .header -->
			</div>
			<div class="content_register">
				<s:fielderror />
				<s:form action="register" method="post" validate="true">
					<table class="register_tab">
						<tr>
							<td>
								<s:textfield name="username" label="用户名" />
							</td>
						</tr>
						<tr>
							<td>
								<s:password name="password" label="注册密码"/>
							</td>
						</tr>
						<tr>
							<td>
								<s:password name="rePassword" label="确认密码"/>
							</td>
						</tr>
						<tr>
							<td>
								身份：
							</td>
							<td>
								<s:radio name="identity" list="%{#{'1':'企业','2':'毕业生'}}" value="1" theme="simple"></s:radio>
							</td>
						</tr>
						<tr>
							<td>
								<s:textfield name="email" label="邮箱"/>
							</td>
						</tr>
						<tr>
							<td>
								<s:textfield name="phone" label="联系电话"/>
							</td>
						</tr>
						<tr>
							<td colspan="2">
								<a href="index.jsp" style="font-size: 12px;">返回</a>
								<s:submit value="提交" cssStyle="height: 30px; width: 60px;" />
							</td>
						</tr>
					</table>
				</s:form>
			</div>
			<!-- end .container -->
		</div>
	</body>
</html>
