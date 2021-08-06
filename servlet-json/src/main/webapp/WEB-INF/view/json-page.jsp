<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Jackson</title>
</head>
<body>

    <h1>Hello from JSON!</h1>

    <form method="post" action="<c:url value='/json'/>">
            <input type="text" name="data"/>
            <input type="submit" name="Send"/>
        </form>
</body>
</html>
