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
<body>

<div id = "main">
        <div class="goods">
            <table>
                <tr class="first">
                    <td>商品名称</td>
                    <td>购买人</td>
                </tr>
<%
	ArrayList<Orders> ao = (ArrayList<Orders>)session.getAttribute("orders");
	Iterator<Orders> io = ao.iterator();
	Orders o = new Orders();
	while(io.hasNext()){
		o = io.next();
		if(o.getO_status() == 2 ){
			%><tr>
	        <td><%=  o.getMerchandise().getM_name()%></td>
	        <td><%= o.getB_act() %></td>
	    </tr>
	    <%
						}
		}
		%>
        </table>
	</div>
</div>
</body>
</html>