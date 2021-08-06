<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Возможности библиотеки JSTL</title>
</head>
<body>

<a target="blank" href="http://ru.bmstu.wiki/JSTL_(JavaServer_Pages_Standard_Tag_Library)">
    Возможности библиотеки JSTL
</a>

<h2>Пример использования вывода данных</h2>
<div>При испоользовании "out" контекст указывается в формате requestScope.yourObjectM</div>
<c:out value="${requestScope.simpleOutput.text}"/>
<hr/>

<div>При испоользовании "set" контекст указывается в формате scope="request"</div>
<c:set var="operations" scope="request" value="${operations}"/>
<hr/>

<h2>Пример использования цыкла:</h2>
<c:forEach items="${operations}" var="operation">
    <c:out value="${operation}"/><br/>
</c:forEach>
<hr/>

<h2>Пример использования условного оператора:</h2>
<c:if test="${requestScope.condition eq true}">
    <div>Сработал условный оператор</div>
</c:if>

</body>
</html>
