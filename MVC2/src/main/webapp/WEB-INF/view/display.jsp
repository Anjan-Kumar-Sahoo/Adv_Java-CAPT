<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome ${s.name}</title>
<style>
    body {
        font-family: 'Segoe UI', sans-serif;
        background-color: #f0f7f4;
        display: flex;
        justify-content: center;
        padding-top: 50px;
        margin: 0;
    }
    .profile-card {
        background: white;
        border-radius: 15px;
        box-shadow: 0 10px 30px rgba(0,0,0,0.1);
        width: 450px;
        overflow: hidden;
        border: 1px solid #d1e7dd;
    }
    .welcome-header {
        background: linear-gradient(135deg, #2ecc71, #3498db);
        color: white;
        padding: 30px;
        text-align: center;
    }
    .welcome-header h1 {
        margin: 0;
        font-size: 1.8rem;
    }
    .data-section {
        padding: 20px;
    }
    .data-row {
        display: flex;
        justify-content: space-between;
        padding: 12px 0;
        border-bottom: 1px solid #eee;
    }
    .label { font-weight: bold; color: #2c3e50; }
    .value { color: #27ae60; font-weight: 500; }
    .footer {
        text-align: center;
        padding: 15px;
        font-style: italic;
        color: #95a5a6;
        font-size: 0.9rem;
    }
</style>
</head>
<body>

<div class="profile-card">
    <div class="welcome-header">
        <h1>Welcome, ${s.name}!</h1>
        <p>Learning Spring is Fun! 🍃</p>
    </div>
    
    <div class="data-section">
        <div class="data-row">
            <span class="label">Student ID:</span>
            <span class="value">${s.id}</span>
        </div>
        <div class="data-row">
            <span class="label">CGPA:</span>
            <span class="value">${s.cgpa}</span>
        </div>
        <div class="data-row">
            <span class="label">College Name:</span>
            <span class="value">${s.collegeName}</span>
        </div>
        <div class="data-row">
            <span class="label">Address:</span>
            <span class="value">${s.address}</span>
        </div>
    </div>

    <div class="footer">
        Data successfully captured via @ModelAttribute
    </div>
</div>

</body>
</html>