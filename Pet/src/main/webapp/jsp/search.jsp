<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <!-- 导入ui框架 -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/semantic-ui@2.4.2/dist/semantic.min.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/public.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/top.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/index.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/search.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/contentus.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/footer.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <script src="https://cdn.bootcss.com/jquery/3.4.1/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/semantic-ui@2.4.2/dist/semantic.min.js"></script>
   
   
</head>
<body>
    <!-- 最顶部 -->
    <%@include file="top.jsp" %>
    
    
    
    <script type="text/javascript">
    	var error = '${error}';
    	if(error !== ''){
    		alert("您所搜索的商品不存在");
    	}
    </script>
    
    <!-- 中间搜索部分 -->
    <div class="search">
	    <div class="searchcenter"> 
	    	<div class="searchtop">
	    		<h4 style="color: pink;">您可以搜索：衣服，玩具或者宠物种类。。。</h4>
	    	</div>
	    	<div class="searchbutton">
	    		<form action="${pageContext.request.contextPath}/search/searchController?currentPage=1" method="post">
	    			<input type="text" name="searchthing"
                    style="border: none;border-bottom: 1px solid pink;outline: none;text-align: center;color:pink;">
                <input type="submit" value="搜索" style="color: white;background: pink;border:none;border-radius: 10px;width: 70px;height: 25px;outline: none;">
            	
	    		</form>
	    	</div>
	    </div>
    </div>
    
    
    
    
    
    
    <!-- 脚部 -->
    <div class="footer">
    	<%@include file="footer.jsp" %>
    </div>