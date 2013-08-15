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

		<title>简历审核</title>
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
				已投递的简历列表
				<table style="text-align: center; margin-left: 30px;" border="1px"
					cellpadding="8px" cellspacing="0px"">
					<tr>
						<td>
							职位名称
						</td>
						<td>
							申请人姓名
						</td>
						<td>
							学校
						</td>
						<td>
							政治面貌
						</td>
						<td>
							学历
						</td>
						<td>
							操作
						</td>
					</tr>
					<s:iterator value="jobs" var="job">
						<s:iterator value="#job.graduates" var="jg">
							<tr>
								<td>
									<s:property value="#job.name" />
								</td>
								<td>
									<s:property value="#jg.name" />
								</td>
								<td>
									<s:property value="#jg.school" />
								</td>
								<td>
									<s:property value="#jg.profile" />
								</td>
								<td>
									<s:property value="#jg.background" />
								</td>
								<td>
									<a
										href='enterprise!profileInfo?id=<s:property value="#jg.no"/>'>详细信息</a>
								</td>
							</tr>
						</s:iterator>
					</s:iterator>
				</table>
			</div>
			<!-- end .container -->
		</div>
	</body>
</html>
