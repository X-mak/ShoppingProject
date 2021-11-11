<%@page import="com.vo.SellerAccount"%>
<%@page import="com.dao.seller.SellerDI"%>
<%@page import="com.dao.seller.SellerD"%>
<%@page import="com.vo.MPicture"%>
<%@page import="com.util.index.IndexUI"%>
<%@page import="com.util.index.IndexUtil"%>
<%@page import="com.vo.Merchandise"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>购物平台</title>
<%@include file="getpath.jsp" %>
<link rel="stylesheet" href="<%=basePath %>css/index.css">
</head>
<%
	session.setAttribute("flag1", "");
	session.setAttribute("flag2", "");
%>
<body>
	<div class="spa">
		<div class="login-btn mid">
            <ul class="custom-login">
                <li>
                    <a href="<%=basePath%>seller_login/seller_login.jsp">
                        卖家登录
                    </a>
                </li>
                
                <li>|</li>
                <li>
                    <a href="<%=basePath%>buyer_login/buyer_login.jsp">
                        买家登录
                    </a>
                </li>
                <li>|</li>
                <li>
                    <a href="<%=basePath%>buyer_register/buyer_register.jsp">
                        买家注册
                    </a>
                </li>
            </ul>
        </div>
	</div>
    <div class="title mid">
        <div class="logo">
            <img src="img/1.webp" alt="logoimg">
        </div>
        <span>
           	网上购物商城
        </span>
        <form class="search" action="#">
            <div class="search-field">
                <input class="input" type="text">
                <input class="btn" type="submit" value="搜索">
            </div>
        </form>
    </div>
    <hr>
    <div class="goods mid">
<%
IndexUtil iu = new IndexUI();
ArrayList<Merchandise> am = iu.showAllMerchanOnSale();
Iterator<Merchandise> im = am.iterator(); 
while(im.hasNext()){
	Merchandise m = im.next();
	MPicture p = m.getmPicture().get(0);
	String img_path = "imgs/"+p.getP_ads();
%>
	<div class="agood">
            <a href="buyer_buy/merchandiseinf.jsp?id=<%=m.getM_id()%>">
                <img src=<%=img_path %>><br />
                <h4>
                   <%=m.getM_name() %>
                </h4>
            </a>
        </div>
		<%
	}
%>
</div>
</body>
</html>