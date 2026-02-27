<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Logged Out</title>
<style>
    body {
        font-family: 'Segoe UI', sans-serif;
        background: linear-gradient(to bottom right, #ebf5fb, #e8f8f5);
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
        margin: 0;
    }
    .logout-container {
        text-align: center;
        background: white;
        padding: 3rem;
        border-radius: 50%;
        width: 300px;
        height: 300px;
        display: flex;
        flex-direction: column;
        justify-content: center;
        box-shadow: 0 4px 15px rgba(0,0,0,0.05);
        border: 4px solid #3498db;
    }
    h1 { color: #2ecc71; margin-bottom: 10px; }
    p { color: #5dade2; font-style: italic; }
    .btn-back {
        text-decoration: none;
        color: #7f8c8d;
        font-size: 0.8rem;
        margin-top: 20px;
    }
    .btn-back:hover { color: #3498db; }
</style>
</head>
<body>
    <div class="logout-container">
        <h1>Success!</h1>
        <p>You have logged out.</p>
        <div style="font-weight: bold; color: #34495e;">
            Learning Spring is Fun!
        </div>
        <a href="hi" class="btn-back">Return to Home</a>
    </div>
</body>
</html>