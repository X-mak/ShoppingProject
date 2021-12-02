<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="../../util/getpath.jsp" %>
<script src="<%=basePath %>js/jquery-3.5.1.min.js"></script>
<link rel="stylesheet" id="templatecss" type="text/css" href="<%=basePath %>css/msgbox.css">
<script src="<%= basePath%>js/msgbox.js"></script>
</head>
<body>
	<form action="<%=basePath %>sellerregisterServlet" method="get">
		账号：<input type="text" name="seller_acc"><br>
		密码：<input type="password" name="seller_pwd1"><br>
		确认密码：<input type="password" name="seller_pwd2"><br>
		<input type="submit" value="注册">
	</form>
</body>
<%
	try{
		String msg = (String)(session.getAttribute("msg10"));
		if(msg.equals("true")){
			session.setAttribute("msg10", "");
			%>
				<script>
			    	alert("修改成功！");
				</script>
			<%}else if(msg.equals("false")){
				session.setAttribute("msg10", "");
			%>
				<script>
			    	alert("修改失败！");
				</script>	
			<%} 
	}catch(Exception e){
		e.printStackTrace();
		session.setAttribute("msg10", "");
	}
%>
</html>