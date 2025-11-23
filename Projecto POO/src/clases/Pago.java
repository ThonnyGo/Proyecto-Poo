/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author rauly
 */
public class Pago {
    private String metodo; // Efectivo, Tarjeta, Transferencia
    private double monto;
    private String fecha;
    
    public Pago(String metodo, double monto) {
        this.metodo = metodo;
        this.monto = monto;
        this.fecha = "21/11/2025"; // Usar fecha real en sistema
    }

    public String getMetodo() {
        return metodo;
    }

    public void setMetodo(String metodo) {
        this.metodo = metodo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    public double getMonto() { return monto; }
    public String getDetalle() { return metodo + ": $" + monto; }
}
