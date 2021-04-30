<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<%@include file="head.jsp"%>
</head>
<body>
<%@include file="navbar.jsp"%>

<div class="mt-3">
    <h2>Search Results: </h2>
        <table class="table mt-3">
            <c:forEach items="${games}" var="game">
                    <tr>
                        <td>${game.imagePth}</td>
                        <td>${game.title}</td>
                        <td>${game.description}</td>
                    </tr>
            </c:forEach>
            <tr><td>${newValue}</td></tr>
        </table>
</div>

</body>
</html>
