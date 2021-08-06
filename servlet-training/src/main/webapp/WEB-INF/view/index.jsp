<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User list page</title>
</head>
<body>

    <h1>Hello from World!</h1>

    <h2>User list</h2>

    <c:forEach var="user" items="${requestScope.users}">
        <ul>
            <li>Name: <c:out value="${user.name}"/></li>
            <li>Age: <c:out value="${user.age}"/></li>

            <form method="get" action="<c:url value='/update'/>">
                <input type="number" hidden name="id" value="${user.id}" />
                <input type="submit" name="update" value="Update" />
            </form>

            <form method="post" action="<c:url value='/delete'/>">
                <input type="number" hidden name="id" value="${user.id}" />
                <input type="submit" name="delete" value="Delete" />
            </form>
        </ul>
        <hr/>
    </c:forEach>

    <h2>User creation</h2>

    <form method="post" action="<c:url value='/add_user'/>">
        <label>Name<input type="text" name="name"></input></label><br/>
        <label>Age<input type="text" name="age"></input></label><br/>
        <input type="submit" value="Ok" name="Ok"/>
    </form>
</body>
</html>
