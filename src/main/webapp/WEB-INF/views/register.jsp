<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<%@ include file="header.jsp" %>

<body>
<section class="register-page">
    <h2>Załóż konto</h2>
    <form action="/register" method="post">
        <div class="form-group">
            <input type="text" name="name" placeholder="Imię" required />
        </div>

        <div class="form-group">
            <input type="text" name="surname" placeholder="Nazwisko" required />
        </div>

        <div class="form-group">
            <input type="email" name="mail" placeholder="Email" required />
        </div>

        <div class="form-group">
            <input type="password" name="password" placeholder="Hasło" required />
        </div>

        <div class="form-group">
            <input type="password" name="password2" placeholder="Powtórz hasło" required />
        </div>

        <c:if test="${not empty userExist}">
            <p style="color:red;">Użytkownik o podanym emailu już istnieje!</p>
        </c:if>

        <div class="form-group form-group--buttons">
            <a href="/login" class="btn btn--without-border">Zaloguj się</a>
            <button class="btn" type="submit">Załóż konto</button>
        </div>
    </form>
</section>
</body>

<%@ include file="footer.jsp" %>