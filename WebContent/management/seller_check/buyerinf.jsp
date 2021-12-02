<%@page import="java.util.List"%>
<%@page import="com.util.util.GetFullUtil"%>
<%@page import="com.util.util.GetFull"%>
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
<link rel="stylesheet" id="templatecss" type="text/css" href="<%=basePath %>css/page_changing.css">

</head>
<script src="<%=basePath %>js/jquery-3.5.1.min.js"></script>
<script src="<%= basePath%>js/navi/goto_order.js"></script>
<link rel="stylesheet" id="templatecss" type="text/css" href="<%=basePath %>css/msgbox.css">
<script src="<%= basePath%>js/msgbox.js"></script>
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
                        	<td>商品</td>
                            <td>购买人</td>
                            <td>联系方式</td>
                            <td>地址</td>
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
	String url = "management/seller_check/buyerinf.jsp";

	//遍历
	Iterator<Orders> io = ao.iterator();
	Orders o = new Orders();
	while(io.hasNext()){
		o = io.next();
		if(o.getO_status()!=2){
		Merchandise m = new Merchandise(o.getM_id());
		GetFullUtil gf = new GetFull();
		BuyerInfo bi = o.getBuyerInfo();
		BuyerInfo full_bi = gf.getAllBuyer(bi);
		BuyerAddress bad = full_bi.getBuyerAddress().get(0);
		%>
		<tr>
			<td><%= o.getMerchandise().getM_name() %></td>
        	<td><%= o.getU_act()%></td>
            <td><%= bi.getB_tele() %></td>
            <td><%= bad.getB_ads() %></td>
            <% 
            	if(o.getO_status()==0){
            %>
            <td><a href = "<%=basePath %>sellerorderconfirmServlet?o_id=<%=o.getO_id() %>">确认订单</a></td>
            <td><a href = "<%=basePath %>sellerquitorderServlet?o_id=<%=o.getO_id() %>">取消订单</a></td>
            <%
            	}else if (o.getO_status()==1){
            %>
            <td><a href = "<%=basePath %>dealServlet?o_id=<%=o.getO_id() %>">交易成功</a></td>
            <td><a href = "<%=basePath %>sellerquitorderServlet?o_id=<%=o.getO_id() %>">交易失败</a></td>
        </tr>
		<%
								}
							}
						}
		%>
		</table>
            	</div>
        	</div>
    	</div>
    	
    		 <br>
    <hr>
    <div class="p">      
        <a href="<%=basePath %><%= url%>?pages=1">&lt;&lt;</a>
        <a href="<%=basePath %><%= url%>?pages=<%=pages - 1%>">&lt;Prev</a>
        <form action="<%=basePath %><%= url%>" method="post">
            <div class="change">
                <input type="text" name="pages" value="<%=pages %>" style="width:20px;"></input><span>/<%= ao.size()/eachPageNum + 1%></span>
            </div>
            <input type="submit" class="button" value="Go" />
        </form>
        <a href="<%=basePath %><%= url%>?pages=<%=pages + 1%>">Next&gt;</a>
        <a href="<%=basePath %><%= url%>?pages=<%=ao.size()/eachPageNum + 1%>">&gt;&gt;</a>
    </div>
    </div>
</body>
<%
	try{
		String msg = (String)(session.getAttribute("msg4"));
		if(msg.equals("true")){
			session.setAttribute("msg4", "");
			%>
				<script>
			    	alert("更新成功！");
				</script>
			<%}else if(msg.equals("false")){
				session.setAttribute("msg4", "");
			%>
				<script>
			    	alert("更新失败！");
				</script>
			<%} 
	}catch(Exception e){
		e.printStackTrace();
		session.setAttribute("msg4", "");
	}
%>
<script>
	$(".second li").eq(0).css("background-image","linear-gradient(to right,#00a3af,#84a2d4)");
</script>
</html>