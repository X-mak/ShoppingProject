<%@page import="com.vo.*"%>
<%@page import="com.dao.users.SellerDI"%>
<%@page import="com.dao.users.SellerD"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="../../util/getpath.jsp" %>
<link rel="stylesheet" id="templatecss" type="text/css" href="<%= basePath %>css/login_interface.css">
</head>
<body>
<% 
	String flag1 = (String)session.getAttribute("flag1");
%>
    <div class="login-Box">
        <h2>登录</h2>
         <%
                		if(flag1.equals("False")){
                			%>
                				<div class="login-fail">输入的账号密码有误，请重新输入！</div>
                			<% 
                		}
                %>
        <form action="<%=basePath %>sellerloginServlet" method="post">
            <p>用户名</p>
                <input type="text" name="selleracnumber" id="name" placeholder="请输入用户名"><br/>
            <p>密码</p>
                <input type="password" name="sellerpwd" id="password" placeholder="请输入密码"><br/>
                <input type="submit" class="button" value="登录"/>
            </form>
    </div>
</body>
</html>