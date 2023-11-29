

/**
 * Write a description of class Tuberia here.
 * 
 * @author (Kisna Marmol) 
 * @version (a version number or a date)
 */
import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.Graphics;
import java.awt.Rectangle;
public class Tuberia extends Coordenada
{
    int ancho, alto;
    Rectangle rec;
    boolean frenar = false;
    public Tuberia(int x, int y, String ruta){
        super(x,y,ruta);
        ancho=ima.getIconWidth();
        alto=ima.getIconHeight();
        setRectangle();
    }
    
    public void setRectangle(){
        rec = new Rectangle(x,y,ancho,alto);
    }
    public Rectangle getRectangle(){
        return rec;
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
    
    public void setAltura(int nuevaAltura) {
        this.alto = nuevaAltura;
    }
    public int getAltura() {
        return alto;
    }
    
    public void mover(){
        x--;
        if(x < 0){
            x = 1080;
        }
    }
    
}
