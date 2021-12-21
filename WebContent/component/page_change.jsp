<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	String p = request.getParameter("pages");		//url传值当前页面
	int n = (int)(session.getAttribute("size"));	//session中需要传遍历数组长度
	int pages = 1;
	if(p.matches("\\d+")){							//正则表达式输入数字
		pages = Integer.parseInt(p);
	}
	int eachPageNum = 10;							//每页显示多少数据
	if(pages < 1)pages = 1;
	if(pages > n/eachPageNum + 1)pages = n/eachPageNum + 1;//防溢出
	int maxItem = Math.min(n, pages*eachPageNum);	//最大值
	String url = "";
%>
<hr>
        <div style="margin:0px auto;width:200px;">
        	<span>总共<%= n/eachPageNum + 1%>页，当前在第<%= pages%>页</span><br/>
        	<a href="<%=basePath %><%= url%>?pages=1">首页</a>
        	<a href="<%=basePath %><%= url%>?pages=<%=pages - 1%>">上一页</a>
        	<a href="<%=basePath %><%= url%>?pages=<%=pages + 1%>">下一页</a>
        	<form action="<%=basePath %>seller_history/historicalgoods.jsp" method="post">
        		跳转到第<input type="text" name="pages" value="<%= pages%>" style="width:20px;"></input>页
        		<input type="submit" class="button" value="跳转" />
        	</form>
        </div>
</body>
</html>