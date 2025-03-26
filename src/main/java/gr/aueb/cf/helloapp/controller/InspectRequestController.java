package gr.aueb.cf.helloapp.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("inspect-request")
public class InspectRequestController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.getWriter().write("Session id: " + req.getSession());

        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("JSESSIONID")) {
                    resp.getWriter().write("Cookie name: " + cookie.getName() + " , Cookie Value: " + cookie.getValue() + "\n");
                }
            }
        }

        resp.getWriter().write("Request URI: " + req.getRequestURI() + "\n");
        resp.getWriter().write("Request Context Path: " + req.getContextPath() + "\n");
        resp.getWriter().write("Request Servlet Path: " + req.getServletPath() + "\n");
    }
}
