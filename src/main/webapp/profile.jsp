<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <%@include file="head.jsp"%>
</head>

<body>
<%@ include file="navbar.jsp"%>
<main class="container-fluid mt-2">
    <div class="row">
        <section class="col-sm-4">
            <div class="panel panel-default bg-light">
                <div class="panel-heading">${profile.userName}</div>
                <div class="panel-body">
                    <p>${profile.userEmail}</p>
                    <c:if test="${profile.userName == pageContext.request.remoteUser}">
                        <p><a href="profiles/${profile.userName}/editProfile">Edit Profile</a></p>
                    </c:if>
                </div>
            </div>
        </section>
        <section class="col-sm-8">
            <ul class="nav nav-tabs" id="myTab" role="tablist">
                <li class="nav-item">
                    <a class="nav-link active text-info" id="runs-tab" data-toggle="tab" href="#runs" role="tab" aria-controls="runs" aria-selected="true">Runs</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link text-info" id="tech-tab" data-toggle="tab" href="#tech" role="tab" aria-controls="tech" aria-selected="false">Techniques</a>
                </li>
            </ul>
            <div class="tab-content" id="myTabContent">
                <div class="tab-pane fade show active" id="runs" role="tabpanel" aria-labelledby="run-tab">
                    <table class="table">
                        <c:forEach var="run" items="${runs}">
                            <tr class="clickable-row border-bottom-1 border-dark" data-href="videos/run/${run.id}">
                                <td><img src="${run.game.imagePth}" alt="gameImage.png" /></td>
                                <td><a href="games/${run.game.id}">${run.game.title}</a></td>
                                <td>${run.category.categoryName}</td>
                                <td>${run.time}</td>
                                <td>${fn:substring(run.date, 0, 10)}</td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
                <div class="tab-pane fade" id="tech" role="tabpanel" aria-labelledby="tech-tab">
                    <table class="table">
                        <c:forEach var="tech" items="${techniques}">
                            <tr class="clickable-row border-bottom-1 border-dark" data-href="videos/tech/${tech.id}">
                                <td><img src="${tech.game.imagePth}" alt="gameImage.png" /></td>
                                <td><a href="games/${tech.game.id}">${tech.game.title}</a></td>
                                <td>${tech.title}</td>
                                <td>${tech.description}</td>
                                <td>${fn:substring(tech.submissionDate, 0, 10)}</td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
            </div>
        </section>
    </div>
</main>
</body>
</html>
