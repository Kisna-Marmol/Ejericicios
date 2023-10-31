/**
 * 3. Programa que promedie 4 notas introducidas por el usuario.
 * @author (Kisna Marmol) 
 */
import javax.swing.JOptionPane;
public class Ejercicio03
{
    public static void main(String args[]){
        int nota1 = 0;
        int nota2 = 0;
        int nota3 = 0;
        int nota4 = 0;
        double promedio = 0.0;
        String entrada = "";
        
        entrada = JOptionPane.showInputDialog("Ingrese la primer nota");
        nota1 = Integer.parseInt(entrada);
        entrada = JOptionPane.showInputDialog("Ingrese la segunda nota");
        nota2 = Integer.parseInt(entrada);
        entrada = JOptionPane.showInputDialog("Ingrese la tercer nota");
        nota3 = Integer.parseInt(entrada);
        entrada = JOptionPane.showInputDialog("Ingrese la cuarta nota");
        nota4 = Integer.parseInt(entrada);
        
        promedio = nota1+nota2+nota3+nota4/4;
        
        JOptionPane.showMessageDialog(null,"El promedio de las cuatro notas es "+promedio+".");
    }
}
