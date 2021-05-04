<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<%@include file="head.jsp"%>
</head>
<body>
<%@include file="navbar.jsp"%>

<div class="mt-3">
    <h2>Search Results: </h2>
    <ul class="nav nav-tabs" id="myTab" role="tablist">
        <li class="nav-item">
            <a class="nav-link active text-info" id="runs-tab" data-toggle="tab" href="#runs" role="tab" aria-controls="runs" aria-selected="true">Game Results</a>
        </li>
        <li class="nav-item">
            <a class="nav-link text-info" id="tech-tab" data-toggle="tab" href="#tech" role="tab" aria-controls="tech" aria-selected="false">Techniques Results</a>
        </li>
    </ul>
    <div class="tab-content" id="myTabContent">
        <div class="tab-pane fade show active" id="runs" role="tabpanel" aria-labelledby="run-tab">
            <table class="table mt-3">
                <c:forEach items="${games}" var="game">
                    <tr class="clickable-row border-bottom-1 border-dark" data-href="games/${game.id}">
                        <td>${game.imagePth}</td>
                        <td>${game.title}</td>
                        <td>${game.description}</td>
                    </tr>
                </c:forEach>
                <tr><td>${newValue}</td></tr>
            </table>
        </div>
        <div class="tab-pane fade" id="tech" role="tabpanel" aria-labelledby="tech-tab">
            <table class="table mt-3">
                <c:forEach var="tech" items="${techniques}">
                    <tr class="clickable-row border-bottom-1 border-dark" data-href="videos/tech/${tech.id}">
                        <td><img src="${tech.game.imagePth}" alt="gameImage.png" /></td>
                        <td><a href="games/${tech.game.id}">${tech.game.title}</a></td>
                        <td>${tech.title}</td>
                        <td>${tech.description}</td>
                        <td>${tech.submissionDate}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>

</div>

</body>
</html>
