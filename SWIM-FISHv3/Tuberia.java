

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
    Rectangle rec; // Rectángulo para detección de colisiones
    boolean frenar = false; // Indica si la tubería debe frenar su movimiento
    public Tuberia(int x, int y, String ruta){
        super(x,y,ruta);
        ancho=ima.getIconWidth();
        alto=ima.getIconHeight();
        setRectangle();// Inicializa el rectángulo de colisión
    }
    
    public void setRectangle(){ // Inicializa el rectángulo de colisión
        rec = new Rectangle(x,y,ancho,alto);
    }
    public Rectangle getRectangle(){ // Getter para el rectángulo de colisión
        return rec;
    }
    
    //Getters & Setters de Ancho y Alto y Altura
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
    
    public void mover(){// Método para mover la tubería hacia la izquierda
        x--;
        if(x < 0){
            x = 1080; // Si la tubería sale de la pantalla, la reposiciona al extremo derecho
        }
    }
    
}
