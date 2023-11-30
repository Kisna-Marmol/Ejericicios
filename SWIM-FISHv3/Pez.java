/**
 * Write a description of class Tuberia here.
 * 
 * @author (Kisna Marmol) 
 * @version (a version number or a date)
 */
import java.awt.Image;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import java.awt.Rectangle;
public class Pez extends Coordenada
{
    private int ancho, alto;
    private Rectangle rec; //Rectangle para detectar colisiones
    boolean espacioPresionado; //Indica si la tecla Espacio esta presionada
    boolean frenar = false;// Indica si el pez debe frenar su movimiento
    //boolean pasoPorEspacio; //Indica si el pez a pasado por un espacio
    public Pez(int x, int y, String ruta){
        super(x,y,ruta);
        ancho=ima.getIconWidth();
        alto=ima.getIconHeight();
        setRectangle(); //Inicializa el rectángulo
    }
    
    //Getters para Alto & Ancho
    public int getAncho(){
        return ancho;
    }
    public int getAlto(){
        return alto;
    }
    
    public void setRectangle(){//Inicializa el rectangulo
        rec = new Rectangle(x,y,ancho,alto);
    }
    
    //Movimiento con tecla
    public void mover(){
        if(frenar == false){
            y--; //Movimiento hacia arriba
            setRectangle();// Actualiza el rectángulo de colisión a la nueva posición
        }
    }
    
    public void moverAut(){ //Movimiento automaticos
        if(frenar == false){
            if(x < 550){
                x++;//se mueve a la derecha
            }
            y++;//se mueve para abajo
            rec.setLocation(x, y);// Actualiza el rectángulo de colisión a la nueva posición
        } 
    }
    
    public boolean detectarTuberia(Tuberia[] tuberias){//Metodo para detectar colision con tuberias
        moverAut();
        mover();
        for(Tuberia tuberia : tuberias ){
            if(this.rec.intersects(tuberia.rec)){
                return true;//Hay colision con la tuberia
            }
        }
        return false; //No hay colision
    }
    
    public boolean detectarEspacio(Espacio[] espacios){//Metodo para detectar colision con los espacios
        moverAut();
        mover();
        for (Espacio espacio : espacios) {
            if(this.rec.intersects(espacio.rec)){
                return true; //Hay colision en el espacio
            }
        }
        return false; // Si el pez no está en ningún espacio, devuelve false
    }
    
    public void setEspacioPresionado(Boolean presionado){// Setter para indicar si la tecla de espacio está presionada
        this.espacioPresionado = presionado;
    }
    
    public void actualizar(){// Método para actualizar la posición del pez
        if(!espacioPresionado){
            moverAut();
        }
    }
}

