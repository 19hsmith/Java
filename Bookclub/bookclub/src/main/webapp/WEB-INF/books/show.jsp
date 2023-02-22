<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!-- Formatting (dates) --> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Tacos</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script><!-- change to match your file/naming structure -->
</head>
<body>
    <h1>Welcome</h1>
    <table class="table">
        <thead>
            <th>Title</th>
            <th>Author</th>
            <th>Posted By</th>
        </thead>
        <tbody>
            <tr>
                <td>${book.title}</td>
                <td>${book.author}</td>
                <td>${book.user.userName}</td>
            </tr>
        </tbody>
    </table>
    <c:choose>
        <c:when test="${book.user.id == userId}">
            <a class="btn btn-warning" href="/books/edit/${id}">Edit</a>
            <form action="/books/${id}" method="post">
                <input type="hidden" name="_method" value="delete">
                <input type="submit" value="delete">
            </form>
        </c:when>
    </c:choose>
</body>
</html>