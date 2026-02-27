<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Operation Result - EMS</title>
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
            display: flex;
            align-items: center;
            justify-content: center;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        }
        .main-container {
            background: white;
            border-radius: 15px;
            box-shadow: 0 10px 40px rgba(0,0,0,0.2);
            padding: 40px;
            max-width: 800px;
            width: 100%;
        }
        .success-header {
            background: linear-gradient(135deg, #10b981 0%, #059669 100%);
            color: white;
            padding: 30px;
            border-radius: 10px;
            margin-bottom: 30px;
            text-align: center;
            box-shadow: 0 4px 15px rgba(16, 185, 129, 0.3);
        }
        .update-header {
            background: linear-gradient(135deg, #3b82f6 0%, #2563eb 100%);
            color: white;
            padding: 30px;
            border-radius: 10px;
            margin-bottom: 30px;
            text-align: center;
            box-shadow: 0 4px 15px rgba(59, 130, 246, 0.3);
        }
        .delete-header {
            background: linear-gradient(135deg, #ef4444 0%, #dc2626 100%);
            color: white;
            padding: 30px;
            border-radius: 10px;
            margin-bottom: 30px;
            text-align: center;
            box-shadow: 0 4px 15px rgba(239, 68, 68, 0.3);
        }
        .header h1 {
            margin: 0;
            font-weight: 700;
            font-size: 2.5rem;
        }
        .details-card {
            background: #f8fafc;
            border-radius: 10px;
            padding: 30px;
            margin-bottom: 30px;
            box-shadow: 0 2px 8px rgba(0,0,0,0.05);
        }
        .detail-row {
            display: flex;
            padding: 15px 0;
            border-bottom: 1px solid #e2e8f0;
        }
        .detail-row:last-child {
            border-bottom: none;
        }
        .detail-label {
            font-weight: 600;
            color: #475569;
            width: 150px;
            flex-shrink: 0;
        }
        .detail-value {
            color: #1e293b;
            font-size: 1.05rem;
        }
        .nav-buttons {
            display: grid;
            grid-template-columns: repeat(3, 1fr);
            gap: 15px;
        }
        a {
            cursor: pointer;
        }
        .nav-btn {
            padding: 15px 25px;
            border-radius: 8px;
            border: none;
            font-weight: 600;
            text-decoration: none;
            text-align: center;
            transition: all 0.3s;
            display: flex;
            align-items: center;
            justify-content: center;
            gap: 8px;
            color: white;
        }
        .nav-btn-home {
            background: linear-gradient(135deg, #3b82f6 0%, #2563eb 100%);
            box-shadow: 0 4px 10px rgba(59, 130, 246, 0.3);
        }
        .nav-btn-add {
            background: linear-gradient(135deg, #10b981 0%, #059669 100%);
            box-shadow: 0 4px 10px rgba(16, 185, 129, 0.3);
        }
        .nav-btn-list {
            background: linear-gradient(135deg, #8b5cf6 0%, #7c3aed 100%);
            box-shadow: 0 4px 10px rgba(139, 92, 246, 0.3);
        }
        .nav-btn:hover {
            transform: translateY(-2px);
            box-shadow: 0 6px 15px rgba(0,0,0,0.2);
            color: white;
        }
        .success-icon {
            font-size: 4rem;
            margin-bottom: 15px;
        }
        .message {
            font-size: 1.1rem;
            margin-top: 10px;
            opacity: 0.95;
        }
    </style>
</head>
<body>
    <div class="main-container">
        <c:choose>
            <c:when test="${action == 'save'}">
                <div class="success-header">
                    <div class="success-icon">✅</div>
                    <h1>Employee Added Successfully!</h1>
                    <p class="message">New employee has been added to the system</p>
                </div>
            </c:when>
            <c:when test="${action == 'update'}">
                <div class="update-header">
                    <div class="success-icon">✏️</div>
                    <h1>Employee Updated Successfully!</h1>
                    <p class="message">Employee details have been updated</p>
                </div>
            </c:when>
            <c:when test="${action == 'delete'}">
                <div class="delete-header">
                    <div class="success-icon">🗑️</div>
                    <h1>Employee Deleted Successfully!</h1>
                    <p class="message">Employee has been removed from the system</p>
                </div>
            </c:when>
        </c:choose>
        
        <c:if test="${not empty employee && action != 'delete'}">
            <div class="details-card">
                <h3 style="color: #1e40af; margin-bottom: 20px; font-weight: 700;">📋 Employee Details</h3>
                
                <div class="detail-row">
                    <div class="detail-label">🆔 Employee ID:</div>
                    <div class="detail-value"><strong>${employee.id}</strong></div>
                </div>
                
                <div class="detail-row">
                    <div class="detail-label">👤 Name:</div>
                    <div class="detail-value">${employee.name}</div>
                </div>
                
                <div class="detail-row">
                    <div class="detail-label">🏢 Department:</div>
                    <div class="detail-value">${employee.department}</div>
                </div>
                
                <div class="detail-row">
                    <div class="detail-label">💰 Salary:</div>
                    <div class="detail-value">$${employee.salary}</div>
                </div>
                
                <div class="detail-row">
                    <div class="detail-label">📞 Phone:</div>
                    <div class="detail-value">${employee.phone}</div>
                </div>
                
                <div class="detail-row">
                    <div class="detail-label">✉️ Email:</div>
                    <div class="detail-value">${employee.email}</div>
                </div>
            </div>
        </c:if>
        
        <c:if test="${action == 'delete'}">
            <div class="details-card">
                <h3 style="color: #dc2626; margin-bottom: 20px; font-weight: 700;">ℹ️ Deletion Information</h3>
                <p style="color: #64748b; font-size: 1.05rem;">
                    Employee with ID <strong>${employeeId}</strong> has been permanently removed from the database.
                </p>
            </div>
        </c:if>
        
        <div class="nav-buttons">
            <a href="${contextPath}/home" class="nav-btn nav-btn-home">
                🏠 Go to Home
            </a>
            <a href="${contextPath}/add" class="nav-btn nav-btn-add">
                ➕ Add Another
            </a>
            <a href="${contextPath}/home" class="nav-btn nav-btn-list">
                📋 View All
            </a>
        </div>
    </div>
</body>
</html>
