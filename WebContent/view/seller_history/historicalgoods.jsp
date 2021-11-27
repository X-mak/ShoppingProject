<%@page import="java.util.List"%>
<%@page import="com.util.util.GetFull"%>
<%@page import="com.util.util.GetFullUtil"%>
<%@page import="com.vo.Orders"%>
<%@page import="com.vo.Shop"%>
<%@page import="java.util.Iterator"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "com.vo.Merchandise" %>
<%@ page import = "java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@include file="../../util/checklogin.jsp" %>
<title>查看我的历史商品</title>
<%@include file="../../component/navigation.jsp" %>
<link rel="stylesheet"  type="text/css" href="<%= basePath %>css/seller_history_interface.css">
</head>
<script src="<%=basePath %>js/jquery-3.5.1.min.js"></script>
<script src="<%= basePath%>js/navi/goto_merchan.js"></script>
<body>

<div id = "main">
        <div class="goods">
            <table cellspacing="0" border="1">
                <thead>
                    <th>商品名称</th>
                    <th>购买人</th>
                </thead>
<%
	//换页
	ArrayList<Orders> ao = (ArrayList<Orders>)session.getAttribute("orders");
	String p = request.getParameter("pages");
	int pages = 1;
	if(p.matches("\\d+")){
		pages = Integer.parseInt(p);
	}	
	int eachPageNum = 10;			//一页显示多少数据
	if(pages < 1)pages = 1;
	if(pages > ao.size()/eachPageNum + 1)pages = ao.size()/eachPageNum + 1;
	int maxItem = Math.min(ao.size(), pages*eachPageNum);
	List<Orders> order = ao.subList(eachPageNum*(pages - 1), maxItem);
	String url = "view/seller_history/historicalgoods.jsp";
%>
<%
	//遍历
	Iterator<Orders> io = order.iterator();
	Orders o = new Orders();
	while(io.hasNext()){
		o = io.next();
			%><tr>
	        <td><%=  o.getMerchandise().getM_name()%></td>
	        <td><%= o.getU_act() %></td>
	    </tr>
	    <%
		}
		%>
        </table>
	</div>
	 <hr>
        <div style="margin:0px auto;width:200px;">
        	<span>总共<%= ao.size()/eachPageNum + 1%>页，当前在第<%= pages%>页</span><br/>
        	<a href="<%=basePath %><%= url%>?pages=1">首页</a>
        	<a href="<%=basePath %><%= url%>?pages=<%=pages - 1%>">上一页</a>
        	<a href="<%=basePath %><%= url%>?pages=<%=pages + 1%>">下一页</a>
        	<form action="<%=basePath %><%= url%>" method="post">
        		跳转到第<input type="text" name="pages" value="<%= pages%>" style="width:20px;"></input>页
        		<input type="submit" class="button" value="跳转" />
        	</form>
        </div>
</div>
</body>
<script>
	$(".first li").eq(2).css("background-image","linear-gradient(to right,#00a3af,#84a2d4)");
</script>
</html>