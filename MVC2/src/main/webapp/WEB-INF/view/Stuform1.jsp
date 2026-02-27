<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Details - Spring MVC</title>
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
        width: 400px;
        border-top: 5px solid #2ecc71; /* Green Accent */
    }
    h2 {
        color: #3498db; /* Blue Accent */
        text-align: center;
        margin-bottom: 20px;
    }
    .input-group {
        margin-bottom: 15px;
    }
    label {
        display: block;
        font-weight: bold;
        color: #34495e;
        margin-bottom: 5px;
    }
    input[type="text"], input[type="number"] {
        width: 100%;
        padding: 10px;
        border: 1px solid #dcdde1;
        border-radius: 5px;
        box-sizing: border-box;
    }
    input:focus {
        outline: none;
        border-color: #3498db;
        box-shadow: 0 0 5px rgba(52, 152, 219, 0.3);
    }
    button {
        background-color: #2ecc71;
        color: white;
        border: none;
        padding: 12px;
        border-radius: 5px;
        width: 100%;
        font-size: 16px;
        font-weight: bold;
        cursor: pointer;
        transition: background 0.3s;
        margin-top: 10px;
    }
    button:hover {
        background-color: #27ae60;
    }
    .fun-footer {
        text-align: center;
        font-size: 0.8rem;
        color: #7f8c8d;
        margin-top: 15px;
    }
</style>
</head>
<body>

<div class="form-container">
    <h2>Student Registration</h2>
    <form action="processForm" method="post">
        <div class="input-group">
            <label>Full Name</label>
            <input type="text" name="name" placeholder="Enter name" required>
        </div>
        <div class="input-group">
            <label>Address</label>
            <input type="text" name="address" placeholder="City/State">
        </div>
        <div class="input-group">
            <label>CGPA</label>
            <input type="text" name="cgpa" placeholder="e.g. 9.2" required>
        </div>
        
        <div class="input-group">
            <label>Student ID</label>
            <input type="text" name="id" placeholder="ID Number" required>
        </div>

        <div class="input-group">
            <label>College Name</label>
            <input type="text" name="collegeName" placeholder="University name">
        </div>
        <button type="submit">Submit Details</button>
    </form>
    <div class="fun-footer">Learning Spring is Fun! 🍃</div>
</div>

</body>
</html>