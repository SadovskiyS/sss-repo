<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<!DOCTYPE HTML>
<html>
<head>
    <title>Главная</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/styles.css">
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
            <div class="row justify-content-center features">

             <div class="col-sm-6 col-md-5 col-lg-4 col-xl-3 item">
                <div class="box"><img />
                    <c:forEach items="${allPizzas}" var="pizza" end="0">
                        <img alt=""  src="data:image/png;base64,${pizza.image}">
                        <br><br>
                    <h3 class="name">${pizza.name}</h3>
                    <p class="description">${pizza.descr}</p>
                        <input type="hidden" id="id" value="${pizza.id}">
                        <input type="hidden" id="price30" value="${pizza.price30SM}">
                        <input type="hidden" id="price50" value="${pizza.price50SM}">
                    <div class="btn-group">
                        <button class="btn btn-primary" id="30sm">30 см</button>
                        <button class="btn btn-primary" id="50sm">50 см</button>
                    </div>
                    <br><br>
                        <b id="price"></b><button id="bucket" class="btn btn-primary" type="button" >В корзину</button>
                    </c:forEach>
                    <fieldset></fieldset>
                </div>
            </div>

        </div>
     </div>
</div>

    <script src="https://code.jquery.com/jquery-3.5.1.min.js" integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0="
            crossorigin="anonymous"></script>
    <script type="text/javascript">

        $(document).ready(function () {
            let idd = document.getElementById('id').value;
            let p30 = document.getElementById('price30').value;
            let p50 = document.getElementById('price50').value;
            $('#30sm, #50sm').click(function () {
                if(this.id == '30sm'){
                    $.ajax({
                        type: 'GET',
                        url: '${pageContext.request.contextPath}/pricePizza?id=' + idd,
                        data: {
                            "price30": p30
                        },
                        success: function (data) {
                            $('#30sm').css('color', 'red');
                            $('#50sm').css('color', 'white');
                            $('#price').html(data + ' грн');
                        }
                    })
                }
                else if(this.id == '50sm'){
                    $.ajax({
                        type: 'GET',
                        url: '${pageContext.request.contextPath}/pricePizza2?id=' + idd,
                        data: {
                            "price50": p50
                        },
                        success: function (data) {
                            $('#50sm').css('color', 'blue');
                            $('#30sm').css('color', 'white');
                            $('#price').html(data + ' грн');
                        }
                    })
                }
            })
        })

    </script>

    <script src="${pageContext.request.contextPath}/resources/js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>