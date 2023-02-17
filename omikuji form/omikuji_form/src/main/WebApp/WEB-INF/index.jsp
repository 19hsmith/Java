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
    <h1 style="text-align: center;">Omikuji form</h1>
        <div class="container">
            <form action="/submit" method="post">
                <label>Pick a number 5 to 25</label><br>
                <input type="number" name="pick"><br>
                <label>Enter the name of any city</label><br>
                <input type="text" name="city"><br>
                <label>Enter the name of any real person</label><br>
                <input type="text" name="person"><br>
                <label>Enter proffesional endeavor or hobby</label><br>
                <input type="text" name="hobby"><br>
                <label>Enter any type of living thing</label><br>
                <input type="text" name="thing"><br>
                <label>Say something nice to someone</label><br>
                <input type="text" name="nice"><br>
                <h3>Send and show a friend</h3>
                <input type="submit" value="submit"><br>
            </form>
        </div>
</body>
</html>