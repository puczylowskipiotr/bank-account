<%--
  Created by IntelliJ IDEA.
  User: Komputer
  Date: 18.02.2023
  Time: 02:38
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Create transfer</title>
</head>
<body>
<form method="post" action="/mvc/transfer/create">
    <div>
        Address: <input type="text" name="address"/>
    </div>
    <div>
        Account: <input type="text" name="account"/>
    </div>
    <div>
        Title: <input type="text" name="title"/>
    </div>
    <div>
        Sum: <input type="text" name="sum"/>
    </div>
    <div>
        <button type="submit">Create</button>
    </div>
</form>
</body>
</html>
