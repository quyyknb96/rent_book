<%--
  Created by IntelliJ IDEA.
  User: quytn
  Date: 16/11/2018
  Time: 09:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <link href="https://fonts.googleapis.com/css?family=Cinzel|Open+Sans+Condensed:300" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="/resource/css/style.css">
    <meta name="viewport" content="width=device-width, initial-scale=1,shrink-to-fit=no">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <link rel="stylesheet" type="text/css" href="/resource/css/demo.css">
</head>
<body>
<header id="headerPage">
    <div class="logo-left">Book<u>Store</u></div>

    <div class="logo-right">
        <ul>
            <c:choose>
                <c:when test="${sessionScope.get('userLogin') != null}">
                    <li style="display: block;">
                        <span style="font-size: 15px; font-weight: 200;">Xin chào</span>
                        <a style="margin-right: 25px;margin-left: 15px; font-size: 20px; display: inline-block" href="#">
                            ${userLogin.users.name}
                        </a>
                        <a style="display: inline-block" href="/logout">Thoát</a>
                    </li>
                </c:when>
                <c:otherwise>
                    <li><a href="/login"><img src="/resource/image/login.png">Đăng nhập</a></li>
                </c:otherwise>
            </c:choose>
        </ul>
    </div>
</header>
<div class="container">
    <!--thanh tiêu đề-->
    <div class="menu">
        <ul>
            <li><a href="/home">Trang chủ</a></li>
            <c:if test="${sessionScope.get('userLogin') != null && userLogin.username == 'admin'}">
                <li>|</li>
                <li>
                    <a href="#">Thống kê</a>
                    <ul class="statHover">
                        <li><a href="/stat/month">Theo tháng</a></li>
                        <li><a href="/stat/quarter">Theo quý</a></li>
                        <li><a href="/stat/year">Theo năm</a></li>
                    </ul>
                </li>
            </c:if>
        </ul>
    </div>
</body>
</html>
