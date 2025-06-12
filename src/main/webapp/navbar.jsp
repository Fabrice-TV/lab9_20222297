<!-- filepath: src/main/webapp/navbar.jsp -->
<%@ page import="jakarta.servlet.http.HttpSession" %>
<%
    String usuario = (String) session.getAttribute("usuario");
    if (usuario == null) usuario = "Invitado";
%>
<nav style="background:#eee;padding:10px;">
    <span><b>Gestión de Gastos – <%= usuario %></b></span>
    | <a href="usuarios">Usuarios</a>
    | <a href="/listarTransacciones">Transacciones</a>
    | <a href="logout">Cerrar sesión</a>
</nav>