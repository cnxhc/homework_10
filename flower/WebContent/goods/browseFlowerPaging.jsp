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
	<jsp:include page="../head.jsp"></jsp:include>
	<div class="content">
		<div class="left">
			<s:action name="browseCatalog" executeResult="true"></s:action>
		</div>
		<div class="right">
			<h3>鲜花展示</h3>
			<s:iterator value="#request.goods" id="good">
				<div class="newgood">
					<s:form action="addToCart" method="post" theme="simple">
						<img src="image/<s:property value="#good.imgUrl"/>"
							style="width: 192px;" />
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
			<div style="clear: both">
				<s:set name="pager" value="#request.page" />
				<s:if test="#pager.hasFirst">
					<a href="browseFlowerPaging.action?currentPage=1">首页</a>
				</s:if>
				<s:if test="#pager.hasPrevious">
					<a
						href="browseFlowerPaging.action?currentPage=
								<s:property  value="#pager.currentPage-1"/>">上一页</a>
				</s:if>
				<s:if test="#pager.hasNext">
					<a
						href="browseFlowerPaging.action?currentPage=
							<s:property  value="#pager.currentPage+1"/>">下一页</a>
				</s:if>
				<s:if test="#pager.hasLast">
					<a
						href="browseFlowerPaging.action?currentPage=
							<s:property  value="#pager.totalPage"/>">尾页</a>
				</s:if>
				<br> 当前第
				<s:property value="#pager.currentPage" />
				页, 总共
				<s:property value="#pager.totalPage" />
				页

			</div>
		</div>


	</div>

	<jsp:include page="../foot.jsp"></jsp:include>
</body>
</html>
