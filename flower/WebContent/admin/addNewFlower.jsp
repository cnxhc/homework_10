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
			<a href="addNewFlower.jsp" target="_self">添加新花品</a><br> <br>
			<a href="../managerFlower.action" target="_self">管理花品</a><br> <br>
			<a href="managerUser.jsp" target="_self">顾客账号管理</a><br> <br>
		</div>
		<div class="right">
			<h3>添加鲜花</h3>
			<div style="padding-left: 200px; padding-top: 30px; width: 600px;">
				<s:form action="addOrUpdateGoods" method="post"
					enctype="multipart/form-data">
					<s:textfield label="品名" name="good.goodsName"></s:textfield>
					<tr>
						<td>价格</td>
						<td><input type="text" name="good.price"> <label>元</label></td>
					</tr>
					<s:action name="browseCatalog" executeResult="false">
					</s:action>
					<s:set value="#request.catalogs" id="catalog"></s:set>
					<s:select label="分类" list="#request.catalogs" listKey="id"
						listValue="catalogName" name="good.catalog.id"
						value="%{#goods.catalog.id}"></s:select>
					<s:file name="upload" label="图片"></s:file>
					<s:submit value="添加"></s:submit>
				</s:form>
			</div>
		</div>
	</div>
	<jsp:include page="../foot.jsp"></jsp:include>
</body>
</html>
