/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import Interfaces.ICalculable;

/**
 *
 * @author rauly
 */
public class Promocion  implements ICalculable {
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

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getVigencia() {
        return vigencia;
    }

    public void setVigencia(String vigencia) {
        this.vigencia = vigencia;
    }

    
  
    @Override
    public double calcularDescuento(double precioBase) {
        if (tipo.equals("Porcentaje")) {
            return precioBase - (precioBase * valor / 100);
        } else {
            return precioBase - valor;
        }
    }
        
}
