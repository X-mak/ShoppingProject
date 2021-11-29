<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="../../js/selectGenre.js"></script>
</head>
<%@include file="../../util/checklogin.jsp" %>
<%@include file="../../component/navigation.jsp" %>
<script src="<%=basePath %>js/jquery-3.5.1.min.js"></script>
<script src="<%= basePath%>js/navi/goto_merchan.js"></script>
<body>
<% 
	String m_id = request.getParameter("m_id");
%>
	<form action="<%=basePath %>sellergenremanageServlet?id=<%=m_id%>" name="form" method="post">
	一级分类：<select name="firstgenre" id="firstgenre" onChange="changeGenre()">
				   <option>--请选择一级分类--</option>
          		   <option value="生活用品">生活用品</option>
          		   <option value="体育用品">体育用品</option>
          		   <option value="学习用品">学习用品</option>
          		   <option value="食品">食品</option>
           </select><br/>
         二级分类：<select name="secondgenre" id="secondgenre" >
         			<option>--请选择二级分类--</option>
         </select> <br/>
       	 <input type="submit" value="提交"> 
     </form>
</body>
<script>
	$(".first li").eq(1).css("background-image","linear-gradient(to right,#00a3af,#84a2d4)");
</script>
</html>