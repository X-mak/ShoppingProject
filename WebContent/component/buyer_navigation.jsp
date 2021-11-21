<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>我的后台</title>
<%@include file="../util/getpath.jsp" %>
<%@include file="../../util/buyer_checklogin.jsp" %>
<link rel="stylesheet" id="templatecss" type="text/css" href="<%=basePath %>css/navi_interface.css">
</head>
<body>
	<div class="headrow mid shadow">
        <div class="logoandname">
         	<a href=""> 网上购物买家后台</a>
        </div>
        <div class="buyerinfo">
            <div class="mesul">
                <span></span><span>∨</span>
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
                        <summary> 订单信息</summary>
                        <ul class="box">
                            <li><a href="<%=basePath%>buyerviewhistoryServlet">查看购买历史&gt;</a></li>
                            <!-- <li>childdemo2 &gt;</li>
                            <li>childdemo3 &gt;</li> -->
                        </ul>
                    </details>
                </li>
                <li>
                    <details>
                        <summary> 个人空间</summary>
                        <ul class="box">
                            <li><a href="<%=basePath%>authentication/buyer_alter/buyer_changeinfo.jsp">修改信息&gt;</a></li>
                           <li><a href="<%=basePath %>authentication/buyer_alter/buyer_changepwd.jsp">修改密码&gt;</a></li>
                           <!--  <li>childdemo3 &gt;</li> -->
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