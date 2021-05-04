<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <%@include file="head.jsp"%>
    <script src="js/jquery.validate.js"></script>
    <script src="js/submit-run.js"></script>
</head>
<body>
<%@ include file="navbar.jsp"%>
<div class="container">
    <div class="row">
        <div class="col-sm-6 mx-auto mt-2">
            <h3>Submit Technique ${game.title}</h3>
            <form id="submitTechForm" method="post" action="submitTech">
                <input id="gameId" name="gameId" type="number" value="${game.id}" required hidden>
                <p>* denotes a required field</p>
                <div class="form-group">
                    <label for="videoTitle">Title*</label>
                    <input id="videoTitle" type="videoTitle" name="platform" required>
                </div>
                <div class="form-group">
                    <label for="description">Description</label>
                    <input id="description" name="description"  required>
                </div>
                <div class="form-group">
                    <label for="videoLink">Embedded Youtube Link*</label>
                    <input id="videoLink" name="videoLink" type="videoLink" required>
                </div>
                <p>
                    <input class="submit" type="submit" value="Submit">
                </p>
            </form>
        </div>
    </div>
</div>
</body>
</html>