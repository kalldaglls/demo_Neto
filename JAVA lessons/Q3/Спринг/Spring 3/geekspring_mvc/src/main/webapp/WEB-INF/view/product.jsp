<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html>
<head>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/main.css" />
</head>

<body>
<h1>Welcome page</h1>

<%--<h1> ${students[0].firstName}</h1>--%>
<%--<h1> ${students[1].firstName}</h1>--%>

<%--, ${name}.--%>

<ul>
<%--    <l1> Hello ${product}</l1>--%>
    <c:forEach var="item" items="${product}">
        <li><c:out value="${item}"/></li>
    </c:forEach>
</ul>

<%--<ul>--%>
<%--<c:forEach var="item" items="${students}">--%>
<%--<li>${item.firstName}</li>--%>
<%--</c:forEach>--%>
<%--</ul>--%>

</body>
</html>
</html>