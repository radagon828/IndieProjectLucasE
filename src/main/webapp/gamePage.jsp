<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<html lang="en">

<%@include file="head.jsp"%>

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
                                    <button type="button" class="btn btn-primary"><a class="nav-link text-light" href="#runsubmit">Tech Videos</a></button>
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
                            <table>
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
                                        <td>${run.date}</td>
                                    </tr>
                                </c:forEach>
                            </table>
                        </div>
                    </c:forEach>
                </div>
            </section>
        </div>
    </main>
</body>
</html>