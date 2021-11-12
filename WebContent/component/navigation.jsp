<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@include file="../util/getpath.jsp" %>

<link rel="stylesheet" id="templatecss" type="text/css" href="<%=basePath %>css/navi_interface.css">
</head>
<body>
<ul>
        <li>
            <a href="<%=basePath %>authentication/seller_login/seller_login_success.jsp">我的首页</a>
        </li>
        <li>
            <a href="<%=basePath %>management/seller_releasegood/releasegood.jsp">发布商品</a>
        </li>
        <li>
            <a href="<%=basePath %>buyerServlet">查看购买意向</a>
        </li>
          <li>
            <a href="<%=basePath %>historyServlet">查看历史商品</a>
        </li>
        <li>
            <a href="<%=basePath %>viewbuyerinfoServlet">查看客户信息</a>
        </li>
    </ul>
</body>
</html>