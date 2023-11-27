
/**
 * Write a description of class Principal here.
 * 
 * @author (Kisna Marmol) 
 * @version (a version number or a date)
 */
import javax.swing.JFrame;
public class Principal extends JFrame
{
    Escenario e;
    public Principal(){
        super("SWIM FISH");
        
        e = new Escenario();
        add(e);
        
        setSize(e.getWidth(),e.getHeight()+50);//Tamaño de ventana
        setLocationRelativeTo(null);//centrar la ventana en la pantalla
        setResizable(false);//que no maximice
        setVisible(true);//Mostrar ventana
    }
    public static void main(String[] args){
        new Principal();
    }
}
