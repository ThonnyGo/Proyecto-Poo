/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author fsg20
 */
public class Vendedor extends Empleado {
    public Vendedor(String dni, String nom, String ape, String user, String pass) {
        super(dni, nom, ape, user, pass, "Vendedor");
    }
    @Override public String getTipoPersona() { return "Vendedor"; }
}
