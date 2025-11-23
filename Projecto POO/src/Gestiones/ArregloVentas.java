/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gestiones;

import Interfaces.Mantenimiento;
import clases.Cotizacion;
import clases.Venta;

/**
 *
 * @author rauly
 */
public class ArregloVentas implements Mantenimiento {
    private Venta[] ventas;
    private Cotizacion[] cotizaciones;
    private int idxVenta;
    private int idxCoti;

    public ArregloVentas() {
        this.ventas = new Venta[100];
        this.cotizaciones = new Cotizacion[100];
        this.idxVenta = 0;
        this.idxCoti = 0;
    }

    // REQ 4: Guardar Cotización
    public void registrarCotizacion(Cotizacion c) {
        if(idxCoti < cotizaciones.length) cotizaciones[idxCoti++] = c;
    }

    // REQ 5: Registrar Venta
    @Override
    public void agregar(Object obj) {
        if(obj instanceof Venta) {
            ventas[idxVenta++] = (Venta) obj;
        }
    }

    // REQ 9: Reporte de Ingresos Totales
    public double reportarIngresos() {
        double total = 0;
        for(int i=0; i<idxVenta; i++) {
            total += ventas[i].getCotizacion().getMontoTotal();
        }
        return total;
    }

    public Cotizacion buscarCotizacion(String codigo) {
        for(int i=0; i<idxCoti; i++) {
            if(cotizaciones[i].getCodigo().equals(codigo)) return cotizaciones[i];
        }
        return null;
    }

    @Override public Object[] listar() { return ventas; }
    // Resto vacíos...
    @Override public void eliminar(String c) {
    }
    @Override public void modificar(Object o) {}
    @Override public Object buscar(String c) { return null; }
    @Override public int cantidad() { return idxVenta; }
}
