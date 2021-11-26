<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>我的后台</title>
<%@include file="../util/getpath.jsp" %>

<link rel="stylesheet" id="templatecss" type="text/css" href="<%=basePath %>css/navi_interface.css">
</head>
<body>
    <div class="headrow mid shadow">
        <div class="logoandname">
         	<a href=""> 网上购物卖家后台</a>
        </div>
        <div class="buyerinfo">
            <div class="mesul">
                <span></span>
                <ul>
                    <li><a href="#">退出登录</a></li>
                </ul>
            </div>
        </div>

    </div>
    <div class="mainbox mid">
        <div class="leftnav shadow">
            <!-- container包含了nav所有的框框 -->
            <ul class="container">
                <li>
                    <details>
                        <summary> 商品管理</summary>
                        <ul class="box">
                            <li><a href="<%=basePath %>management/seller_releasegood/releasegood.jsp">发布商品 &gt;</a></li>
                            <li><a href="<%=basePath %>management/seller_merchanmanage/seller_merchanmanage.jsp?pages=1">商品管理 &gt;</a></li>
                            <li><a href="<%=basePath %>historyServlet">历史商品  &gt;</a></li>
                        </ul>
                    </details>
                </li>
                <li>
                    <details>
                        <summary> 订单管理</summary>
                        <ul class="box">
                            <li> <a href="<%=basePath %>sellerordermanageServlet">查看购买意向&gt;</a></li>
                            <!--  <li>childdemo2 &gt;</li>
                            <li>childdemo3 &gt;</li>-->
                        </ul>
                    </details>
                </li>
               <!--  --> <li>
                    <details>
                        <summary> 用户管理</summary>
                        <ul class="box">
                            <li><a href="<%=basePath %>viewbuyerinfoServlet">查看客户信息&gt;</a></li>
                          <!--   <li>childdemo3 &gt;</li> -->
                        </ul>
                    </details>
                </li>
                <li>
                    <details>
                        <summary> 个人空间</summary>
                        <ul class="box">
                            <li><a href="<%=basePath %>authentication/seller_alter/sellerpwdchange.jsp">修改密码&gt;</a></li>
                            <!--  <li>childdemo2 &gt;</li>
                            <li>childdemo3 &gt;</li>-->
                        </ul>
                    </details>
                </li>
                <a href="<%=basePath %>index.jsp">返回商城</a>
            </ul>
        </div>
        <!-- <div class="context shadow"></div> -->
    </div>
</body>

</html>