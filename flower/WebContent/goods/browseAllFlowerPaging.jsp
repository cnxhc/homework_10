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
						<input type="hidden" name="id"
							value="<s:property value="#good.id" />">
						<input type="submit" value="修改"
							onclick="this.form.action='displayOneFlower'" />
						<input type="submit" value="删除"
							onclick="this.form.action='deleteOneFlower'" />
					</s:form>
				</div>
			</s:iterator>
			<div style="clear: both">
				<s:set name="pager" value="#request.page" />
				<s:if test="#pager.hasFirst">
					<a href="browseAllFlowerPaging.action?currentPage=1">首页</a>
				</s:if>
				<s:if test="#pager.hasPrevious">
					<a
						href="browseAllFlowerPaging.action?currentPage=
								<s:property  value="#pager.currentPage-1"/>">上一页</a>
				</s:if>
				<s:if test="#pager.hasNext">
					<a
						href="browseAllFlowerPaging.action?currentPage=
							<s:property  value="#pager.currentPage+1"/>">下一页</a>
				</s:if>
				<s:if test="#pager.hasLast">
					<a
						href="browseAllFlowerPaging.action?currentPage=
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
