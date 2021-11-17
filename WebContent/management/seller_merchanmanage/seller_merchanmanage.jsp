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
<body>
	 <table>
                <tr >
                    <td>商品图片</td>
                    <td>商品名称</td>
                    <td>商品库存</td>
                </tr>
<%
MerchanView mv = new MerchanView();
ArrayList<Merchandise> am = mv.showAllMerchanOnSale();
Iterator<Merchandise> im = am.iterator(); 
while(im.hasNext()){
	Merchandise m = im.next();
	MPicture p = m.getmPicture().get(0);
	StockLog sl = m.getStockLog().get(0);
	String img_path = "../../imgs/"+p.getP_ads();
%>
           <tr>
          	<td><img src=<%=img_path %>></td>
        	<td><%= m.getM_name()%></td>
            <td><%= sl.getSl_num() %></td>
            <td><a href = "<%=basePath %>management/seller_merchanmanage/seller_genremanage.jsp?m_id=<%=m.getM_id() %>">商品种类管理</a></td>
            <td><a href = "<%=basePath %>management/seller_merchanmanage/seller_stockmanage.jsp?m_id=<%=m.getM_id() %>">商品库存管理</a></td>
        </tr>
		<%
	}
%>
</table>
</body>
</html>