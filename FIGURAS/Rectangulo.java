
/**
 * Write a description of class Rectangulo here.
 * 
 * @author (Kisna Marmol) 
 * @version (a version number or a date)
 */
import javax.swing.JOptionPane;
public class Rectangulo extends Figura
{
    int base = 0;
    int altura = 0;
    
    public Rectangulo(){
        super();
    }
    public Rectangulo(int x, int y, int base, int altura,String nombre){
        //super();
        super(x,y,nombre);
        this.base = base;
        this.altura = altura;
    }
    
    public double area() {
        return (double)base * altura;
    }
}
