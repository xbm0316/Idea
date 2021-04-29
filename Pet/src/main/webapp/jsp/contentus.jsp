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


    <!-- 联系部分 -->
    <div class="contentus">
        <!-- 中间区域 -->
        <div class="content_center_area">
            <!-- 联系图标 -->
            <div class="contentway">
                <ul>
                    <div style="width: 900px;height: 250px;margin:0 auto;margin-top: 90px;">
                        <li><a href=""><img src="${pageContext.request.contextPath}/iv/qq.jpg" alt=""></a></li>
                        <li><a href=""><img src="${pageContext.request.contextPath}/iv/phone.jpg" alt=""></a></li>
                        <li><a href=""><img src="${pageContext.request.contextPath}/iv/email.jpg" alt=""></a></li>
                    </div>
                    
                </ul>
                <form action="" method="POST">
                    <div class="userway" style="margin-left: 500px;margin-top: 70px;">
                        <h4 style="color: pink;">留下您的联系方式：</h4>
                        <input type="text" style="border: none;border-bottom:1px solid pink;outline: none;color: pink;text-align: center;">
                        <i class="phone volume icon" style="font-weight: 600;color: pink;"></i>
                    </div>
                </form>
            </div>
        </div>
    </div>


    

    <!-- 脚部 -->
    <div class="footer">
    	<%@include file="footer.jsp" %>
    </div>

</body>
</html>