package com.iesemilidarder.projectozero.web;

import com.sun.org.apache.regexp.internal.RE;
import com.iesemilidarder.projectozero.core.ReadRestaurant;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class ShowRestaurantServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");
        ReadRestaurant readRestaurant = new ReadRestaurant();
        request.setAttribute("id", readRestaurant.readDB(id));
        request.getRequestDispatcher("showRestaurant.jsp").forward(request, response);
    }
}
