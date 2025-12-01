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
        
        promociones[indice++]=new clases.Promocion("Verano2025", "Porcentaje", 10.0, "31/12/2025");
        promociones[indice++]=new clases.Promocion("BonoRegalo", "Monto Fijo", 500.0, "15/12/2025");
        promociones[indice++]=new clases.Promocion("BlackFriday", "Porcentaje", 20.0, "29/11/2025");
        promociones[indice++]=new clases.Promocion("ClienteNuevo", "Monto Fijo", 100.0, "Indefinido");
        promociones[indice++]=new clases.Promocion("EmpleadoVIP", "Porcentaje", 5.0, "Todo el año");
        
    }
    
    @Override public void agregar(Object obj) { 
        if(obj instanceof Promocion) promociones[indice++] = (Promocion) obj;
    }
    @Override public Object[] listar() { 
        return promociones; 
    }
    @Override public void eliminar(String nombre) {
        int pos = -1;
        for(int i = 0; i < indice; i++) {
            if(promociones[i].getNombre().equals(nombre)) {
                pos = i;
                break;
            }
        }
        if(pos != -1) {
            for(int k = pos; k < indice - 1; k++) {
                promociones[k] = promociones[k + 1];
            }
            promociones[indice - 1] = null;
            indice--;
        }
    }
    @Override public void modificar(Object obj) {
        if (obj instanceof clases.Promocion) {
            clases.Promocion promoNueva = (clases.Promocion) obj;
            
            for (int i = 0; i < indice; i++) {
                if (promociones[i].getNombre().equals(promoNueva.getNombre())) {
                    promociones[i] = promoNueva; // Reemplazamos
                    return;
                }
            }
        }
    }
    @Override public Object buscar(String nombre) { 
        for(int i = 0; i < indice; i++) {
            if(promociones[i].getNombre().equals(nombre)) {
                return promociones[i];
            }
        }
        return null;
    }
    @Override public int cantidad() { return indice; }
}
