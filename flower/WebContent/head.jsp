<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<link rel="stylesheet" type="text/css" href="css/flower.css" />
</head>
<body>
<div class="head_right">
	<a href="index.jsp" target="_top">首页</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<s:if test="#session.user!=null">
		<a href="logOut.action" target="_top">注销</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a
			href="modifyUser.action?id=<s:property value="#session.user.id"/>" target="_top">管理我的信息</a>
	</s:if>
	<s:else>
		<a href="login.jsp" target="_self">登录</a>
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="register.jsp"
			target="_self">注册</a>
	</s:else>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="showCart.jsp"
		target="_self">购物车</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a>联系我们</a>
	<div></div>
	<br>

</div>
</body>
</html>