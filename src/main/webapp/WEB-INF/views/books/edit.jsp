<%--
  Created by IntelliJ IDEA.
  User: piotr
  Date: 09.07.2021
  Time: 10:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form method="post"
           modelAttribute="book">
    <p> Author<form:input path="author" /> </p>
    <p> ISBN<form:input path="isbn" /></p>
    <p> Publisher<form:input path="publisher" /></p>
    <p>Title<form:input path="title"/></p>
    <p>Type<form:input path="type"/></p>
    <p><input type="submit" value="Save"></p>
</form:form>
<p><a href="/admin/books/all">Powrót</a><p>
</body>
</html>
