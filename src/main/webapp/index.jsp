<%@ page import="persistance.GenericDao" %>
<%@ page import="entity.Run" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="myTitle" value="Home" />
<%

        GenericDao dao = new GenericDao(Run.class);
        List<Run> runs = dao.getAll();

        request.setAttribute("runs", runs);
%>

<html lang="en">

<%@include file="head.jsp"%>

<body>
    <%@ include file="navbar.jsp"%>

    <main>
        <section>
            <h2>Top Runs</h2>
            <table></table>
        </section>
        <section>
            <h2>Latest Runs</h2>
            <table>
                <c:forEach var="recentRuns" items="${runs}">
                    <tr><td>${recentRuns.toString()}</td></tr>
                </c:forEach>
            </table>
        </section>
    </main>

</body>
</html>
