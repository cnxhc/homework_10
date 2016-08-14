<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<link rel="stylesheet" type="text/css" href="css/flower.css" />
</head>

<body>
	<div class="head_right">
		<a href="admin/login_success.jsp" target="_top">首页</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<s:if test="#session.admin!=null">
			<a href="adminlogOut.action" target="_top">注销</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		</s:if>
	</div>
	<div class="content">
		<div class="left">
			<h4>鲜花分类</h4>
			<a href="admin/addNewFlower.jsp" target="_self">添加新花品</a><br> <br>
			<a href="managerFlower.action" target="_self">管理花品</a><br> <br>
			<a href="admin/managerUser.jsp" target="_self">顾客账号管理</a><br> <br>
		</div>
		<div class="right">
			<div style="padding-left: 200px; width: 600px;">
				<s:action name="browseCatalog" executeResult="false" />
				<s:set value="#request.good" id="good"></s:set>
				<s:form action="addOrUpdateGoods" method="post"
					enctype="multipart/form-data">
					<tr>
						<td></td>
						<td>请在此修改花品的信息</td>
					</tr>
					<s:textfield label="品名" name="good.goodsName"
						value="%{#good.goodsName}"></s:textfield>
					<tr>
						<td>价格</td>
						<td><input type="text" name="good.price"
							value="<s:property value="#good.price"/>"> <label>元</label></td>
					</tr>
					<s:set value="#request.catalogs" id="catalog"></s:set>
					<s:select label="分类" list="#request.catalogs" listKey="id"
						listValue="catalogName" name="good.catalog.id"
						value="%{#goods.catalog.id}"></s:select>
					<tr>
						<td></td>
						<td><input type="file" name="upload"
							value="<s:property value="#good.imgUrl"/>" /></td>
						<td><img alt=""
							src="image/<s:property value="#good.imgUrl"/>"
							style="width: 200px;"></td>
					</tr>
					<s:hidden name="good.id" value="%{#good.id}"></s:hidden>
					<s:hidden name="picture" value="%{#good.imgUrl}"></</s:hidden>
					<s:submit value="修改"></s:submit>
				</s:form>
			</div>
		</div>
	</div>
	<jsp:include page="../foot.jsp"></jsp:include>
</body>
</html>
