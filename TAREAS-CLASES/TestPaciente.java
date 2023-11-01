
/**
 * Write a description of class Test2 here.
 * 
 * @author (Kisna Marmol) 
 * @version (a version number or a date)
 */
import javax.swing.JOptionPane;
public class TestPaciente
{
    //public static Paciente paciente[] = new Paciente[3];
    public static void main(String args[]){
        String nombre = FM.pedirCadena("Ingrese el nombre:");
        int edad = FM.pedirEntero("Ingrese la edad");
        char genero = FM.pedirLetra("Ingrese el genero (F/M):");
        double peso = FM.pedirDecimal("Ingrese el peso en kg:");
        double altura = FM.pedirDecimal("Ingrese al altura en ft:");
        
        Paciente p[] = new Paciente[3]; //arreglo de paciente
        p[0] = new Paciente(nombre, edad, genero, peso, altura);
        p[1] = new Paciente(nombre, edad, genero);
        p[1].setPeso(70.5);
        p[1].setAltura(1.70);
        p[2] = new Paciente();
        
        
        for(int i = 0; i < p.length; i++){
            FM.mensaje("Paciente #"+(i+1)+"\n==========================================\n"+p[i].toString());
            int resultadoIMC = p[i].calcIMC();
            if(resultadoIMC == -1){
                FM.mensaje("El paciente esta por debajo de su peso ideal");
            }else if(resultadoIMC == 0){
                FM.mensaje("El paciente esta en su peso ideal");
            }else{
                FM.mensaje("El paciente tiene sobrepeso");
            }
            
            FM.mensaje("Es mayor de edad: "+p[i].vereficarEdad());
        }
    }
}
