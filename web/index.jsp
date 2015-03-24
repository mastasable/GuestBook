<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 21.03.2015
  Time: 12:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="Ru-ru">
<head>
    <meta charset="UTF-8">
    <title>Guest book</title>
    <style>
        input, textarea, div{
            display: block;
            margin-bottom: 20px;
        }

        .date{
            display: block;
            margin-bottom: 20px;
        }

        .wrapper{
            width: 900px;
            margin: auto;
        }

        .post{
            border: solid 1px black;
            padding: 10px;
            width: 550px;
        }

        textarea{
            resize: none;
        }
    </style>
</head>
<body>
<div class="wrapper">
    <div class="posts">
        <h2>Последние записи:</h2>
        <c:forEach var="post" items="${requestScope.posts}">
            <div class="post">
                <div class="commentary">${post.commentary}</div>
                <a class="item" href="${post.url}">${post.url}</a>
                <span class="name">${post.name}</span>
                <span class="date">${post.date}</span>
            </div>
        </c:forEach>
    </div>
    <form method="post" enctype="multipart/form-data">
        <fieldset>
            <legen><h2>Напишите комментарий</h2></legen>
            <label for="name">Ваше имя: </label>
            <input id="name" name="name" type="text"/>
            <textarea name="commentary" id="commentary" cols="80" rows="10"></textarea>
            <input type="file" name="file"/>
            <button type="submit">Отправить</button>
        </fieldset>
    </form>
</div>
</body>
</html>
