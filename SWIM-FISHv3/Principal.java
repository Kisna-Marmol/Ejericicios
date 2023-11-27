
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
        
        e = new Escenario(this);
        add(e);
        
        setSize(e.getWidth(),e.getHeight()+50);//Tamaño de ventana
        setLocationRelativeTo(null);//centrar la ventana en la pantalla
        setResizable(false);//que no maximice
        setVisible(true);//Mostrar ventana
    }
    // Método para cerrar la ventana
    public void cerrarVentana() {
        setVisible(false); // Oculta la ventana
        dispose(); // Libera los recursos asociados con la ventana
        System.exit(0); // Sale del programa
    }
    public static void main(String[] args){
        new Principal();
    }
}
