<%@page import="java.util.List"%>
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
<link rel="stylesheet"  type="text/css" href="<%= basePath %>css/seller_viewbuyerinfo.css">
<link rel="stylesheet" id="templatecss" type="text/css" href="<%=basePath %>css/page_changing.css">
<script src="<%=basePath %>js/jquery-3.5.1.min.js"></script>
<script src="<%= basePath%>js/navi/goto_user.js"></script>
<body>
<% 
	//换页
		ArrayList<BuyerInfo> ab = (ArrayList<BuyerInfo>)(session.getAttribute("ab"));
		Iterator<BuyerInfo> ib = ab.iterator();
		String p = request.getParameter("pages");
		int pages = 1;
		if(p.matches("\\d+")){
			pages = Integer.parseInt(p);
		}	
		int eachPageNum = 10;			//一页显示多少数据
		if(pages < 1)pages = 1;
		if(pages > ab.size()/eachPageNum + 1)pages = ab.size()/eachPageNum + 1;
		int maxItem = Math.min(ab.size(), pages*eachPageNum);
		List<BuyerInfo> order = ab.subList(eachPageNum*(pages - 1), maxItem);
		String url = "view/seller_viewbuyerinfo/seller_viewbuyerinfo.jsp";
%>
		 <table border="1">
                <thead>
                    <th>客户账号</th>
                    <th>客户电话</th>
                    <th>客户地址</th>
                    <th>操作</th>
                </thead>
<%
	//遍历
      	while(ib.hasNext()) {
      		BuyerInfo bi = ib.next();
      		BuyerAddress bad = bi.getBuyerAddress().get(0);   
%>			
		<tr>
        	<td><%= bi.getU_act()%></td>
            <td><%= bi.getB_tele() %></td>
            <td><%= bad.getB_ads() %></td>
            <td><a href = "<%=basePath %>buyerhistoryServlet?b_act=<%=bi.getU_act() %>">购买历史</a></td>
        </tr>
         <%} %>
         </table>
         
      	 <br>
    <hr>
    <div class="p">      
        <a href="<%=basePath %><%= url%>?pages=1">&lt;&lt;</a>
        <a href="<%=basePath %><%= url%>?pages=<%=pages - 1%>">&lt;Prev</a>
        <form action="<%=basePath %><%= url%>" method="post">
            <div class="change">
                <input type="text" name="pages" value="<%=pages %>" style="width:20px;"></input><span>/<%= ab.size()/eachPageNum + 1%></span>
            </div>
            <input type="submit" class="button" value="Go" />
        </form>
        <a href="<%=basePath %><%= url%>?pages=<%=pages + 1%>">Next&gt;</a>
        <a href="<%=basePath %><%= url%>?pages=<%=ab.size()/eachPageNum + 1%>">&gt;&gt;</a>
    </div>
</body>
<script>
	$(".third li").eq(0).css("background-image","linear-gradient(to right,#00a3af,#84a2d4)");
</script>
</html>