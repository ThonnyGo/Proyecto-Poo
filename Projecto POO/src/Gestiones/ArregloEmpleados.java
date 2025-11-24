/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gestiones;

import Interfaces.Mantenimiento;
import clases.Administrador;
import clases.Empleado;
import clases.Vendedor;

/**
 *
 * @author rauly
 */
public class ArregloEmpleados implements Mantenimiento{
    private Empleado[] empleados;
    private int indice;

    public ArregloEmpleados() {
        this.empleados = new Empleado[50];
        this.indice = 0;
        // Usuario por defecto para poder entrar al sistema (REQ 10)
        agregar(new Administrador("001", "Anthony", "Garcia", "admin", "123"));
        agregar(new Vendedor("002", "Flavio", "Souza", "vend", "123"));
    }

    // REQ 10: Mecanismo de Autenticación
    public Empleado iniciarSesion(String user, String pass) {
        for(int i=0; i<indice; i++) {
            if(empleados[i].autenticar(user, pass)) {
                return empleados[i];
            }
        }
        return null;
    }

    @Override
    public void agregar(Object obj) {
        if(obj instanceof Empleado && indice < empleados.length) {
            empleados[indice++] = (Empleado) obj;
        }
    }
    // Métodos obligatorios de la interfaz (Modificar, Eliminar, Buscar, Listar)...
    // Implementar lógica básica de arrays aquí (bucles for)
    @Override public void eliminar(String dni) { 
        // 1. Buscar la posición
        int pos = -1;
        for (int i = 0; i < indice; i++) {
            if (empleados[i].getDni().equals(dni)) {
                pos = i;
                break;
            }
        }

        // 2. Si existe, borrar y recorrer
        if (pos != -1) {
            for (int k = pos; k < indice - 1; k++) {
                empleados[k] = empleados[k + 1]; // Mueve el de la derecha a la izquierda
            }
            empleados[indice - 1] = null; // Borra el último duplicado
            indice--; // Baja el contador
        }
    }
    @Override public void modificar(Object obj) {
        if(obj instanceof clases.Empleado) {
            clases.Empleado empNuevo = (clases.Empleado) obj;
            // Buscamos por DNI y reemplazamos
            for(int i = 0; i < indice; i++) {
                if(empleados[i].getDni().equals(empNuevo.getDni())) {
                    empleados[i] = empNuevo;
                    break;
                }
            }
        }
    }
    @Override public Object buscar(String dni) { return null; }
    @Override public Object[] listar() { return empleados; }
    @Override public int cantidad() { return indice; }
}

