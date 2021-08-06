<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Filter</title>
</head>
<body>

    <h1>Hello from Filters!</h1>

    <p><c:out value="${requestScope.dataForView}"/></p>

    <form method="post" action="">
        <input type="text" name="data"/>
        <input type="submit" name="Send"/>
    </form>
</body>
</html>
