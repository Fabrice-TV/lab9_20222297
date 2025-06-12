package org.example.lab09_iweb_tirado_fabricio.beans;

public class Usuario {
    private int idusuarios;
    private String nombre;
    private String apellido;
    private String dni;
    private String correo;

    // Getters y setters
    public int getIdusuarios() { return idusuarios; }
    public void setIdusuarios(int idusuarios) { this.idusuarios = idusuarios; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }

    public String getDni() { return dni; }
    public void setDni(String dni) { this.dni = dni; }

    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }
}
