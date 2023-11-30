
/**
 * Write a description of class Escenario here.
 * 
 * @author (Kisna Marmol) 
 * @version (a version number or a date)
 */
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import javax.swing.Timer;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.Font;
import javax.swing.JOptionPane;
import java.util.List;
import java.util.ArrayList;

public class Escenario extends JPanel implements ActionListener, KeyListener {
    int TUBERIA_MIN_Y = -25;//Posicion minima en Y de las tuberias superiores
    /*private static final*/ int TUBERIA_MAX_Y = -50;//Posicion maxima en Yde las tuberias superiores
    int TUBERIA_MIN_HEIGHT = 300;//410 Altura maxima de las tuberias
    int TUBERIA_MAX_HEIGHT = 410;//500 Altura minina de las tuberias
    int ESPACIO_ENTRE_TUBOS; //Espacio entre las tuberias

    Tuberia tAbajo[]; //Arreglo de tuberias de abajo
    Tuberia tArriba[]; //Arreglo de tuberia de arrbia
    Timer tem; //Temporizador
    Fondo f; //Fondo
    Pez p;// Pez
    Espacio recEnMedio[]; //Arreglo de espacio entre las tuberias
    int contadorPuntos = 0; //Contador de Puntos
    Principal principal; //Referencia a la clase principal
    List<Espacio> espacioAtravesado; //Lista para almacenar los espacios atravesados

    public Escenario(Principal principal) {
        this.principal = principal;
        inicializarTuberiaArriba();
        inicializarTuberiaAbajo();
        inicializarEspacio();
        f = new Fondo(0, 0, "imagenes/fondo4.jpg");
        p = new Pez(50, 280, "imagenes/pez3.png");//y = 300
        espacioAtravesado = new ArrayList<>(); //Inicializa la lista de espacios Atravesados
        tem = new Timer(70, this);
        tem.start();
        addKeyListener(this);
        setFocusable(true);
        setSize(f.ancho, f.alto);//f.ancho + 200, f.alto + 100; Establece el ancho y alto del Panel segun el fondo
    }

    private void inicializarTuberiaAbajo() {
        tAbajo = new Tuberia[11];
        int x = 400;
        for (int i = 0; i < tAbajo.length; i++) {
            int yy = FM.generaAleatorio(TUBERIA_MIN_HEIGHT + ESPACIO_ENTRE_TUBOS, TUBERIA_MAX_HEIGHT); //Genera posicion aleatoria en Y
            tAbajo[i] = new Tuberia(x + i * 100, yy, "imagenes/tuberia11.png");//x + i * 100
        }
    }

    private void inicializarEspacio() {
        recEnMedio = new Espacio[11];
        for (int i = 0; i < recEnMedio.length; i++) {
            int yy = FM.generaAleatorio(TUBERIA_MIN_HEIGHT, TUBERIA_MAX_HEIGHT);//Genera posicion aleatoria en Y
            int medioX = tAbajo[i].getX() + (tAbajo[i].getAncho() - 100) / 2;//Calcula la posicion X del centro del espacio
            int medioY = (tAbajo[i].getY() + tArriba[i].getY() + tArriba[i].getAlto()) / 2 - 50; // Calcula la posicion Y del centro del espacio
            recEnMedio[i] = new Espacio(medioX + 20, medioY - 15, 50, 150);//medioY - 65 Crea espacio en la posicion ya calculada
        }
    }

    private void inicializarTuberiaArriba() {
        tArriba = new Tuberia[11];
        int x = 400;
        for (int i = 0; i < tArriba.length; i++) {
            int yy = FM.generaAleatorioN(TUBERIA_MIN_Y, TUBERIA_MAX_Y - ESPACIO_ENTRE_TUBOS);
            tArriba[i] = new Tuberia(x + i * 100, yy, "imagenes/tuberiaArriba3.png");//x + i * 100
        }
    }

