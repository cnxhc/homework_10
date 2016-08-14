<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.4/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/flower.css" />
<title>登录页</title>
</head>
<body>
<div id="div_bg">
		<div id="div_context">
			<center>
				<s:property value="#request.msg" />
				<s:form action="checkUser" method="post">
										
					<div class="input-group">
						<span class="glyphicon glyphicon-user"></span> <input type="text"
							placeholder="username" name="user.userName">
					</div>

					<div class="input-group">
						<span class="glyphicon glyphicon-lock"></span> <input
							type="password" placeholder="password" name="user.password">
					</div>
					<s:submit></s:submit>
				</s:form>
			</center>
		</div>
	</div>
</body>
</html>