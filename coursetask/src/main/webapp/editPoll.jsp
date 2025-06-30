<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Редактирование опроса</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-5">
    <h1>Редактирование: ${poll.title}</h1>
    <h3>Варианты ответов</h3>
    <ul class="list-group mb-3">
        <c:forEach var="option" items="${options}">
            <li class="list-group-item d-flex justify-content-between align-items-center">
                    ${option.text}
                <a href="deleteOption?id=${option.id}" class="btn btn-danger btn-sm">Удалить</a>
            </li>
        </c:forEach>
    </ul>

    <form action="addOption" method="post" class="form-inline">
        <input type="hidden" name="pollId" value="${poll.id}">
        <input type="text" name="text" class="form-control" placeholder="Добавить ответ" required>
        <button type="submit" class="btn btn-success ml-2">Добавить</button>
    </form>
    <a href="polls" class="btn btn-secondary mb-3">Вернуться назад</a>
</div>
</body>
</html>