    public void actionPerformed(ActionEvent evt) {
        boolean detectarAbajo = p.detectarTuberia(tAbajo);
        boolean detectarArriba = p.detectarTuberia(tArriba);
        boolean pasaPorEspacio = p.detectarEspacio(recEnMedio);

        if (detectarAbajo || detectarArriba) {//Si hay colision en la parte superior o inferior se detiene el pez y aparece el mensaje de Game Over
            p.frenar = true;
            tem.stop();
            GameOver();
        } else {
            if (pasaPorEspacio) {//Si el pez pasa un espacio verifica que atraveso y actualiza los puntos
                for(Espacio espacio: recEnMedio){
                    if (espacio.pasarEspacio(p.getX(), p.getY(), p.getAncho(), p.getAlto())){
                        if(!espacioAtravesado.contains(espacio)){
                            contadorPuntos++;  // Incrementa el contador de puntos
                            espacioAtravesado.add(espacio);//Agrega el espacio atravesado a la lista
                        }
                    }
                }
            }
            moverTuberias();//Mueve las tuberias y los espacios
            p.actualizar();//Actualiza la posicion del pez
            repaint();//Vuelve a pintar el panel
        }
    }
    
    public void moverTuberias() {//Metodo que mueve todos los elementos por los que debe pasar el pez
        for (Tuberia tuberia : tAbajo) {
            tuberia.mover();
        }
        for (Tuberia tuberia : tArriba) {
            tuberia.mover();
        }
        for (Espacio espacio : recEnMedio) {
            espacio.mover();
        }
    }

    public void keyPressed(KeyEvent evt) {//Metodo que se utiliza al presionar una tecla
        int codigo = evt.getKeyCode();
        if (codigo == 32) {//Al presionar la tecla Espacio(32) se mueve el pez
            p.mover();
        }
        if (codigo == 32) {// Si la tecla Espacio está presionada, verifica colisiones y toma acciones correspondientes
            boolean detectarAbajo = p.detectarTuberia(tAbajo);
            boolean detectarArriba = p.detectarTuberia(tArriba);
            boolean detectarEnMedio = p.detectarEspacio(recEnMedio);

            if (detectarAbajo || detectarArriba) {// Si hay colisión con tuberías inferiores o superiores, detiene el pez
                p.frenar = true;
                System.out.println("Si hay colision abajo/arriba");
            } else if (detectarEnMedio) { // Si hay colisión con espacios entre las tuberías, limpia la lista de espacios atravesados
                System.out.println("Si hay colision en medio");
                espacioAtravesado.clear();
            }
        }

        if (p.frenar) {// Si el pez está frenado, detiene el temporizador y muestra el mensaje de Game Over
            tem.stop();
            GameOver();
        }
        repaint();
    }

    private void GameOver() {// Este método se llama cuando se produce un Game Over
        if (principal != null) { // Verifica si la referencia a la clase Principal es diferente de null
            JOptionPane.showMessageDialog(this, "Game Over" + "\n Puntos: " + contadorPuntos);// Muestra un mensaje de Game Over con la cantidad de puntos obtenidos
            principal.cerrarVentana(); // Cierra la ventana del juego llamando al método cerrarVentana de la clase Principal
        }
    }

    public void keyReleased(KeyEvent evt) {
        
    }

    public void keyTyped(KeyEvent evt) {
        
    }

    public void paint(Graphics g) {// Método se encarga de dibujar los elementos en el panel
        super.paint(g);// Llama al método paint de la clase base para realizar limpieza y configuración previa al dibujo
        f.dibujar(g);
        dibujarTuberia(g);
        p.dibujar(g);
        // Configura la fuente y el color para dibujar el contador de puntos
        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.setColor(Color.RED);
        // Dibuja el contador de puntos en la posición específica
        g.drawString("PUNTOS: " + contadorPuntos, 900, 20);
    }

    public void dibujarTuberia(Graphics g) {
        for (Tuberia tuberia : tAbajo) {
            tuberia.dibujar(g);
        }
        for (Tuberia tuberia : tArriba) {
            tuberia.dibujar(g);
        }
        for (Espacio espacio : recEnMedio) {
            espacio.dibujar(g);
        }
    }
}