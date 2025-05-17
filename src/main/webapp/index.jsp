<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <meta name="description" content="Task Manager - Organize your tasks efficiently and boost productivity" />
    <title>Welcome | Task Manager</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
</head>
<body class="bg-gray">
<header class="header">
    <div class="container header-container">
        <div class="logo">Task Manager</div>
    </div>
</header>

<main>
    <!-- Hero Section -->
    <section class="hero-section">
        <div class="container text-center">
            <h1 class="hero-title">Welcome to Task Manager</h1>
            <p class="hero-description">
                Manage your tasks efficiently, stay organized, and boost your productivity with our simple yet powerful task management solution.
            </p>
            <a href="${pageContext.request.contextPath}/tasks" class="w-btn">Get Started</a>
        </div>
    </section>

    <!-- Features Section -->
    <section class="features-section">
        <div class="container">
            <h2 class="features-title">Key Features</h2>

            <div class="features-grid">
                <div class="feature-card">
                    <div class="icon">🗂</div>
                    <h3 class="feature-heading">Task Organization</h3>
                    <p class="feature-description">Create, organize, and prioritize your tasks with our intuitive interface.</p>
                </div>

                <div class="feature-card">
                    <div class="icon">⏰</div>
                    <h3 class="feature-heading">Reminders</h3>
                    <p class="feature-description">Never miss a deadline with customizable reminders and notifications.</p>
                </div>

                <div class="feature-card">
                    <div class="icon">📈</div>
                    <h3 class="feature-heading">Progress Tracking</h3>
                    <p class="feature-description">Track your productivity and visualize your accomplishments over time.</p>
                </div>
            </div>
        </div>
    </section>
</main>

<footer class="footer">
    <div class="container text-center">
        <p>&copy; 2025 Task Manager. All rights reserved.</p>
        <div class="footer-links">
            <a href="#">Privacy Policy</a>
            <a href="#">Terms of Service</a>
            <a href="#">Contact Us</a>
        </div>
    </div>
</footer>
</body>
</html>
