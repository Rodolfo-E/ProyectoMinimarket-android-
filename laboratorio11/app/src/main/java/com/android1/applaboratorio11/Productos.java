package com.android1.applaboratorio11;

public class Productos {
    private String codigo;
    private String nombre;
    private String imagen;
    private String stock;
    private String precio_compra;
    private String precio_venta;


    public Productos() {
    }

    public Productos(String codigo, String nombre, String imagen, String stock, String precio_compra, String precio_venta) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.imagen = imagen;
        this.stock = stock;
        this.precio_compra = precio_compra;
        this.precio_venta = precio_venta;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public String getPrecio_compra() {
        return precio_compra;
    }

    public void setPrecio_compra(String precio_compra) {
        this.precio_compra = precio_compra;
    }

    public String getPrecio_venta() {
        return precio_venta;
    }

    public void setPrecio_venta(String precio_venta) {
        this.precio_venta = precio_venta;
    }


}
