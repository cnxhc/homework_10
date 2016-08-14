<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE HTML>
<html>
<head>
<link rel="stylesheet" type="text/css" href="../css/flower.css" />
<title>修改用户信息</title>
</head>

<body>
	<div class="head_right">
		<a href="login_success.jsp" target="_top">首页</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<s:if test="#session.admin!=null">
			<a href="adminlogOut.action" target="_top">注销</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		</s:if>
	</div>
	<div class="content">
		<div class="left">
			<h4>管理用户</h4>
			<a href="addNewUser.jsp" target="_self">添加新用户</a><br>
			<br> <a href="browseAllUser.action" target="_self">查询用户</a><br>
			<br>
		</div>
		<div class="right">
			<div style="margin: 0 auto; padding-top: 20px; width: 500px;">
				<h3>修改用户信息</h3>
				<center>
				<s:action name="browseCatalog" executeResult="false" />
				<s:set value="#request.user" id="user"></s:set>
				<s:form action="updateUser" method="post"
					enctype="multipart/form-data">
					<s:textfield label="用户名称" name="user.userName"
						value="%{#user.userName}"></s:textfield>
					<s:textfield label="真实姓名" name="user.realName"
						value="%{#user.realName}"></s:textfield>
					<s:textfield label="用户密码" name="user.password"
						value="%{#user.password}"></s:textfield>
					<s:textfield label="保密问题" name="user.pwdQuestion"
						value="%{#user.pwdQuestion}"></s:textfield>
					<s:textfield label="保密答案" name="user.pwdQuestionAnswer"
						value="%{#user.pwdQuestionAnswer}"></s:textfield>
					<s:textfield label="邮箱" name="user.email" value="%{#user.email}"></s:textfield>
					<s:textfield label="地址" name="user.address"
						value="%{#user.address}"></s:textfield>
					<s:textfield label="手机" name="user.phoneNo"
						value="%{#user.phoneNo}"></s:textfield>
					<s:hidden name="user.id" value="%{#user.id}"></s:hidden>
					<s:submit value="修改"></s:submit>
				</s:form>
				</center>
			</div>
		</div>
	</div>
	<jsp:include page="../foot.jsp"></jsp:include>
</body>
</html>
