<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Employee - EMS</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
            min-height: 100vh;
            padding: 20px 0;
        }
        .main-container {
            background: white;
            border-radius: 15px;
            box-shadow: 0 10px 40px rgba(0,0,0,0.2);
            padding: 40px;
            margin: 50px auto;
            max-width: 700px;
        }
        .header {
            background: linear-gradient(135deg, #2563eb 0%, #1e40af 100%);
            color: white;
            padding: 25px;
            border-radius: 10px;
            margin-bottom: 30px;
            text-align: center;
            box-shadow: 0 4px 15px rgba(37, 99, 235, 0.3);
        }
        .header h2 {
            margin: 0;
            font-weight: 700;
            font-size: 2rem;
        }
        .form-label {
            font-weight: 600;
            color: #1e40af;
            margin-bottom: 8px;
            font-size: 0.95rem;
        }
        .form-control {
            border: 2px solid #e0e7ff;
            border-radius: 8px;
            padding: 12px 15px;
            transition: all 0.3s;
        }
        .form-control:focus {
            border-color: #3b82f6;
            box-shadow: 0 0 0 0.2rem rgba(59, 130, 246, 0.25);
        }
        .form-group {
            margin-bottom: 20px;
        }
        .btn-submit {
            background: linear-gradient(135deg, #10b981 0%, #059669 100%);
            border: none;
            color: white;
            padding: 14px 40px;
            border-radius: 8px;
            font-weight: 600;
            font-size: 1.1rem;
            width: 100%;
            transition: all 0.3s;
            box-shadow: 0 4px 15px rgba(16, 185, 129, 0.3);
        }
        .btn-submit:hover {
            transform: translateY(-2px);
            box-shadow: 0 6px 20px rgba(16, 185, 129, 0.4);
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
                <h2>➕ Add New Employee</h2>
                <p style="margin: 5px 0 0 0; opacity: 0.9;">Fill in the employee details</p>
            </div>
            
            <!-- Navigation Buttons -->
            <div class="nav-buttons">
                <a href="${contextPath}/home" class="nav-btn nav-btn-home">🏠 Home</a>
                <a href="${contextPath}/home" class="nav-btn nav-btn-list">📋 View All Employees</a>
            </div>
            
            <form action="${contextPath}/save" method="post">
                <div class="form-group">
                    <label class="form-label">👤 Full Name</label>
                    <input type="text" class="form-control" name="name" required 
                           placeholder="Enter employee name">
                </div>
                
                <div class="form-group">
                    <label class="form-label">🏢 Department</label>
                    <input type="text" class="form-control" name="department" required 
                           placeholder="Enter department">
                </div>
                
                <div class="form-group">
                    <label class="form-label">💰 Salary</label>
                    <input type="number" class="form-control" name="salary" step="0.01" required 
                           placeholder="Enter salary">
                </div>
                
                <div class="form-group">
                    <label class="form-label">📞 Phone Number</label>
                    <input type="number" class="form-control" name="phone" required 
                           placeholder="Enter phone number">
                </div>
                
                <div class="form-group">
                    <label class="form-label">✉️ Email Address</label>
                    <input type="email" class="form-control" name="email" required 
                           placeholder="Enter email address">
                </div>
                
                <div class="button-group">
                    <a href="${contextPath}/home" class="btn btn-back">
                        ← Back to List
                    </a>
                    <button type="submit" class="btn btn-submit">
                        💾 Save Employee
                    </button>
                </div>
            </form>
        </div>
    </div>
    
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
