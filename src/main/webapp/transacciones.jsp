<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="org.example.lab09_iweb_tirado_fabricio.beans.Transaccion" %>
<%@ include file="navbar.jsp" %>

<html>
<head><title>Lista de Transacciones</title></head>
<body>
<h2>Transacciones del Usuario</h2>

<table border="1">
    <tr>
        <th>ID</th>
        <th>Título</th>
        <th>Monto</th>
        <th>Tipo</th>
        <th>Descripción</th>
        <th>Fecha</th>
    </tr>

    <%
        List<Transaccion> lista = (List<Transaccion>) request.getAttribute("listaTransacciones");
        for (Transaccion t : lista) {
    %>
    <tr>
        <td><%= t.getIdtransacciones() %></td>
        <td><%= t.getTitulo() %></td>
        <td><%= t.getMonto() %></td>
        <td><%= t.getTipo() %></td>
        <td><%= t.getDescripcion() %></td>
        <td><%= t.getFecha() %></td>
    </tr>
    <% } %>
</table>
</body>
</html>
