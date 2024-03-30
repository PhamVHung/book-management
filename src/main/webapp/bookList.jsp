<%@ page import="book.model.Book" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Book List</title>
    <!-- Include Tailwind CSS -->
    <link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css" rel="stylesheet">
</head>
<body class="bg-gray-100">
<div class="container mx-auto px-4 py-8">
    <h1 class="text-3xl font-bold mb-4">Book List</h1>
    <%
        List<Book> books = (List<Book>) request.getAttribute("books");
        if (books != null && !books.isEmpty()) {
    %>
    <table class="table-auto w-full">
        <thead>
        <tr>
            <th class="px-4 py-2">Title</th>
            <th class="px-4 py-2">Author</th>
            <th class="px-4 py-2">Year</th>
        </tr>
        </thead>
        <tbody>
        <% for (Book book : books) { %>
        <tr>
            <td class="border px-4 py-2"><%= book.getTitle() %></td>
            <td class="border px-4 py-2"><%= book.getAuthor() %></td>
            <td class="border px-4 py-2"><%= book.getYear() %></td>
        </tr>
        <% } %>
        </tbody>
    </table>
    <% } else { %>
    <p class="text-gray-600">No books found.</p>
    <% } %>
    <a href="addBook.jsp" class="mt-4 inline-block bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded">Add Book</a>
</div>
</body>
</html>
