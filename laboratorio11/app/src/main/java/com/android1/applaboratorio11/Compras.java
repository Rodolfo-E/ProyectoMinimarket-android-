package com.android1.applaboratorio11;

public class Compras {
    private String codigo;
    private String cliente;
    private String descripcion;
    private String fecha;
    private String cantidad;
    private String Precio;
    private String monto;

    public Compras() {
    }

    public Compras(String codigo, String cliente, String descripcion, String fecha, String cantidad, String precio, String monto) {
        this.codigo = codigo;
        this.cliente = cliente;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.cantidad = cantidad;
        Precio = precio;
        this.monto = monto;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getPrecio() {
        return Precio;
    }

    public void setPrecio(String precio) {
        Precio = precio;
    }

    public String getMonto() {
        return monto;
    }

    public void setMonto(String monto) {
        this.monto = monto;
    }
}
