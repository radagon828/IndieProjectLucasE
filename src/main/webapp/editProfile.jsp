<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 5/4/21
  Time: 7:43 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<%@include file="head.jsp"%>

<body>
<%@ include file="navbar.jsp"%>
<form id="signUpForm" method="post" action="editProfile">
    <input id="userId" name="userId" minlength="4" type="text" value="${profile.id}" required hidden>
    <p>* denotes a required field</p>
    <p>
        <label for="username">Change UserName</label>
        <input id="username" name="username" minlength="4" type="text" value="${profile.userName}" required>
    </p>
    <p>
        <label for="email">Change E-Mail</label>
        <input id="email" type="email" name="email" value="${profile.userEmail}" required>
    </p>
    <p>
        <input class="submit" type="submit" value="Submit">
    </p>
</form>
</body>
</html>
