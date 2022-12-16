<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %><html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="index.css">
    <script src="display1.js"></script>
</head>
<body >
    <div id="top"><p id="status"></p> People's Hospital
        <!-- <h3 id="name"> <font color="white"> Hi,${uname1}</font> <a href="/">Logout</a></h3> -->

    </div>
    <div id="contain1">
        <h1 >Account Register 
            <hr>
        </h1>
        <br>
        <form action="/dserv" method="post">
            <font color="yellow" size="5px" bgcolor="white">${checkname}</font><br>
            <input id="ipt1" type="text" placeholder="Patient Name" name="p_name" required><br>
            
            <input id="ipt1" type="password" placeholder="password" name="psword" required><br>
            <input id="ipt1" type="email" placeholder="Mail Id" name="mail" required><br>
            <input id="ipt1" type="text" placeholder="Contact " name="contact" required><br>
            <input id="ipt1" type="text" placeholder="Address" name="address" required><br>

            <input id="btn1" type="submit" value="Register">
        </form>

    </div>
    
</body>
</html>