// LoginServlet.java

package login.controller;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import login.dao.UserDAO;

import java.io.*;

@WebServlet(value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    private final UserDAO userDAO = new UserDAO();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        boolean isValidUser = userDAO.isValidUser(username, password);

        if (isValidUser) {
            request.setAttribute("message", "Login successful!");
            request.getRequestDispatcher("bookList.jsp").forward(request, response);
        } else {
            request.setAttribute("message", "Invalid username or password. Please try again.");
            request.getRequestDispatcher("login.jsp?error=true").forward(request, response);
        }
    }
}
