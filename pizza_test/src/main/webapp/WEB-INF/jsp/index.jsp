<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<!DOCTYPE HTML>
<html>
<head>
    <title>Главная</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/style.css">
    <link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/Features-Boxed.css">
    <link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/bootstrap.min.css">
</head>
<body>
<div>
    <h3>${pageContext.request.userPrincipal.name}</h3>
    <sec:authorize access="!isAuthenticated()">
        <h4><a href="/login">Войти</a></h4>
        <h4><a href="/registration">Зарегистрироваться</a></h4>
    </sec:authorize>
    <sec:authorize access="isAuthenticated()">
        <h4><a href="/logout">Выйти</a></h4>
    </sec:authorize>
    <h4><a href="/news">Новости (только пользователь)</a></h4>
    <h4><a href="/admin">Редактор (только админ)</a></h4>

    <div class="features-boxed">
        <div class="container">
            <div class="intro">
                <h2 class="text-center">Celentano</h2>
                <p class="text-center">Информация всякая...</p>
            </div>
            <div class="row justify-content-center features"><div class="col-sm-6 col-md-5 col-lg-4 col-xl-3 item">
                <div class="box"><img />
                    <h3 class="name">Pizza name</h3>
                    <p class="description">Pizza description</p>
                    <div class="btn-group">
                        <button class="btn btn-primary" type="button">30 см</button>
                        <button class="btn btn-primary" type="button">50 см</button>
                    </div>
                    <br><br>
                    <p>... грн <button class="btn btn-primary" type="button">В корзину</button></p>
                    <fieldset></fieldset>
                </div>
            </div>
                </div>
        </div>
</div>
<%--    <script type="text/javascript">--%>
<%--        <%@include file="resources/js/jquery.min.js"%>--%>
<%--    </script>--%>
<%--    <script type="text/javascript">--%>
<%--        <%@include file="resources/js/jquery.min.js"%>--%>
<%--    </script>--%>
    <script src="${pageContext.request.contextPath}/resources/js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>