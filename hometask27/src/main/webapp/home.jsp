<%--
  Created by IntelliJ IDEA.
  User: kera2
  Date: 10.06.2025
  Time: 19:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<body>
    <ul>
        <c:forEach var="car" items="${cars}">
        <li><c:out value="${car}"/></li>
            </c:forEach>
</body>
</html>
