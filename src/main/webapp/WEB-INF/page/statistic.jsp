<%--
  Created by IntelliJ IDEA.
  User: quytn
  Date: 19/11/2018
  Time: 10:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>Thống kê</title>
    <c:set var="category" value="${statList.get(0).category}"/>
</head>
<body>
    <jsp:include page="header.jsp"></jsp:include>
    <div class="content">
        <table class="table table-hover">
            <thead>
                <tr>
                    <th scope="col">STT</th>
                    <th scope="col">Thời gian</th>
                    <th scope="col">Tổng doanh thu</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="stat" items="${statList}" varStatus="loop">
                    <fmt:formatNumber var="costFmt" value="${stat.totalCost}" maxFractionDigits="2" minFractionDigits="2" />
                    <tr>
                        <th scope="row"><span>${loop.index + 1}</span></th>
                        <td>
                            <span>${stat.label}</span>
                            <span style="font-size: 75%;">
                                <c:choose>
                                    <c:when test="${category == 'month'}">
                                        <a href="/statDetail/month?month=${stat.customeDate.month}&year=${stat.customeDate.year}">[Chi tiết]</a>
                                    </c:when>
                                    <c:when test="${category == 'quarter'}">
                                        <a href="/statDetail/quarter?quarter=${stat.customeDate.quarter}&year=${stat.customeDate.year}">[Chi tiết]</a>
                                    </c:when>
                                    <c:when test="${category == 'year'}">
                                        <a href="/statDetail/year?year=${stat.customeDate.year}">[Chi tiết]</a>
                                    </c:when>
                                </c:choose>
                            </span>
                        </td>
                        <td><span>${costFmt}</span></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>

    <jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
