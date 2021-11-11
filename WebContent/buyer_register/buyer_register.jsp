<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%@include file="../getpath.jsp" %>
<link rel="stylesheet" href="<%=basePath %>css/buyer_register.css">
<body>
<form action="<%=basePath %>buyerregisterServlet" method="post">
        <table>
            <tr>
                <td>账号：</td>
                <td><input type="text" name="buyer_acc"><br></td>
            </tr>
            <tr>
                <td>密码：</td>
                <td><input type="password" name="buyer_pwd1"><br></td>
            </tr>
            <tr>
                <td>确认密码：</td>
                <td><input type="password" name="buyer_pwd2"><br></td>
            </tr>
            <tr>
                <td>电话：</td>
                <td><input type="text" name="buyer_tel"><br></td>
            </tr>
            <tr>
                <td>地址：</td>
                <td><input type="text" name="buyer_ads"><br></td>
            </tr>
            <td colspan="2" align="center"><input type="submit" value="注册"></td>
        </table>	
	</form>
</body>
</html>