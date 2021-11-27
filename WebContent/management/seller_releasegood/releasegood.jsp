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
<link rel="stylesheet" id="templatecss" type="text/css" href="<%=basePath %>css/seller_release_interface.css">
<script type="text/javascript" src="<%=basePath %>ueditor/ueditor.config.js"></script>
<script type="text/javascript" src="<%=basePath %>ueditor/ueditor.all.js"></script>
<script type="text/javascript" charset="utf-8" src="<%=basePath %>ueditor/lang/zh-cn/zh-cn.js"></script>
<body>
	 <form action="<%=basePath %>/releasegoodServlet" method="post" enctype="multipart/form-data" class="form">
        <table>
            <tr>
                <td>商品名称:</td>
                <td><input type="text" name="goodname" placeholder="请输入商品名称"></td>
            </tr>
            <tr>
                <td>商品价格:</td>
                <td><input type="text" name="goodprice" placeholder="请输入商品价格"></td>
            </tr>
            <tr>
                <td>商品数量:</td>
                <td><input type="text" name="goodnum" placeholder="请输入商品数量"></td>
            </tr>
            <tr>
                <td>商品图片:</td>
                <td><input type="file" name="goodimgfile" class="image-input" multiple="multiple"></td>
            </tr>
            <tr>
                <td>商品描述:</td>
                <td><textarea id="richmedia"  name="goodinf"  style="resize: none;"></textarea><br /></td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="submit" value="发布" class="sub-btn"/></td>
                <td></td>
            </tr>
        </table>
    </form>
</body>
 <script type="text/javascript">

       var ue = UE.getEditor("richmedia",{});

		setTimeout(function(){editor.execCommand('drafts')},2000);//自动保存


      </script>
</html>