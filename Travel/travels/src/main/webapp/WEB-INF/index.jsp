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
    <h1>Save Travels</h1>
    <table class="table table-dark">
            <tr>
                <th>Expense</th>
                <th>Vendor</th>
                <th>Amount</th>
                <th>Actions</th>
            </tr>
            <c:forEach var="travel" items="${travels}">
                <tr>
                    <td><a href="/travels/show/${travel.id}">${travel.expense}</a></td>
                    <td>${travel.vendor}</td>
                    <td>${travel.amount}</td>
                    <td class="d-flex"><a class ="btn btn-warning" href="/travels/edit/${travel.id}">edit </a>
                        <form action="/travels/delete/${travel.id}" method="post">
                            <input type="hidden" name="_method" value="delete">
                            <input class="btn btn-danger" type="submit" value="delete">
                        </form>
                    </td>
                </tr>
            </c:forEach>
    </table>
    <h2>Add an expense</h2>
    <form:form action="/travels" method="post" modelAttribute="travel">
        <div class="form-control">
            <form:label path="expense">Expense:</form:label>
            <form:errors path="expense"/>
            <form:input path="expense"></form:input>
        </div>
        <div class="form-control">
            <form:label path="vendor">Vendor:</form:label>
            <form:errors path="vendor"/>
            <form:input path="vendor"></form:input>
        </div>
        <div class="form-control">
            <form:label path="amount">Amount:</form:label>
            <form:input path="amount"></form:input>
        </div>
        <div class="form-control">
            <form:label path="description">Description:</form:label>
            <form:errors path="description"/>
            <form:input path="description"></form:input>
        </div>
        <input type="submit" value="submit">

    </form:form>
</body>
</html>