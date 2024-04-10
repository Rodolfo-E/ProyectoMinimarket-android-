package com.android1.applaboratorio11;

public class Deudas {

    private String codigo;
    private String cliente;
    private String deuda;
    private String fecha;

    public Deudas() {
    }

    public Deudas(String codigo, String cliente, String deuda, String fecha) {

        this.codigo = codigo;
        this.cliente = cliente;
        this.deuda = deuda;
        this.fecha = fecha;
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

    public String getDeuda() {
        return deuda;
    }

    public void setDeuda(String deuda) {
        this.deuda = deuda;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}
