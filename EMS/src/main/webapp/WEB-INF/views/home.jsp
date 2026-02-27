<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Employee Management System</title>
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
            max-width: 1400px;
            margin: 0 auto;
        }
        .main-container {
            background: white;
            border-radius: 20px;
            box-shadow: 0 20px 60px rgba(0,0,0,0.3);
            overflow: hidden;
        }
        .header {
            background: linear-gradient(135deg, #2563eb 0%, #1e40af 100%);
            color: white;
            padding: 40px 50px;
            position: relative;
            overflow: hidden;
        }
        .header::before {
            content: '';
            position: absolute;
            top: -50%;
            right: -10%;
            width: 400px;
            height: 400px;
            background: rgba(255,255,255,0.1);
            border-radius: 50%;
        }
        .header::after {
            content: '';
            position: absolute;
            bottom: -30%;
            left: -5%;
            width: 300px;
            height: 300px;
            background: rgba(255,255,255,0.05);
            border-radius: 50%;
        }
        .header-content {
            position: relative;
            z-index: 1;
        }
        .header h1 {
            margin: 0;
            font-weight: 800;
            font-size: 2.8rem;
            text-shadow: 2px 2px 4px rgba(0,0,0,0.2);
            letter-spacing: -0.5px;
        }
        .header p {
            margin: 10px 0 0 0;
            opacity: 0.95;
            font-size: 1.15rem;
            font-weight: 300;
        }
        .stats-bar {
            background: linear-gradient(90deg, #f0f9ff 0%, #e0f2fe 100%);
            padding: 25px 50px;
            border-bottom: 2px solid #e0e7ff;
        }
        .stat-item {
            display: inline-block;
            margin-right: 40px;
        }
        .stat-number {
            font-size: 2rem;
            font-weight: 800;
            color: #1e40af;
            display: block;
        }
        .stat-label {
            color: #64748b;
            font-size: 0.9rem;
            font-weight: 600;
            text-transform: uppercase;
            letter-spacing: 0.5px;
        }
        .content-section {
            padding: 40px 50px;
        }
        .nav-buttons {
            display: grid;
            grid-template-columns: repeat(3, 1fr);
            gap: 20px;
            margin-bottom: 35px;
        }
        .nav-btn {
            padding: 15px 25px;
            border-radius: 10px;
            border: none;
            font-weight: 600;
            text-decoration: none;
            text-align: center;
            transition: all 0.3s;
            display: inline-block;
            font-size: 1rem;
            box-shadow: 0 4px 15px rgba(0,0,0,0.1);
            cursor: pointer;
        }
        .nav-btn-home {
            background: linear-gradient(135deg, #3b82f6 0%, #2563eb 100%);
            color: white;
        }
        .nav-btn-add {
            background: linear-gradient(135deg, #10b981 0%, #059669 100%);
            color: white;
        }
        .nav-btn-refresh {
            background: linear-gradient(135deg, #f59e0b 0%, #d97706 100%);
            color: white;
        }
        .nav-btn:hover {
            transform: translateY(-3px);
            box-shadow: 0 8px 25px rgba(0,0,0,0.2);
            color: white;
        }
        .table-container {
            background: white;
            border-radius: 15px;
            overflow: hidden;
            box-shadow: 0 4px 20px rgba(0,0,0,0.08);
        }
        table {
            margin: 0;
            width: 100%;
            border-collapse: collapse;
        }
        thead {
            background: linear-gradient(135deg, #3b82f6 0%, #2563eb 100%);
            color: white;
        }
        thead th {
            border: none;
            padding: 18px 20px;
            font-weight: 700;
            text-transform: uppercase;
            letter-spacing: 1px;
            font-size: 0.85rem;
            text-align: left;
        }
        tbody tr {
            transition: all 0.2s;
            border-bottom: 1px solid #f1f5f9;
        }
        tbody tr:hover {
            background: linear-gradient(90deg, #eff6ff 0%, #dbeafe 100%);
            transform: scale(1.005);
        }
        tbody tr:last-child {
            border-bottom: none;
        }
        tbody td {
            padding: 18px 20px;
            vertical-align: middle;
            color: #334155;
            font-size: 0.95rem;
        }
        tbody td:first-child {
            font-weight: 700;
            color: #1e40af;
            font-size: 1.05rem;
        }
        .btn-edit {
            background: linear-gradient(135deg, #3b82f6 0%, #2563eb 100%);
            border: none;
            color: white;
            padding: 10px 24px;
            border-radius: 8px;
            font-weight: 600;
            transition: all 0.2s;
            margin-right: 8px;
            font-size: 0.9rem;
        }
        .btn-edit:hover {
            transform: translateY(-2px);
            box-shadow: 0 6px 15px rgba(59, 130, 246, 0.4);
            color: white;
        }
        .btn-delete {
            background: linear-gradient(135deg, #ef4444 0%, #dc2626 100%);
            border: none;
            color: white;
            padding: 10px 24px;
            border-radius: 8px;
            font-weight: 600;
            transition: all 0.2s;
            font-size: 0.9rem;
        }
        .btn-delete:hover {
            transform: translateY(-2px);
            box-shadow: 0 6px 15px rgba(239, 68, 68, 0.4);
            color: white;
        }
        .no-data {
            text-align: center;
            padding: 60px;
            color: #64748b;
        }
        .no-data h3 {
            font-size: 1.5rem;
            margin-bottom: 10px;
            color: #475569;
        }
        .no-data p {
            font-size: 1.05rem;
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="main-container">
            <div class="header">
                <div class="header-content">
                    <h1>🏢 Employee Management System</h1>
                    <p>Manage your workforce efficiently and effectively</p>
                </div>
            </div>
            
            <div class="stats-bar">
                <div class="stat-item">
                    <span class="stat-number">${employees.size()}</span>
                    <span class="stat-label">Total Employees</span>
                </div>
                <div class="stat-item">
                    <span class="stat-number">📊</span>
                    <span class="stat-label">Active Records</span>
                </div>
            </div>
            
            <div class="content-section">
                <!-- Navigation Buttons -->
                <div class="nav-buttons">
                    <a href="${contextPath}/home" class="nav-btn nav-btn-home">
                        🏠 Home
                    </a>
                    <a href="${contextPath}/add" class="nav-btn nav-btn-add">
                        ➕ Add Employee
                    </a>
                    <a href="${contextPath}/home" class="nav-btn nav-btn-refresh">
                        🔄 Refresh List
                    </a>
                </div>
                
                <div class="table-container">
                    <c:choose>
                        <c:when test="${not empty employees}">
                            <table>
                                <thead>
                                    <tr>
                                        <th>ID</th>
                                        <th>Name</th>
                                        <th>Department</th>
                                        <th>Salary</th>
                                        <th>Phone</th>
                                        <th>Email</th>
                                        <th>Actions</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="emp" items="${employees}">
                                        <tr>
                                            <td>${emp.id}</td>
                                            <td><strong>${emp.name}</strong></td>
                                            <td>${emp.department}</td>
                                            <td>$${emp.salary}</td>
                                            <td>${emp.phone}</td>
                                            <td>${emp.email}</td>
                                            <td>
                                                <a href="${contextPath}/edit?id=${emp.id}" class="btn-edit">
                                                    ✏️ Edit
                                                </a>
                                                <a href="${contextPath}/delete?id=${emp.id}" 
                                                   class="btn-delete"
                                          	      onclick="return confirm('Are you sure you want to delete ${emp.name}?')">
                                                    🗑️ Delete
                                                </a>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </c:when>
                        <c:otherwise>
                            <div class="no-data">
                                <h3>📋 No Employees Found</h3>
                                <p>Start by adding your first employee to the system!</p>
                            </div>
                        </c:otherwise>
                    </c:choose>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
