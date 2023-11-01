
/**
 * Write a description of class CuentaAhorro here.
 * 
 * @author (Kisna Marmol) 
 * @version (a version number or a date)
 */
import javax.swing.JOptionPane;
public class CuentaAhorro
{
    String ID;
    String titular;
    double saldo = 0.0;
    
    public CuentaAhorro(){
        
    }
    public CuentaAhorro(String ID, String titular, double saldo){
        this.ID = ID;
        this.titular = titular;
        this.saldo = saldo;
    }
    //Funcion depositar que aunmenta el valor del saldo con la cantidad que el usuario ingrese
    public boolean depositar(double cantidad){
        boolean seguir = true;
        if(cantidad > 0){
            saldo += cantidad;
            return seguir = false;
        }else{
            FM.mensaje("La cantidad es negativa no se puede realizar la transaccion.");
        }
        return seguir;
    }
    //Funcion retira que disminuye el valor del saldo con la cantidad que el usuario ingrese
    public boolean retirar(double cantidad){
        boolean seguir = true;
        if(cantidad > 0 && cantidad <= saldo){
            saldo -= cantidad;
            return seguir = false;
        }else if(cantidad <= 0){
            FM.mensaje("La cantidad es negativa no se puede realizar la transaccion.");
        }else{
            FM.mensaje("No tiene suficiente dinero es su cuenta");
        }
        return seguir;
    }
    
    //getters & setter
    public String getID(){
        return this.ID;
    }
    public void setID(String ID){
        this.ID = ID;
    }
    
    public String getTitular(){
        return titular;
    }
    public void setTitular(String titular){
        this.titular = titular;
    }
    
    public double getSaldo(){
        return saldo;
    }
    public void setSaldo(double saldo){
        this.saldo = saldo;
    }
    
    //toString
    public String toString(){
        return "ID: "+ID+", Titular: "+titular+", Saldo = "+saldo;
    }
}
