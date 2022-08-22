<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 22/08/2022
  Time: 11:03 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
  <title>Create</title>
  <style>
    message {color: blue}
  </style>
</head>
<body>
<h2>Edit Product</h2>
<p>
  <c:if test='${requestScope["message"] != null}'>
    <span class="message">${requestScope["message"]}</span>
  </c:if>
</p>
<p>
  <a href="/products">Back to customer list</a>
</p>
<form method="post" >
  <fieldset>
    <legend>Customer information</legend>
    <table>
      <tr>
        <td>Name: </td>
        <td><input type="text" name="name" id="name"></td>
      </tr>
      <tr>
        <td>Brand: </td>
        <td><input type="text" name="brand" id="brand"></td>
      </tr>
      <tr>
        <td>Price: </td>
        <td><input type="text" name="price" id="price"></td>
      </tr>
      <tr>
        <td>Description: </td>
        <td><input type="text" name="description" id="description"></td>
      </tr>
      <tr>
        <td></td>
        <td><input type="submit" value="Edit product"></td>
      </tr>
    </table>
  </fieldset>
  </form>
</body>
</html>
