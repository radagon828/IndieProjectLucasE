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
<script src="js/jquery.validate.js"></script>
<script src="js/sign-up.js"></script>
<body>
<%@ include file="navbar.jsp"%>
<div class="panel panel-default bg-light m-2">
    <form id="signUpForm" method="post" action="editProfile">
        <input id="userIdTwo" name="userId" minlength="4" type="text" value="${profile.id}" required hidden>
        <input id="editFieldEmail" name="editField" value="email" hidden>
        <p>
            <label for="email">Change E-Mail - Current: ${profile.userEmail}</label><br>
            <input id="email" type="email" name="email" required>
        </p>
        <p>
            <input class="submit" type="submit" value="Submit">
        </p>
    </form>
</div>
<div class="panel panel-default bg-light m-2">
    <form id="signUpFormTwo" method="post" action="editProfile">
        <input id="userIdThree" name="userId" minlength="4" type="text" value="${profile.id}" required hidden>
        <input id="editFieldPass" name="editField" value="pass" hidden>
        <p>Change Password</p>
        <div class="form-group">
            <label for="password">New Password</label>
            <input id="password" name="password" type="password" required>
        </div>
        <div class="form-group">
            <label for="confirm_password">Confirm New Password</label>
            <input id="confirm_password" name="confirm_password" type="password" required>
        </div>
        <p>
            <input class="submit" type="submit" value="Submit">
        </p>
    </form>
</div>
</body>
</html>
