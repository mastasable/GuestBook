<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 22.03.2015
  Time: 11:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Document</title>
</head>
<body>
  <h2>Запись добавлена!</h2>
  <p>Через 5 секунд Вы будете перенаправлены обратно. Если этого не происходит, перейдите самостоятельно: <a
          href="guestbook">guestbook</a></p>
  <script language="JavaScript">
    var delay = 5000;
    console.log("Идёт ожилание 5 сек ", delay)
    setTimeout("document.location.href = 'guestbook'", delay);
  </script>
</body>
</html>
