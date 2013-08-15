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

		<title>职位信息</title>
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
			<jsp:include page="graduateHeader.jsp"></jsp:include>
			<div class="content">
					<table style="height:300px; width:400px; text-align:center; margin-left:70px;" border="1px" cellpadding="0px" cellspacing="0px"">
						<tr>
							<td>职位名称</td>
							<td><s:property value="job.name"/></td>
							<td rowspan="10"><s:property value="job.require"/></td>
						</tr>
						<tr>
							<td>职位年龄</td>
							<td><s:property value="job.age"/></td>
						</tr>
						<tr>
							<td>招聘人数</td>
							<td><s:property value="job.count"/></td>
						</tr>
						<tr>
							<td>性别要求</td>
							<td><s:property value="job.sex"/></td>
						</tr>
						<tr>
							<td>职位学历</td>
							<td><s:property value="job.background"/></td>
						</tr>
						<tr>
							<td>工作经验</td>
							<td><s:property value="job.workExper"/></td>
						</tr>
						<tr>
							<td>聘用方式</td>
							<td><s:property value="job.employMode"/></td>
						</tr>
						<tr>
							<td>工资待遇</td>
							<td><s:property value="job.salary"/></td>
						</tr>
						<tr>
							<td>工作地点</td>
							<td><s:property value="job.workAddress"/></td>
						</tr>
						<tr>
							<td>截至日期</td>
							<td><s:property value="job.endDate"/></td>
						</tr>
						<tr>
							<td colspan="3">
							<input type="button" value="返回" onclick="window.location='graduate!jobList'"/>
							<input type="button" value="投递简历" onclick="window.location='graduate!applyJob?jid=<s:property value="job.id"/>'"/>
							</td>
						</tr>
					</table>
			</div>
			<!-- end .container -->
		</div>
	</body>
</html>
