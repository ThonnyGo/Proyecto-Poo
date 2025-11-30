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
        vehiculos[indice++] = new Vehiculo("001", "Toyota", "Yaris", "Verde", 2006, "Sedán", 30000.0);
        vehiculos[indice++] = new Vehiculo("002", "Nissan", "Versa", "Plata", 2022, "Sedán", 19000.0);
        vehiculos[indice++] = new Vehiculo("003", "Kia", "Picanto", "Rojo", 2024, "Hatchback", 13000.0);
        vehiculos[indice++] = new Vehiculo("004", "Hyundai", "Accent", "Azul", 2021, "Sedán", 17000.0);
        vehiculos[indice++] = new Vehiculo("005", "Honda", "Civic", "Negro", 2023, "Sedán", 28000.0);
        vehiculos[indice++] = new Vehiculo("006", "Mazda", "3", "Gris", 2022, "Sedán", 24000.0);
        vehiculos[indice++] = new Vehiculo("007", "Chevrolet", "Onix", "Naranja", 2023, "Sedán", 16000.0);
        vehiculos[indice++] = new Vehiculo("008", "Volkswagen", "Gol", "Blanco", 2021, "Hatchback", 14000.0);
        vehiculos[indice++] = new Vehiculo("009", "Suzuki", "Swift", "Amarillo", 2022, "Hatchback", 15000.0);
        vehiculos[indice++] = new Vehiculo("010", "Toyota", "RAV4", "Verde", 2023, "SUV", 35000.0);
        vehiculos[indice++] = new Vehiculo("011", "Ford", "Ranger", "Negro", 2022, "Pick-up", 40000.0);
        vehiculos[indice++] = new Vehiculo("012", "Renault", "Duster", "Marron", 2021, "SUV", 21000.0);
        vehiculos[indice++] = new Vehiculo("013", "Subaru", "Impreza", "Azul", 2020, "Sedán", 23000.0);
        vehiculos[indice++] = new Vehiculo("014", "Jeep", "Renegade", "Verde Oliva", 2022, "SUV", 29000.0);
        vehiculos[indice++] = new Vehiculo("015", "Hyundai", "Tucson", "Gris", 2023, "SUV", 32000.0);
        vehiculos[indice++] = new Vehiculo("016", "Nissan", "Sentra", "Blanco", 2021, "Sedán", 20000.0);
        vehiculos[indice++] = new Vehiculo("017", "BMW", "Serie 3", "Negro", 2021, "Sedán", 45000.0);
        vehiculos[indice++] = new Vehiculo("018", "Audi", "Q3", "Plata", 2022, "SUV", 42000.0);
        vehiculos[indice++] = new Vehiculo("019", "Peugeot", "208", "Azul", 2023, "Hatchback", 18000.0);
        vehiculos[indice++] = new Vehiculo("020", "Chery", "Tiggo", "Rojo", 2022, "SUV", 16000.0);
    }

    @Override
    public void agregar(Object obj) {
        if(obj instanceof Vehiculo) vehiculos[indice++] = (Vehiculo) obj;
    }

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
    
    public String reporteEstado() {
        int disp = 0, vend = 0;
        for(int i=0; i<indice; i++) {
            if(vehiculos[i].getEstado().equals("Vendido")) vend++;
            else disp++;
        }
        return "Disponibles: " + disp + " | Vendidos: " + vend;
    }

    @Override public void eliminar(String codigo) {// 1. Buscar la posición del vehículo
        int pos = -1;
        for(int i = 0; i < indice; i++) {
            if(vehiculos[i].getCodigo().equals(codigo)) {
                pos = i;
                break;
            }
        }

        if(pos != -1) {
            for(int k = pos; k < indice - 1; k++) {
                vehiculos[k] = vehiculos[k + 1];
            }
            vehiculos[indice - 1] = null;
            indice--;
        }}
    @Override public void modificar(Object obj) {
        if (obj instanceof clases.Vehiculo) {
            clases.Vehiculo vehiculoNuevo = (clases.Vehiculo) obj;
            
            for (int i = 0; i < indice; i++) {
              
                if (vehiculos[i].getCodigo().equals(vehiculoNuevo.getCodigo())) {
                    vehiculos[i] = vehiculoNuevo; 
                    return; 
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
    

