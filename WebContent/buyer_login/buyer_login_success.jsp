<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%@include file="../buyer_checklogin.jsp" %>
<%@include file="../getpath.jsp" %>
<body>
<a href="<%=basePath%>buyer_alter/buyer_changepwd.jsp">修改密码</a>
<a href="<%=basePath%>buyerviewhistoryServlet">查看购买历史</a>
<a href="<%=basePath%>buyer_alter/buyer_changeinfo.jsp">修改信息</a>
</body>
</html>