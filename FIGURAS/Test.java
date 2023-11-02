
/**
 * Write a description of class Test here.
 * 
 * @author (Kisna Marmol) 
 * @version (a version number or a date)
 */
import javax.swing.JOptionPane;
public class Test
{
    public static void main(String args[]){
        Figura f[] = new Figura[3];
        f[0] = new Circulo(100,200,10,"Circulo");
        f[1] = new Cuadrado(50,60,10,"Cuadrado");
        f[2] = new Rectangulo(70,50,60,70,"Rectangulo");
        
        String cadena = "Informacion de Figura\n";
        for(int i = 0; i < f.length; i++){
            cadena += f[i].getNombre()+" Area: "+f[i].area()+"\n";
        }
        FM.mensaje(cadena);
    }
}
