<%@page import="java.util.Iterator"%>
<%@page import="com.util.util.GetFull"%>
<%@page import="com.util.view.MerchanView"%>
<%@page import="com.vo.MPicture"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.vo.Merchandise"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="textml" charset="UTF-8">
<title>商品</title>
<%@include file="../../util/getpath.jsp" %>
<link rel="stylesheet" href="<%=basePath %>css/merchandise.css">
</head>
<body>
<%	    //该界面还需要修改，未完全正常
		int m_id = Integer.parseInt(request.getParameter("id"));
		Merchandise m = new Merchandise(m_id);
		GetFull gf = new GetFull();
		Merchandise new_m = gf.getAllMerchan(m);
		ArrayList<MPicture> amp = new_m.getmPicture();
		Iterator<MPicture> im = amp.iterator();
		//String img_path = basePath+"/imgs/"+amp.get(0).getP_ads();
		// String img_path = basePath+"/imgs/"+merchan.getM_pic();
%><br>
<div class="blank"></div>
    <div class="box mid">
   	 <div class="rotation">
            <a href="javascript:;" class="prev">&lt;</a>
            <a href="javascript:;" class="next">&gt;</a>
            <ul>
             <% while(im.hasNext()){
        	String img_path = basePath+"/imgs/"+im.next().getP_ads();
        %>
                <li> <img src=<%=img_path %> alt="goodsimg"></li>
            <% }%>
            </ul>
            <ol class="point">
            
            </ol>
        </div>
        <div class="text">
            <div class="goodname">商品名称：<%=new_m.getM_name() %></div>
                                 商品介绍：</br><div class="goodcontro"><%=new_m.getM_intro() %></div>
            <div class="price">价格:<%=new_m.getM_price() %></div>
            			</br>商品库存：<%=new_m.getM_num() %> <br/>
            <form action="<%=basePath %>management/buyer_buy/buyer_buycheck.jsp?id=<%=m_id %>" method="post">
                   	购买数量：<input type="text" name="buynum" placeholder="1"><br/>
                   	<div class="buy">
                    <input type="submit" value="购买">
                    </div>
            </form>
            <div class="back">
            	<form action="<%=basePath %>/index.jsp" method="post">
                    <input type="submit" value="返回">
                </form>
            </div>	
	</div>
</div>
</body>
<script src="<%=basePath %>js/animate.js">
</script>
<script src="<%=basePath %>js/merchandise.js">
</script>
</html>