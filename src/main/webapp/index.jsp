<%@ page import="persistance.GenericDao" %>
<%@ page import="entity.Run" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="entity.Technique" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="myTitle" value="Home" />
<%

        GenericDao runDao = new GenericDao(Run.class);
        List<Run> runs = runDao.getAll();

        GenericDao techDao = new GenericDao(Technique.class);
        List<Technique> techniques = techDao.getAll();

//        runs.subList(10, runs.size()).clear();
//        techniques.subList(10, techniques.size()).clear();

        request.setAttribute("techniques", techniques);
        request.setAttribute("runs", runs);
%>

<html lang="en">
<head>
<%@include file="head.jsp"%>
</head>
<body>
    <%@ include file="navbar.jsp"%>

    <main class="mt-3">
        <div class="container-fluid">
            <div class="row">
                <div class="col-sm-6 mt-2">
                    <div class="panel panel-default">
                        <div class="panel-heading">Latest Techniques</div>
                        <div class="panel-body">
                            <table>
                                <c:forEach var="recentTech" items="${techniques}">
                                    <tr class="clickable-row" data-href="/Videos/tech/${recentTech.id}">
                                        <td>${recentTech.game.imagePth}</td>
                                        <td>${recentTech.game.title}</td>
                                        <td>${recentTech.title}</td>
                                        <td><a href="profiles/${recentTech.user.id}">${recentTech.user.userName}</a></td>
                                        <td>${recentTech.description}</td>
                                        <td>${recentTech.submissionDate}</td>
                                    </tr>
                                </c:forEach>
                            </table>
                        </div>
                    </div>
                </div>
                <div class="col-sm-6 mt-2">
                    <div class="panel panel-default">
                        <div class="panel-heading">Latest Runs</div>
                        <div class="panel-body">
                            <table>
                                <c:forEach var="recentRun" items="${runs}">
                                    <tr><td>${recentRun.toString()}</td></tr>
                                </c:forEach>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </main>

</body>
</html>
<script>

</script>