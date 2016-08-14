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
	<jsp:include page="head.jsp"></jsp:include>
	<div class="content">
		<div class="left">
			<s:action name="browseCatalog" executeResult="true"></s:action>
		</div>
		<div class="right">
				<div style="margin:0 auto;padding-top:20px;width: 500px;">
					<h3>用户注册</h3>
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
	<jsp:include page="foot.jsp"></jsp:include>
</body>
</html>
