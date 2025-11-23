/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gestiones;

import Interfaces.Mantenimiento;
import clases.Promocion;

/**
 *
 * @author rauly
 */
public class ArregloPromociones implements Mantenimiento {
    private Promocion[] promociones;
    private int indice;
    
    public ArregloPromociones() {
        this.promociones = new Promocion[20];
        this.indice = 0;
    }
    
    @Override public void agregar(Object obj) { if(obj instanceof Promocion) promociones[indice++] = (Promocion) obj; }
    @Override public Object[] listar() { return promociones; }
    // Resto de CRUD vacío por brevedad...
    @Override public void eliminar(String n) {}
    @Override public void modificar(Object o) {}
    @Override public Object buscar(String n) { return null; }
    @Override public int cantidad() { return indice; }
}
