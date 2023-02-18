<%--
  Created by IntelliJ IDEA.
  User: Komputer
  Date: 17.02.2023
  Time: 15:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Create person</title>
</head>
<body>
<form method="post" action="/mvc/person/create">
    <div>
        Login: <input type="text" name="login"/>
    </div>
    <div>
        Email: <input type="text" name="email"/>
    </div>
    <div>
        Password: <input type="password" name="password"/>
    </div>
    <div>
        <button type="submit">Create</button>
    </div>
</form>
</body>
</html>
