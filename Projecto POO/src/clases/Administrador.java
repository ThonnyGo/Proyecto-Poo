/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author fsg20
 */
public class Administrador extends Empleado {
    public Administrador(String dni, String nom, String ape, String user, String pass) {
        super(dni, nom, ape, user, pass, "Administrador");
    }
    @Override public String getTipoPersona() { return "Administrador"; }
}
    

