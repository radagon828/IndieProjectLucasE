<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<header>
<nav class="navbar navbar-expand-sm navbar-light bg-danger">
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse mx-0" id="navbarNavDropdown">
        <div class="navbar-header">
            <a class="navbar-brand text-light" href="index.jsp">ScaryGames.com</a>
        </div>
        <ul class="nav navbar-nav">
            <li class="nav-item"><a class="nav-link text-light" href="games">Games List</a></li>
            <li class="nav-item"><a class="nav-link text-light" href="techniques">Tech Videos</a></li>
        </ul>
            <form class="form-inline my-2 my-lg-0" name="searchData" action="searchGame" method="get">
                <input class="form-control mr-sm-2" type="text" name="searchValue" id="searchValue">
                <button class="btn btn-outline-dark bg-light my-2 my-sm-0 mx-1 text-dark" type="submit">Search</button>
            </form>
        <c:choose>
            <c:when test="${pageContext.request.isUserInRole('admin')}">
                <ul class="nav navbar-nav">
                    <li class="nav-item"><a class="nav-link text-light" href="logout.jsp">Logout</a></li>
                    <li class="nav-item"><a class="nav-link text-light" href="admin.jsp">Admin</a></li>
                </ul>
            </c:when>
            <c:when test="${pageContext.request.isUserInRole('user')}">
                <ul class="nav navbar-nav">
                    <li class="nav-item"><a class="nav-link text-light" href="logout.jsp">Logout</a></li>
                </ul>
            </c:when>
            <c:otherwise>
                <ul class="nav navbar-nav">
                    <li class="nav-item"><a class="nav-link text-light" href="loginAction">Log In</a></li>
                    <li class="nav-item"><a class="nav-link text-light" href="signUp.jsp">Sign Up</a></li>
                </ul>
            </c:otherwise>
        </c:choose>
    </div>
</nav>
</header>