package com.example.demo1.controller;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;



import com.example.demo1.dao.TaskDAO;
import com.example.demo1.model.Task;
import jakarta.servlet.*;
//import javax.servlet.http.*;
//import javax.servlet.annotation.*;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "AddTaskServlet", value = "/tasks/add")
public class AddTaskServlet extends HttpServlet {
    private TaskDAO taskDAO;

    @Override
    public void init() {
        taskDAO = new TaskDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/views/add-task.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        String dueDateStr = request.getParameter("dueDate");
        String status = request.getParameter("status");

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date dueDate = sdf.parse(dueDateStr);

            Task newTask = new Task();
            newTask.setTitle(title);
            newTask.setDescription(description);
            newTask.setDueDate(dueDate);
            newTask.setStatus(status);

            taskDAO.addTask(newTask);
            response.sendRedirect(request.getContextPath() + "/tasks");
        } catch (ParseException e) {
            throw new ServletException("Error parsing date", e);
        }
    }
}
