package book.controller;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import util.DBUtil;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/AddBookServlet")
public class AddBookServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Retrieve book details from the form
        String title = request.getParameter("title");
        String author = request.getParameter("author");
        int year = Integer.parseInt(request.getParameter("year"));

        // Get the existing database connection
        Connection connection = null;
        try {
            connection = DBUtil.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        // Prepare SQL statement to insert the new book into the database
        String sql = "INSERT INTO books (title, author, year) VALUES (?, ?, ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, title);
            preparedStatement.setString(2, author);
            preparedStatement.setInt(3, year);

            // Execute the SQL statement
            int rowsAffected = preparedStatement.executeUpdate();

            // Check if the insertion was successful
            if (rowsAffected > 0) {
                System.out.println("New Book Added:");
                System.out.println("Title: " + title);
                System.out.println("Author: " + author);
                System.out.println("Year: " + year);
            } else {
                System.out.println("Failed to add new book.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                // Close the database connection
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        // Redirect back to the displayBook.jsp after adding the book
        response.sendRedirect("bookList.jsp");
    }
}
