
/**
 * Write a description of class Cuadrado here.
 * 
 * @author (Kisna Marmol) 
 * @version (a version number or a date)
 */
import javax.swing.JOptionPane;
public class Cuadrado extends Figura
{
    int lado = 0;
    
    public Cuadrado(){
        super();
    }
    public Cuadrado(int x, int y, int lado,String nombre){
        //super();
        super(x,y,nombre);
        this.lado = lado;
    }
    
    public double area() {
        return (double)lado * lado;
    }
}
