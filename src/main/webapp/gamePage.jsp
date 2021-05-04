<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html lang="en">
<head>
<%@include file="head.jsp"%>
</head>
<body>
    <%@ include file="navbar.jsp"%>
    <main class="container-fluid mt-2">
        <div class="row">
            <section class="col-sm-4">
                <div class="panel panel-default bg-light">
                    <div class="panel-heading">${game.title}</div>
                    <div class="panel-body">
                        <img src="${game.imagePth}" alt="${game.imagePth}.png"/>
                        <p>${game.description}</p>
                    </div>
                </div>
            </section>
            <section class="col-sm-8">
                <ul class="nav nav-tabs" id="myTab" role="tablist">
                    <c:forEach var="category" items="${categories}">
                        <li class="nav-item">
                            <a class="nav-link text-info" id="${category.categoryNameCon}-tab" data-toggle="tab" href="#${category.categoryNameCon}" role="tab">${category.categoryName}</a>
                        </li>
                    </c:forEach>
                        <li class="nav-item">
                            <a class="nav-link text-info" id="techniques-tab" data-toggle="tab" href="#techniques" role="tab">Techniques</a>
                        </li>
                </ul>
                <div class="tab-content" id="myTabContent">
                    <c:forEach var="content" items="${categoriesTwo}">
                        <div class="tab-pane fade" id="${content.categoryNameCon}" role="tabpanel">
                            <ul class="nav navbar-nav">
                                <li class="nav-item">
                                    <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#${content.categoryNameCon}Modal">
                                        View Rules
                                    </button>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link text-light" href="games/${game.id}/submitRun">Submit Run</a>
                                </li>
                            </ul>
                            <!-- Modal -->
                            <div class="modal fade" id="${content.categoryNameCon}Modal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                <div class="modal-dialog" role="document">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <h5 class="modal-title" id="exampleModalLabel">Rules</h5>
                                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                <span aria-hidden="true">&times;</span>
                                            </button>
                                        </div>
                                        <div class="modal-body">
                                            ${content.categoryRules}
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <table class="table">
                                <tr>
                                    <th>Runner</th>
                                    <th>Time</th>
                                    <th>Platform</th>
                                    <th>Submission Date</th>
                                </tr>
                                <c:forEach var="run" items="${content.runs}">
                                    <tr class="clickable-row border-bottom-1 border-dark" data-href="videos/run/${run.id}">
                                        <td>${run.user.userName}</td>
                                        <td>${run.time}</td>
                                        <td>${run.platform}</td>
                                        <td>${fn:substring(run.date, 0, 10)}</td>
                                    </tr>
                                </c:forEach>
                            </table>
                        </div>
                    </c:forEach>
                    <div class="tab-pane fade" id="techniques" role="tabpanel">
                        <table class="table">
                            <tr>
                                <th>Title</th>
                                <th>Runner</th>
                                <th>Description</th>
                                <th>Submission Date</th>
                            </tr>
                            <c:forEach var="tech" items="${game.techniques}">
                                <tr class="clickable-row border-bottom-1 border-dark" data-href="videos/tech/${tech.id}">
                                    <td>${tech.title}</td>
                                    <td><a href="profiles/${tech.user.userName}">${tech.user.userName}</a></td>
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