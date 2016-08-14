<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>


<!DOCTYPE HTML>
<html>
<head>
<link rel="stylesheet" type="text/css" href="../css/flower.css" />
<title>添加鲜花</title>
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
			<a href="addNewUser.jsp" target="_self">添加新用户</a><br><br>
			<a href="browseAllUser.action" target="_self">查询用户</a><br>
			<br>
		</div>
		<div class="right">
				<div style="margin:0 auto;padding-top:20px;width: 500px;">
					<h3>添加用户</h3>
					<form action="addOrUpdateUser.action" method="post">
					用户名称:<input type="text" name="user.userName" required="required">
						<br> 
					真实姓名:<input type="text" name="user.realName" required="required">
						<br> 
					用户密码:<input type="password" name="user.password"
							required="required">
						<br> 
					保密问题:<input type="text" name="user.pwdQuestion" required="required">
						<br> 
					保密答案:<input type="text" name="user.pwdQuestionAnswer"
							required="required">
						<br> 
					用户邮箱:<input type="text" name="user.email" required="required">
						<br> 
					用户地址:<input type="text" name="user.address" required="required">
						<br> 
					用户手机:<input type="number" name="user.phoneNo" required="required">
						<br>
					<input type="submit" value="注册" style="width:120px;">
					</form>
				</div>
		</div>
	</div>
	<jsp:include page="../foot.jsp"></jsp:include>
</body>
</html>
