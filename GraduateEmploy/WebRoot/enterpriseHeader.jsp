<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<div class="header">
	<div class="header_title">
		毕业生就业管理系统
	</div>
	<div style="height: 27px;">
		<div class="header_menu header_link">
			<a href="enterprise.jsp">首页</a>
			<a href="enterprise!infoManage">企业信息管理</a>
			<a href="enterprise!jobManage">企业职位管理</a>
			<a href="enterprise!verifyProfile">审核简历</a>
		</div>
		<div class="header_exit header_link">
			欢迎你&nbsp;&nbsp;
			<s:property value="#session.username" />
			<a href="logout">退出系统</a>
		</div>
	</div>
	<!-- end .header -->
</div>
