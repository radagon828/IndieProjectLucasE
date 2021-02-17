<html lang="en">
<head>
    <title>Home</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
<%@ include file="navbar.jsp"%>
<div class="submitContent">
    <form method="post">
        <label for="time">Category</label>
        <input type="text" name="time" id="time"><br />
        <label for="videoLink">Video Link*</label>
        <input type="text" name="videoLink" id="videoLink"><br />
        <input type="submit" value="Submit Run">
    </form>
</div>
</body>
</html>