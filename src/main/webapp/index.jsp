<%@ page import="persistance.GenericDao" %>
<%@ page import="entity.Run" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%

        GenericDao dao = new GenericDao(Run.class);
        List<Run> runs = dao.getAll();
        request.setAttribute("runs", runs);
%>

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

    <main>
        <section>
            <h2>Top Runs</h2>
            <table></table>
        </section>
        <section>
            <h2>Latest Runs</h2>
            <table>
                <c:forEach var="recentRuns" items="${runs}">
                    <tr><td>Run: ${recentRuns.id}</td></tr>
                </c:forEach>
            </table>
        </section>
    </main>

</body>
</html>
