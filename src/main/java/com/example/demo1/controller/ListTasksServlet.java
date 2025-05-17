package com.example.demo1.controller;



import com.example.demo1.dao.TaskDAO;
import com.example.demo1.model.Task;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ListTasksServlet", value = "/tasks")
public class ListTasksServlet extends HttpServlet {
    private TaskDAO taskDAO;

    @Override
    public void init() {
        taskDAO = new TaskDAO();
    }

//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        List<Task> tasks = taskDAO.getAllTasks();
//        request.setAttribute("tasks", tasks);
//        request.getRequestDispatcher("/views/list-tasks.jsp").forward(request, response);
//    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String statusFilter = request.getParameter("status");
        String sortOrder = request.getParameter("sort");

        if (statusFilter == null || statusFilter.isEmpty()) {
            statusFilter = "All";
        }
        if (sortOrder == null || sortOrder.isEmpty()) {
            sortOrder = "ASC";
        }

        List<Task> tasks = taskDAO.getFilteredAndSortedTasks(statusFilter, sortOrder);

        request.setAttribute("tasks", tasks);
        request.setAttribute("selectedStatus", statusFilter);
        request.setAttribute("selectedSort", sortOrder);

        request.getRequestDispatcher("/views/list-tasks.jsp").forward(request, response);
    }


}