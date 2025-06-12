package org.example.lab09_iweb_tirado_fabricio.servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.security.MessageDigest;
import java.sql.*;

@WebServlet(name = "RegistrarUsuarioServlet", value = "/registrarUsuario")
public class RegistrarUsuarioServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String dni = request.getParameter("dni");
        String correo = request.getParameter("correo");
        String pass = request.getParameter("pass");

        // Validaciones
        /*if (nombre == null || nombre.isEmpty() ||
            apellido == null || apellido.isEmpty() ||
            dni == null || !dni.matches("\\d+") ||
            correo == null || correo.isEmpty() ||
            pass == null || !pass.matches("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$")) {
            request.setAttribute("error", "Todos los campos son obligatorios y deben cumplir las reglas.");
            request.getRequestDispatcher("registroUsuario.jsp").forward(request, response);
            return;
        }*/

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lab9", "root", "root");

            // Validar unicidad de DNI y correo
            PreparedStatement ps1 = conn.prepareStatement("SELECT COUNT(*) FROM usuarios WHERE dni=? OR correo=?");
            ps1.setString(1, dni);
            ps1.setString(2, correo);
            ResultSet rs1 = ps1.executeQuery();
            rs1.next();
            if (rs1.getInt(1) > 0) {
                request.setAttribute("error", "El DNI o correo ya existe.");
                request.getRequestDispatcher("registroUsuario.jsp").forward(request, response);
                conn.close();
                return;
            }

            // Validar que no se repita el nombre y apellido
            PreparedStatement ps2 = conn.prepareStatement("SELECT COUNT(*) FROM usuarios WHERE nombre=? AND apellido=?");
            ps2.setString(1, nombre);
            ps2.setString(2, apellido);
            ResultSet rs2 = ps2.executeQuery();
            rs2.next();
            if (rs2.getInt(1) > 0) {
                request.setAttribute("error", "Ya existe un usuario con ese nombre y apellido.");
                request.getRequestDispatcher("registroUsuario.jsp").forward(request, response);
                conn.close();
                return;
            }

            // Insertar usuario (contraseña cifrada SHA-256)
            String hashedPass = hashPassword(pass);
            PreparedStatement ps3 = conn.prepareStatement(
                "INSERT INTO usuarios (nombre, apellido, dni, correo, pass) VALUES (?, ?, ?, ?, ?)");
            ps3.setString(1, nombre);
            ps3.setString(2, apellido);
            ps3.setString(3, dni);
            ps3.setString(4, correo);
            ps3.setString(5, hashedPass);
            ps3.executeUpdate();

            conn.close();
            response.sendRedirect("usuarios");
        } catch (Exception e) {
            request.setAttribute("error", "Error en el registro: " + e.getMessage());
            request.getRequestDispatcher("registroUsuario.jsp").forward(request, response);
        }
    }

    private String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes("UTF-8"));
            StringBuilder sb = new StringBuilder();
            for (byte b : hash) sb.append(String.format("%02x", b));
            return sb.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}