<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Update Employee - EMS</title>
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }
        body {
            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
            min-height: 100vh;
            padding: 20px;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        }
        .container {
            max-width: 700px;
            margin: 50px auto;
        }
        .main-container {
            background: white;
            border-radius: 15px;
            box-shadow: 0 10px 40px rgba(0,0,0,0.2);
            padding: 40px;
        }
        .header {
            background: linear-gradient(135deg, #f59e0b 0%, #d97706 100%);
            color: white;
            padding: 25px;
            border-radius: 10px;
            margin-bottom: 30px;
            text-align: center;
            box-shadow: 0 4px 15px rgba(245, 158, 11, 0.3);
        }
        .header h2 {
            margin: 0;
            font-weight: 700;
            font-size: 2rem;
        }
        .employee-id-badge {
            background: rgba(255,255,255,0.2);
            padding: 8px 20px;
            border-radius: 20px;
            display: inline-block;
            margin-top: 10px;
            font-weight: 600;
        }
        .form-label {
            font-weight: 600;
            color: #d97706;
            margin-bottom: 8px;
            font-size: 0.95rem;
        }
        .form-control {
            border: 2px solid #fef3c7;
            border-radius: 8px;
            padding: 12px 15px;
            transition: all 0.3s;
        }
        .form-control:focus {
            border-color: #f59e0b;
            box-shadow: 0 0 0 0.2rem rgba(245, 158, 11, 0.25);
        }
        .form-group {
            margin-bottom: 20px;
        }
        .btn-update {
            background: linear-gradient(135deg, #3b82f6 0%, #2563eb 100%);
            border: none;
            color: white;
            padding: 14px 40px;
            border-radius: 8px;
            font-weight: 600;
            font-size: 1.1rem;
            width: 100%;
            transition: all 0.3s;
            box-shadow: 0 4px 15px rgba(59, 130, 246, 0.3);
        }
        .btn-update:hover {
            transform: translateY(-2px);
            box-shadow: 0 6px 20px rgba(59, 130, 246, 0.4);
            color: white;
        }
        .btn-back {
            background: linear-gradient(135deg, #64748b 0%, #475569 100%);
            border: none;
            color: white;
            padding: 14px 40px;
            border-radius: 8px;
            font-weight: 600;
            font-size: 1.1rem;
            width: 100%;
            transition: all 0.3s;
            box-shadow: 0 4px 15px rgba(100, 116, 139, 0.3);
            text-decoration: none;
            display: inline-block;
            text-align: center;
        }
        .btn-back:hover {
            transform: translateY(-2px);
            box-shadow: 0 6px 20px rgba(100, 116, 139, 0.4);
            color: white;
        }
        .button-group {
            display: grid;
            grid-template-columns: 1fr 1fr;
            gap: 15px;
            margin-top: 30px;
        }
        input[type="submit"],
        button {
            cursor: pointer;
        }
        .info-note {
            background: #fef3c7;
            border-left: 4px solid #f59e0b;
            padding: 15px;
            border-radius: 8px;
            margin-bottom: 25px;
            color: #92400e;
        }
        .nav-buttons {
            display: flex;
            gap: 10px;
            margin-bottom: 25px;
            padding: 15px;
            background: #f1f5f9;
            border-radius: 10px;
        }
        .nav-btn {
            flex: 1;
            padding: 12px 20px;
            border-radius: 8px;
            font-weight: 600;
            text-decoration: none;
            text-align: center;
            transition: all 0.3s;
            color: white;
        }
        .nav-btn-home {
            background: linear-gradient(135deg, #3b82f6 0%, #2563eb 100%);
        }
        .nav-btn-add {
            background: linear-gradient(135deg, #10b981 0%, #059669 100%);
        }
        .nav-btn-list {
            background: linear-gradient(135deg, #8b5cf6 0%, #7c3aed 100%);
        }
        .nav-btn:hover {
            transform: translateY(-2px);
            box-shadow: 0 4px 15px rgba(0,0,0,0.2);
            color: white;
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="main-container">
            <div class="header">
                <h2>✏️ Update Employee</h2>
                <p style="margin: 5px 0 0 0; opacity: 0.9;">Modify employee details</p>
                <div class="employee-id-badge">
                    Employee ID: ${employee.id}
                </div>
            </div>
            
            <!-- Navigation Buttons -->
            <div class="nav-buttons">
                <a href="${contextPath}/home" class="nav-btn nav-btn-home">🏠 Home</a>
                <a href="${contextPath}/add" class="nav-btn nav-btn-add">➕ Add New</a>
                <a href="${contextPath}/home" class="nav-btn nav-btn-list">📋 View All</a>
            </div>
            
            <div class="info-note">
                <strong>ℹ️ Note:</strong> All fields below are pre-filled with existing data. Modify as needed.
            </div>
            
            <form action="${contextPath}/update?id=${employee.id}" method="post">
                <div class="form-group">
                    <label class="form-label">👤 Full Name</label>
                    <input type="text" class="form-control" name="name" required 
                           value="${employee.name}" placeholder="Enter employee name">
                </div>
                
                <div class="form-group">
                    <label class="form-label">🏢 Department</label>
                    <input type="text" class="form-control" name="department" required 
                           value="${employee.department}" placeholder="Enter department">
                </div>
                
                <div class="form-group">
                    <label class="form-label">💰 Salary</label>
                    <input type="number" class="form-control" name="salary" step="0.01" required 
                           value="${employee.salary}" placeholder="Enter salary">
                </div>
                
                <div class="form-group">
                    <label class="form-label">📞 Phone Number</label>
                    <input type="number" class="form-control" name="phone" required 
                           value="${employee.phone}" placeholder="Enter phone number">
                </div>
                
                <div class="form-group">
                    <label class="form-label">✉️ Email Address</label>
                    <input type="email" class="form-control" name="email" required 
                           value="${employee.email}" placeholder="Enter email address">
                </div>
                
                <div class="button-group">
                    <a href="${contextPath}/home" class="btn-back">
                        ← Back to List
                    </a>
                    <button type="submit" class="btn-update">
                        💾 Update Employee
                    </button>
                </div>
            </form>
        </div>
    </div>
</body>
</html>
