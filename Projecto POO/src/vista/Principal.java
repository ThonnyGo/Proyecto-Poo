/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

/**
 *
 * @author rauly
 */
import Gestiones.*; 

public class Principal {
    // ESTO ES TU "MEMORIA": Arreglos estáticos accesibles desde cualquier ventana
    public static ArregloEmpleados gestorEmpleados = new ArregloEmpleados();
    public static ArregloVehiculos gestorVehiculos = new ArregloVehiculos();
    public static ArregloClientes gestorClientes = new ArregloClientes();
    public static ArregloVentas gestorVentas = new ArregloVentas();
    public static ArregloPromociones gestorPromociones = new ArregloPromociones();
    
    public static clases.Empleado empleadoAutenticado;

    public static void main(String[] args) {
        // Al ejecutar, arrancamos el LOGIN directamente
        frmLogin login = new frmLogin();
        login.setVisible(true);
    }
}
