
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
    boolean yaContado;// Indica si el espacio ya fue contado para los puntos
    public Espacio(int x, int y, int ancho, int alto){
        super(x,y);
        /*ancho=ima.getIconWidth();
        alto=ima.getIconHeight();*/
        this.ancho = ancho;
        this.alto = alto;
        setRectangle(); // Inicializa el rectángulo del espacio
        this.yaContado = false; // Inicializa el conteo
    }
    
    //Getters & Setters
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
    
    public void setRectangle(){// Método para inicializar el rectángulo del espacio
        rec = new Rectangle(x,y,ancho,alto);
        //System.out.println("Tube Rectangle: " + rec);
    }
    
    public void dibujar(Graphics g)
    {
        //g.drawImage(imagen,x,y,null);
        //g.setColor(Color.GREEN);
        //g.fillRect(x, y, ancho, alto);
        //g.drawRect(x, y, ancho, alto);
    }
    
    public void mover(){
        x--;
        if(x < 0){
            x = 1080;// Si el espacio sale de la pantalla, se reinicia en la posición derecha
        }
    }
    
    public boolean detectarChoque(Rectangle otro)// Método para detectar choque con otro rectángulo
    {
        return rec.intersects(otro);
    }
    
    public boolean pasarEspacio(int x, int y, int ancho, int alto) {// Método para verificar si el pez pasa por el espacio y cuenta puntos
        // Verifica si el rectángulo definido por las coordenadas (x, y) y las dimensiones (ancho, alto)
        // se superpone con el área del espacio representado por este objeto.
        boolean pasaPorEspacio = (x + ancho >= this.x && x <= this.x + this.ancho) && (y + alto >= this.y && y <= this.y + this.alto);
        if(pasaPorEspacio && !yaContado){
            yaContado = true;// Marca el espacio como contado
            return true;// Indica que el pez ha pasado por el espacio
        }
        return false;// Indica que el pez no ha pasado por el espacio
    }
    
    public void resetYaContado(){// Método para reiniciar el estado de conteo del espacio
        yaContado = false;
    }
}
