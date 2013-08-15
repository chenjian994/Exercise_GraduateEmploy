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

		<title>个人简历管理</title>
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
				<form action="graduate!updateProfile" method="post">
					<table class="verify_info" cellpadding="0px" cellspacing="0px" style="width:660px">
						<tr>
							<td>
								姓名
							</td>
							<td>
								<input type="text" name="graduate.name"
									value='<s:property value="graduate.name"/>' />
							</td>
							<td>
								性别
							</td>
							<td>
								<input type="radio" name="graduate.sex" value="男"
									checked="checked" />
								男
								<input type="radio" name="graduate.sex" vlaue="女" />
								女
							</td>
						</tr>
						<tr>
							<td>
								政治面貌
							</td>
							<td>
								<select name="graduate.profile">
									<option value="党员">
										党员
									</option>
									<option value="团员">
										团员
									</option>
									<option value="无">
										无
									</option>
								</select>
							</td>
							<td>
								学历
							</td>
							<td>
								<select name="graduate.background">
									<option value="博士">
										博士
									</option>
									<option value="硕士">
										硕士
									</option>
									<option value="本科">
										本科
									</option>
									<option value="专科">
										专科
									</option>
									<option value="中专">
										中专
									</option>
								</select>
							</td>
						</tr>
						<tr>
							<td>
								学校
							</td>
							<td>
								<input type="text" name="graduate.school"
									value='<s:property value="graduate.school"/>' />
							</td>
							<td>
								学院
							</td>
							<td>
								<input type="text" name="graduate.college"
									value='<s:property value="graduate.college"/>' />
							</td>
						</tr>
						<tr>
							<td>
								专业
							</td>
							<td>
								<input type="text" name="graduate.major"
									value='<s:property value="graduate.major"/>' />
							</td>
							<td>
								电话
							</td>
							<td>
								<input type="text" name="graduate.phone"
									value='<s:property value="graduate.phone"/>' />
							</td>
						</tr>
						<tr>
							<td>
								邮箱
							</td>
							<td>
								<input type="text" name="graduate.email"
									value='<s:property value="graduate.email"/>' />
							</td>
							<td>
								地址
							</td>
							<td>
								<input type="text" name="graduate.address"
									value='<s:property value="graduate.address"/>' />
							</td>
						</tr>
						<tr>
							<td>
								自我评价
							</td>
							<td colspan="3" style="text-align: left">
								<textarea name="graduate.selfEval" rows="10" cols="60"><s:property value="graduate.selfEval" /></textarea>
							</td>
						</tr>
						<tr>
							<td>
								附加信息
							</td>
							<td colspan="3" style="text-align: left">
							<textarea name="graduate.addition" rows="14" cols="60"><s:property value="graduate.addition" /></textarea>
							</td>
						</tr>
						<s:if test="perfect == false">
					请先完善你的个人信息
						<tr>
								<td colspan="4">
									<input type="submit" value="保存" />
								</td>
							</tr>
						</s:if>
						<s:else>
							<tr>
								<td>
									获得证书
								</td>
								<td colspan="3" style="text-align: left; padding-left: 10px">
									<s:iterator value="graduate.profiles" var="pro" status="ind">
										<s:property value="#ind.getIndex() + 1" />.<s:property
											value="#pro.explain" />
										<br />
									</s:iterator>
								</td>
							</tr>
							<tr>
								<td colspan="4">
									<input type="submit" value="保存修改" />
									<input type="button" value="预览简历"
										onclick="window.location='graduate!showProfile'" />
								</td>
							</tr>
						</s:else>
					</table>
				</form>
				<form action="graduate!addProfile" method="post">
					证书名称：
					<input type="text" name="profileName" />
					<input type="submit" value="添加" />
				</form>
			</div>
		</div>
	</body>
</html>
