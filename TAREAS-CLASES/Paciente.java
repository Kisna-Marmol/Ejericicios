
/**
 * Write a description of class Paciente here.
 * 
 * @author (Kisna Marmol) 
 * @version (a version number or a date)
 */
import javax.swing.JOptionPane;
public class Paciente
{
    public String nombre;
    public int edad = 0;
    public String ID;
    public char genero;
    public double peso;
    public double altura;
    
    //Constructores
    public Paciente(){
        
    }
    public Paciente(String nombre, int edad, char genero, double peso, double altura) {
    	this.nombre = nombre;
    	this.edad = edad;
    	this.ID = "";
    	this.genero = genero;
    	this.peso = peso;
    	this.altura = altura;
    }
    public Paciente(String nombre, int edad, String ID, char genero, double peso, double altura){
        this.nombre = nombre;
        this.edad = edad;
        this.ID = ID;
        this.genero = genero;
        this.peso = peso;
        this.altura = altura;
    }
    public Paciente(String nombre, int edad, char genero){
        this.nombre = nombre;
        this.edad = edad;
        this.ID = "";
        this.genero = genero;
        this.peso = 0.0;
        this.altura = 0.0;
    }
    
    //Funcion para calcula IMC
    public int calcIMC(){
        double imc = peso / (altura*altura);
        if(imc < 20){
            return -1;
        }else if(imc >= 20 && imc <= 25){
            return 0;
        }else{
            return 1;
        }
    }
    //Funcion para vereficar si es mayor o menor de edad
    public boolean vereficarEdad(){
        return edad >= 18;
    }
    
    //Getter & setter
    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public int getEdad(){
        return edad;
    }
    public void setEdad(int edad){
        this.edad = edad;
    }
    
    public String getID(){
        return ID;
    }
    public void setID(String ID){
        this.ID = ID;
    }
    
    public char getGenero(){
        return genero;
    }
    public void setGenero(char genero){
        this.genero = genero;
    }
    
    public double getPeso(){
        return peso;
    }
    public void setPeso(double peso){
        this.peso = peso;
    }
    
    public double getAltura(){
        return altura;
    }
    public void setAltura(double altura){
        this.altura = altura;
    }
    
    //metodo toString
    public String toString(){
        return "ID: "+ID+", Nombre: "+nombre+", Edad: "+edad+", Genero: "+genero+", Peso: "+peso+", Altura: "+altura;
    }
}
