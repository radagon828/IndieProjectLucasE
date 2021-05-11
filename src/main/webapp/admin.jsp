<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page import="entity.Run" %>
<%@ page import="java.util.List" %>
<%@ page import="persistance.GenericDao" %><%--
  Created by IntelliJ IDEA.
  User: student
  Date: 3/17/21
  Time: 2:42 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%

    GenericDao runDao = new GenericDao(Run.class);
    List<Run> runs = runDao.getByString("approval", "0");


    request.setAttribute("runs", runs);
%>
<html>
<head>
    <%@include file="head.jsp"%>
</head>
<body>
<%@ include file="navbar.jsp"%>
<h3>Unapproved runs</h3>
<div class="container-fluid mt-3">
    <div class="row">
        <div class="col-sm-6 mt-2">
            <div class="panel panel-default bg-light">
                <div class="panel-heading">Latest Techniques</div>
                <div class="panel-body">
                    <table class="table">
                        <c:forEach var="run" items="${runs}">
                            <tr class="clickable-row small border-bottom-1 border-dark" data-href="videos/run/${recentRun.id}">
                                <td><img src="${run.game.imagePth}" alt="gameImage.png" /></td>
                                <td><a href="games/${run.game.id}">${run.game.title}</a></td>
                                <td>${run.category.categoryName}</td>
                                <td><a href="profiles/${run.user.userName}">${run.user.userName}</a></td>
                                <td>${run.time}</td>
                                <td>${fn:substring(run.date, 0, 10)}</td>
                                <td>
                                    <form method="post" action="approve">
                                        <input id="runId" name="runId" type="number" value="${run.id}" required hidden>
                                        <input class="submit" type="submit" value="Approve?">
                                    </form>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
