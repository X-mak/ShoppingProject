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
<body>
<% 
	String m_id = request.getParameter("m_id");
%>
	<form action="<%=basePath %>sellergenremanageServlet?id=<%=m_id%>">
	商品种类：<select name="selectName1">
          		   <option selected="selected" value="生活用品">生活用品</option>
          		   <option value="体育用品">体育用品</option>
          		   <option value="学习用品">学习用品</option>
          		   <option value="食品">食品</option>
           </select><br/>
           
     </form>
</body>
</html>