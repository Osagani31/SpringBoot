<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: ASUSV
  Date: 4/9/2026
  Time: 9:04 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
   <title>New Customer</title>
</head>
<body>

<%--@elvariable id="customer" type="com"--%>
<form:form action="${pageContext.request.contextPath}/customer/register" modelAttribute="customer">
    <div>
        <label for="name">Customer Name</label>
        <input id="name" placeholder="Sanath" name="name">
    </div>
    <div>
        <label for="address">Customer Adreess</label>
        <input id="address" placeholder="Colombo" name="address">
    </div>
    <div>
        <input type="submit" value="Register">
    </div>

</form:form>
</body>
</html>
