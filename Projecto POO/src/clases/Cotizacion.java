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
    private Promocion promocion; // Opcional
    private double montoTotal;
    private Calendar fecha;

    public Cotizacion(String cod, Cliente cli, Vendedor ven, Vehiculo veh, Promocion promo) {
        this.codigo = cod;
        this.cliente = cli;
        this.vendedor = ven;
        this.vehiculo = veh;
        this.promocion = promo;
        this.fecha = Calendar.getInstance();
        this.montoTotal = calcularTotal();
    }

    private double calcularTotal() {
        double precio = vehiculo.getPrecioBase();
        if (promocion != null) {
            precio -= promocion.calcularDescuento(precio);
        }
        return precio;
    }

    // Getters para pasar a Venta (Req 5)
    public Vehiculo getVehiculo() { return vehiculo; }
    public double getMontoTotal() { return montoTotal; }
    public Cliente getCliente() { return cliente; }
    public Vendedor getVendedor() { return vendedor; }
    public String getCodigo() { return codigo; }
    public Promocion getPromocion() { return promocion; }
}

