<%--
  Created by IntelliJ IDEA.
  User: james
  Date: 16.01.2017
  Time: 14:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Add Goal</title>
    <style>
        .error {
            color: red;
        }

        .error-block {
            color: black;
            background-color: #ffEEEE;
            border: 3px solid red;
            padding: 8px;
            margin: 16px;
        }
    </style>
</head>
<body>
<form:form commandName="goal">
    <form:errors path="*" cssClass="error-block" element="div" />
    <table>
        <tr>
            <td>Enter minutes:</td>
            <td>
                <form:input path="minutes" />
                <form:errors path="minutes" cssClass="error" />
            </td>
        </tr>
        <tr>
            <td colspan="3">
                <input type="submit" value="Enter Goal Value" />
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
