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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    public String getCorreo() { 
        return correo; 
    }
    public String getDireccion() { 
        return direccion; 
    }
    @Override public String getTipoPersona() { return "Cliente"; }
}
