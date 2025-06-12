<!-- filepath: src/main/webapp/usuarios.jsp -->
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="org.example.lab09_iweb_tirado_fabricio.beans.Usuario" %>
<%@ page import="java.util.List" %>
<%@ include file="navbar.jsp" %>
<html>
<head>
    <title>Lista de Usuarios</title>
</head>
<body>
    <h2>Lista de Usuarios</h2>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Nombre</th>
            <th>Apellido</th>
            <th>DNI</th>
            <th>Correo</th>
        </tr>
        <%
            List<Usuario> usuarios = (List<Usuario>) request.getAttribute("usuarios");
            for (Usuario u : usuarios) {
        %>
        <tr>
            <td><%= u.getIdusuarios() %></td>
            <td><%= u.getNombre() %></td>
            <td><%= u.getApellido() %></td>
            <td><%= u.getDni() %></td>
            <td><%= u.getCorreo() %></td>
        </tr>
        <% } %>
    </table>
    <br>
    <form action="registroUsuario.jsp">
        <button type="submit">Registrar Usuario</button>
    </form>
</body>
</html>