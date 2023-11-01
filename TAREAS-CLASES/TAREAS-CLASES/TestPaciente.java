
/**
 * Write a description of class Test2 here.
 * 
 * @author (Kisna Marmol) 
 * @version (a version number or a date)
 */
import javax.swing.JOptionPane;
public class TestPaciente
{
    public static void main(String args[]){
        String nombre = FM.pedirCadena("Ingrese el nombre:");
        int edad = FM.pedirEntero("Ingrese la edad");
        char genero = FM.pedirLetra("Ingrese el genero (F/M):");
        double peso = FM.pedirDecimal("Ingrese el peso en kg:");
        double altura = FM.pedirDecimal("Ingrese al altura en ft:");
        
        //Paciente paciente1 = new Paciente(nombre, edad, genero, peso, altura);
        Paciente paciente1 = new Paciente(nombre, edad, genero, peso, altura);
        Paciente paciente2 = new Paciente(nombre, edad, genero);
        Paciente paciente3 = new Paciente();
        
        Paciente[] pacientes = {paciente1, paciente2, paciente3};
        
        for(int i = 0; i < pacientes.length; i++){
            
            
        }
    }
}
