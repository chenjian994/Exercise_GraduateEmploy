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

		<title>个人简历</title>
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
			<input type="button" value="返回" onclick="window.location='graduate!profileManage'" />
					<table class="verify_info" cellpadding="0px" cellspacing="0px" style="width:660px;">
						<tr>
							<td>
								姓名
							</td>
							<td>
								<s:property value="graduate.name"/>								
							</td>
							<td>
								性别
							</td>
							<td>
								<s:property value="graduate.sex"/>
							</td>
						</tr>
						<tr>
							<td>
								政治面貌
							</td>
							<td>
								<s:property value="graduate.profile"/>
							</td>
							<td>
								学历
							</td>
							<td>
								<s:property value="graduate.background"/>
							</td>
						</tr>
						<tr>
							<td>
								学校
							</td>
							<td>
								<s:property value="graduate.school"/>
							</td>
							<td>
								学院
							</td>
							<td>
								<s:property value="graduate.college"/>
							</td>
						</tr>
						<tr>
							<td>
								专业
							</td>
							<td>
								<s:property value="graduate.major"/>
							</td>
							<td>
								电话
							</td>
							<td>
								<s:property value="graduate.phone"/>
							</td>
						</tr>
						<tr>
							<td>
								邮箱
							</td>
							<td>
								<s:property value="graduate.email"/>
							</td>
							<td>
								地址
							</td>
							<td>
								<s:property value="graduate.address"/>
							</td>
						</tr>
							<tr>
								<td>获得证书</td>
								<td colspan="3" style="text-align: left; padding-left:10px">
									<s:iterator value="graduate.profiles" var="pro" status="ind">
										<s:property value="#ind.getIndex() + 1"/>.<s:property value="#pro.explain" />。<br/>
									</s:iterator>
								</td>
							</tr>
							<tr>
								<td>
									自我评价
								</td>
								<td colspan="3" style="text-align: left; padding-left:10px; height:200px">
									<s:property value="graduate.selfEval"/>
								</td>
							</tr>
						<tr>
							<td>
								附加信息
							</td>
							<td colspan="3" style="text-align: left; padding-left:10px; height:250px">
								<s:property value="graduate.addition"/>
							</td>
						</tr>
					</table>
			</div>
		</div>
	</body>
</html>
