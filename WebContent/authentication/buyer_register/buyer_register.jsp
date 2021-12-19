<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%@include file="../../util/getpath.jsp" %>
<link rel="stylesheet" href="<%=basePath %>css/buyer_register.css">
<script src="<%=basePath %>js/jquery-3.5.1.min.js"></script>
<link rel="stylesheet" id="templatecss" type="text/css" href="<%=basePath %>css/msgbox.css">
<script src="<%= basePath%>js/msgbox.js"></script>
<body>
<form action="<%=basePath %>buyerregisterServlet" method="post">
        <table>
            <tr>
                <td>账号：</td>
                <td><input type="text" name="buyer_acc" maxlength = "16"><br></td>
            </tr>
            <tr>
                <td>密码：</td>
                <td><input type="password" name="buyer_pwd1" maxlength = "16"><br></td>
            </tr>
            <tr>
                <td>确认密码：</td>
                <td><input type="password" name="buyer_pwd2" maxlength = "16"><br></td>
            </tr>
            <tr>
                <td>电话：</td>
                <td><input type="text" name="buyer_tel" maxlength = "16"><br></td>
            </tr>
            <tr>
                <td>地址：</td>
                <td><input type="text" name="buyer_ads" maxlength = "16"><br></td>
            </tr>
            <td colspan="2" align="center"><input type="submit" value="注册"></td>
        </table>	
        <a href="<%=basePath%>index.jsp">返回</a>
	</form>
	
</body>
<%
	try{
		String msg = (String)(session.getAttribute("msg8"));
		if(msg.equals("true")){
			session.setAttribute("msg8", "");
			%>
				<script>
			    	alert("注册成功！");
				</script>
			<%
			response.sendRedirect(basePath+"index.jsp");	
		}else if(msg.equals("false")){
				session.setAttribute("msg8", "");
			%>
				<script>
			    	alert("注册失败！");
				</script>	
			<%} 
	}catch(Exception e){
		e.printStackTrace();
		session.setAttribute("msg8", "");
	}
%>
</html>