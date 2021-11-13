<%@page import="com.vo.BuyerAddress"%>
<%@page import="com.vo.Orders"%>
<%@page import="com.vo.BuyerInfo"%>
<%@page import="com.vo.Merchandise"%>
<%@page import="com.dao.*" %>
<%@page import="java.util.Iterator"%>
<%@ page import = "java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>意向购买表</title>
<%@include file="../../component/navigation.jsp" %>
<%@include file="../../util/checklogin.jsp" %>
<link rel="stylesheet"  type="text/css" href="<%= basePath %>css/seller_check_interface.css">
</head>
<body>

    <div id = "main">
        <div class="goods">
            <div class="agood">
                <div class="goodmes">
                    <div class="pic" ></div>
                    <div class="mes">
                        <div class="title"></div>
                    </div>
                </div>
                <div class="buyer">
                    <table>
                        <tr class="first">
                            <td>购买人</td>
                            <td>联系方式</td>
                            <td>地址</td>
                        </tr>
<%
	ArrayList<Orders> ao = (ArrayList<Orders>)session.getAttribute("orders");
	Iterator<Orders> io = ao.iterator();
	Orders o = new Orders();
	while(io.hasNext()){
		o = io.next();
		if(o.getO_status()==0){
		BuyerInfo bi = o.getBuyerInfo();
		BuyerAddress bad = bi.getBuyerAddress().get(0);
		%>
		<tr>
        	<td><%= o.getB_act()%></td>
            <td><%= bi.getB_tele() %></td>
            <td><%= bad.getB_ads() %></td>
            <td><a href = "<%=basePath %>dealServlet?o_id=<%=o.getO_id() %>">与他交易</a></td>
        </tr>
		<%
							}
						}
		%>
		</table>
            	</div>
        	</div>
    	</div>
    </div>
</body>
</html>