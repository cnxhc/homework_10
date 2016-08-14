<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.4/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/flower.css" />
<title>首页</title>
</head>
<body>
	<jsp:include page="head.jsp"></jsp:include>
	<div class="content">
		<div class="left">
			<s:action name="browseCatalog" executeResult="true"></s:action>
		</div>
		<div class="right">
			<s:action name="browseNewFlower" executeResult="true"></s:action>
		</div>
	</div>
	<jsp:include page="foot.jsp"></jsp:include>
</body>
</html>