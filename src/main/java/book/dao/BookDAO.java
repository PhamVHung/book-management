package book.dao;

import book.model.Book;
import util.DBUtil;

import java.sql.*;
import java.util.*;

public class BookDAO {

    public static List<Book> getAllBooks() {
        List<Book> books = new ArrayList<>();
        try (Connection connection = DBUtil.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM books")) {
            while (resultSet.next()) {
                String title = resultSet.getString("title");
                String author = resultSet.getString("author");
                int year = resultSet.getInt("year");
                Book book = new Book(title, author, year);
                books.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle any database errors
        }
        return books;
    }
}
