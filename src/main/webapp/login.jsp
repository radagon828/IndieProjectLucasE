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
    <div class="container mt-2">

            <FORM ACTION="j_security_check" METHOD="POST">
                <TABLE>
                    <div class="form-group">
                        <TR><TD>User name: <INPUT TYPE="TEXT" NAME="j_username" /></TD></TR>
                    </div>
                    <div class="form-group">
                        <TR><TD>Password: <INPUT TYPE="PASSWORD" NAME="j_password" /></TD></TR>
                    </div>
                    <div class="form-group">
                        <TR><TH><INPUT TYPE="SUBMIT" VALUE="Log In">
                    </div>
                </TABLE>
            </FORM>

    </div>
</body>
</html>
