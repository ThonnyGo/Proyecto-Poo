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
public class Venta {
    private String codigoVenta;
    private Cotizacion cotizacion;
    private Pago[] pagos; // Req 7: Registro de pagos parciales
    private int idxPagos;
    private double saldoPendiente;
    private Calendar fechaVenta;

    public Venta(String codigoVenta, Cotizacion cotizacion) {
        this.codigoVenta = codigoVenta;
        this.cotizacion = cotizacion;
        this.fechaVenta = Calendar.getInstance();
        this.saldoPendiente = cotizacion.getMontoTotal();
        this.pagos = new Pago[10]; // Hasta 10 cuotas
        this.idxPagos = 0;

        // REQ 5: Cambio automático de estado
        this.cotizacion.getVehiculo().setEstado("Vendido");
    }

    // REQ 7: Registrar pagos y calcular saldo
    public void agregarPago(String metodo, double monto) {
        if (idxPagos < pagos.length && monto <= saldoPendiente) {
            pagos[idxPagos] = new Pago(metodo, monto);
            saldoPendiente -= monto;
            idxPagos++;
        }
    }

    // REQ 8: Generar Comprobante
    public String generarComprobante() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== COMPROBANTE DE VENTA ===\n");
        sb.append("Fecha: ").append(fechaVenta.getTime()).append("\n");
        sb.append("Cliente: ").append(cotizacion.getCliente().getNombres()).append("\n");
        sb.append("Vendedor: ").append(cotizacion.getVendedor().getNombres()).append("\n");
        sb.append("Vehículo: ").append(cotizacion.getVehiculo().getDetalle()).append("\n");
        sb.append("Precio Final: $").append(cotizacion.getMontoTotal()).append("\n");
        sb.append("Pagado: $").append(cotizacion.getMontoTotal() - saldoPendiente).append("\n");
        sb.append("Saldo Pendiente: $").append(saldoPendiente).append("\n");
        return sb.toString();
    }
    
    public Cotizacion getCotizacion() { return cotizacion; }
    public Calendar getFecha() { return fechaVenta; }
}

