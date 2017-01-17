<%--
  Created by IntelliJ IDEA.
  User: james
  Date: 15.01.2017
  Time: 22:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Add Minutes Page</title>
    <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
    <script>
        $(document).ready(function() {
            $.getJSON('<spring:url value="/activities" />', { ajax: true}, function (data) {
                var html = '<option value="">-- Please select one --</option>';
                var len = data.length;

                for(var i = 0; i < len; i++) {
                    html += '<option value="' + data[i].description + '">' + data[i].description + '</option>';
                }

                $('#activity').html(html);
            });
        });
    </script>
</head>
<body>
<h1>Add minutes exercised</h1>

Language : <a href="?lang=en">English</a> | <a href="?lang=fr">French</a>

<form:form commandName="exercise">
    <table>
        <tr>
            <td><spring:message code="goal.text" /></td>
            <td><form:input path="minutes"/></td>
            <td>
                <form:select path="activity" id="activity" />
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="Enter exercise" />
            </td>
        </tr>
    </table>
</form:form>

<h1>Our goal for the date is: ${goal.minutes}.</h1>
</body>
</html>
