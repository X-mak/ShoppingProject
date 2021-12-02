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
<script src="<%=basePath %>js/jquery-3.5.1.min.js"></script>
<script src="<%= basePath%>js/navi/goto_me.js"></script>
<link rel="stylesheet" id="templatecss" type="text/css" href="<%=basePath %>css/msgbox.css">
<script src="<%= basePath%>js/msgbox.js"></script>
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
<script>
	$(".forth li").eq(0).css("background-image","linear-gradient(to right,#00a3af,#84a2d4)");
</script>
<%
	try{
		String msg = (String)(session.getAttribute("msg9"));
		if(msg.equals("true")){
			session.setAttribute("msg9", "");
			%>
				<script>
			    	alert("修改成功！");
				</script>
			<%}else if(msg.equals("false")){
				session.setAttribute("msg9", "");
			%>
				<script>
			    	alert("修改失败！");
				</script>	
			<%} 
	}catch(Exception e){
		e.printStackTrace();
		session.setAttribute("msg9", "");
	}
%>
</html>