
/**
 * Write a description of class Circulo here.
 * 
 * @author (Kisna Marmol) 
 * @version (a version number or a date)
 */
import javax.swing.JOptionPane;
public class Circulo extends Figura
{
    int radio = 0;
    
    public Circulo(){
        super();
    }
    public Circulo(int x, int y, int radio,String nombre){
        super(x,y,nombre);
        this.radio = radio;
    }
    
    public double area(){
        return Math.PI * radio * radio;
    }
}
