package org.example.lab09_iweb_tirado_fabricio.servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.example.lab09_iweb_tirado_fabricio.beans.Usuario;
import org.example.lab09_iweb_tirado_fabricio.daos.BaseDao;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

@WebServlet(name = "UsuarioListServlet", value = "/usuarios")
public class UsuarioListServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Usuario> usuarios = new ArrayList<>();
        try (Connection conn = BaseDao.getConnection()) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT idusuarios, nombre, apellido, dni, correo FROM usuarios");
            while (rs.next()) {
                Usuario u = new Usuario();
                u.setIdusuarios(rs.getInt("idusuarios"));
                u.setNombre(rs.getString("nombre"));
                u.setApellido(rs.getString("apellido"));
                u.setDni(rs.getString("dni"));
                u.setCorreo(rs.getString("correo"));
                usuarios.add(u);
            }
        } catch (Exception e) {
            throw new ServletException(e);
        }
        request.setAttribute("usuarios", usuarios); // Bean como atributo
        request.getRequestDispatcher("usuarios.jsp").forward(request, response);
    }
}