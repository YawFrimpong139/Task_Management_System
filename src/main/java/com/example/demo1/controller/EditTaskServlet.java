package com.example.demo1.controller;



import com.example.demo1.dao.TaskDAO;
import com.example.demo1.model.Task;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "EditTaskServlet", value = "/tasks/edit")
public class EditTaskServlet extends HttpServlet {
    private TaskDAO taskDAO;

    @Override
    public void init() {
        taskDAO = new TaskDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Task task = taskDAO.getTaskById(id).orElseThrow(() ->
                new ServletException("Task not found with ID: " + id));

        request.setAttribute("task", task);
        request.getRequestDispatcher("/views/edit-task.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        String dueDateStr = request.getParameter("dueDate");
        String status = request.getParameter("status");

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date dueDate = sdf.parse(dueDateStr);

            Task task = new Task(id, title, description, dueDate, status);
            taskDAO.updateTask(task);

            response.sendRedirect(request.getContextPath() + "/tasks");
        } catch (ParseException e) {
            throw new ServletException("Error parsing date", e);
        }
    }
}
