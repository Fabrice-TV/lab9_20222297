<!-- filepath: src/main/webapp/login.jsp -->
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Login - Gestión de Gastos</title>
</head>
<body>
    <form action="login" method="post">
        <label>Correo:</label>
        <input type="email" name="correo" required /><br>
        <label>Contraseña:</label>
        <input type="password" name="pass" required /><br>
        <button type="submit">Iniciar Sesión</button>
        <c:if test="${not empty error}">
            <p style="color:red">${error}</p>
        </c:if>
    </form>
</body>
</html>