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
            <li><a href="login.jsp"><img src="/resource/image/login.png">Đăng nhập</a></li>
            <%--<li style="display: block;">--%>
                <%--<span style="font-size: 15px; font-weight: 200;">Xin chào</span>--%>
                <%--<a style="margin-right: 25px;margin-left: 15px; font-size: 20px; display: inline-block" href="user_detail.jsp">--%>
                <%--</a>--%>
                <%--<a style="display: inline-block" href="logout.jsp">Thoát</a>--%>
            <%--</li>--%>
        </ul>
    </div>
</header>
<div class="container">
    <!--thanh tiêu đề-->
    <div class="menu">
        <ul>
            <li><a href="/home">Trang chủ</a></li>
            <li>|</li>
            <li><a href="news.jsp">Thống kê</a></li>
        </ul>
    </div>
</body>
</html>
