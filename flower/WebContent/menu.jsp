<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE HTML>
<html>
<head>
<title></title>
<link rel="stylesheet" type="text/css" href="css/flower.css" />
</head>

<body>
	<h4>鲜花分类</h4>
	<s:iterator value="#request.catalogs" id="catalog">
		<a href="browseFlowerPaging.action?catalogId=
		<s:property value="#catalog.id"/>&currentPage=1"
			target="_self"><s:property value="#catalog.catalogName" /></a>
		<br>
		<br>
	</s:iterator>
</body>
</html>
