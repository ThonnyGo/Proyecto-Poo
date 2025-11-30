/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.util.Calendar;

/**
 *
 * @author rauly
 */
public class Cotizacion {
    private String codigo;
    private Cliente cliente;      
    private Vendedor vendedor;    
    private Vehiculo vehiculo;    
    private Promocion promocion;  
    private double montoTotal;    
    private Calendar fecha;

    public Cotizacion(String codigo, Cliente cliente, Vendedor vendedor, Vehiculo vehiculo, Promocion promocion) {
        this.codigo = codigo;
        this.cliente = cliente;
        this.vendedor = vendedor;
        this.vehiculo = vehiculo;
        this.promocion = promocion;
        this.fecha = Calendar.getInstance();
        
       
        double precio = vehiculo.getPrecioBase();
        if (promocion != null) {
            
            precio -= promocion.calcularDescuento(precio);
        }
        this.montoTotal = precio;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public Promocion getPromocion() {
        return promocion;
    }

    public void setPromocion(Promocion promocion) {
        this.promocion = promocion;
    }

    public double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(double montoTotal) {
        this.montoTotal = montoTotal;
    }

    public Calendar getFecha() {
        return fecha;
    }

    public void setFecha(Calendar fecha) {
        this.fecha = fecha;
    }
}

