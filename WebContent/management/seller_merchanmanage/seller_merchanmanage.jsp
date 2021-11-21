<%@page import="com.vo.StockLog"%>
<%@page import="com.vo.MPicture"%>
<%@page import="com.vo.Merchandise"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.util.view.MerchanView"%>
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
<link rel="stylesheet" id="templatecss" type="text/css" href="<%=basePath %>css/seller_merchanmanage.css">
<body>
	 <table border="1" cellspacing="0">
        <thead>
            <th>商品图片</th>
            <th>商品名称</th>
            <th>商品库存</th>
            <th colspan="2">操作</th>
        </thead>
<%
MerchanView mv = new MerchanView();
ArrayList<Merchandise> am = mv.showAllMerchan();
Iterator<Merchandise> im = am.iterator(); 
while(im.hasNext()){
	Merchandise m = im.next();
	MPicture p = m.getmPicture().get(0);
	int s_num = m.getM_num();
	String img_path = "../../imgs/"+p.getP_ads();
%>
           <tr>
          	<td><img src=<%=img_path %>></td>
        	<td><%= m.getM_name()%></td>
            <td><%= s_num %></td>
            <td><a href = "<%=basePath %>management/seller_merchanmanage/seller_genremanage.jsp?m_id=<%=m.getM_id() %>">商品种类管理</a></td>
            <td><a href = "<%=basePath %>management/seller_merchanmanage/seller_stockmanage.jsp?m_id=<%=m.getM_id() %>">商品库存管理</a></td>
        </tr>
		<%
	}
%>
</table>
</body>
</html>