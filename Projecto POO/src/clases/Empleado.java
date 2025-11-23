/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author fsg20
 */
public abstract class Empleado extends Persona{
    protected String usuario;
    protected String password;
    protected String rol; // "Administrador" o "Vendedor"

    public Empleado(String dni, String nombres, String apellidos, String usuario, String password, String rol) {
        super(dni, nombres, apellidos);
        this.usuario = usuario;
        this.password = password;
        this.rol = rol;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    // Lógica para el REQ 10: Login
    public boolean autenticar(String user, String pass) {
        return this.usuario.equals(user) && this.password.equals(pass);
    }
    
    public String getRol() { return rol; }
}


    

