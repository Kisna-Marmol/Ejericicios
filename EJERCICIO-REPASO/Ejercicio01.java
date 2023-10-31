
/**
 * 1. Programa que sume tres números introducidos por el usuario.
 * 
 * @author (Kisna Marmol) 
 * @version (a version number or a date)
 */
import javax.swing.JOptionPane;
public class Ejercicio01
{
    public static void main(String args[]){
        int num1 = 0;
        int num2 = 0;
        int num3 = 0;
        int suma = 0;
        String entrada = "";
        
        entrada = JOptionPane.showInputDialog("Ingrese el primer numero");
        num1 = Integer.parseInt(entrada);
        entrada = JOptionPane.showInputDialog("Ingrese el segundo numero");
        num2 = Integer.parseInt(entrada);
        entrada = JOptionPane.showInputDialog("Ingrese el tercer numero");
        num3 = Integer.parseInt(entrada);
        
        suma = num1+num2+num3;
        
        JOptionPane.showMessageDialog(null,"La suma de los tres numeros es "+suma);
    }
}
