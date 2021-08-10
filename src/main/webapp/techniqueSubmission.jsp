<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <%@include file="head.jsp"%>
    <script src="js/jquery.validate.js"></script>
    <script src="js/submit-tech.js"></script>
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
                    <input id="videoTitle" type="videoTitle" name="videoTitle" required>
                </div>
                <div class="form-group">
                    <label for="videoType">Type*</label>
                    <select id="videoType" name="videoType" type="videoType" class="form-control">
                        <option value="a single trick">A single trick</option>
                        <option value="walkthrough">Walkthrough</option>
                    </select>
                </div>
                <div class="form-group">
                    <label for="description">Description</label>
                    <input id="description" name="description" type="description" required>
                </div>
                <div class="form-group">
                    <label for="videoLink">Embedded Youtube Link*</label>
                    <input id="videoLink" name="videoLink" hidden>
                    <input id="videoLinkRaw" name="videoLinkRaw" type="videoLink" required>
                </div>

                <p>
                    <input type="button" onclick="convertUrl()" value="Submit" />
                </p>
            </form>
        </div>
    </div>
</div>
</body>
<script>
    function getId(url) {
        const regExp = /^.*(youtu.be\/|v\/|u\/\w\/|embed\/|watch\?v=|&v=)([^#&?]*).*/;
        const match = url.match(regExp);

        return (match && match[2].length === 11)
            ? match[2]
            : null;
    }

    function convertUrl() {
        let rawUrlField = document.getElementById("videoLinkRaw").value;
        let videoId = getId(rawUrlField);
        let embeddedUrl = "//www.youtube.com/embed/" + videoId;
        document.getElementById("videoLink").value = embeddedUrl;

        document.getElementById("submitRunForm").submit();
    }
</script>
</html>