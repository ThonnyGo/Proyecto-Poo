/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

/**
 *
 * @author rauly
 */
public interface Mantenimiento {

    void agregar(Object obj);
    void eliminar(String codigo);
    void modificar(Object obj);
    Object buscar(String codigo);
    Object[] listar();
    int cantidad(); 
}

