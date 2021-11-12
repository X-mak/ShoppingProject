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
<link rel="stylesheet"  type="text/css" href="<%= basePath %>css/seller_alter_interface.css">
<body>
    <div id = "main">
        <form action="<%=basePath %>sellerpwdchangeServlet" method="post" >
            <p>账号：</p> <input type="text" name="selleracnumber" placeholder="请输入账号"><br/>
            <p>原密码：</p> <input type="password" name="selleroldpwd" placeholder="请输入原密码"><br/>
            <p>新密码：</p> <input type="password" name="sellernewpwd" placeholder="请输入新密码"><br/>
            <p></p> <input type="submit" value="修改"/>
        </form>
    </div>
</body>
</html>