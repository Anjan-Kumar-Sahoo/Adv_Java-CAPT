<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Search Student - Spring MVC</title>
<style>
    body {
        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        background: linear-gradient(135deg, #e8f8f5 0%, #ebf5fb 100%);
        display: flex;
        justify-content: center;
        align-items: center;
        min-height: 100vh;
        margin: 0;
    }
    .form-container {
        background: white;
        padding: 30px;
        border-radius: 15px;
        box-shadow: 0 8px 20px rgba(0,0,0,0.1);
        width: 350px;
        border-top: 5px solid #3498db; /* Blue Accent for Search */
    }
    h2 {
        color: #2c3e50;
        text-align: center;
        margin-bottom: 25px;
    }
    .input-group {
        margin-bottom: 20px;
    }
    label {
        display: block;
        font-weight: bold;
        color: #34495e;
        margin-bottom: 8px;
    }
    input[type="text"] {
        width: 100%;
        padding: 12px;
        border: 1px solid #dcdde1;
        border-radius: 5px;
        box-sizing: border-box;
        font-size: 14px;
    }
    input:focus {
        outline: none;
        border-color: #3498db;
        box-shadow: 0 0 5px rgba(52, 152, 219, 0.3);
    }
    button {
        background-color: #3498db;
        color: white;
        border: none;
        padding: 12px;
        border-radius: 5px;
        width: 100%;
        font-size: 16px;
        font-weight: bold;
        cursor: pointer;
        transition: all 0.3s ease;
    }
    button:hover {
        background-color: #2980b9;
        transform: translateY(-1px);
    }
    .back-link {
        display: block;
        text-align: center;
        margin-top: 20px;
        text-decoration: none;
        color: #7f8c8d;
        font-size: 0.9rem;
    }
    .back-link:hover {
        color: #3498db;
    }
</style>
</head>
<body>

<div class="form-container">
    <h2>Find Student</h2>
    <form action="findStudent" method="get">
        <div class="input-group">
            <label for="studentId">Enter Student ID</label>
            <input type="text" id="studentId" name="id" placeholder="Enter ID (e.g. 101)" required>
        </div>
        
        <button type="submit">Search Record</button>
    </form>
    
    <a href="stuform" class="back-link">← Back to Registration</a>
</div>

</body>
</html>