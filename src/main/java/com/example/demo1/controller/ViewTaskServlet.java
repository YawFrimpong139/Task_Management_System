package com.example.demo1.controller;

import com.example.demo1.dao.TaskDAO;
import com.example.demo1.model.Task;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "ViewTaskServlet", value = "/tasks/view")
public class ViewTaskServlet extends HttpServlet {
    private static final Logger logger = Logger.getLogger(ViewTaskServlet.class.getName());
    private TaskDAO taskDAO;

    @Override
    public void init() {
        taskDAO = new TaskDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            // 1. Validate presence of ID parameter
            String idParam = request.getParameter("id");
            if (idParam == null || idParam.trim().isEmpty()) {
                logger.warning("Missing ID parameter in request");
                handleError(request, response, "Task ID is required",
                        HttpServletResponse.SC_BAD_REQUEST);
                return;
            }

            // 2. Validate ID format
            int id;
            try {
                id = Integer.parseInt(idParam.trim());
            } catch (NumberFormatException e) {
                logger.warning("Invalid ID format: " + idParam);
                handleError(request, response, "Task ID must be a number",
                        HttpServletResponse.SC_BAD_REQUEST);
                return;
            }

            // 3. Retrieve task
            Optional<Task> taskOptional = taskDAO.getTaskById(id);
            if (taskOptional.isEmpty()) {
                logger.warning("Task not found with ID: " + id);
                handleError(request, response, "Task not found with ID: " + id,
                        HttpServletResponse.SC_NOT_FOUND);
                return;
            }

            // 4. Display task
            request.setAttribute("task", taskOptional.get());
            request.getRequestDispatcher("/views/view-task.jsp").forward(request, response);

        } catch (Exception e) {
            logger.log(Level.SEVERE, "Unexpected error", e);
            handleError(request, response, "An unexpected error occurred",
                    HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }

    private void handleError(HttpServletRequest request, HttpServletResponse response,
                             String message, int statusCode) throws IOException, ServletException {
        response.setStatus(statusCode);

        // Check if this is an AJAX request
        if ("XMLHttpRequest".equals(request.getHeader("X-Requested-With"))) {
            response.setContentType("application/json");
            response.getWriter().write("{\"error\":\"" + message + "\"}");
        } else {
            // Forward to error page for regular requests
            request.setAttribute("errorMessage", message);
            request.setAttribute("statusCode", statusCode);
            request.getRequestDispatcher("/views/error.jsp").forward(request, response);
        }
    }
}