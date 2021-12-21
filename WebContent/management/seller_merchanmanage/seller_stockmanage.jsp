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
<link rel="stylesheet" id="templatecss" type="text/css" href="<%=basePath %>css/msgbox.css">

<script src="<%=basePath %>js/jquery-3.5.1.min.js"></script>
<script src="<%= basePath%>js/navi/goto_merchan.js"></script>
<script src="<%= basePath%>js/msgbox.js"></script>
<body>
<% 
	int m_id = Integer.parseInt((String)request.getParameter("m_id"));
%>
 		<form action="<%=basePath %>/sellerstockmanageServlet?m_id=<%=m_id%>" method="post">
 		添加库存数量：<input type="text" placeholder="请输入添加的库存数量" name="newnum">
 		<input type="submit" value="修改">
 		</form>
 		<form action="<%=basePath %>sellermerchandropServlet?m_id=<%=m_id%>" method="post">
                    <input type="submit" value="下架商品">
        </form>
</body>
<script>
	$(".first li").eq(1).css("background-image","linear-gradient(to right,#00a3af,#84a2d4)");
</script>
<%
	try{
		String msg = (String)(session.getAttribute("msg3"));
		if(msg.equals("true")){
			session.setAttribute("msg3", "");
			%>
				<script>
			    	alert("更新成功！");
				</script>
			<%}else if(msg.equals("false")){
				session.setAttribute("msg3", "");
			%>
				<script>
			    	alert("更新失败！");
				</script>
			<%} 
	}catch(Exception e){
		e.printStackTrace();
		session.setAttribute("msg3", "");
	}
%>
</html>