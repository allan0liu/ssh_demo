<%--
  Created by IntelliJ IDEA.
  User: allan
  Date: 11/10/2019
  Time: 7:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>访问servlet api method 1</h1>
    <form action="${contextPath}/servletApiM1.action" method="post">
        name: <input type="text" name="name"><br/>
        age: <input type="text" name="age"><br/>
        <input type="submit" value="submit">
    </form>
</body>
</html>
