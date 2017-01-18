<%--
  Created by IntelliJ IDEA.
  User: james
  Date: 17.01.2017
  Time: 20:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Attendee Page</title>
    <style>
        .error{
            color: #ff0000;
        }
        .error-block{
            color: #000;
            background-color: #ffeeee;
            border: 3px solid #ff0000;
            padding: 8px;
            margin: 16px;
        }
    </style>
</head>
<body>
<a href="?lang=en">English</a> - <a href="?lang=fr">French</a>

<form:form commandName="attendee">
    <form:errors path="*" cssClass="error-block" />
    <label for="name"><spring:message code="attendee.name"/>:</label>
    <form:input path="name" cssErrorClass="error" />
    <form:errors path="name" cssClass="error" />
    <br/>
    <label for="name"><spring:message code="attendee.email.address" />:</label>
    <form:input path="emailAddress" cssErrorClass="error" />
    <form:errors path="emailAddress" cssClass="error" />
    <br/>
    <input type="submit" value="Enter attendee" />
</form:form>
</body>
</html>
