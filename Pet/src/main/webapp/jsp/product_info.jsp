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
	
	<script type="text/javascript">
		var error = '${cartsuccess}';
		if(error != ''){
			alert("加入购物车成功！");
		}
	</script>
    <div class="pinfo">
        <div class="w">
            <div class="left">
            	<c:if test="${cartsuccess == null }">
            		<img src="${pageContext.request.contextPath}/${pinfo.p_img}"/>
            	</c:if>
                <c:if test="${cartsuccess != null }">
                	<img src="${pageContext.request.contextPath}/${img}"/>
                </c:if>
            </div>
            <div class="right">
                <h2 style="color:pink;">${pinfo.p_name }</h2>
                <div class="price">${pinfo.p_price }</div>
                <div class="info" style="color:pink;">
                    一条没有训练过的犬对于主人来说是一种负担，对于犬本身来说也是不幸的。德国牧羊犬协会(SV)通过各地的分会，建立了各分会的训练场，举办训练班。这样给会员提供了许多方便，在基础设施方面，SV做得相当完善。训练出一条出色的犬需要爱心，耐心和对爱犬行为的理解。狗不是机器
                </div>
                <div class="parameter">
                    <p>参数: 
                        <!-- Large button group -->
                        <div class="btn-group">
                            <button class="btn btn-default btn-lg dropdown-toggle" type="button" data-toggle="dropdown" aria-haspopup="true"
                                aria-expanded="false">
                                商品参数 <span class="caret"></span>
                            </button>
                            <ul class="dropdown-menu">
                                <li role="presentation"><a href="#">action1 </a></li>
                                <li role="presentation"><a href="#">action2 </a></li>
                                <li role="presentation"><a href="#">action3 </a></li>
                            </ul>
                        </div>
                    </p>
                    <p>数量:</p>
                    <div class="num">
                        <button type="button" class="btn btn-danger glyphicon glyphicon-minus"></button>
                        <input type="text" class="form-control" value="1" style="width: 50px;">
                        <button type="button" class="btn btn-success glyphicon glyphicon-plus"></button>
                    </div>
                    <p>
                    	<c:if test="${username == null }">
                    		<a href="${pageContext.request.contextPath}/jsp/login.jsp">
                    			<button class=" btn btn-primary btn-lg" style="background: pink;border:none;outline: none;">
                      		 		添加到购物车
                    			</button>
                    		</a>
                    	</c:if>
                    	
                    	<c:if test="${username !=null }">
                    		<a href="${pageContext.request.contextPath}/orderController/addOrder?username=${username}&p_img=${pinfo.p_img}&p_price=${pinfo.p_price}">
                    			<button class=" btn btn-primary btn-lg" style="background: pink;border:none;outline: none;">
                      		 		添加到购物车
                    			</button>
                    		</a>
                    	</c:if>
                        
                    </p>
                </div>
            </div>
        </div>
    </div>


    <!-- 脚部 -->
    <div class="footer">
      <%@include file="footer.jsp" %>
    </div>

</body>

</html>