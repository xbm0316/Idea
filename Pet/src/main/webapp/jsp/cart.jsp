<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/public.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/top.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/footer.css">
     <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <script src="https://cdn.bootcss.com/jquery/3.4.1/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/semantic-ui@2.4.2/dist/semantic.min.js"></script>
    
    <style type="text/css">
    	.cart{
    		width: 100%;
    		height: 500px;
    		
    	}
    	.cart .center{
    		width: 50%;
    		height: 500px;
    		margin: 0 auto;
    		border-radius:10px;
    		border:1px solid pink; 
    	}
    	 .center .c_top{
    	 	width: 80%;
    	 	height: 40px;
    	 	padding-top: 10px;
    	 	margin: 0 auto;	
    	 	color: pink;
    	 	position: relative;
    	 }
    	  .c_center .info{
    	  	width: 80%;
    	  	height: 440px;
    	  	color: pink;
    	  	margin: 0 auto;
    	  	border-radius: 10px;
    	  	border: 1px solid pink; 
    	  	font-size: 18px;
    	  	font-family: 500;
    	  }
    	  .c_center .o_info li{
    	  	padding-left: 110px;
    	  	padding-top: 90px;
    	  	line-height: 30px;
    	  }
    </style>
</head>
<body>
	<!-- 头部 -->
	<%@include file="top.jsp" %>
	
	
	
	
	<!-- 购物车 -->
	<div class="cart">
		<div class="center">
			<div class="c_top">
				<h4 style="font-size: 18px;font-family: 500;width: 30%;height: 20px;position: absolute;">用户名：${username }</h4>
				<a href="${pageConetxt.request.contextPath }/Ipet/orderController/showPayOrder?username=${username}&start=1"><h4 style="font-size: 18px;font-family: 500;float:right; width: 200px;height: 20px;color: pink;">查看已经支付的订单</h4></a>
			</div>
			<div class="c_center">
				
					<div class="info">
					<c:forEach items="${orderlist }" var="list">
						<div class="o_info">
							<ul>
								<li>
									商品编号：${list.order_id }<br>
									收货&nbsp;&nbsp;人:${list.re_name }<br>
									收货电话：${list.re_phone }<br>
									价&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;格：${list.o_money }<br>
									收货地址：${list.re_address }<br>
									<a href="${pageConetxt.request.contextPath }/Ipet/orderController/pay?order_id=${list.order_id}&username=${username}&start=1">
										<button class="pay" style="width: 100px;height: 30px;border: none;border-radius: 10px;background: pink;color: white;margin-left: 10px;">
											支付
										</button>
									</a>
								</li>
							</ul>
						</div>
					</c:forEach>
					</div>
					
				
			</div>
		</div>
		
		<div class="page" style="margin-left: 650px;">
            <nav aria-label="Page navigation">
                <ul class="pagination">
                    <li>
                        <a href="#" aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                        </a>
                    </li>
                    <li><a href="${pageConetxt.request.contextPath }/Ipet/orderController/showCart?username=${username}&start=1">1</a></li>
                    <li><a href="${pageConetxt.request.contextPath }/Ipet/orderController/showCart?username=${username}&start=2">2</a></li>
                    <li><a href="${pageConetxt.request.contextPath }/Ipet/orderController/showCart?username=${username}&start=3">3</a></li>
                    <li><a href="${pageConetxt.request.contextPath }/Ipet/orderController/showCart?username=${username}&start=4">4</a></li>
                    <li><a href="${pageConetxt.request.contextPath }/Ipet/orderController/showCart?username=${username}&start=5">5</a></li>
                    
                    <li>
                        <a href="#" aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                        </a>
                    </li>
                </ul>
            </nav>
        </div>
	</div>
	
	<script type="text/javascript">
		var pay = '${payerror}';
		if(pay !== ""){
			alert("购买成功！");
		}
	</script>
	<!-- 脚部 -->
	<div class="footer" style="margin-top: 70px;">
		<%@include file="footer.jsp" %>
	</div>
	
</body>
</html>