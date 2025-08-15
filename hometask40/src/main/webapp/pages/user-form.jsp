<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Форма пользователя</title>
</head>
<body>
<h1>Создание пользователя</h1>

<form:form method="POST" modelAttribute="userForm">
    <div>
        <label>Имя пользователя:</label>
        <form:input path="username"/>
    </div>

    <div>
        <label>Возраст:</label>
        <form:input path="age" type="number"/>
    </div>

    <div>
        <label>Роль:</label>
        <form:select path="role">
            <form:option value="USER">Обычный пользователь</form:option>
            <form:option value="ADMIN">Администратор</form:option>
        </form:select>
    </div>

    <button type="submit">Отправить</button>
</form:form>
</body>
</html>