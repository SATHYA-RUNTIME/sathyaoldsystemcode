<html>

<head>
    <link rel="stylesheet" href="index.css">
</head>

<body>
    <div id="top">People's Hospital +   <a id="hf" href="register.jsp">Register</a></div>
    <div id="contain">
        <h2 id="h">Log In
            <hr>
        </h2>
        <br>
        <form action="/serv1" method="post">
            <label for="">Username/user Id</label><br>
            <input id="ipt" type="text" placeholder="Username or UserID" name="un" required><br>
            <label for="">password</label><br>
            <input id="ipt" type="password" placeholder="password" name="ps" required><br>
            <input id="btn" type="submit" value="Login">
        </form>

    </div>
</body>

</html>