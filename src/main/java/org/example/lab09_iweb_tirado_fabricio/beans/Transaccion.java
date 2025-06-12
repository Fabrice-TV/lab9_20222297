package org.example.lab09_iweb_tirado_fabricio.beans;

import java.util.Date;

public class Transaccion {
    private int idtransacciones;
    private double monto;
    private String descripcion;
    private String titulo;
    private String tipo;
    private Date fecha; // Puede ser String o java.sql.Date dependiendo de tu lógica
    private int usuarios_idusuarios;

    // Getters y Setters
    public int getIdtransacciones() {
        return idtransacciones;
    }

    public void setIdtransacciones(int idtransacciones) {
        this.idtransacciones = idtransacciones;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getUsuarios_idusuarios() {
        return usuarios_idusuarios;
    }

    public void setUsuarios_idusuarios(int usuarios_idusuarios) {
        this.usuarios_idusuarios = usuarios_idusuarios;
    }
}
