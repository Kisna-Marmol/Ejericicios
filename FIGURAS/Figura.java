
/**
 * Write a description of class Figura here.
 * 
 * @author (Kisna Marmol) 
 * @version (a version number or a date)
 */
import javax.swing.JOptionPane;
public class Figura
{
    private int x = 0;
    private int y = 0;
    private String nombre;
    
    public Figura(){
        
    }
    public Figura(int x, int y, String nombre){
        this.x = x;
        this.y = y;
        this.nombre = nombre;
    }
    public Figura(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    public double area() {
        return 0;  // Por defecto, devolvemos 0. Este valor puede ser modificado según la figura.
    }
    
    //Getter & Setter
    public int getX(){
        return x;
    }
    public void setX(int x){
        this.x = x;
    }
    
    public int getY(){
        return y;
    }
    public void setY(int y){
        this.y = y;
    }
    
    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
}
