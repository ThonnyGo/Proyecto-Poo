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
        vehiculos[indice++]= new Vehiculo("001", "Toyota", "Yaris", "Verde", 2006, "Yusan", 30000.0);
        
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
    @Override public void eliminar(String codigo) {// 1. Buscar la posición del vehículo
        int pos = -1;
        for(int i = 0; i < indice; i++) {
            if(vehiculos[i].getCodigo().equals(codigo)) {
                pos = i;
                break;
            }
        }

        // 2. Si lo encontramos, lo eliminamos
        if(pos != -1) {
            // Movemos todos los de la derecha una posición a la izquierda
            for(int k = pos; k < indice - 1; k++) {
                vehiculos[k] = vehiculos[k + 1];
            }
            // Borramos el último rastro y bajamos el contador
            vehiculos[indice - 1] = null;
            indice--;
        }}
    @Override public void modificar(Object obj) {
        if(obj instanceof clases.Vehiculo) {
            clases.Vehiculo nuevoAuto = (clases.Vehiculo) obj;
            
            // Recorremos el arreglo para encontrar el auto original usando el CÓDIGO
            for(int i = 0; i < indice; i++) {
                // Si los códigos coinciden, este es el que debemos actualizar
                if(vehiculos[i].getCodigo().equals(nuevoAuto.getCodigo())) {
                    vehiculos[i] = nuevoAuto; // ¡AQUÍ OCURRE EL REEMPLAZO!
                    break; // Ya lo encontramos, dejamos de buscar
                }
            }
        }
      }
    @Override public Object buscar(String codigo) {
        for(int i=0; i<indice; i++) if(vehiculos[i].getCodigo().equals(codigo)) return vehiculos[i];
        return null;
    }
    @Override public Object[] listar() { return vehiculos; }
    @Override public int cantidad() { return indice; }
}
    

