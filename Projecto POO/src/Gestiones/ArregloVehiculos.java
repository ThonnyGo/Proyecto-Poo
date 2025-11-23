/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gestiones;

import Interfaces.Mantenimiento;
import clases.Vehiculo;

/**
 *
 * @author rauly
 */
public class ArregloVehiculos implements Mantenimiento {
    private Vehiculo[] vehiculos;
    private int indice;

    public ArregloVehiculos() {
        this.vehiculos = new Vehiculo[100];
        this.indice = 0;
    }

    @Override
    public void agregar(Object obj) {
        if(obj instanceof Vehiculo) vehiculos[indice++] = (Vehiculo) obj;
    }

    // Soporte para REQ 4: Seleccionar vehículo disponible
    public Vehiculo[] listarDisponibles() {
        int count = 0;
        for(int i=0; i<indice; i++) {
            if(vehiculos[i].getEstado().equals("Disponible")) count++;
        }
        Vehiculo[] temporal = new Vehiculo[count];
        int k = 0;
        for(int i=0; i<indice; i++) {
            if(vehiculos[i].getEstado().equals("Disponible")) temporal[k++] = vehiculos[i];
        }
        return temporal;
    }
    
    // Soporte para REQ 9: Reporte de vendidos y disponibles
    public String reporteEstado() {
        int disp = 0, vend = 0;
        for(int i=0; i<indice; i++) {
            if(vehiculos[i].getEstado().equals("Vendido")) vend++;
            else disp++;
        }
        return "Disponibles: " + disp + " | Vendidos: " + vend;
    }

    // Resto de métodos CRUD...
    @Override public void eliminar(String codigo) {}
    @Override public void modificar(Object obj) {}
    @Override public Object buscar(String codigo) {
        for(int i=0; i<indice; i++) if(vehiculos[i].getCodigo().equals(codigo)) return vehiculos[i];
        return null;
    }
    @Override public Object[] listar() { return vehiculos; }
    @Override public int cantidad() { return indice; }
}
    

