<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%@include file="../../util/checklogin.jsp" %>
<%@include file="../../component/navigation.jsp" %>
<link rel="stylesheet" id="templatecss" type="text/css" href="<%=basePath %>css/sellerPage_interface.css">
<body>
<div id = "main">
	<p>欢迎回来,<%=selleruser.getS_act() %></p>
	<div>
		<a href="<%=basePath %>authentication/seller_alter/sellerpwdchange.jsp">修改密码</a>
		<a href="<%=basePath %>index.jsp">返回商城</a>
	</div>	
</div>
</body>
</html>