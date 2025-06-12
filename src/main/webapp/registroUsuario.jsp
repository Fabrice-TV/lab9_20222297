<!-- filepath: src/main/webapp/registroUsuario.jsp -->
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="navbar.jsp" %>
<html>
<head>
    <title>Registrar Usuario</title>
</head>
<body>
    <h2>Registrar Usuario</h2>
    <form action="registrarUsuario" method="post">
        <label>Nombre:</label>
        <input type="text" name="nombre" required /><br>
        <label>Apellido:</label>
        <input type="text" name="apellido" required /><br>
        <label>DNI:</label>
        <input type="text" name="dni" required /><br>
        <label>Correo:</label>
        <input type="email" name="correo" required /><br>
        <label>Contraseña:</label>
        <input type="password" name="pass" required /><br>
        <button type="submit">Registrar</button>
        <div style="color:red;">
            <%= request.getAttribute("error") != null ? request.getAttribute("error") : "" %>
        </div>
    </form>
</body>
</html>