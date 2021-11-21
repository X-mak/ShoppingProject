<%@page import="com.vo.BuyerAddress"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.vo.BuyerInfo"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%@include file="../../component/navigation.jsp" %>
<%@include file="../../util/checklogin.jsp" %>
<link rel="stylesheet"  type="text/css" href="<%= basePath %>css/seller_check_interface.css">
<body>
<% 
		ArrayList<BuyerInfo> ab = (ArrayList<BuyerInfo>)(session.getAttribute("ab"));
		Iterator<BuyerInfo> ib = ab.iterator();
%>
		 <table>
                <tr >
                    <td>客户账号</td>
                    <td>客户电话</td>
                    <td>客户地址</td>
                </tr>
<%
      	while(ib.hasNext()) {
      		BuyerInfo bi = ib.next();
      		BuyerAddress bad = bi.getBuyerAddress().get(0);   
%>			
		<tr>
        	<td><%= bi.getB_act()%></td>
            <td><%= bi.getB_tele() %></td>
            <td><%= bad.getB_ads() %></td>
            <td><a href = "<%=basePath %>buyerhistoryServlet?b_act=<%=bi.getB_act() %>">购买历史</a></td>
        </tr>
         <%} %>
         </table>
</body>
</html>