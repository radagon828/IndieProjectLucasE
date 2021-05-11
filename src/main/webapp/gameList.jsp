<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<%@include file="head.jsp"%>
<body>
<%@ include file="navbar.jsp"%>
<div class="mt-3">
    <div class="container-fluid">
        <div class="row">
            <c:forEach var="game" items="${games}">
                <div class="col-sm-4 mt-3">
                    <div class="card clickable-row" data-href="games/${game.id}">
                        <div class="card-body mx-auto">
                            <img src="${game.imagePth}" alt="gameImage.png" width="200">
                            <h4 class="card-title">${game.title}</h4>
                            <p class="card-text">${game.description}</p>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</div>
</body>
</html>