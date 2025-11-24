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
        // Opción 1: Si es Porcentaje (Ej. 10%)
        if (this.tipo.equalsIgnoreCase("Porcentaje")) {
            return precioBase * (this.valor / 100);
        } 
        // Opción 2: Si es Monto Fijo (Ej. $500)
        else {
            return this.valor;
        }
    }
    public String getNombre() { return nombre; }
    public String getTipo() { return tipo; }
    public double getValor() { return valor; }
    public String getVigencia() { return vigencia; }
}
