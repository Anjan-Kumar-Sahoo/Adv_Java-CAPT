<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login - Spring is Fun</title>
<style>
    body {
        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        background-color: #f0f4f8;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
        margin: 0;
    }
    .login-card {
        background: white;
        padding: 2rem;
        border-radius: 12px;
        box-shadow: 0 10px 25px rgba(0,0,0,0.1);
        width: 350px;
        text-align: center;
    }
    .header {
        background: linear-gradient(135deg, #2ecc71, #3498db);
        color: white;
        padding: 1rem;
        border-radius: 8px;
        margin-bottom: 1.5rem;
    }
    h2 { margin: 0; font-size: 1.2rem; }
    p { color: #666; font-size: 0.9rem; }
    input[type="text"], input[type="password"] {
        width: 100%;
        padding: 10px;
        margin: 10px 0;
        border: 1px solid #ddd;
        border-radius: 5px;
        box-sizing: border-box;
    }
    button {
        background-color: #2ecc71;
        color: white;
        border: none;
        padding: 10px 20px;
        border-radius: 5px;
        cursor: pointer;
        width: 100%;
        font-weight: bold;
        transition: background 0.3s;
    }
    button:hover { background-color: #27ae60; }
    .fun-text { color: #3498db; font-weight: bold; margin-top: 15px; display: block;}
</style>
</head>
<body>
    <div class="login-card">
        <div class="header">
            <h2>Welcome Back!</h2>
        </div>
        <form action="login" method="post">
            <input type="text" name="username" placeholder="Username" required>
            <input type="password" name="password" placeholder="Password" required>
            <button type="submit">Login</button>
        </form>
        <span class="fun-text">Learning Spring is Fun! 🍃</span>
    </div>
</body>
</html>