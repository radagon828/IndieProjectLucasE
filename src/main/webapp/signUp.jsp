<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 3/20/21
  Time: 2:21 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@ include file="head.jsp"%>
<body>
<%@ include file="navbar.jsp"%>

<h2>Sign Up Form</h2>
<form id="signUpForm" method="post" action="/signUp">
    <p>* denotes a required field</p>
    <p>
        <label for="username">UserName* (min 4 characters))</label>
        <input id="username" name="name" minlength="4" type="text" required>
    </p>
    <p>
        <label for="email">E-Mail*</label>
        <input id="email" type="email" name="email" required>
    </p>
    <p>
        <label for="password">Password*</label>
        <input id="password" name="password" type="password" required>
    </p>
    <p>
        <label for="confirm_password">Confirm password*</label>
        <input id="confirm_password" name="confirm_password" type="password" required>
    </p>
    <p>
        <input class="submit" type="submit" value="Submit">
    </p>
</form>
</body>
</html>
