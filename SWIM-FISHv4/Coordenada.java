
/**
 * Write a description of class Coordenada here.
 * 
 * @author (Kisna Marmol) 
 * @version (a version number or a date)
 */
import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.Graphics;

public class Coordenada
{
    int x;
    int y;
    ImageIcon ima;
    Image imagen;
    
    public Coordenada(int x, int y, String ruta){
        this.x = x;
        this.y = y;
        this.ima = new ImageIcon(getClass().getResource(ruta));
        this.imagen = ima.getImage();
    }
    public Coordenada(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    public int getX(){
        return this.x;
    }
    public void setX(int x){
        this.x = x;
    }
    
    public int getY(){
        return this.y;
    }
    public void setY(int y){
        this.y = y;
    }
    
    public void dibujar(Graphics g){
        g.drawImage(imagen,x,y,null);
    }
}
