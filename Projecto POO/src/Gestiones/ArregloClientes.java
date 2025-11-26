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
        clientes[indice++]= new Cliente("60916230", "Pedro", "Neto", "Garcia", "Lince","987654321", "Thonny@gmail.com");
    }

    @Override
    public void agregar(Object obj) {
        if(obj instanceof Cliente) clientes[indice++] = (Cliente) obj;
    }
    
    // Soporte REQ 9: Clientes frecuentes (Lógica simplificada)
    public Object[] listar() { return clientes; }
    
    // Resto de CRUD...
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
        if(obj instanceof clases.Cliente) {
            clases.Cliente cliNuevo = (clases.Cliente) obj;
            for(int i=0; i < indice; i++) {
                // Buscamos por DNI
                if(clientes[i].getDni().equals(cliNuevo.getDni())) {
                    clientes[i] = cliNuevo; // Reemplazamos
                    break;
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
