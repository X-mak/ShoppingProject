<%@page import="java.util.List"%>
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
<%@include file="../../component/navigation.jsp" %>
<%@include file="../../util/checklogin.jsp" %>
<link rel="stylesheet"  type="text/css" href="<%= basePath %>css/buyer_history.css">
<body>
		<table border="1">
                <tr >
                    <td>商品名称</td>
                    <td>购买地址</td>
                </tr>
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
	String url = "view/seller_viewbuyerinfo/buyer_history.jsp";
%>   
              
<%
	//遍历		
		Iterator<Orders> io = ao.iterator();
		GetFull gf = new GetFull();
		while(io.hasNext()){
			Orders o = io.next();
			Merchandise m = o.getMerchandise();
			BuyerInfo bi = o.getBuyerInfo();
			bi = gf.getAllBuyer(bi);
			%>
		<tr>
        	<td><%= m.getM_name()%></td>
            <td><%= bi.getBuyerAddress().get(0).getB_ads() %></td>
        </tr>
			<% 
		}
%>
        </table>
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
</body>
</html>