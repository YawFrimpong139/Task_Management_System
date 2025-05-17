<%--
  Created by IntelliJ IDEA.
  User: User
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
    <title>Task Details</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
<div class="container">
    <h1>Task Details</h1>

    <div class="task-details">
        <div class="detail-row">
            <span class="detail-label">ID:</span>
            <span class="detail-value">${task.id}</span>
        </div>
        <div class="detail-row">
            <span class="detail-label">Title:</span>
            <span class="detail-value">${task.title}</span>
        </div>
        <div class="detail-row">
            <span class="detail-label">Description:</span>
            <span class="detail-value">${task.description}</span>
        </div>
        <div class="detail-row">
            <span class="detail-label">Due Date:</span>
            <span class="detail-value"><fmt:formatDate value="${task.dueDate}" pattern="MMM dd, yyyy" /></span>
        </div>
        <div class="detail-row">
            <span class="detail-label">Status:</span>
            <span class="detail-value status-badge ${task.status.toLowerCase()}">${task.status}</span>
        </div>
    </div>

    <div class="action-buttons">
        <a href="${pageContext.request.contextPath}/tasks/edit?id=${task.id}" class="btn btn-edit">Edit</a>
        <form action="${pageContext.request.contextPath}/tasks/delete" method="post" style="display:inline;">
            <input type="hidden" name="id" value="${task.id}">
            <button type="submit" class="btn btn-delete" onclick="return confirm('Are you sure?')">Delete</button>
        </form>
        <a href="${pageContext.request.contextPath}/tasks" class="btn btn-cancel">Back to List</a>
    </div>
</div>
</body>
</html>
