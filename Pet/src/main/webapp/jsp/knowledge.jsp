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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/knowledge.css">
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
            <div class="left">
                <h3 style="color: pink;">宠物种类</h3>
                <ul>
                    <li>
                        <h4 style="font-weight: 500;color: pink;">狗狗：</h4>
                        <div>
                            <a href="#">全部</a>
                            <a href="#">牧羊犬</a>
                            <a href="#">二哈</a>
                            <a href="#">田园农家犬</a>
                            <a href="#">藏獒</a>
                            <a href="#">松狮</a>
                        </div>
                    </li>
                    <li>
                        <h4 style="font-weight: 500;color: pink;">猫咪：</h4>
                        <div>
                            <a href="#">全部</a>
                            <a href="#">橘猫</a>
                            <a href="#">布偶猫</a>
                            <a href="#">波斯猫</a>
                            <a href="#">埃及猫</a>
                            <a href="#">孟买猫</a>
                        </div>
                    </li>
                </ul>
            </div>
            <div class="right">
                <ul>
                    <li>
                        <h3>牧羊犬的基本训练方法</h3>
                        <div class="info">
                            <img src="${pageContext.request.contextPath}/iv/g.jpeg"/>
                            <div class="body">
                                一条没有训练过的犬对于主人来说是一种负担，对于犬本身来说也是不幸的。德国牧羊犬协会(SV)通过各地的分会，建立了各分会的训练场，举办训练班。这样给会员提供了许多方便，在基础设施方面，SV做得相当完善。训练出一条出色的犬需要爱心，耐心和对爱犬行为的理解。狗不是机器
                            </div>
                        </div>
                    </li>
                    <li>
                        <h3>牧羊犬的基本训练方法</h3>
                        <div class="info">
                            <img src="${pageContext.request.contextPath}/iv/g.jpeg" />
                            <div class="body">
                                一条没有训练过的犬对于主人来说是一种负担，对于犬本身来说也是不幸的。德国牧羊犬协会(SV)通过各地的分会，建立了各分会的训练场，举办训练班。这样给会员提供了许多方便，在基础设施方面，SV做得相当完善。训练出一条出色的犬需要爱心，耐心和对爱犬行为的理解。狗不是机器
                            </div>
                        </div>
                    </li>
                    <li>
                        <h3>牧羊犬的基本训练方法</h3>
                        <div class="info">
                            <img src="${pageContext.request.contextPath}/iv/g.jpeg" />
                            <div class="body">
                                一条没有训练过的犬对于主人来说是一种负担，对于犬本身来说也是不幸的。德国牧羊犬协会(SV)通过各地的分会，建立了各分会的训练场，举办训练班。这样给会员提供了许多方便，在基础设施方面，SV做得相当完善。训练出一条出色的犬需要爱心，耐心和对爱犬行为的理解。狗不是机器
                            </div>
                        </div>
                    </li>
                    <li>
                        <h3>牧羊犬的基本训练方法</h3>
                        <div class="info">
                            <img src="${pageContext.request.contextPath}/iv/g.jpeg" />
                            <div class="body">
                                一条没有训练过的犬对于主人来说是一种负担，对于犬本身来说也是不幸的。德国牧羊犬协会(SV)通过各地的分会，建立了各分会的训练场，举办训练班。这样给会员提供了许多方便，在基础设施方面，SV做得相当完善。训练出一条出色的犬需要爱心，耐心和对爱犬行为的理解。狗不是机器
                            </div>
                        </div>
                    </li>
                    <li>
                        <h3>牧羊犬的基本训练方法</h3>
                        <div class="info">
                            <img src="${pageContext.request.contextPath}/iv/g.jpeg" />
                            <div class="body">
                                一条没有训练过的犬对于主人来说是一种负担，对于犬本身来说也是不幸的。德国牧羊犬协会(SV)通过各地的分会，建立了各分会的训练场，举办训练班。这样给会员提供了许多方便，在基础设施方面，SV做得相当完善。训练出一条出色的犬需要爱心，耐心和对爱犬行为的理解。狗不是机器
                            </div>
                        </div>
                    </li>
                </ul>
                <nav aria-label="...">
                    <ul class="pager">
                        <li><a href="#">上一页</a></li>
                        <li><a href="#">下一页</a></li>
                    </ul>
                </nav>
            </div>
        </div>
    </div>
   
    <!-- 脚部 -->
    <div class="footer">
        <%@include file="footer.jsp" %>
    </div>

</body>

</html>