//package com.example.demo1;
//
//import jakarta.servlet.*;
//import jakarta.servlet.http.*;
//import jakarta.servlet.annotation.*;
//
//import java.io.IOException;
//
//@WebServlet(name = "WelcomeServlet", value = {"/", "/welcome"})
//public class WelcomeServlet extends HttpServlet {
//
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//
//        // Check if user is already authenticated (optional)
////        HttpSession session = request.getSession(false);
////        if (session != null && session.getAttribute("user") != null) {
////            // If logged in, redirect to tasks page
////            response.sendRedirect(request.getContextPath() + "/tasks");
////            return;
////        }
//
//        // Forward to the welcome page
//        request.getRequestDispatcher("/index.jsp").forward(request, response);
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        // Handle any POST requests if needed
//        doGet(request, response);
//    }
//}

package com.example.demo1;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "WelcomeServlet", value = "/hello")
public class WelcomeServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        // Forward the request to index.jsp
        RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
        dispatcher.forward(request, response);
    }
}
