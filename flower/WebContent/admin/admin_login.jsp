<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.4/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="../css/flower.css" />
<title>登录页</title>
</head>
<div id="div_bg">
		<div id="div_context">
			<center>
			<h2>管理员登录</h2>
				<s:form action="checkAdmin" method="post">
										
					<div class="input-group">
						<span class="glyphicon glyphicon-user"></span> <input type="text"
							placeholder="username" name="admin.username">
					</div>

					<div class="input-group">
						<span class="glyphicon glyphicon-lock"></span> <input
							type="password" placeholder="password" name="admin.password">
					</div>
					<s:submit></s:submit>
				</s:form>
			</center>
		</div>
	</div>
</body>
</html>