<%@page import="com.util.util.GetFull"%>
<%@page import="com.vo.BuyerInfo"%>
<%@page import="com.vo.Merchandise"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.vo.Orders"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%@include file="../../util/buyer_checklogin.jsp" %>
<%@include file="../../util/getpath.jsp" %>
<body>
		<table>
                <tr >
                    <td>商品名称</td>
                    <td>购买地址</td>
                </tr>
<%
		ArrayList<Orders> ao = (ArrayList<Orders>)session.getAttribute("orders");
		Iterator<Orders> io = ao.iterator();
		GetFull gf = new GetFull();
		while(io.hasNext()){
			Orders o = io.next();
			Merchandise m = o.getMerchandise();
			BuyerInfo bi = o.getBuyerInfo();
			bi = gf.getAllBuyer(bi);
			if(o.getO_status()==2){
			%>
		<tr>
        	<td><%= m.getM_name()%></td>
            <td><%= bi.getBuyerAddress().get(0).getB_ads() %></td>
            <td><a href="<%=basePath%>authentication/buyer_login/buyer_login_success.jsp">返回买家后台</a></td>
        </tr>
			<% }
		}
%>
        </table>
</body>
</html>