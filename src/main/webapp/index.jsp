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

    <div class="mt-3">
        <div class="container-fluid">
            <div class="row">
                <div class="col-sm-6 mt-2">

                <h2>Latest Techniques</h2>
                <table>
                    <c:forEach var="recentTech" items="${techniques}">
                        <tr><td>${recentTech.toString()}</td></tr>
                    </c:forEach>
                </table>
                </div>
                <div class="col-sm-6 mt-2">
                <h2>Latest Runs</h2>
                <table>
                    <c:forEach var="recentRun" items="${runs}">
                        <tr><td>${recentRun.toString()}</td></tr>
                    </c:forEach>
                </table>
                </div>
            </div>
        </div>
    </div>

</body>
</html>
