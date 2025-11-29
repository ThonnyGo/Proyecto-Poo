/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gestiones;

import Interfaces.Mantenimiento;
import clases.Cliente;

/**
 *
 * @author rauly
 */
public class ArregloClientes implements Mantenimiento {
    private Cliente[] clientes;
    private int indice;

    public ArregloClientes() {
        this.clientes = new Cliente[100];
        this.indice = 0;
        clientes[indice++] = new Cliente("60916230", "Pedro", "Neto", "Garcia", "Lince","987654321", "Thonny@gmail.com");
        clientes[indice++] = new Cliente("74612984", "Luis", "Ramirez", "Torres", "Miraflores", "987321654", "luis.ramirez@gmail.com");
        clientes[indice++] = new Cliente("81256390", "Maria", "Quispe", "Paredes", "Surco", "986452130", "mariaq@hotmail.com");
        clientes[indice++] = new Cliente("70341985", "Jorge", "Fernandez", "Lopez", "San Isidro", "994561203", "jorgefl@outlook.com");
        clientes[indice++] = new Cliente("64578120", "Andrea", "Vargas", "Huaman", "Pueblo Libre", "981230456", "andreavh@gmail.com");
        clientes[indice++] = new Cliente("75892013", "Carlos", "Gomez", "Salazar", "Breña", "995743210", "carlosg@hotmail.com");
        clientes[indice++] = new Cliente("68943175", "Lucia", "Sanchez", "Rojas", "Comas", "987654210", "luciasr@gmail.com");
        clientes[indice++] = new Cliente("71589342", "Fernando", "Diaz", "Mendoza", "Rimac", "981457236", "fdiaz@outlook.com");
        clientes[indice++] = new Cliente("72051489", "Valeria", "Castro", "Aguilar", "San Miguel", "994125789", "valeriaca@gmail.com");
        clientes[indice++] = new Cliente("63847952", "Hector", "Rios", "Palomino", "La Molina", "980312547", "hrios@hotmail.com");
        clientes[indice++] = new Cliente("78205613", "Natalia", "Peña", "Caballero", "Los Olivos", "987210345", "nataliapc@gmail.com");
        clientes[indice++] = new Cliente("69481235", "Diego", "Escobar", "Villanueva", "Chorrillos", "993124578", "diegoev@outlook.com");
        clientes[indice++] = new Cliente("73159840", "Paola", "Mamani", "Cruz", "Independencia", "989654123", "paolamc@gmail.com");
        clientes[indice++] = new Cliente("76034982", "Renato", "Salinas", "Bautista", "San Borja", "986743219", "renatosb@hotmail.com");
        clientes[indice++] = new Cliente("81247963", "Fiorella", "Guevara", "Serna", "Magdalena", "992315768", "fiorellags@gmail.com");
        clientes[indice++] = new Cliente("67532918", "Erick", "Lozano", "Chavez", "Villa El Salvador", "981679543", "ericklc@outlook.com");
        clientes[indice++] = new Cliente("70986412", "Sofia", "Montoya", "Infantes", "Santa Anita", "987890123", "sofiam@gmail.com");
        clientes[indice++] = new Cliente("74821359", "Martin", "Pacheco", "Solis", "Barranco", "994312578", "martinps@gmail.com");
        clientes[indice++] = new Cliente("79804261", "Daniela", "Reyes", "Cuellar", "Ate", "982435671", "danielarc@hotmail.com");
        clientes[indice++] = new Cliente("66713948", "Gabriel", "Suarez", "Tamayo", "Callao", "995678231", "gsuarez@gmail.com");
        clientes[indice++] = new Cliente("72659043", "Camila", "Ortega", "Beltran", "San Juan de Lurigancho", "981234765", "camilaob@gmail.com");    }

    @Override
    public void agregar(Object obj) {
        if(obj instanceof Cliente) clientes[indice++] = (Cliente) obj;
    }
    
    
    public Object[] listar() { return clientes; }
    
   
    @Override public void eliminar(String dni) {
        int pos = -1;
        for(int i = 0; i < indice; i++) {
            if(clientes[i].getDni().equals(dni)) {
                pos = i;
                break;
            }
        }
        if(pos != -1) {
            for(int k = pos; k < indice - 1; k++) {
                clientes[k] = clientes[k + 1];
            }
            clientes[indice - 1] = null;
            indice--;
        }
    }
    @Override public void modificar(Object obj) {
        if (obj instanceof clases.Cliente) {
            clases.Cliente clienteNuevo = (clases.Cliente) obj;
            
            for (int i = 0; i < indice; i++) {
                if (clientes[i].getDni().equals(clienteNuevo.getDni())) {
                    clientes[i] = clienteNuevo; 
                    return; 
                }
            }
        }
    }
    @Override public Object buscar(String dni) { 
         for(int i=0; i<indice; i++) if(clientes[i].getDni().equals(dni)) return clientes[i];
         return null;
    }
    @Override public int cantidad() { return indice; }
}
