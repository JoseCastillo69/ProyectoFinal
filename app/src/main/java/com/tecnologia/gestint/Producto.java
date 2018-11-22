package com.tecnologia.gestint;

public class Producto {

    private int id;
    private String nombre;
    private String tipo;
    private int cantidad;
    private String foto;

    public Producto() {
    }

    public Producto(int id, String nombre, String tipo, int cantidad, String foto) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.cantidad = cantidad;
        this.foto = foto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public void NuevaP(){
        datos.agregar(this);
    }

    public void EliminarP(){
        datos.eliminar(this);
    }

    public void EditarP(){
        datos.editar(this);
    }
}
