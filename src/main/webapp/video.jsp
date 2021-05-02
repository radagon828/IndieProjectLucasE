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
        <div class="col-sm-8" mx-auto mt-2>
            <iframe src="${videoDisplay.videoLink}" title="Video">
            </iframe>
        </div>
<%--        </c:if>--%>
    </div>
</div>
</body>
</html>