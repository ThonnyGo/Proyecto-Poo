/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author fsg20
 */
 public class Vehiculo {
    private String codigo;
    private String marca;
    private String modelo;
    private String color;
    private int anio;
    private String tipo; // Sedán, SUV, etc.
    private double precioBase;
    private String estado; // "Disponible", "Vendido", "Reservado"

    public Vehiculo(String codigo, String marca, String modelo, String color, int anio, String tipo, double precio) {
        this.codigo = codigo;
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.anio = anio;
        this.tipo = tipo;
        this.precioBase = precio;
        this.estado = "Disponible";
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    // Getters y Setters para cambiar estado (Req 5)
    public void setEstado(String estado) { this.estado = estado; }
    public String getEstado() { return estado; }
    public String getCodigo() { return codigo; }
    public double getPrecioBase() { return precioBase; }
    public String getDetalle() { return marca + " " + modelo + " (" + tipo + ")"; }
    
    @Override
    public String toString() { return getDetalle() + " - $" + precioBase; }
}
    
