package com.example.demo1.controller;



import com.example.demo1.dao.TaskDAO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DeleteTaskServlet", value = "/tasks/delete")
public class DeleteTaskServlet extends HttpServlet {
    private TaskDAO taskDAO;

    @Override
    public void init() {
        taskDAO = new TaskDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        taskDAO.deleteTask(id);
        response.sendRedirect(request.getContextPath() + "/tasks");
    }
}
