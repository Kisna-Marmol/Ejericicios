
/**
 * Write a description of class FM here.
 * 
 * @author (Kisna Marmol) 
 * @version (a version number or a date)
 */
import javax.swing.JOptionPane;
public class FM
{
    //Funcion que pide, valida y devuelve un entero
    public static int pedirEntero(String mensaje){
        boolean seguir = true;
        int numero = 0;
        
        do{
            try{
                String num = JOptionPane.showInputDialog(mensaje);
                numero = Integer.parseInt(num);
                seguir = false;
            }catch(Exception e){
                FM.mensaje("ERROR, Ingrese un entero");
            }
        }while(seguir == true);
        
        return numero;
    }
    //Funcion que pide, valida y devuelve un decimal
    public static double pedirDecimal(String mensaje)
    {
        boolean seguir=true;
        double num = 0;
        
        do{
            String cadena = JOptionPane.showInputDialog(mensaje);
            num = Double.parseDouble(cadena);
            if((num % 1) != 0){//verifica que sea decimal
                seguir = false;
            }else{
                FM.mensaje("ERROR, Ingrese un decimal");
            }
        }while(seguir == true);
        
        return num;
    }
    //Funcion que pide una cadena, la valida si no esta vacia y la devuelve
    public static String pedirCadena(String mensaje){
        String cadena = " ";
        boolean seguir = true;
        
        do{
            cadena = JOptionPane.showInputDialog(mensaje);
            if(cadena != null && !cadena.isEmpty() && cadena.length() >= 3){
                //FM.mensaje("La cadena ingresada es: "+cadena);
                seguir = false;
            }else{
                FM.mensaje("La cadena esta vacia, vuelva a intentarlo");
            }
        }while(seguir == true);
        
        return cadena;
    }
    //Metodo que muestra un mensaje en una caja de dialogos de la libreria JOptionPane MessageDialog
    public static void mensaje(String mensaje){
        JOptionPane.showMessageDialog(null,mensaje);
    }
}
