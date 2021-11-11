<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="../getpath.jsp" %>
</head>
<body>
	<form action="<%=basePath %>sellerregisterServlet" method="get">
		账号：<input type="text" name="seller_acc"><br>
		密码：<input type="password" name="seller_pwd1"><br>
		确认密码：<input type="password" name="seller_pwd2"><br>
		<input type="submit" value="注册">
	</form>
</body>
</html>