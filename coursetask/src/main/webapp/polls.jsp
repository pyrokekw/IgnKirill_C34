<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Опросы</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-5">
    <h1>Опросы</h1>
    <table class="table table-bordered">
        <thead>
        <tr>
            <th>Тема</th>
            <th>Действия</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="poll" items="${polls}">
            <tr>
                <td>${poll.title}</td>
                <td>
                    <a href="editPoll?id=${poll.id}" class="btn btn-primary">Редактировать</a>
                    <a href="deletePoll?id=${poll.id}" class="btn btn-danger" onclick="return confirm('Вы уверены, что хотите удалить этот опрос?');">Удалить</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <form action="polls" method="post" class="form-inline">
        <input type="text" name="title" class="form-control" placeholder="Создать новый опрос" required>
        <button type="submit" class="btn btn-success ml-2">Создать</button>
    </form>
</div>
</body>
</html>