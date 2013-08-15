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

		<title>企业职位管理</title>
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
			<jsp:include page="enterpriseHeader.jsp"></jsp:include>
			<div class="content">
				<table class="verify_info" cellpadding="0px" cellspacing="0px">
					<tr>
						<td>职位名称</td>
						<td>职位年龄</td>
						<td>性别</td>
						<td>学历</td>
						<td>工作经验</td>
						<td>工作地点</td>
						<td>发布日期</td>
						<td>截至日期</td>
						<td>操作</td>
					</tr>
					<s:if test="jobs.size <= 0">
						<tr>
							<td colspan="8">你公司尚未发布任何职位</td>
						</tr>
					</s:if>
					<s:else>
						<s:iterator value="jobs" var="j">
							<tr>
								<td><s:property value="#j.name"/></td>
								<td><s:property value="#j.age"/></td>
								<td><s:property value="#j.sex"/></td>
								<td><s:property value="#j.background"/></td>
								<td><s:property value="#j.workExper"/></td>
								<td><s:property value="#j.workAddress"/></td>
								<td><s:property value="#j.publishDate"/></td>
								<td><s:property value="#j.endDate"/></td>
								<td><a href='enterprise!jobInfo?id=<s:property value="#j.id"/>'>详情</a></td>
							</tr>	
						</s:iterator>
					</s:else>
				</table>
				<input type="button" value="发布新职位" onclick="window.location='enterpriseNewJob.jsp'"/>
			</div>
			<!-- end .container -->
		</div>
	</body>
</html>
