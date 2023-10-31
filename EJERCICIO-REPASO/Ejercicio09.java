
/**
 * 9. Programa que determine si un número que da el usuario es positivo, 
 * negativo o cero.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import javax.swing.JOptionPane;
public class Ejercicio09
{
    public static void main(String args[]){
        int num = 0;
        
        String entrada = JOptionPane.showInputDialog("Ingrese un numero");
        num = Integer.parseInt(entrada);
        
        if(num > 0){
            JOptionPane.showMessageDialog(null,num+" es positivo.");
        }else if(num < 0){
            JOptionPane.showMessageDialog(null,num+" es negativo.");
        }else if (num == 0){
            JOptionPane.showMessageDialog(null,num+" es cero.");
        }
    }
}
