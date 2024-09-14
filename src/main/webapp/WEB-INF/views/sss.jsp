<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8">
    <title>Donations</title>
</head>
<body>
<em>
    <c:choose>
        <c:when test="${donations == null}">
            0
        </c:when>
        <c:otherwise>
            ${donations}
        </c:otherwise>
    </c:choose>
</em>
</body>
</html>