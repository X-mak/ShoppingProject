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
<link rel="stylesheet" id="templatecss" type="text/css" href="<%=basePath %>css/msgbox.css">

<script src="<%=basePath %>js/jquery-3.5.1.min.js"></script>
<script src="<%= basePath%>js/navi/goto_merchan.js"></script>
<script src="<%= basePath%>js/msgbox.js"></script>

<body>
<% 
	String m_id = request.getParameter("m_id");
%>
	<form action="<%=basePath %>sellergenremanageServlet?m_id=<%=m_id%>" name="form" method="post">
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
<%
	try{
		String msg = (String)(session.getAttribute("msg2"));
		if(msg.equals("true")){
			session.setAttribute("msg2", "");
			%>
				<script>
			    	alert("分类更新成功！");
				</script>
			<%}else if(msg.equals("false")){
				session.setAttribute("msg2", "");
			%>
				<script>
			    	alert("分类更新失败！");
				</script>
			<%} 
	}catch(Exception e){
		e.printStackTrace();
		session.setAttribute("msg2", "");
	}
%>
</html>