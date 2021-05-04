<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <%@ include file="head.jsp"%>
</head>
<body>
<%@ include file="navbar.jsp"%>
<div class="container">
    <div align="center">
            <iframe src="${videoDisplay.videoLink}"
                    width="80%"
                    height="80%"
                    allowfullscreen="<allowfullscreen>"
                    class="mx-auto mt-2">
            </iframe>
    </div>

</div>
</body>
</html>