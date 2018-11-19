<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%--
  Created by IntelliJ IDEA.
  User: quytn
  Date: 19/11/2018
  Time: 13:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Chi tiết</title>
</head>
<body>
    <jsp:include page="header.jsp"></jsp:include>

    <div class="content">
        <table class="table table-hover">
            <thead>
                <tr>
                    <th scope="col">STT</th>
                    <th scope="col">Tên khách hàng</th>
                    <th scope="col">Ngày trả</th>
                    <th scope="col">Tổng truyện trả</th>
                    <th scope="col">Tổng tiền</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="detail" items="${detailList}" varStatus="loop">
                    <fmt:formatDate value="${detail.invoiceDate}" var="dateFormat" pattern="dd-MM-yyyy HH:mm:ss" />
                    <tr>
                        <th scope="row"><span>${loop.index + 1}</span></th>
                        <td><span>${detail.userName}</span></td>
                        <td><span>${dateFormat}</span></td>
                        <td><span>${detail.rentTotal}</span></td>
                        <td><span>${detail.costTotal}</span></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>

    <jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
