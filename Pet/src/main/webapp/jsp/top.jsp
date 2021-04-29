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
    
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <script src="https://cdn.bootcss.com/jquery/3.4.1/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/semantic-ui@2.4.2/dist/semantic.min.js"></script>
   
</head>
<body>
    <!-- 最顶部 -->
    <div class="top">
        <!-- 中间区域 -->
        <div class="center_area">
            <!-- 左边 -->
            <p class="title">
                <!-- <img src="img and video/title.png" style="width: 100px;height: 50px;"> -->
                <!-- <img src="img and video/title.png" alt=""> -->
            </p>
            <!-- 右边切换中英文 -->
            <div class="ui selection dropdown" id="select">
                <input type="hidden" name="lanuage">
                
                <div class="default text" style="color: white;">选择语言</div>
                <div class="menu">
                  <div class="item" data-value="male" style="border: none;text-align: center;">
                    <i class="cn flag"></i>
                    
                  </div>
                  <div class="item" data-value="female" style="border: none;text-align: center;">
                    <i class="gb uk flag"></i>
                    
                  </div>
                </div>
            </div>

            <script>
                $('.ui.dropdown')
                    .dropdown();  
            </script>
            
        </div>
    </div>


    <!-- 导航栏 -->
    <div class="nav">
        <!-- 中间区域 -->
        <div class="nav_center_area">
            <!-- 左边 -->
            <div class="left">
                <!-- 图标 -->
                <a href="${pageContext.request.contextPath}/jsp/index.jsp">
                    <img src="${pageContext.request.contextPath}/iv/title.png" style="width: 100px;height: 100px;">
                </a>
            </div>
            <!-- 中间 -->
            <div class="center">
                <ul>
                    <li><a href="${pageContext.request.contextPath}/jsp/index.jsp"><span>首页</span></a></li>
                    <li><a href="${pageContext.request.contextPath}/jsp/product.jsp"><span>产品</span></a></li>
                    <li><a href="${pageContext.request.contextPath}/jsp/petspecies.jsp"><span>宠物品种</span></a></li>
                    <li><a href="${pageContext.request.contextPath}/jsp/knowledge.jsp"><span>宠物知识</span></a></li>
                    <li><a href="${pageContext.request.contextPath}/jsp/contentus.jsp"><span>联系我们</span></a></li>
                    
                </ul>
            </div>
            
            <script type="text/javascript">
            	var spans = document.getElementsByTagName('span');
                var num = 0;
                for(var i = 0;i<spans.length;i++){
                    spans[i].index = i;
                    spans[i].onmouseover = function(){
                        for(var i = 0;i<spans.length;i++){
                            spans[i].style.background = 'none';
                            spans[i].style.color = '#6E7AB7';
                        }
                        this.style.background = 'pink';
                        this.style.color = 'white';
                    }
                    spans[i].onmouseleave = function(){
                        for(var i = 0;i<spans.length;i++){
                            spans[i].style.background = 'none';
                            spans[i].style.color = '#6E7AB7';
                        }
                        
                    }
                   
                }
            </script>
            
            <!-- 右边 -->
            <div class="right">
                <ul>
                    <li><a href="${pageContext.request.contextPath}/jsp/search.jsp"><i class="search icon" style="color: pink;"></a></i></li>
                    <c:if test="${username!=null }">
                    	<li style="color:pink;"><a href="${pageContext.request.contextPath}/jsp/userinfo.jsp.jsp" style="color: pink;">${username }</a></li>
                    </c:if>
                    <c:if test="${username==null }">
                    	<li><a href="${pageContext.request.contextPath}/jsp/login.jsp"><i class="user icon" style="color: pink;"></i></a></li>
                    </c:if>
                    <c:if test="${username!=null }">
                    	<li><a href="${pageContext.request.contextPath}/orderController/showCart?username=${username}&start=1"><i class="shopping cart icon" style="color: pink;"></i></a></li>
                    </c:if>
                    <c:if test="${username==null }">
                    	<li><a href="${pageContext.request.contextPath}/jsp/login.jsp"><i class="shopping cart icon" style="color: pink;"></i></a></li>
                    </c:if>
                </ul>
            </div>
        </div>
    </div>




</body>
</html>