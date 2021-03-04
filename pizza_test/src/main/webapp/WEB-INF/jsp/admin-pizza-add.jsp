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
    <h3>Добавление пиццы в БД!</h3>
    <form:form action="/admin/admin-pizza/savePizza" modelAttribute="pizza" enctype="multipart/form-data">
        <form:hidden path="id"></form:hidden>
        Название пиццы<form:input path="name"></form:input>
        <form:errors path="name"></form:errors>
        <br><br>
        Описание<form:input path="descr"></form:input>
        <form:errors path="descr"></form:errors>
        <br><br>
        Цена за 30 см<form:input path="price30SM"></form:input>
        <br><br>
        Цена за 50 см<form:input path="price50SM"></form:input>
        <br><br>
        Изображение<input type="file" name="file">
        <br><br>
        <input type="submit" value="OK">
    </form:form>
    <a href="/">Главная</a>
    <br>
    <a href="/admin-pizza">Админка</a>
</div>
</body>
</html>