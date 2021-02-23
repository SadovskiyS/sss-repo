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
    <form:form action="/admin/admin-pizza/savePizza" modelAttribute="pizza">
        <form:hidden path="id"></form:hidden>
        Name<form:input path="name"></form:input>
        <br><br>
        Description<form:input path="descr"></form:input>
        <br><br>
        <input type="submit" value="OK">
    </form:form>
    <a href="/">Главная</a>
    <br>
    <a href="/admin-pizza">Админка</a>
</div>
</body>
</html>