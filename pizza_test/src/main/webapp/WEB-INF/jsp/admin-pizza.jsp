<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Log in with your account</title>
    <link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/style.css">
</head>

<body>
<div>
    <table>
        <thead>
        <th>ID</th>
        <th>Name</th>
        <th>Description</th>
        </thead>
        <c:forEach items="${allPizzas}" var="pizza">
            <tr>
                <td>${pizza.id}</td>
                <td>${pizza.name}</td>
                <td>${pizza.descr}</td>
                <td>
                    <form action="${pageContext.request.contextPath}/admin/admin-pizza" method="post">
                        <input type="hidden" name="pizzaId" value="${pizza.id}"/>
                        <input type="hidden" name="actionPizza" value="deletePizza"/>
                        <button type="submit">Delete</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
    <a href="/">Главная</a>
    <br>
    <input type="button" value="Add" onclick="window.location.href='/admin/admin-pizza/addNewPizza'">
</div>
</body>
</html>