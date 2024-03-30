<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="book.model.Book" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Book List</title>
    <link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css" rel="stylesheet">
</head>
<body class="bg-gray-100">
<div class="max-w-5xl mx-auto py-8">
    <h2 class="text-2xl font-bold mb-4">Book List</h2>
    <table class="w-full bg-white shadow-md rounded-lg overflow-hidden">
        <thead class="bg-gray-100 border-b">
        <tr>
            <th class="px-4 py-2">Title</th>
            <th class="px-4 py-2">Author</th>
            <th class="px-4 py-2">Year</th>
        </tr>
        </thead>
        <tbody>
        <%
            List<Book> books = book.dao.BookDAO.getAllBooks();
            if (books.isEmpty()) {
        %>
        <tr class="border-b">
            <td class="px-4 py-2" colspan="3">No books available.</td>
        </tr>
        <% } else { %>
        <% for (Book book : books) { %>
        <tr class="border-b">
            <td class="px-4 py-2"><%= book.getTitle() %>
            </td>
            <td class="px-4 py-2"><%= book.getAuthor() %>
            </td>
            <td class="px-4 py-2"><%= book.getYear() %>
            </td>
        </tr>
        <% } %>
        <% } %>
        </tbody>
    </table>
</div>
<div class="max-w-5xl mx-auto py-4">
    <a href="addBook.jsp" class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded">Add Book</a>
</div>
</body>
</html>
