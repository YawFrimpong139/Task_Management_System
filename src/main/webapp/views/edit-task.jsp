<%--
  Created by IntelliJ IDEA.
  User: Yaw Frimpong
  Date: 5/16/2025
  Time: 9:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <title>Edit Task</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
<div class="container">
    <h1><a href="${pageContext.request.contextPath}/tasks" class="task-title">Edit Task</a></h1>
    <form action="${pageContext.request.contextPath}/tasks/edit" method="post">
        <input type="hidden" name="id" value="${task.id}">

        <div class="form-group">
            <label for="title">Title:</label>
            <input type="text" id="title" name="title" value="${task.title}" required>
        </div>
        <div class="form-group">
            <label for="description">Description:</label>
            <textarea id="description" name="description" rows="4">${task.description}</textarea>
        </div>
        <div class="form-group">
            <label for="dueDate">Due Date:</label>
            <input type="date" id="dueDate" name="dueDate"
                   value="<fmt:formatDate value='${task.dueDate}' pattern='yyyy-MM-dd' />" required>
        </div>
        <div class="form-group">
            <label for="status">Status:</label>
            <select id="status" name="status" required>
                <option value="Pending" ${task.status == 'Pending' ? 'selected' : ''}>Pending</option>
                <option value="In Progress" ${task.status == 'In Progress' ? 'selected' : ''}>In Progress</option>
                <option value="Completed" ${task.status == 'Completed' ? 'selected' : ''}>Completed</option>
            </select>
        </div>
        <div class="form-actions">
            <button type="submit" class="btn btn-primary">Update Task</button>
            <a href="${pageContext.request.contextPath}/tasks" class="btn btn-cancel">Cancel</a>
        </div>
    </form>
</div>
</body>
</html>
