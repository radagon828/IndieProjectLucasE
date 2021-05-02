<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <%@ include file="head.jsp"%>
</head>
<body>
<%@ include file="navbar.jsp"%>
<div class="container">
    <div class="row">
<%--        <c:if test="${videoDisplay.title}">--%>
        <div class="mx-auto mt-2">
            <iframe src="${videoDisplay.videoLink}"
                    width="80%"
                    allowfullscreen="<allowfullscreen>">>
            </iframe>
        </div>
<%--        </c:if>--%>
    </div>
</div>
</body>
</html>