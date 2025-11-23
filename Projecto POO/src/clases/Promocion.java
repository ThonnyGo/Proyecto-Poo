/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author rauly
 */
public class Promocion {
    private String nombre;
    private String tipo; // "Porcentaje" o "MontoFijo"
    private double valor;
    private String vigencia;

    public Promocion(String nombre, String tipo, double valor, String vigencia) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.valor = valor;
        this.vigencia = vigencia;
    }

    public double calcularDescuento(double precioBase) {
        if (tipo.equalsIgnoreCase("Porcentaje")) {
            return precioBase * (valor / 100);
        } else {
            return valor; // Monto fijo
        }
    }
    
    public String getNombre() { return nombre; }
}
