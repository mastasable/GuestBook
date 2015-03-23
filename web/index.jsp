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
<html lang="En-en">
<head>
  <meta charset="UTF-8">
  <title>Guest book</title>
  <style>
    input, textarea, div, span{
      display: block;
      margin-bottom: 20px;
    }

    .date, .name{
      float: right;
    }
  </style>
</head>
<body>
  <div class="wrapper">
    <div class="posts">
      <h2>Последние записи:</h2>
      <c:forEach var="post" items="${requestScope.posts}">
        <div class="commentary">${post.commentary}</div>
        <span class="name">${post.name}</span>
        <span class="date">${post.date}</span>
      </c:forEach>
    </div>
    <form action="response.jsp" method="post">
      <h2>Напишите комментарий:</h2>
      <label for="name">Ваше имя: </label>
      <input id="name" type="text"/>
      <textarea name="commentary" id="commentary" cols="30" rows="10"></textarea>
      <button type="submit">Отправить</button>
    </form>
  </div>
</body>
</html>
