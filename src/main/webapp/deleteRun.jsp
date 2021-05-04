<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 5/4/21
  Time: 3:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="head.jsp"%>
</head>
<body>
<%@ include file="navbar.jsp"%>
<h2>Are you sure you want to delete this run</h2>
<form id="deleteForm" method="post" action="deleteRun">
    <input id="runId" name="runId" value="${runId}" hidden />
    <div class="form-group">
        <input type="radio" id="yes" name="confirm" value="yes" />
        <label for="yes">Yes</label>
        <input type="radio" id="no" name="confirm" value="no" />
        <label for="no">No</label>
    </div>
    <p>
        <input class="submit" type="submit" value="Submit">
    </p>
</form>
</body>
</html>
