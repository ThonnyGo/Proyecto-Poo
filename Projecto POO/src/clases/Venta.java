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
public class Venta implements Interfaces.IReporte {
    private String codigoVenta;
    private Cotizacion cotizacion;
    private Pago[] pagos; 
    private int idxPagos;
    private double saldoPendiente;
    private Calendar fechaVenta;

   
    public Venta(String codigoVenta, Cotizacion cotizacion, String metodoPago, double montoInicial) {
        this.codigoVenta = codigoVenta;
        this.cotizacion = cotizacion;
        this.fechaVenta = Calendar.getInstance();
        
       
        this.saldoPendiente = cotizacion.getMontoTotal();
        
       
        this.pagos = new Pago[10]; 
        this.idxPagos = 0;

       
        agregarPago(metodoPago, montoInicial);

      
        this.cotizacion.getVehiculo().setEstado("Vendido");
    }

    // Método para registrar pagos y bajar la deuda
    public void agregarPago(String metodo, double monto) {
        if (idxPagos < pagos.length && monto > 0) {
            pagos[idxPagos] = new Pago(metodo, monto);
            saldoPendiente -= monto; // Aquí se actualiza la deuda
            idxPagos++;
        }
    }
    
   
    
    public String generarComprobante() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== COMPROBANTE DE VENTA ===\n");
        sb.append("Fecha: ").append(fechaVenta.getTime()).append("\n");
        sb.append("Cliente: ").append(cotizacion.getCliente().getNombres()).append("\n");
        sb.append("Vehículo: ").append(cotizacion.getVehiculo().getDetalle()).append("\n");
        sb.append("Precio Total: $").append(cotizacion.getMontoTotal()).append("\n");
        
        // Mostrar lo que pagó ahora
        sb.append("Monto Abonado: $").append(cotizacion.getMontoTotal() - saldoPendiente).append("\n");
        
        // Mostrar si debe algo (Req 7)
        if (saldoPendiente > 0) {
            sb.append("SALDO PENDIENTE: $").append(saldoPendiente).append(" (A crédito)\n");
        } else {
            sb.append("ESTADO: CANCELADO (Pagado totalmente)\n");
        }
        
        return sb.toString();
    }

    public String getCodigoVenta() {
        return codigoVenta;
    }

    public void setCodigoVenta(String codigoVenta) {
        this.codigoVenta = codigoVenta;
    }

    public Cotizacion getCotizacion() {
        return cotizacion;
    }

    public void setCotizacion(Cotizacion cotizacion) {
        this.cotizacion = cotizacion;
    }

    public Pago[] getPagos() {
        return pagos;
    }

    public void setPagos(Pago[] pagos) {
        this.pagos = pagos;
    }

    public int getIdxPagos() {
        return idxPagos;
    }

    public void setIdxPagos(int idxPagos) {
        this.idxPagos = idxPagos;
    }

    public double getSaldoPendiente() {
        return saldoPendiente;
    }

    public void setSaldoPendiente(double saldoPendiente) {
        this.saldoPendiente = saldoPendiente;
    }

    public Calendar getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(Calendar fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    @Override
    public String generarDetalleImpresion() {
        // En vez de lanzar error, llamamos a tu método que ya funciona
        return generarComprobante(); 
    }
    
}


