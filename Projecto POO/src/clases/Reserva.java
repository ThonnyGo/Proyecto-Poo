/*
 * Sistema de reserva de vehículos con temporizador automático
 * Permite reservar un vehículo para un cliente por un tiempo limitado.
 */
package clases;

import java.util.Calendar;

public class Reserva {

    private String codigo;
    private Vehiculo vehiculo;
    private Cliente cliente;
    private Vendedor vendedor;
    private Calendar fechaReserva;
    private int horasDuracion;   // Ej: 48 horas
    private boolean activa;      // true = reservada, false = expirada / cancelada

    public Reserva(String codigo, Vehiculo vehiculo, Cliente cliente,
                   Vendedor vendedor, int horasDuracion) {
        this.codigo = codigo;
        this.vehiculo = vehiculo;
        this.cliente = cliente;
        this.vendedor = vendedor;
        this.horasDuracion = horasDuracion;
        this.fechaReserva = Calendar.getInstance();
        this.activa = true;
    }

    public String getCodigo() {
        return codigo;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public Calendar getFechaReserva() {
        return fechaReserva;
    }

    public int getHorasDuracion() {
        return horasDuracion;
    }

    public boolean isActiva() {
        return activa;
    }

    public void setActiva(boolean activa) {
        this.activa = activa;
    }

    /** Calcula si la reserva ya venció respecto a la fecha y hora actual. */
    public boolean estaExpirada() {
        Calendar fechaLimite = (Calendar) fechaReserva.clone();
        fechaLimite.add(Calendar.HOUR_OF_DAY, horasDuracion);

        Calendar ahora = Calendar.getInstance();
        return ahora.after(fechaLimite);
    }
}
