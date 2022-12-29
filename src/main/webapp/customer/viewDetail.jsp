<%--
  Created by IntelliJ IDEA.
  User: ThinkPad
  Date: 12/28/2022
  Time: 4:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View</title>
</head>
<body>
<a href="/customers">back</a>
<p>id:${requestScope['customer'].getId()}
</p>
<p>id:${requestScope['customer'].getName()}
</p>
<p>id:${requestScope['customer'].getEmail()}
</p>
<p>id:${requestScope['customer'].getAddress()}
</p>
<p>id:${requestScope['customer'].getImg()}
</p>
</body>
</html>
