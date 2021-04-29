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
    <link rel="stylesheet" href="/css/bootstrap.min.css">
    <script src="${pageContext.request.contextPath }/jar/jquery-3.4.1.min.js"></script>
    <script src="${pageContext.request.contextPath }/js/bootstrap.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/semantic-ui@2.4.2/dist/semantic.min.js"></script>
   
</head>
<body>

    <!-- 最顶部 -->
    <%@include file="top.jsp"%>


    <!-- 主体部分 -->
    <div class="main">
        <!-- 轮播图部分 -->
        <div class="banner">
            <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
                <!-- Indicators -->
                <ol class="carousel-indicators">
                    <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
                    <li data-target="#carousel-example-generic" data-slide-to="1"></li>
                    <li data-target="#carousel-example-generic" data-slide-to="2"></li>
                </ol>
            
                <!-- Wrapper for slides -->
                <div class="carousel-inner" role="listbox">
                    <div class="item active" style="background-color: #ffe4b3;">
                        <img src="${pageContext.request.contextPath}/iv/1.png" alt="...">
                        <div class="carousel-caption">
                        </div>
                    </div>
                    <div class="item"  style="background-color: #ffe4b3;">
                        <img src="${pageContext.request.contextPath}/iv/2.png" alt="...">
                        <div class="carousel-caption">
                        </div>
                    </div>
                    
                </div>
            
                <!-- Controls -->
                <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
                    <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                    <span class="sr-only">Previous</span>
                </a>
                <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
                    <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                    <span class="sr-only">Next</span>
                </a>
            </div>
        
        </div>

        <!-- 居中区域 -->
        <div class="main_center_area">
            <!-- 宠物种类 -->
            <div class="petspecies">
                <div class="pettop">
                    <h2>PetSpecies</h2>
                </div>
                    
                <div class="petbutton">
                    <ul>
                        <li><a href="${pageContext.request.contextPath}/productController/findProduct?searchproduct=猫&currentPage=1"><img src="${pageContext.request.contextPath}/iv/cat.png" alt="" style="width: 250px;height: 250px;"></a></li>
                        <li><a href="${pageContext.request.contextPath}/productController/findProduct?searchproduct=狗&currentPage=1"><img src="${pageContext.request.contextPath}/iv/dog.png" style="width: 250px;height: 250px;"></a></li>
                    </ul>
                </div>
            </div>

            <!-- 今日热售 -->
            <div class="sale">
                <div class="sale_top">
                    <h2>今日热售</h2>
                </div>
                <div class="sale_button">
                    <div class="sale_left">
                        <img src="${pageContext.request.contextPath}/iv/sale.png" alt="">
                    </div>
                    <div class="sale_right">
                        <div class="price">
                            <h2>￥199.00</h2>
                        </div>
                        <div class="context">
                            <p>近两周已售出一千万份！</p>
                        </div>
                        <div class="salebtn">
                            <a href="${pageContext.request.contextPath }/productController/findProductInfo?p_img=/iv/sale.png">
                                <span class="salbtn">
                                    	立即购买
                                </span>
                            </a>
                        </div>
                    </div>
                </div>
                
            </div>


            <!-- 宠物电子产品 -->
            <div class="petproduct">
                <div></div>
            </div>

        </div>
    </div>

    <!-- 脚部 -->
    <div class="footer" style="margin-top: 800px;">
    	<%@include file="footer.jsp"  %>
    </div>
    

</body>
</html>