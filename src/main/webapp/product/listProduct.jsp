<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 22/08/2022
  Time: 11:09 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Product List</title>
</head>
<body>
<h2>Products List</h2>
<p><a href="/products?action=create">Create New Product</a></p>
<table border="1px" width="500px">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Brand</th>
        <th>Price($)</th>
        <th>Description</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    <c:forEach items="${pList}" var="listOfProduct">
        <tr>
            <td>${listOfProduct.id}</td>
            <td>${listOfProduct.name}</td>
            <td>${listOfProduct.brand}</td>
            <td>${listOfProduct.price}</td>
            <td>${listOfProduct.description}</td>
            <td><a href="/products?action=edit&id=${listOfProduct.id}">edit</a></td>
            <td><a href="/products?action=delete&id=${listOfProduct.id}">delete</a></td>
        </tr>
    </c:forEach>
</table>
<h2><a href="/products?action=find">Find Product By Name</a></h2>
</form>
</body>
</html>
