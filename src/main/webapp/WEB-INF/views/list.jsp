<%--
  Created by IntelliJ IDEA.
  User: Komputer
  Date: 18.02.2023
  Time: 02:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>List transfer</title>
</head>
<body>
<h1>List of all transfer</h1>
<table>
    <tr>
        <th>Id</th>
        <th>Address</th>
        <th>Account</th>
        <th>Title</th>
        <th>Sum</th>
        <th>person</th>

    </tr>
    <c:forEach items="${bankTransfer}" var="transfer">
        <tr>
            <td>${bankTransfer.id}</td>
            <td>${bankTransfer.address}</td>
            <td>${bankTransfer.account}</td>
            <td>${bankTransfer.title}</td>
            <td>${bankTransfer.sum}</td>
            <td>
                <a href="<c:out value='/views/transfer/update?id=${bankTransfer.id}'/>">Update</a>
                    <input type="hidden" name="id" value="${bankTransfer.id}">
                    <button type="submit">Delete</button>
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
