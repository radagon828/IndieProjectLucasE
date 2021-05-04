<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <%@include file="head.jsp"%>
    <script src="js/jquery.validate.js"></script>
    <script src="js/submit-up.js"></script>
</head>
<body>
<%@ include file="navbar.jsp"%>
<div class="container">
    <div class="row">
        <div class="col-sm-6 mx-auto mt-2">
            <h3>Submit Run for ${game.title}</h3>
            <form id="submitRunForm" method="post" action="submitRun">
                <input id="gameId" name="gameId" type="number" value="${game.id}" required hidden>
                <p>* denotes a required field</p>
                <div class="form-group">
                    <label for="category">Run Category*</label>
                    <select id="category" name="category" class="form-control">
                        <c:forEach var="category" items="${game.categories}">
                            <option value="${category.categoryId}">${category.categoryName}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group">
                    <label for="platform">Platform*</label>
                    <input id="platform" type="platform" name="platform" required>
                </div>
                <div class="form-group">
                    <label for="time">Run Time(enter time in this format (HH:mm:ss))*</label>
                    <input id="time" name="time" type="time" required>
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