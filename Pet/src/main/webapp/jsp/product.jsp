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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/product.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/footer.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <script src="https://cdn.bootcss.com/jquery/3.4.1/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/semantic-ui@2.4.2/dist/semantic.min.js"></script>

</head>

<body>
    <!-- 最顶部 -->
   <%@include file="top.jsp"%>

    <div class="main">
        <div class="w">
            <div class="pet_left_top">
            	<form action="${pageContext.request.contextPath }/productController/findProduct?currentPage=1" method="post">
            		<c:if test="${category != null }">
            			<input type="text" name="searchproduct" value="${category }"
	                    style="border: none;border-bottom: 1px solid pink;outline: none;text-align: center;color:pink;">
	                	<input type="submit" value="搜索" style="color: white;background: pink;border:none;border-radius: 10px;width: 70px;height: 25px;outline: none;">
            		</c:if>
            		<c:if test="${category == null }">
            		
            		
            		<input type="text" name="searchproduct"
	                    style="border: none;border-bottom: 1px solid pink;outline: none;text-align: center;color:pink;">
	                	<input type="submit" value="搜索" style="color: white;background: pink;border:none;border-radius: 10px;width: 70px;height: 25px;outline: none;">
	                </c:if>
            	</form>
                
            </div>
            
            <c:if test="${productlist != null }">
            	<c:forEach items="${productlist }" var="product">
            		<ul style="color:pink;">
		                <li>
		                    <div class="productimg">
		                        <a href="${pageContext.request.contextPath}/productController/findProductInfo?p_img=${product.p_img}"><img src="${pageContext.request.contextPath}${product.p_img}"/></a>
		                        <a href="#">
		                            <span class="glyphicon glyphicon-heart-empty collect"></span>
		                        </a>
		                    </div>
		                    <div class="productinfo">
		                        <h4>${product.p_name }</h4>
		                        <div class="price">${product.p_price }</div>
		                    </div>
		                </li>
                
            		</ul>
            	</c:forEach>
            </c:if>
             
            <c:if test="${productlist ==null }">
            	<ul style="color:pink;">
	                <li>
	                    <div class="productimg">
	                        <a href="${pageContext.request.contextPath}/productController/findProductInfo?p_img=/iv/catfood.png"><img src="${pageContext.request.contextPath}/img and video/catfood.png"/></a>
	                        <a href="#">
	                            <span class="glyphicon glyphicon-heart-empty collect"></span>
	                        </a>
	                    </div>
	                    <div class="productinfo">
	                        <h4>纯正猫粮</h4>
	                        <div class="price">￥199.00</div>
	                    </div>
	                </li>
	                <li>
	                    <div class="productimg">
	                        <a href="${pageContext.request.contextPath}/productController/findProductInfo?p_img=/iv/catplay1.png"><img src="${pageContext.request.contextPath}/img and video/catplay1.png" /></a>
	                        <a href="#">
	                            <span class="glyphicon glyphicon-heart-empty collect"></span>
	                        </a>
	                    </div>
	                    <div class="productinfo">
	                        <h4>猫抓板</h4>
	                        <div class="price">￥20.00</div>
	                    </div>
	                </li>
	                <li>
	                    <div class="productimg">
	                        <a href="${pageContext.request.contextPath}/productController/findProductInfo?p_img=/iv/catplay2.png"><img src="${pageContext.request.contextPath}/img and video/catplay2.png" /></a>
	                        <a href="#">
	                            <span class="glyphicon glyphicon-heart-empty collect"></span>
	                        </a>
	                    </div>
	                    <div class="productinfo">
	                        <h4>逗猫杆</h4>
	                        <div class="price">￥20.00</div>
	                    </div>
	                </li>
	                <li>
	                    <div class="productimg">
	                        <a href="${pageContext.request.contextPath}/productController/findProductInfo?p_img=/iv/sale.png"><img src="${pageContext.request.contextPath}/img and video/sale.png" /></a>
	                        <a href="#">
	                            <span class="glyphicon glyphicon-heart-empty collect"></span>
	                        </a>
	                    </div>
	                    <div class="productinfo">
	                        <h4>纯正狗粮</h4>
	                        <div class="price">￥199.00</div>
	                    </div>
	                </li>
	                <li>
	                    <div class="productimg">
	                        <a href="${pageContext.request.contextPath}/productController/findProductInfo?p_img=/iv/dogplay1.png"><img src="${pageContext.request.contextPath}/img and video/dogplay1.png" /></a>
	                        <a href="#">
	                            <span class="glyphicon glyphicon-heart-empty collect"></span>
	                        </a>
	                    </div>
	                    <div class="productinfo">
	                        <h4>狗抓球球</h4>
	                        <div class="price">￥20.00</div>
	                    </div>
	                </li>
	                <li>
	                    <div class="productimg">
	                        <a href="${pageContext.request.contextPath}/productController/findProductInfo?p_img=/iv/catwear1.png"><img src="${pageContext.request.contextPath}/img and video/catwear1.png" /></a>
	                        <a href="#">
	                            <span class="glyphicon glyphicon-heart-empty collect"></span>
	                        </a>
	                    </div>
	                    <div class="productinfo">
	                        <h4>可爱猫衣服~</h4>
	                        <div class="price">￥100.00</div>
	                    </div>
	                </li>
	                <li>
	                    <div class="productimg">
	                        <a href="${pageContext.request.contextPath}/productController/findProductInfo?p_img=/iv/dogwear2.png"><img src="${pageContext.request.contextPath}/img and video/dogwear2.png" /></a>
	                        <a href="#">
	                            <span class="glyphicon glyphicon-heart-empty collect"></span>
	                        </a>
	                    </div>
	                    <div class="productinfo">
	                        <h4>狗狗连帽卫衣</h4>
	                        <div class="price">￥100.00</div>
	                    </div>
	                </li>
	                <li>
	                    <div class="productimg">
	                        <a href="${pageContext.request.contextPath}/productController/findProductInfo?p_img=/iv/catplay3.png"><img src="${pageContext.request.contextPath}/img and video/catplay3.png" /></a>
	                        <a href="#">
	                            <span class="glyphicon glyphicon-heart-empty collect"></span>
	                        </a>
	                    </div>
	                    <div class="productinfo">
	                        <h4>逗猫杆</h4>
	                        <div class="price">￥20.00</div>
	                    </div>
	                </li>
            </ul>
            </c:if>
            
        </div>
       	<div class="fenpage">
            <nav aria-label="Page navigation">
                <ul class="pagination">
                    <li>
                        <a href="#" aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                        </a>
                    </li>
                    <li><a href="${pageConetxt.request.contextPath }/Ipet/productController/findProduct?searchproduct=${category }&currentPage=1">1</a></li>
                    <li><a href="${pageConetxt.request.contextPath }/Ipet/productController/findProduct?searchproduct=${category }&currentPage=2">2</a></li>
                    
                    <li>
                        <a href="#" aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                        </a>
                    </li>
                </ul>
            </nav>
        </div>
    </div>
    
   
	
	

    <!-- 脚部 -->
    <div class="footer">
    	<%@include file="footer.jsp" %>
    </div>    

</body>

</html>