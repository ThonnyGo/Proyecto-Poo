/*
 * GestorReservasTemporizador
 * Revisa periódicamente las reservas activas y, cuando expiran,
 * devuelve el estado del vehículo a "Disponible".
 */
package Gestiones;

import clases.Reserva;
import clases.Vehiculo;
import java.util.Timer;
import java.util.TimerTask;

public class GestorReservasTemporizador {

    private ArregloReservas arregloReservas;
    private Timer timer;

    // Periodo de revisión en milisegundos (ejemplo: cada 60 segundos)
    private static final long PERIODO_REVISION_MS = 60 * 1000;

    public GestorReservasTemporizador(ArregloReservas arregloReservas) {
        this.arregloReservas = arregloReservas;
        this.timer = new Timer(true); // hilo daemon

        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                verificarReservas();
            }
        }, 0, PERIODO_REVISION_MS);
    }

    private void verificarReservas() {
        int n = arregloReservas.cantidad();
        for (int i = 0; i < n; i++) {
            Reserva r = arregloReservas.getReserva(i);
            if (r != null && r.isActiva() && r.estaExpirada()) {
                // Marca la reserva como no activa
                r.setActiva(false);

                // Si el vehículo sigue "Reservado", lo devolvemos a "Disponible"
                Vehiculo v = r.getVehiculo();
                if (v != null && "Reservado".equalsIgnoreCase(v.getEstado())) {
                    v.setEstado("Disponible");
                }

                // Log simple en consola
                System.out.println("Reserva " + r.getCodigo() + " expirada. Vehículo disponible nuevamente.");
            }
        }
    }
}
