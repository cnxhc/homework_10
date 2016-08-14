<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<link rel="stylesheet" type="text/css" href="css/flower.css" />
</head>
<body>
	<div>
		<h3>新品展示</h3>
		<br>
		<s:set value="#request.newgoods" id="newgood"></s:set>
		<s:iterator value="#newgood" id="good">
			<div class="newgood">
				<s:form theme="simple" action="addToCart" method="post">
					<img src="image/<s:property value="#good.imgUrl"/>"
						style="width: 194px;" />
					<br>
					<s:property value="#good.goodsName" />
					<br>
					<s:property value="#good.price" />元
 					<br>
					 数量<s:textfield size="4" name="num"></s:textfield>
					<input type="hidden" name="id"
						value="<s:property value="#good.id" />">
					<s:submit value="购买"></s:submit>
				</s:form>
			</div>
		</s:iterator>
	</div>
</body>
</html>