<%--
  Created by IntelliJ IDEA.
  User: Komputer
  Date: 17.02.2023
  Time: 15:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Person created</title>
</head>
<body>
<h2>Created person</h2>
<div>id: ${person.id}</div>
<div>login: ${person.login}</div>
<div>email: ${person.email}</div>
<div>password: ${person.password.replaceAll('.', '*')}</div>
</body>
</html>
