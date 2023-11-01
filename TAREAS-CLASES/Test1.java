
/**
 * Write a description of class Test1 here.
 * 
 * @author (Kisna Marmol) 
 * @version (a version number or a date)
 */
import javax.swing.JOptionPane;
public class Test1
{
    public static CuentaAhorro cuentas[] = new CuentaAhorro[10];
    public static int posicion = 0;
    
    public static void main(String args[]){
        inicializar();
        boolean seguir = true;
        
        String menu = "MENU\n 1.Crear una cuenta de ahorro\n 2.Depositar a una cuenta\n 3.Retirar de una cuenta\n 4.Lista de las cuentas de ahorro\n 0.Salir";
        int opcion = 0;
        
        do{
            opcion = FM.pedirEntero(menu);
            switch(opcion){
                case 1://Ingresar cuenta de ahorro
                    if(posicion < cuentas.length){
                        ingresarCuenta();
                    }else{
                        FM.mensaje("Sin espacio");
                    }
                break;
                case 2://Depositar en cuenta
                    depositar();
                break;
                case 3: //Retirar en cuenta
                    retirar();
                break;
                case 4://Lista de cuentas
                    listaCuentas();
                break;
                case 0://Salir
                    seguir = false;
                break;
                default:
                    JOptionPane.showMessageDialog(null, "Ingrese una opcion correcta");
            }
        }while(seguir);
    }
    //metodo que ingresa datos de una cuenta
    public static void ingresarCuenta(){
        String ID = FM.pedirCadena("Ingrese el ID");
        String titular = FM.pedirCadena("Ingrese el titular");
        double saldo = FM.pedirDecimal("Ingrese el saldo");
        cuentas[posicion]=new CuentaAhorro(ID,titular,saldo);
        posicion++;
    }
    //Funcion para depositar en una cuenta
    public static boolean depositar(){
        String ID = FM.pedirCadena("Ingrese la cuenta a la que va depositar");
        double cantidad = FM.pedirDecimal("Ingrese la cantidad");
        
        for(int i = 0; i < cuentas.length; i++){
            if(cuentas[i].getID().equals(ID)){
                return cuentas[i].depositar(cantidad);
            }
        }
        
        return false;//por mientras
    }
    //Funcion para retirar en una cuenta
    public static int retirar(){
        return 0;
    }
    //Metodo para imprimir las cuentas
    public static void listaCuentas(){
        String cadena="Listado de Cuentas\n";
        int i=0;
        while(i<posicion)
        {
            //cadena+=t[i].toString()+"\n";
            cadena=cadena+cuentas[i].toString()+"\n";
            i++;
        }
        FM.mensaje(cadena);
    }
    //Inicializar arreglo
    public static void inicializar(){
        for(int i = 0; i < cuentas.length; i++){
            cuentas[i] = new CuentaAhorro();
        }
    }
}
