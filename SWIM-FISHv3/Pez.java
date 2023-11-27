
/**
 * Write a description of class Pez here.
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
    private Rectangle rec;
    boolean espacioPresionado;
    boolean frenar = false;
    public Pez(int x, int y, String ruta){
        super(x,y,ruta);
        ancho=ima.getIconWidth();
        alto=ima.getIconHeight();
        setRectangle(); // Agrega esta línea para inicializar el rectángulo
    }
    
    public void setRectangle(){
        rec = new Rectangle(x,y,ancho,alto);
        //System.out.println("Fish Rectangle: " + rec);
    }
    
    public void dibujar(Graphics g)
    {
        g.drawImage(imagen,x,y,null);
    }
    
    //Movimiento
    public void mover(){
        if(frenar == false){
        y--;
        setRectangle();}
        /*if(dir == 'a'){
            y--;
            setRectangle();
            //rec.setLocation(x, y); 
            //System.out.println("Fish Position: x=" + x + ", y=" + y);
        }*/
    }
    public void moverAut(){
        if(frenar == false){
        if(x < 550){
        x++;}//se mueve a la derecha
        y++;//se mueve para abajo
        rec.setLocation(x, y);} 
    }
    
    
    public boolean detectarTuberia(Tuberia[] tuberias){
        moverAut();
        mover();
        for(Tuberia tuberia : tuberias ){
            //System.out.println("Fish Rectagle: " + this.rec);
            //System.out.println("Tube Rectangle: " + tuberia.rec);
            //System.out.println("intersects: " + this.rec.intersects(tuberia.rec));
            if(this.rec.intersects(tuberia.rec)){
                return true;
            }
        }
        return false;
    }
    
    public boolean detectarEspacio(Espacio[] espacios){
        moverAut();
        mover();
        for(Espacio espacio : espacios ){
            //System.out.println("Fish Rectagle: " + this.rec);
            //System.out.println("Tube Rectangle: " + tuberia.rec);
            //System.out.println("intersects: " + this.rec.intersects(tuberia.rec));
            if(this.rec.intersects(espacio.rec)){
                return true;
            }
        }
        return false;
    }
    
    public void setEspacioPresionado(Boolean presionado){
        this.espacioPresionado = presionado;
    }
    
    public void actualizar(){
        if(!espacioPresionado){
            moverAut();
        }
    }
}

