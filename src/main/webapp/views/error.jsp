<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 5/16/2025
  Time: 10:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <title>Error ${statusCode}</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
<div class="container">
  <h1>Error ${statusCode}</h1>
  <div class="error-message">
    <p>${errorMessage}</p>
    <c:if test="${statusCode == 404}">
      <p>The requested resource was not found.</p>
    </c:if>
    <c:if test="${statusCode == 400}">
      <p>Please check your request and try again.</p>
    </c:if>
  </div>
  <a href="${pageContext.request.contextPath}/tasks" class="btn btn-primary">
    Back to Task List
  </a>
</div>
</body>
</html>
</html>
