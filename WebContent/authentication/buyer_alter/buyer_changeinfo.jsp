<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%@include file="../../component/buyer_navigation.jsp" %>
<link rel="stylesheet" href="<%=basePath %>css/buyer_changeinfo.css">
<script src="<%=basePath %>js/jquery-3.5.1.min.js"></script>
<script src="<%= basePath%>js/navi/goto_me.js"></script>
<link rel="stylesheet" id="templatecss" type="text/css" href="<%=basePath %>css/msgbox.css">
<script src="<%= basePath%>js/msgbox.js"></script>
<body>
<form action="<%=basePath %>buyerinfochangeServlet">
	新电话：<input type="text" name="newtel" placeholder="请输入新电话" maxlength = "16"><br/>
	新地址：<input type="text" name="newadd" placeholder="请输入新地址" maxlength = "16"><br/>
	<input type="submit" value="修改">
</form>
</body>
<%
	try{
		String msg = (String)(session.getAttribute("msg6"));
		if(msg.equals("true")){
			session.setAttribute("msg6", "");
			%>
				<script>
			    	alert("更新成功！");
				</script>
			<%}else if(msg.equals("false")){
				session.setAttribute("msg6", "");
			%>
				<script>
			    	alert("更新失败！");
				</script>
			<%} 
	}catch(Exception e){
		e.printStackTrace();
		session.setAttribute("msg6", "");
	}
%>
</html>