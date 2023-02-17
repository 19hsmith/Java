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
        <h1 style="text-align: center;">Here's your Omikuji!</h1>
        <div class="card">
            <p>
                In <c:out value="${pick}"></c:out> years,<br>
                you will live in <c:out value="${city}"></c:out> with <c:out value="${person}"></c:out> as your roommate,
                selling <c:out value="${hobby}"></c:out> for a living.<br> The next time you see a <c:out value="${thing}"></c:out>, you will have good luck.<br>
                Also <c:out value="${nice}"></c:out>.
            </p>
            <a href="/">Go back to home</a>
        </div>
    </body>
</html>