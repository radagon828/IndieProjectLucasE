<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <title>Home</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
<%@ include file="navbar.jsp"%>
<div class="submitContent">
    <form id="signUpForm" method="post" action="submitRun">
        <p>* denotes a required field</p>
        <p>
            <label for="username">UserName* (min 4 characters))</label>
            <input id="username" name="username" minlength="4" type="text" required>
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
</div>
</body>
</html>