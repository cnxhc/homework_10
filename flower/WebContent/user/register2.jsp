<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/flower.css" />
<title>注册页面</title>
</head>
<body>
	<jsp:include page="../head.jsp"></jsp:include>
	<div class="content">
		<div class="left">
			<s:action name="browseCatalog" executeResult="true"></s:action>
		</div>
		<div class="right">
			<div style="padding-left: 200px; width: 600px;">
				<s:form action="addUser.action" method="post">
					用户名:<input type="text" name="user.username" required="required"><br> 
					真实姓名:<input type="text" name="user.realName" required="required"><br> 
					用户密码:<input type="password" name="user.password" required="required"><br> 
					保密问题:<input type="text" name="user.pwdQuestion" required="required"><br> 
					保密答案:<input type="text" name="user.pwdQuestionAnswer" required="required"><br> 
					用户邮箱:<input type="text" name="user.email" required="required"><br> 
					用户地址:<input type="text" name="user.email" required="required"><br> 
					用户手机:<input type="number" name="user.phoneNO" required="required"><br> 
					<s:submit value="注册"></s:submit>
				</s:form>
			</div>
		</div>
	</div>
	<jsp:include page="../foot.jsp"></jsp:include>
</body>
</html>
