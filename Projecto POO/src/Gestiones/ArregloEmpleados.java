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
        agregar(new Administrador("001", "Super", "Admin", "admin", "123"));
        agregar(new Vendedor("002", "Juan", "Perez", "vend", "123"));
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
    @Override public void eliminar(String dni) { /* ... */ }
    @Override public void modificar(Object obj) { /* ... */ }
    @Override public Object buscar(String dni) { return null; }
    @Override public Object[] listar() { return empleados; }
    @Override public int cantidad() { return indice; }
}

