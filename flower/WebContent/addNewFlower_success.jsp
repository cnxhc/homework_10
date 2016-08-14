<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE HTML>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/flower.css" />
<title>修改鲜花</title>
</head>

<body>
	<div class="head_right">
		<a href="index.jsp" target="_top">首页</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<s:if test="#session.admin!=null">
			<a href="adminlogOut.action" target="_top">注销</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		</s:if>
	</div>
	<div class="content">
		<div class="left">
		<h4>管理信息</h4>
			<a href="admin/addNewFlower.jsp" target="_self">添加新花品</a><br> <br>
			<a href="managerFlower.action" target="_self">管理花品</a><br> <br>
			<a href="admin/managerUser.jsp" target="_self">顾客账号管理</a><br> <br>
		</div>
		<div class="right">
				<h3>修改成功！</h3>
		</div>
	</div>
	<jsp:include page="foot.jsp"></jsp:include>
</body>
</html>