
/**
 * 6. Pedir 2 números y mostrar en pantalla el mayor de  ambos.
 * 
 * @author (Kisna Marmol) 
 * @version (a version number or a date)
 */
import javax.swing.JOptionPane;
public class Ejercicio06
{
    public static void main(String args[]){
        int num1 = 0;
        int num2 = 0;
        String entrada = "";
        
        entrada = JOptionPane.showInputDialog("Ingrese el primer numero");
        num1 = Integer.parseInt(entrada);
        entrada = JOptionPane.showInputDialog("Ingrese el segundo numero");
        num2 = Integer.parseInt(entrada);
        
        if(num1 > num2){
            JOptionPane.showMessageDialog(null,"El primer numero = "+num1+" es mayor que el segundo numero = "+num2);
        }else{
            JOptionPane.showMessageDialog(null,"El primer numero = "+num1+" es menor que el segundo numero = "+num2);
        }
    }
}
