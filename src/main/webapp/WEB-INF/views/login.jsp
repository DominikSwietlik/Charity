<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<%@ include file="header.jsp" %>
<body>
<div class="container">
    <div class="form-container">

        <!-- Display error message if login fails -->
        <c:if test="${not empty param.error}">
            <div class="error-message">
                <p>Invalid username or password.</p>
            </div>
        </c:if>

        <!-- Display message on successful logout -->
        <c:if test="${not empty param.logout}">
            <div class="logout-message">
                <p>Logout successful!</p>
            </div>
        </c:if>

        <section class="login-page">
            <h2>Zaloguj się</h2>
            <form action="<c:url value='/login'/>" method="post">
                <div class="form-group">
                    <input type="text" name="username" placeholder="Email" />
                </div>
                <div class="form-group">
                    <input type="password" name="password" placeholder="Hasło" />
                    <a href="#" class="btn btn--small btn--without-border reset-password">Przypomnij hasło</a>
                </div>

                <div class="form-group form-group--buttons">
                    <a href="register" class="btn btn--without-border">Załóż konto</a>
                    <button class="btn" type="submit">Zaloguj się</button>
                </div>
            </form>
        </section>
</body>

<%@ include file="footer.jsp" %>