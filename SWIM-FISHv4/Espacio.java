
/**
 * Write a description of class Espacio here.
 * 
 * @author (Kisna Marmol) 
 * @version (a version number or a date)
 */

import java.awt.Image;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import java.awt.Rectangle;
import java.awt.Color;
public class Espacio extends Coordenada
{
    int ancho, alto;
    Rectangle rec;
    public Espacio(int x, int y, int ancho, int alto){
        super(x,y);
        /*ancho=ima.getIconWidth();
        alto=ima.getIconHeight();*/
        this.ancho = ancho;
        this.alto = alto;
        setRectangle();
    }
    
    public int getAncho(){
        return ancho;
    }
    public void setAncho(int ancho){
        this.ancho = ancho;
    }
    
    public int getAlto(){
        return alto;
    }
    public void setAlto(int alto){
        this.alto = alto;
    }
    
    public void setRectangle(){
        rec = new Rectangle(x,y,ancho,alto);
        //System.out.println("Tube Rectangle: " + rec);
    }
    
    public void dibujar(Graphics g)
    {
        //g.drawImage(imagen,x,y,null);
        g.setColor(Color.GREEN);
        g.fillRect(x, y, ancho, alto);
        //g.drawRect(x, y, ancho, alto);
    }
    
    public void mover(){
        x--;
        if(x < 0){
            x = 1080;
        }
    }
    
    public boolean detectarChoque(Rectangle otro)
    {
        return rec.intersects(otro);
    }
    
    // Dentro de la clase Pez
    public Rectangle getBounds() {
        return new Rectangle(x, y, ancho, alto);
    }
}
