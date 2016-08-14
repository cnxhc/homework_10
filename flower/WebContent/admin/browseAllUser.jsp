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
			<a href="addNewUser.jsp" target="_self">添加新用户</a><br>
			<br> <a href="browseAllUser.action" target="_self">查询用户</a><br>
			<br>
		</div>
		<div class="right" style="padding-top:30px;";>
			<h3>显示用户</h3>
			<s:iterator value="#request.users" id="user">
				<div class="browseUser">
					<s:form action="shoppingAction" method="post" theme="simple">
						用户编号：<s:property value="#user.id" />
						<br>
						用户名：<s:property value="#user.userName" />
						<br>
						真实名：<s:property value="#user.realName" />
						<br>
						密码：<s:property value="#user.password" />
						<br>
						手机号：<s:property value="#user.phoneNo" />
						<br>
						地址：<s:property value="#user.address" />
						<br>
						邮箱：<s:property value="#user.email" />
						<br>
						<input type="hidden" name="id"
							value="<s:property value="#user.id" />">
						<input type="submit" value="修改"
							onclick="this.form.action='displayOneUser'" />
						<input type="submit" value="删除"
							onclick="this.form.action='deleteOneUser'" />
					</s:form>
				</div>
			</s:iterator>
			<div style="clear: both">
				<s:set name="pager" value="#request.page" />
				<s:if test="#pager.hasFirst">
					<a href="browseAllUser.action?currentPage=1">首页</a>
				</s:if>
				<s:if test="#pager.hasPrevious">
					<a
						href="browseAllUser.action?currentPage=
								<s:property  value="#pager.currentPage-1"/>">上一页</a>
				</s:if>
				<s:if test="#pager.hasNext">
					<a
						href="browseAllUser.action?currentPage=
							<s:property  value="#pager.currentPage+1"/>">下一页</a>
				</s:if>
				<s:if test="#pager.hasLast">
					<a
						href="browseAllUser.action?currentPage=
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
