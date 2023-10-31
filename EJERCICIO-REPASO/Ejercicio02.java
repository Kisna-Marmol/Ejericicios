
/**
 * 2. Programa que calcule el cubo de un número introducido por el usuario.
 * 
 * @author (Kisna Marmol) 
 * @version (a version number or a date)
 */
import javax.swing.JOptionPane;
public class Ejercicio02
{
    public static void main(String args[]){
        int num = 0;
        String entrada = "";
        int numCubo = 0;
        
        entrada = JOptionPane.showInputDialog("Ingrese un numero");
        num = Integer.parseInt(entrada);
        
        //numCubo = Math.pow(num, 3);
        numCubo = num * num * num;
        
        JOptionPane.showMessageDialog(null,"El numero "+num+" al cubo es "+numCubo);
    }
}
