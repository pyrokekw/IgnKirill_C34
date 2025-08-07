<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>orders</title>
</head>
<body>

<form:form method="POST" modelAttribute="userForm">
    <div>
        <form:label path="name">Имя:</form:label>
        <form:input path="name"/>
        <form:errors path="name"/>
    </div>

    <div>
        <form:label path="email">Email:</form:label>
        <form:input path="email"/>
        <form:errors path="email"/>
    </div>

    <div>
        <form:label path="age">Возраст:</form:label>
        <form:input path="age" type="number"/>
        <form:errors path="age"/>
    </div>

    <input type="submit" value="Подтвердить"/>
</form:form>
</body>
</html>