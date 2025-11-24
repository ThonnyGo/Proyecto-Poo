/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilitario;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class PanelFondo extends JPanel {
    private Image imagen;

    // Constructor: Recibe la ruta de la imagen para que sea dinámico
    public PanelFondo(String rutaImagen) {
        try {
            // Cargamos la imagen desde tu paquete de imágenes
            imagen = new ImageIcon(getClass().getResource(rutaImagen)).getImage();
        } catch (Exception e) {
            System.out.println("Error cargando imagen: " + rutaImagen);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        // Dibuja la imagen ocupando todo el ancho y alto del panel
        if (imagen != null) {
            g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
        }
        // Esta línea es importante para que se dibujen los botones encima
        setOpaque(false); 
        super.paintComponent(g);
    }
}