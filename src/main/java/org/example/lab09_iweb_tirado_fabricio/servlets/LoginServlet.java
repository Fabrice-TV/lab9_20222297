package org.example.lab09_iweb_tirado_fabricio.servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.example.lab09_iweb_tirado_fabricio.daos.BaseDao;
import java.io.IOException;
import java.security.MessageDigest;
import java.sql.*;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String correo = request.getParameter("correo");
        String pass = request.getParameter("pass");
        String hashedPass = hashPassword(pass);

        try (Connection conn = BaseDao.getConnection()) {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM usuarios WHERE correo=? AND pass=?");
            ps.setString(1, correo);
            ps.setString(2, hashedPass);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                HttpSession session = request.getSession();
                session.setAttribute("usuario", rs.getString("nombre") + " " + rs.getString("apellido"));
                response.sendRedirect("usuarios");
            } else {
                request.setAttribute("error", "Correo o contraseña incorrectos");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        } catch (Exception e) {
            throw new ServletException(e);
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