<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 5/2/21
  Time: 12:02 AM
  To change this template use File | Settings | File Templates.
--%>
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
                    <table>
                        <c:forEach var="run" items="${runs}">
                            <tr class="clickable-row" data-href="videos/run/${run.id}">
                                <td><img src="${run.game.imagePth}" alt="gameImage.png" /></td>
                                <td>${run.game.title}</td>
                                <td>${run.category}</td>
                                <td>${run.time}</td>
                                <td>${run.date}</td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
                <div class="tab-pane fade" id="tech" role="tabpanel" aria-labelledby="tech-tab">
                    <table>
                        <c:forEach var="tech" items="${techniques}">
                            <tr class="clickable-row" data-href="videos/tech/${tech.id}">
                                <td><img src="${tech.game.imagePth}" alt="gameImage.png" /></td>
                                <td>${tech.game.title}</td>
                                <td>${tech.title}</td>
                                <td>${tech.description}</td>
                                <td>${tech.submissionDate}</td>
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
