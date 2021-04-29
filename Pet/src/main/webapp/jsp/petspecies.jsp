<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/footer.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/petspecies.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <script src="https://cdn.bootcss.com/jquery/3.4.1/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/semantic-ui@2.4.2/dist/semantic.min.js"></script>
   
</head>
<body>
    <!-- 最顶部 -->
   <%@include file="top.jsp"%>

    <!-- 照片 -->
    <img src="${pageContext.request.contextPath}/iv/banner-2.jpg" alt="">

    <!-- 宠物品种部分 -->
    <div class="pet">
        <!-- 中间部分 -->
        <div class="pet_center">
            <!-- 左边部分 -->
            <div class="pet_left">
                <!-- 左边的上部分 -->
                <div class="pet_left_top">
                	<form action="${pageContext.request.contextPath}/petController/findCate" method="post">
                		<input type="text" name="category" style="border: none;border-bottom: 1px solid pink;outline: none;text-align: center;">	
                		<input type="submit" value="搜索" style="color: white;background: pink;border:none;border-radius: 10px;width: 70px;height: 25px;outline: none;">
                	</form>
                	
                    
                     
                </div>
                <!-- 左边的下部分 -->
                <div class="pet_left_button">
                    <ul>
                        <div class="pet_title">
                            <li style="color: pink;"><h4>狗狗：</h4></li>
                        </div>
                        <div class="pet_context">
                            <li><a href="${pageContext.request.contextPath}/petController/findCate?category=牧羊犬">牧羊犬</a></li>
                            <li><a href="${pageContext.request.contextPath}/petController/findCate?category=二哈">二哈</a></li>
                            <li><a href="${pageContext.request.contextPath}/petController/findCate?category=田园农家犬">田园农家犬</a></li>
                            <li><a href="${pageContext.request.contextPath}/petController/findCate?category=藏獒">藏獒</a></li>
                            <li><a href="${pageContext.request.contextPath}/petController/findCate?category=松狮">松狮</a></li>
                        </div>
                        
                        <div class="pet_title2">
                            <li style="color: pink;"><h4>猫咪：</h4></li>
                        </div>
                        <div class="pet_context2">
                            <li><a href="${pageContext.request.contextPath}/petController/findCate?category=橘猫">橘猫</a></li>
                            <li><a href="${pageContext.request.contextPath}/petController/findCate?category=布偶猫">布偶猫</a></li>
                            <li><a href="${pageContext.request.contextPath}/petController/findCate?category=波斯猫">波斯猫</a></li>
                            <li><a href="${pageContext.request.contextPath}/petController/findCate?category=埃及猫">埃及猫</a></li>
                            <li><a href="${pageContext.request.contextPath}/petController/findCate?category=孟买猫">孟买猫</a></li>
                        </div>
                    </ul>
                </div>
            </div>
            <!-- 右边部分 -->
            <div class="pet_right">
                <ul>
                	<c:forEach items="${petInfo }" var="pet">
                		<li><a href="#"><img src="${pageContext.request.contextPath}${pet.imgurl}" alt=""></a></li>
	                    
                	</c:forEach>
                	<li><a href="#"><img src="${pageContext.request.contextPath}${ img}" alt="" style="margin-left:200px"></a></li>
                </ul>
            </div>
        </div>
    </div>

    

    <!-- 脚部 -->
    <div class="footer" style="margin-top: 500px">
    	<%@include file="footer.jsp" %>
    </div>

</body>
</html>