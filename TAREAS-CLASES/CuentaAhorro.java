
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
    
    public boolean depositar(double cantidad){
        boolean seguir = true;
        if(cantidad > 0){
            saldo += cantidad;
            return seguir = false;
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
