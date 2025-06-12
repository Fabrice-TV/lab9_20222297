package org.example.lab09_iweb_tirado_fabricio.daos;

import org.example.lab09_iweb_tirado_fabricio.beans.Transaccion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TransaccionDao extends BaseDao {

    public List<Transaccion> listarPorIdUsuario(int idUsuario) {
        List<Transaccion> lista = new ArrayList<>();
        String sql = "SELECT idtransacciones, titulo, monto, tipo, descripcion, fecha " +
                "FROM transacciones " +
                "WHERE usuarios_idusuarios = ?";

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, idUsuario);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Transaccion t = new Transaccion();
                t.setIdtransacciones(rs.getInt("idtransacciones"));
                t.setTitulo(rs.getString("titulo"));
                t.setMonto(rs.getDouble("monto"));
                t.setTipo(rs.getString("tipo"));
                t.setDescripcion(rs.getString("descripcion"));
                t.setFecha(rs.getDate("fecha"));  // si tu bean lo tiene como java.sql.Date

                lista.add(t);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }
}
