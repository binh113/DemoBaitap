<%--
  Created by IntelliJ IDEA.
  User: ThinkPad
  Date: 12/28/2022
  Time: 2:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customers List</title>
</head>
<body>
<a href="/customers?action=create">Create new customer</a>
<c:if test="${requestScope['message']!=null}">
    <p>${requestScope['message']} </p>
</c:if>
<table>
    <tr>
        <th>
            ID
        </th>
        <th>
            NAME
        </th>
        <th>
            EMAIL
        </th>
        <th>
            ADDRESS
        </th>
        <th>
            AVATAR
        </th>
    </tr>
    <c:forEach items='${requestScope["customers"]}' var="customer">
        <tr>
            <td>
              <a href="/customers?action=view&id=${customer.getId()}" > ${customer.getId()}</a>
            </td>
            <td>
                    ${customer.getName()}
            </td>
            <td>
                    ${customer.getEmail()}
            </td>
            <td>
                    ${customer.getAddress()}
            </td>
            <td>
                    ${customer.getImg()}
            </td>
            <td>
                <a href="/customers?action=edit&id=${customer.getId()}">Edit</a>
                <a href="/customers?action=delete&id=${customer.getId()}">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
