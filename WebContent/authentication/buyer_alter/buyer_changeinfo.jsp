<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%@include file="../../util/buyer_checklogin.jsp" %>
<%@include file="../../util/getpath.jsp" %>
<body>
<form action="<%=basePath %>buyerinfochangeServlet">
新电话：<input type="text" name="newtel" placeholder="请输入新电话"><br/>
新地址：<input type="text" name="newadd" placeholder="请输入新地址"><br/>
<input type="submit" value="修改">
</form>
</body>
</html>