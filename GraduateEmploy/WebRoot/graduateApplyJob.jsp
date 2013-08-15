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

		<title>职位申请</title>
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
		<div class="container">
			<jsp:include page="graduateHeader.jsp"></jsp:include>
			<!-- end .container -->
			<div class="content">
				<table class="verify_info" cellpadding="0px" cellspacing="0px">
					<thead>职位列表</thead>
					<tr>
						<td>职位名称</td>
						<td>发布公司</td>
						<td>状态</td>
					</tr>
					<s:iterator value="jobsInfo" var="ji">
						<tr>
							<td><s:property value="#ji.job.name"/></td>
							<td><s:property value="#ji.job.enterprise.name"/></td>
							<td>
								<s:if test="#ji.applied == true"><font color='green'>已投递</font></s:if>
								<s:else><a href='graduate!jobInfo?id=<s:property value="#ji.job.id"/>'>查看详情</a></s:else>
							</td>
						</tr>
					</s:iterator>
				</table>
			</div>
		</div>
	</body>
</html>
