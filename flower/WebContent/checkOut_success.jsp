<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML>
<html>
<head>
<title>购物结算成功</title>
<link rel="stylesheet" type="text/css" href="css/flower.css" />
</head>

<body>
	<jsp:include page="head.jsp"></jsp:include>
	<div class="content">
		<div class="left">
			<s:action name="browseCatalog" executeResult="true"></s:action>
		</div>
		<div class="right" style="padding-top:120px;">
			亲爱的：<s:property value="#request.order.users.userName" />
			，您的订单编号：
			<s:property value="#request.order.ordersId" />
			已下达，我们会在三日内按指定要求送达！
		</div>
	</div>
	<jsp:include page="foot.jsp"></jsp:include>
	<br>

</body>
</html>
