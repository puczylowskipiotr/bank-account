<%--
  Created by IntelliJ IDEA.
  User: Komputer
  Date: 18.02.2023
  Time: 23:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Transfer created</title>
</head>
<body>

<div>id: ${bankTransfer.id}</div>
<div>address: ${bankTransfer.address}</div>
<div>account: ${bankTransfer.account}</div>
<div>title: ${bankTransfer.title}</div>
<div>sum: ${bankTransfer.sum.replaceAll('.', '*')}</div>

</body>
</html>
