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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/footer.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/regist.css">
    
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <script src="https://cdn.bootcss.com/jquery/3.4.1/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/semantic-ui@2.4.2/dist/semantic.min.js"></script>
   
</head>
<body>
    <!-- 最顶部 -->
    <%@include file="top.jsp"%>

    <!-- 注册部分 -->
    <div class="registform">
        <div class="w">
        <div class="myform">
         <h4>注册</h4>
            <form action="${pageContext.request.contextPath}/userController/addUser" method="POST">
                <div class="input-group input-group-lg">
                    <input type="text" name="name" class="form-control" placeholder="账号" aria-describedby="sizing-addon1" style="border-radius: 5px;border: 1px solid pink;color: pink;outline: pink;text-align: center;">
                </div>
                <div class="input-group input-group-lg">
                    <input type="text" name="password" class="form-control" placeholder="密码" aria-describedby="sizing-addon1" style="border-radius: 5px;border: 1px solid pink;color: pink;outline: pink;text-align: center;">
                </div>
                <div class="input-group input-group-lg">
                    <input type="text" name="phone" class="form-control" placeholder="手机" aria-describedby="sizing-addon1" style="border-radius: 5px;border: 1px solid pink;color: pink;outline: pink;text-align: center;">
                </div>
                <div class="input-group input-group-lg">
                    <input type="text" name="address" class="form-control" placeholder="收货地址" aria-describedby="sizing-addon1" style="border-radius: 5px;border: 1px solid pink;color: pink;outline: pink;text-align: center;">
                </div>
                <div class="loginbtn">
                    <button class="btn btn-primary btn-lg">
                        注册
                    </button>
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