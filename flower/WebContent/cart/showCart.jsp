<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML>
<html>
<head>
<title></title>
<link rel="stylesheet" type="text/css" href="css/flower.css" />
</head>
<body>
	<jsp:include page="../head.jsp"></jsp:include>
	<div class="content">
		<div class="left">
			<s:action name="browseCatalog" executeResult="true"></s:action>
		</div>
		<div class="right">
			<s:set value="#session.cart.items" id="items"></s:set>
			<s:if test="#items.size!=0">
				<s:iterator value="#items" id="item">
					<div style="text-align: left">
						<s:form action="updateCart.action" method="post">
							<div class="flowercheck">
								花名：
								<s:property value="value.goodsName" />
							</div>

							<div class="flowercheck">
								单价：
								<s:property value="value.price" />
								元
							</div>
							<div class="flowercheck">
								数量：<input size="4" type="text" name="num"
									value="<s:property value="value.num"/>">
							</div>

							<input type="hidden" name="goodsName"
								value="<s:property value="value.goodsName"/>">
							<div class="flowercheck">
								<input type="submit" value="更新">
							</div>
						</s:form>
					</div>
				</s:iterator>

				<div style="clear: both;">
					<s:form action="checkOut" method="post">
						<s:submit value="提交订单"></s:submit>
					</s:form>
				</div>
			</s:if>
			<s:else>
		对不起，你购物车没有鲜花！！
		</s:else>

		</div>
	</div>
	<jsp:include page="../foot.jsp"></jsp:include>
</body>
</html>
