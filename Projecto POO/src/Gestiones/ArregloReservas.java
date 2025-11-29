/*
 * ArregloReservas
 * Mantenimiento de reservas de vehículos en memoria.
 */
package Gestiones;

import Interfaces.Mantenimiento;
import clases.Reserva;

public class ArregloReservas implements Mantenimiento {

    private Reserva[] reservas;
    private int indice;

    public ArregloReservas() {
        reservas = new Reserva[100]; // Tamaño inicial configurable
        indice = 0;
    }

    @Override
    public void agregar(Object obj) {
        if (obj instanceof Reserva) {
            Reserva r = (Reserva) obj;
            if (indice < reservas.length) {
                reservas[indice] = r;
                indice++;
            }
        }
    }

    @Override
    public void eliminar(String codigo) {
        int pos = -1;
        for (int i = 0; i < indice; i++) {
            if (reservas[i].getCodigo().equals(codigo)) {
                pos = i;
                break;
            }
        }
        if (pos != -1) {
            for (int i = pos; i < indice - 1; i++) {
                reservas[i] = reservas[i + 1];
            }
            reservas[indice - 1] = null;
            indice--;
        }
    }

    @Override
    public void modificar(Object obj) {
        if (obj instanceof Reserva) {
            Reserva rNueva = (Reserva) obj;
            for (int i = 0; i < indice; i++) {
                if (reservas[i].getCodigo().equals(rNueva.getCodigo())) {
                    reservas[i] = rNueva;
                    break;
                }
            }
        }
    }

    @Override
    public Object buscar(String codigo) {
        for (int i = 0; i < indice; i++) {
            if (reservas[i].getCodigo().equals(codigo)) {
                return reservas[i];
            }
        }
        return null;
    }

    @Override
    public Object[] listar() {
        return reservas;
    }

    @Override
    public int cantidad() {
        return indice;
    }

    // Métodos de apoyo para el temporizador
    public Reserva getReserva(int i) {
        if (i >= 0 && i < indice) {
            return reservas[i];
        }
        return null;
    }
}
