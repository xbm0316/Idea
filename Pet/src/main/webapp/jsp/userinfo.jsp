<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/public.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/top.css">
    
    
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/footer.css">
    
    <style type="text/css">
    	.userinfo{
    		width: 100%;
    		height: 300px;
    	}
    	.userinfo .center{
    		width: 50%;
    		height: 300px;
    		margin:0 auto;
    		margin-top:70px;
    		padding-left: 220px;
    		padding-top: 50px;
    		font-size: 18px;
    		font-family: 500;
    		color: pink;
    		line-height: 40px;
    		border: 1px solid pink;
    	}
    </style>
</head>
<body>
	
	<script type="text/javascript">
		var info = '${success}';
		if(info !== ''){
			alert("修改成功！");
		}
	</script>
	
	<!-- 头部 -->
	<%@include file="top.jsp" %>
	
    <!-- 显示个人信息 -->
    <div class="userinfo">
    	<div class="center">
    		<form action="${pageContext.request.contextPath }/userController/updateUser?name=${username}" method="post">
    			用户账号：${username }<br>
    			密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码：<input type="text" name="password" style="border:none;border-bottom: 1px solid pink;outline: none;text-align: center; "><br>
    			收货地址：<input type="text" name="address" style="border:none;border-bottom: 1px solid pink;outline: none;text-align: center; "><br>
    			<input type="submit" value="修改" style="width:100px;height: 30px;border:1px solid pink;border-radius: 10px;background: pink;color: white;margin-top: 20px;margin-left: 100px;line-height: 30px;">
    			
    		</form>
    		<a href="${pageContext.request.contextPath }/userController/exitUser" style="color: pink;padding-left: 400px;padding-top: 30px;">退出用户</a>
    	</div>
    </div>
    
    <!-- 脚部 -->
    <div class="footer" style="margin-top: 100px;">
    	<%@include file="footer.jsp" %>
    </div>
    
    
</body>
</html>