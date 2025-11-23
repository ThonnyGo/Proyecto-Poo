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
    }

    @Override
    public void agregar(Object obj) {
        if(obj instanceof Cliente) clientes[indice++] = (Cliente) obj;
    }
    
    // Soporte REQ 9: Clientes frecuentes (Lógica simplificada)
    public Object[] listar() { return clientes; }
    
    // Resto de CRUD...
    @Override public void eliminar(String dni) {}
    @Override public void modificar(Object obj) {}
    @Override public Object buscar(String dni) { 
         for(int i=0; i<indice; i++) if(clientes[i].getDni().equals(dni)) return clientes[i];
         return null;
    }
    @Override public int cantidad() { return indice; }
}
