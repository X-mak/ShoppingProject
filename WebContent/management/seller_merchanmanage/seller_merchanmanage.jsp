<%@page import="java.util.List"%>
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
<link rel="stylesheet" id="templatecss" type="text/css" href="<%=basePath %>css/page_changing.css">
<script src="<%=basePath %>js/jquery-3.5.1.min.js"></script>
<script src="<%= basePath%>js/navi/goto_merchan.js"></script>
<body>
	 <table border="1" cellspacing="0">
        <thead>
            <th>商品图片</th>
            <th>商品名称</th>
            <th>商品库存</th>
            <th colspan="2">操作</th>
        </thead>
<%
//换页
	MerchanView mv = new MerchanView();
	ArrayList<Merchandise> am = mv.showAllMerchan();
	Iterator<Merchandise> im = am.iterator(); 
	String p = request.getParameter("pages");
	int pages = 1;
	if(p.matches("\\d+")){
		pages = Integer.parseInt(p);
	}	
	int eachPageNum = 10;			//一页显示多少数据
	if(pages < 1)pages = 1;
	if(pages > am.size()/eachPageNum + 1)pages = am.size()/eachPageNum + 1;
	int maxItem = Math.min(am.size(), pages*eachPageNum);
	List<Merchandise> order = am.subList(eachPageNum*(pages - 1), maxItem);
	String url = "management/seller_merchanmanage/seller_merchanmanage.jsp";


//遍历
while(im.hasNext()){
	Merchandise m = im.next();
	MPicture pic = m.getmPicture().get(0);
	int s_num = m.getM_num();
	String img_path = "../../imgs/"+pic.getP_ads();
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
	<br>
    <hr>
    <div class="p">      
        <a href="<%=basePath %><%= url%>?pages=1">&lt;&lt;</a>
        <a href="<%=basePath %><%= url%>?pages=<%=pages - 1%>">&lt;Prev</a>
        <form action="<%=basePath %><%= url%>" method="post">
            <div class="change">
                <input type="text" name="pages" value="<%=pages %>" style="width:20px;"></input><span>/<%= am.size()/eachPageNum + 1%></span>
            </div>
            <input type="submit" class="button" value="Go" />
        </form>
        <a href="<%=basePath %><%= url%>?pages=<%=pages + 1%>">Next&gt;</a>
        <a href="<%=basePath %><%= url%>?pages=<%=am.size()/eachPageNum + 1%>">&gt;&gt;</a>
    </div>
</body>
<script>
	$(".first li").eq(1).css("background-image","linear-gradient(to right,#00a3af,#84a2d4)");
</script>
</html>