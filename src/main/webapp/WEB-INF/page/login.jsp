<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: quytn
  Date: 16/11/2018
  Time: 11:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Đăng nhập</title>
</head>
<body>
    <jsp:include page="header.jsp"></jsp:include>
    <div class="content">
        <form action="/login" method="POST">
            <center><h3>Đăng nhập</h3></center>
            <div>
                <p style="color: red;">
                    <c:if test="${errorMessenger != null}">
                        <c:out value="${errorMessenger}"></c:out>
                    </c:if>
                </p>
            </div>
            <div class="form-group">
                <label>USERNAME</label>
                <input type="text" class="form-control" name="username" autocomplete="off" placeholder="Enter your username" >

            </div>
            <div class="form-group">
                <label>PASSWORD</label>
                <input type="password" class="form-control" name="password" autocomplete="off" placeholder="Password">
            </div>
            <button type="submit" class="btn btn-primary">Submit</button>
        </form>

    </div>
    <jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
