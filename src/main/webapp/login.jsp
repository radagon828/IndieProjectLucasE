<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 3/16/21
  Time: 10:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="head.jsp"%>
</head>
<body>
    <%@ include file="navbar.jsp"%>
    <div class="panel panel-default bg-light m-2">
            <FORM ACTION="j_security_check" METHOD="POST" id="loginForm">
                <TABLE>
                    <div class="form-group">
                        <TR><TD>User name: <INPUT TYPE="TEXT" NAME="j_username" /></TD></TR>
                    </div>
                    <div class="form-group">
                        <INPUT TYPE="PASSWORD" NAME="j_password" id="jPass" hidden />
                        <TR><TD>Password: <INPUT TYPE="PASSWORD" NAME="raw_password" id="rawPass"/></TD></TR>
                    </div>
                    <div class="form-group">
                        <TR><TH><INPUT TYPE="button" onclick="encryptPassword()" VALUE="Log In">
                    </div>
                </TABLE>
            </FORM>

    </div>
</body>
<script>
    function encryptPassword() {
        let rawPassField = document.getElementById("rawPass").value;
        let conPass = MD5(rawPassField);
        document.getElementById("jPass").value = conPass;

        document.getElementById("loginForm").submit();
    }
</script>
</html>
