<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML>
<html>
<head>
<link rel="stylesheet" type="text/css" href="../css/flower.css" />
<title>注册成功</title>
</head>
<body>
	<s:if test="#session.admin!=null">
		<div class="head_right">
			<a href="login_success.jsp" target="_top">首页</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<s:if test="#session.admin!=null">
				<a href="adminlogOut.action" target="_top">注销</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		</s:if>
		</div>
		<div class="content">
			<div class="left">
				<h4>管理用户</h4>
				<a href="addNewUser.jsp" target="_self">添加新用户</a><br> <br>
				<a href="browseAllUser.action" target="_self">查询用户</a><br> <br>
			</div>
			<div class="right">
				<center>
					<h2>操作成功</h2>
				</center>
			</div>
		</div>
		<jsp:include page="foot.jsp"></jsp:include>
	</s:if>
	<s:elseif test="#session.user!=null">
		<jsp:include page="head.jsp"></jsp:include>
		<div class="content">
			<div class="left">
				<s:action name="browseCatalog" executeResult="true"></s:action>
			</div>
			<div class="right" style="padding-top:40px;";>
				<!-- 注册成功！欢迎<a href="login.jsp" target="_self"> 登录</a> -->
				恭喜操作成功了！请继续...
			</div>
		</div>
		<jsp:include page="foot.jsp"></jsp:include>
	</s:elseif>
	<s:else>
		<jsp:include page="head.jsp"></jsp:include>
		<div class="content">
			<div class="left">
				<s:action name="browseCatalog" executeResult="true"></s:action>
			</div>
			<div class="right" style="padding-top:40px;";>
				恭喜注册成功了！欢迎<a href="login.jsp" target="_self"> 登录</a>
			</div>
		</div>
		<jsp:include page="foot.jsp"></jsp:include>
	</s:else>
</body>
</html>
