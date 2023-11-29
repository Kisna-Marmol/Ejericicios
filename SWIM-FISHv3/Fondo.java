/**
 * Write a description of class Fondo here.
 * 
 * @author (Kisna Marmol) 
 * @version (a version number or a date)
 */

import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.Graphics;
public class Fondo extends Coordenada
{
    int ancho, alto;
    public Fondo(int x, int y, String ruta){
        super(x,y,ruta);
        ancho=ima.getIconWidth();
        alto=ima.getIconHeight();
    }
}
