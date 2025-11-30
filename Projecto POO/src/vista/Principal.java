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
import javax.swing.UIManager;

public class Principal {
    // ESTO ES TU "MEMORIA": Arreglos estáticos accesibles desde cualquier ventana
    public static ArregloEmpleados gestorEmpleados = new ArregloEmpleados();
    public static ArregloVehiculos gestorVehiculos = new ArregloVehiculos();
    public static ArregloClientes gestorClientes = new ArregloClientes();
    public static ArregloVentas gestorVentas = new ArregloVentas();
    public static ArregloPromociones gestorPromociones = new ArregloPromociones();
    public static clases.Empleado empleadoAutenticado;
    public static ArregloReservas gestorReservas = new ArregloReservas();
    public static GestorReservasTemporizador temporizadorReservas =
            new GestorReservasTemporizador(gestorReservas);

    public static void main(String[] args) {
        try {

            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");

        } catch (Exception e) {

        }
        frmLogin login = new frmLogin();
        login.setVisible(true);
    }
}
