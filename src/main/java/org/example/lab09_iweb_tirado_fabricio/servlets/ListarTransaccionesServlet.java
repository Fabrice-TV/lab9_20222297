package org.example.lab09_iweb_tirado_fabricio.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import org.example.lab09_iweb_tirado_fabricio.daos.TransaccionDao;
import org.example.lab09_iweb_tirado_fabricio.beans.Transaccion;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/*import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;*/

import java.io.IOException;
import java.util.List;

@WebServlet("/listarTransacciones")
public class ListarTransaccionesServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        Integer idUsuario = (Integer) session.getAttribute("idusuario");

        if (idUsuario == null) {
            response.sendRedirect(request.getContextPath()+"/usuarios");
            return;
        }

        TransaccionDao dao = new TransaccionDao();
        List<Transaccion> lista = dao.listarPorIdUsuario(idUsuario);

        // Guardar el listado como atributo tipo BEAN
        request.setAttribute("listaTransacciones", lista);

        // Redirigir al JSP para mostrar la lista
        request.getRequestDispatcher("listarTransacciones.jsp").forward(request, response);
    }
}
