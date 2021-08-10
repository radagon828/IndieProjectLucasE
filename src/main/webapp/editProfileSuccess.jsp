<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 8/10/21
  Time: 12:34 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="head.jsp"%>
</head>
<body>
<%@ include file="navbar.jsp"%>
<p>Your Profile was changed! Go back to <a href="profiles/${pageContext.request.remoteUser}">profile page?</a>a></p>
</body>
</html>