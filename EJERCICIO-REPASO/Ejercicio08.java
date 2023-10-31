/**
 * 8. Ingresar el nombre de un hombre y de una mujer y luego mostrar en  
 * pantalla que  se va a casar con .
 * 
 * @author (Kisna Marmol) 
 * @version (a version number or a date)
 */
import javax.swing.JOptionPane;
public class Ejercicio08
{
    public static void main(String args[]){
        String nombreH = JOptionPane.showInputDialog("Ingrese el nombre del hombre");
        String nombreM = JOptionPane.showInputDialog("Ingrese el nombre de la mujer");
        
        JOptionPane.showMessageDialog(null,nombreH+" se casara con "+nombreM);
    }
}
