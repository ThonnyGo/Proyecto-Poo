/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author fsg20
 */
public class Cliente extends Persona {
    private String direccion;
    private String telefono;
    private String correo;

    public Cliente(String dni, String nom, String apePaterno, String apeMaterno, String dir, String tel, String correo) {
        super(dni, nom, apePaterno + " " + apeMaterno); // Concatenamos apellidos para simplificar herencia
        this.direccion = dir;
        this.telefono = tel;
        this.correo = correo;
    }
    
    // Getters necesarios para Cotización (Req 4)
    public String getCorreo() { return correo; }
    public String getDireccion() { return direccion; }
    @Override public String getTipoPersona() { return "Cliente"; }
}
