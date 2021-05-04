<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <%@ include file="head.jsp"%>
</head>
<body>
<%@ include file="navbar.jsp"%>
<div class="container">

            <iframe src="${videoDisplay.videoLink}"
                    width="80%"
                    height="80%"
                    allowfullscreen="<allowfullscreen>">>
            </iframe>

</div>
</body>
</html>