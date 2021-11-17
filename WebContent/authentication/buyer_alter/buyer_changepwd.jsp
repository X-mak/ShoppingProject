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
 <form action="<%=basePath %>buyerpwdchangeServlet" method="post" >
            <p>账号：</p> <input type="text" name="buyeracnumber" placeholder="请输入账号"><br/>
            <p>原密码：</p> <input type="password" name="buyeroldpwd" placeholder="请输入原密码"><br/>
            <p>新密码：</p> <input type="password" name="buyernewpwd" placeholder="请输入新密码"><br/>
            <p></p> <input type="submit" value="修改"/>
        </form>
</body>
</html>