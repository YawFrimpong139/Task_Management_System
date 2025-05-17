<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Task Manager</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
<div class="container">
    <h1><a href="${pageContext.request.contextPath}/hello" class="task-title">Task Manager</a></h1>
    <a href="${pageContext.request.contextPath}/tasks/add" class="btn btn-primary">Add New Task</a>

    <!-- Filter and Sort Form -->
    <form method="get" action="${pageContext.request.contextPath}/tasks" class="filter-form">
        <label for="status">Filter by Status:</label>
        <select name="status" id="status">
            <option value="All" ${selectedStatus == 'All' ? 'selected' : ''}>All</option>
            <option value="Pending" ${selectedStatus == 'Pending' ? 'selected' : ''}>Pending</option>
            <option value="Completed" ${selectedStatus == 'Completed' ? 'selected' : ''}>Completed</option>
        </select>

        <label for="sort">Sort by Due Date:</label>
        <select name="sort" id="sort">
            <option value="ASC" ${selectedSort == 'ASC' ? 'selected' : ''}>Oldest First</option>
            <option value="DESC" ${selectedSort == 'DESC' ? 'selected' : ''}>Newest First</option>
        </select>

        <button type="submit" class="btn btn-secondary">Apply</button>
    </form>

    <table class="task-table">
        <thead>
        <tr>
            <th>ID</th>
            <th>Title</th>
            <th>Due Date</th>
            <th>Status</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="task" items="${tasks}">
            <tr>
                <td>${task.id}</td>
                <td>${task.title}</td>
                <td>${task.dueDate}</td>
                <td><span class="status-badge ${task.status.toLowerCase()}">${task.status}</span></td>
                <td>
                    <a href="${pageContext.request.contextPath}/tasks/view?id=${task.id}" class="btn btn-view">View</a>
                    <a href="${pageContext.request.contextPath}/tasks/edit?id=${task.id}" class="btn btn-edit">Edit</a>
                    <form action="${pageContext.request.contextPath}/tasks/delete" method="post" style="display:inline;">
                        <input type="hidden" name="id" value="${task.id}">
                        <button type="submit" class="btn btn-delete" onclick="return confirm()">Delete</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<script src="${pageContext.request.contextPath}/js/script.js"></script>
</body>
</html>




<%--&lt;%&ndash;--%>
<%--  Created by IntelliJ IDEA.--%>
<%--  User: User--%>
<%--  Date: 5/16/2025--%>
<%--  Time: 9:57 PM--%>
<%--  To change this template use File | Settings | File Templates.--%>
<%--&ndash;%&gt;--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>--%>
<%--<!DOCTYPE html>--%>
<%--<html>--%>
<%--<head>--%>
<%--    <title>Task Manager</title>--%>
<%--    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">--%>
<%--</head>--%>
<%--<body>--%>
<%--<div class="container">--%>
<%--    <h1><a href="${pageContext.request.contextPath}/hello" class="task-title">Task Manager</a></h1>--%>
<%--    <a href="${pageContext.request.contextPath}/tasks/add" class="btn btn-primary">Add New Task</a>--%>

<%--    <table class="task-table">--%>
<%--        <thead>--%>
<%--        <tr>--%>
<%--            <th>ID</th>--%>
<%--            <th>Title</th>--%>
<%--            <th>Due Date</th>--%>
<%--            <th>Status</th>--%>
<%--            <th>Actions</th>--%>
<%--        </tr>--%>
<%--        </thead>--%>
<%--        <tbody>--%>
<%--        <c:forEach var="task" items="${tasks}">--%>
<%--            <tr>--%>
<%--                <td>${task.id}</td>--%>
<%--                <td>${task.title}</td>--%>
<%--                <td>${task.dueDate}</td>--%>
<%--                <td><span class="status-badge ${task.status.toLowerCase()}">${task.status}</span></td>--%>
<%--                <td>--%>
<%--                    <a href="${pageContext.request.contextPath}/tasks/view?id=${task.id}" class="btn btn-view">View</a>--%>
<%--                    <a href="${pageContext.request.contextPath}/tasks/edit?id=${task.id}" class="btn btn-edit">Edit</a>--%>
<%--                    <form action="${pageContext.request.contextPath}/tasks/delete" method="post" style="display:inline;">--%>
<%--                        <input type="hidden" name="id" value="${task.id}">--%>
<%--                        <button type="submit" class="btn btn-delete" onclick="return confirm()">Delete</button>--%>
<%--                    </form>--%>
<%--                </td>--%>
<%--            </tr>--%>
<%--        </c:forEach>--%>
<%--        </tbody>--%>
<%--    </table>--%>
<%--</div>--%>
<%--<script src="${pageContext.request.contextPath}/js/script.js"></script>--%>
<%--</body>--%>
<%--</html>--%>
