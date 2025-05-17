<%--
  Created by IntelliJ IDEA.
  User: Yaw Frimpong
  Date: 5/16/2025
  Time: 9:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add New Task</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
<div class="container">
    <h1>Add New Task</h1>
    <form action="${pageContext.request.contextPath}/tasks/add" method="post">
        <div class="form-group">
            <label for="title">Title:</label>
            <input type="text" id="title" name="title" required>
        </div>
        <div class="form-group">
            <label for="description">Description:</label>
            <textarea id="description" name="description" rows="4"></textarea>
        </div>
        <div class="form-group">
            <label for="dueDate">Due Date:</label>
            <input type="date" id="dueDate" name="dueDate" required>
        </div>
        <div class="form-group">
            <label for="status">Status:</label>
            <select id="status" name="status" required>
                <option value="Pending">Pending</option>
                <option value="In Progress">In Progress</option>
                <option value="Completed">Completed</option>
            </select>
        </div>
        <div class="form-actions">
            <button type="submit" class="btn btn-primary">Save Task</button>
            <a href="${pageContext.request.contextPath}/tasks" class="btn btn-cancel">Cancel</a>
        </div>
    </form>
</div>
</body>
</html>
