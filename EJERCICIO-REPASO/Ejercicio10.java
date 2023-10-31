/**
 * 10. Escribir un programa que diga si 3 lados introducidos por el usuario 
 * forman un triángulo equilátero.
 * 
 * @author (Kisna Marmol) 
 * @version (a version number or a date)
 */
import javax.swing.JOptionPane;
public class Ejercicio10
{
    public static void main(String args[]){
        int ladoA = 0;
        int ladoB = 0;
        int ladoC = 0;
        String entrada = "";
        
        entrada = JOptionPane.showInputDialog("Ingrese el primer lado");
        ladoA = Integer.parseInt(entrada);
        entrada = JOptionPane.showInputDialog("Ingrese el segundo lado");
        ladoB = Integer.parseInt(entrada);
        entrada = JOptionPane.showInputDialog("Ingrese el tercer lado");
        ladoC = Integer.parseInt(entrada);
        
        if(ladoA == ladoB && ladoA == ladoC || ladoB == ladoA && ladoB == ladoC || ladoC == ladoA && ladoC == ladoB){
            JOptionPane.showMessageDialog(null,"El triangulo es equilatero");
        }
    }
}
