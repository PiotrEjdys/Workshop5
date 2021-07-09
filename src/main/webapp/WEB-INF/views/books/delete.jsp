<%--
  Created by IntelliJ IDEA.
  User: piotr
  Date: 09.07.2021
  Time: 09:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post">
    <p><input type="hidden" name="id" value="${book.id}"></p>
    <p><input type="submit" value="Potwierdź"></p>
    <p><a href="/admin/books/all">Anuluj</a></p>
</form>


</body>
</html>
