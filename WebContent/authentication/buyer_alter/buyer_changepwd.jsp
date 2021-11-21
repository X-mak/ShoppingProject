<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%@include file="../../component/buyer_navigation.jsp" %>
<link rel="stylesheet" href="<%=basePath %>css/buyer_changepwd.css">
<body>
 <form action="<%=basePath %>buyerpwdchangeServlet" method="post" >
        <table>
            <tr>
                <td>账号：</td>
                <td><input type="text" name="buyeracnumber" placeholder="请输入账号"></td>
            </tr>
            <tr>
                <td>原密码：</td>
                <td> <input type="password" name="buyeroldpwd" placeholder="请输入原密码"></td>
            </tr>
            <tr>
                <td>新密码：</td>
                <td><input type="password" name="buyernewpwd" placeholder="请输入新密码"></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="修改"/></td>
                <td></td>
            </tr>
        </table>
    </form>
</html>