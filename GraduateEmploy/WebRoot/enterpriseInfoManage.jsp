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

		<title>企业信息管理</title>
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
			<jsp:include page="enterpriseHeader.jsp"></jsp:include>
			<div class="content">
				<form method="post" action="enterprise!updateInfo">
					<input type="hidden" name="enterprise.id" value="<s:property value="enterprise.id"/>"/>
					<input type="hidden" name="enterprise.password" value="<s:property value="enterprise.password"/>"/>
					<input type="hidden" name="enterprise.username" value="<s:property value="enterprise.username"/>"/>
					<input type="hidden" name="enterprise.verified" value="<s:property value="enterprise.verified"/>"/>
					<table class="verify_info" cellpadding="0px" cellspacing="0px" height="130px">
						<tr>
							<td>公司名称</td>
							<td><input type="text" name="enterprise.name" value='<s:property value="enterprise.name"/>'/></td>
							<td>公司简介</td>
							<td><input type="text" name="enterprise.summary" value='<s:property value="enterprise.summary"/>'/></td>
							<td>公司成立时间</td>
							<td><input type="text" name="enterprise.establishDate" value='<s:property value="enterprise.establishDate"/>'/></td>
						</tr>
						<tr>
							<td>公司性质</td>
							<td><input type="text" name="enterprise.type" value='<s:property value="enterprise.type"/>'/></td>
							<td>公司地址</td>
							<td><input type="text" name="enterprise.address" value='<s:property value="enterprise.address"/>'/></td>
							<td>公司员工规模</td>
							<td><input type="text" name="enterprise.employeeAmount" value='<s:property value="enterprise.employeeAmount"/>'/></td>
						</tr>
						<tr>
							<td>公司联系人</td>
							<td><input type="text" name="enterprise.contact" value='<s:property value="enterprise.contact"/>'/></td>
							<td>公司网址</td>
							<td><input type="text" name="enterprise.website" value='<s:property value="enterprise.website"/>'/></td>
							<td>公司联系电话</td>
							<td><input type="text" name="enterprise.phone" value='<s:property value="enterprise.phone"/>'/></td>
						</tr>
						<tr>
							<td>公司邮箱</td>
							<td><input type="text" name="enterprise.email" value='<s:property value="enterprise.email"/>'/></td>
						</tr>
				<s:if test="perfect == false">
					<font>请完善你的企业信息</font>
						<tr>
							<td colspan="6"><input type="submit" value="保存"/></td>
						</tr>
				</s:if>
				<s:else>
						<tr>
							<td colspan="6">
								<input type="submit" value="修改"/>
								<a href='enterprise!deleteInfo?id=<s:property value="enterprise.id"/>'>删除</a>
							</td>
						</tr>
				</s:else>
				</table>
				</form>
			</div>
			<!-- end .container -->
		</div>
	</body>
</html>
