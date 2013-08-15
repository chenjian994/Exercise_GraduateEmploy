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
				<form method="post" action="enterprise!newJob">
					<table style="text-align:center; margin-left:30px;" border="1px" cellpadding="0px" cellspacing="0px"">
						<tr>
							<td>职位名称</td>
							<td><input type="text" name="job.name"/></td>
							<td rowspan="10"><textarea name="job.require" rows="17" cols="40" placeholder="职责描述"></textarea></td>
						</tr>
						<tr>
							<td>职位年龄</td>
							<td><input type="text" name="job.age"/></td>
						</tr>
						<tr>
							<td>招聘人数</td>
							<td><input type="text" name="job.count"/></td>
						</tr>
						<tr>
							<td>性别</td>
							<td><input type="radio" name="job.sex" value="男" checked="checked"/>男
							<input type="radio" name="job.sex" value="女"/>女</td>
						</tr>
						<tr>
							<td>职位学历</td>
							<td>
								<select name="job.background">
									<option value="博士">博士</option>
									<option value="硕士及以上">硕士及以上</option>
									<option value="本科及以上">本科及以上</option>
									<option value="专科及以上">专科及以上</option>
									<option value="中专及以上">中专及以上</option>
									<option value="高中及以上">高中及以上</option>
									<option value="初中及以上">初中及以上</option>
									<option value="小学及以上">小学及以上</option>
								</select>
							</td>
						</tr>
						<tr>
							<td>工作经验</td>
							<td>
								<select name="job.workExper">
									<option value="1年以下">1年以下</option>
									<option value="1-2年">1-2年</option>
									<option value="2-5年">2-5年</option>
									<option value="5年以上">5年以上</option>
								</select>
							</td>
						</tr>
						<tr>
							<td>聘用方式</td>
							<td>
								<input type="radio" name="job.employMode" value="兼职"/>兼职
								<input type="radio" name="job.employMode" value="全职" checked="checked"/>全职
							</td>
						</tr>
						<tr>
							<td>工资待遇</td>
							<td>
								<select name="job.salary">
									<option value="1000元以下">1000元以下</option>
									<option value="1000-3000元">1000-3000元</option>
									<option value="3000-5000元">3000-5000元</option>
									<option value="5000-10000元">5000-10000元</option>
									<option value="10000以上">10000以上</option>
								</select>
							</td>
						</tr>
						<tr>
							<td>工作地点</td>
							<td>
								<select name="job.workAddress">
									<option value="北京">北京</option>
									<option value="上海">上海</option>
									<option value="成都">成都</option>
								</select>
							</td>
						</tr>
						<tr>
							<td>截至日期</td>
							<td><input type="text" name="job.endDate"/></td>
						</tr>
						<tr>
							<td colspan="3">
							<input type="button" value="取消" onclick="window.location='enterprise!jobManage'"/>
							<input type="submit" value="发布"/></td>
						</tr>
					</table>
				</form>
			</div>
			<!-- end .container -->
		</div>
	</body>
</html>
