<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 5/2/21
  Time: 12:02 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="head.jsp"%>
</head>

<body>
<%@ include file="navbar.jsp"%>
<p>This is a profile page</p>

<tr><td>${profile.toString()}</td></tr>
</body>
</html>
