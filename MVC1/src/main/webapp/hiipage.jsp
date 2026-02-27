<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home - Spring is Fun</title>
<style>
    body {
        font-family: 'Segoe UI', sans-serif;
        background-color: #f4f7f6;
        text-align: center;
        padding-top: 50px;
    }
    h1 { color: #2c3e50; }
    
    .btn {
        display: inline-block;
        padding: 12px 30px;
        margin: 10px;
        font-size: 16px;
        font-weight: bold;
        text-decoration: none;
        border-radius: 25px;
        transition: transform 0.2s, box-shadow 0.2s;
    }
    .btn:hover { transform: translateY(-2px); box-shadow: 0 5px 15px rgba(0,0,0,0.1); }
    
    .btn-login {
        background-color: #2ecc71; /* Green */
        color: white;
    }
    .btn-logout {
        background-color: #3498db; /* Blue */
        color: white;
    }
</style>
</head>
<body>
    <h1>Hii Kaha apne -- Dur Raho --- Niklo  yahan se : Byye</h1>
    <p>Learning Spring is Fun!</p>
    <a href="login.jsp" class="btn btn-login">Login</a>
    <a href="logout.jsp" class="btn btn-logout">Logout</a>
</body>
</html>