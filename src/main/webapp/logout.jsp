<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 3/20/21
  Time: 2:35 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="head.jsp"%>
</head>
<body>
<%@ include file="navbar.jsp"%>
<%@ page session="true"%>

User '<%=request.getRemoteUser()%>' has been logged out.

<p></p>
<% session.invalidate(); %>
</body>
</html>
