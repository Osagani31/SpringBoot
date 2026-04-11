<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: ASUSV
  Date: 4/9/2026
  Time: 7:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
  <title>Customer Form</title>
</head>
<body>

<div class="container mt-4">
  <h2 class="mb-4">Save / Update Customer</h2>

<form:form action="new-customer" modelAttribute="customer" method="post">

  <form:hidden path="id"/>

  <div class="mb-3">
    <label for="name" class="form-label">Customer Name</label>
    <form:input path="name" id="name" cssClass="form-control"/>
  </div>

  <div class="mb-3">
    <label for="salary" class="form-label">Customer Salary</label>
    <form:input path="salary" id="salary" cssClass="form-control"/>
  </div>

  <div class="d-flex gap-2">
    <button type="submit" class="btn btn-primary">Save Customer</button>
    <a href="all" class="btn btn-outline-secondary">Back to List</a>
  </div>
</form:form>

</div>

</body>
</html>