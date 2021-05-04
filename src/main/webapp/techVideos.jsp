<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 3/20/21
  Time: 2:26 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="head.jsp"%>
</head>
<body>
<%@ include file="navbar.jsp"%>
<div class="container mt-3">
    <table class="table mt-3">
        <c:forEach var="tech" items="${techniques}">
            <tr class="clickable-row border-bottom-1 border-dark" data-href="videos/tech/${tech.id}">
                <td><img src="${tech.game.imagePth}" alt="gameImage.png" /></td>
                <td><a href="games/${tech.game.id}">${tech.game.title}</a></td>
                <td>${tech.title}</td>
                <td><a href="profiles/${tech.user.userName}">${tech.user.userName}</a></td>
                <td>${tech.description}</td>
                <td>${fn:substring(tech.submissionDate, 0, 10)}</td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
