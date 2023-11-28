
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

public class Escenario extends JPanel implements ActionListener, KeyListener {
    private static final int TUBERIA_MIN_Y = -25;
    private static final int TUBERIA_MAX_Y = -50;
    private static final int TUBERIA_MIN_HEIGHT = 410;
    private static final int TUBERIA_MAX_HEIGHT = 500;

    Tuberia tAbajo[];
    Tuberia tArriba[];
    Timer tem;
    Fondo f;
    Pez p;
    Espacio recEnMedio[];
    int contadorPuntos = 0;
    boolean ultimoEspacioPasado = false; // Nuevo indicador para rastrear el último espacio pasado
    boolean interacion = false;
    boolean detectarMedio = false;
    boolean puedeIncrementar = true;
    Principal principal;

    public Escenario(Principal principal) {
        this.principal = principal;
        inicializarTuberiaArriba();
        inicializarTuberiaAbajo();
        inicializarEspacio();
        f = new Fondo(0, 0, "imagenes/fondo3.jpg");
        p = new Pez(50, 300, "imagenes/pez3.png");
        tem = new Timer(70, this);
        tem.start();
        addKeyListener(this);
        setFocusable(true);
        setSize(f.ancho + 200, f.alto + 100);
    }

    private void inicializarTuberiaAbajo() {
        tAbajo = new Tuberia[11];
        for (int i = 0; i < tAbajo.length; i++) {
            int yy = FM.generaAleatorio(TUBERIA_MIN_HEIGHT, TUBERIA_MAX_HEIGHT);
            tAbajo[i] = new Tuberia(400 + i * 100, yy, "imagenes/tuberia8.png");
        }
    }

    private void inicializarEspacio() {
        recEnMedio = new Espacio[11];
        for (int i = 0; i < recEnMedio.length; i++) {
            int yy = FM.generaAleatorio(TUBERIA_MIN_HEIGHT, TUBERIA_MAX_HEIGHT);
            int medioX = tAbajo[i].getX() + (tAbajo[i].getAncho() - 100) / 2;
            int medioY = (tAbajo[i].getY() + tArriba[i].getY() + tArriba[i].getAlto()) / 2 - 50;
            recEnMedio[i] = new Espacio(medioX + 20, medioY - 65, 50, 245);
        }
    }

    private void inicializarTuberiaArriba() {
        tArriba = new Tuberia[11];
        for (int i = 0; i < tArriba.length; i++) {
            int yy = FM.generaAleatorioN(TUBERIA_MIN_Y, TUBERIA_MAX_Y);
            tArriba[i] = new Tuberia(400 + i * 100, yy, "imagenes/tuberiaArriba1.png");
        }
    }

    public void actionPerformed(ActionEvent evt) {
        boolean detectarAbajo = p.detectarTuberia(tAbajo);
        boolean detectarArriba = p.detectarTuberia(tArriba);
        boolean pasaPorEspacio = p.detectarEspacio(recEnMedio);

        if (detectarAbajo || detectarArriba) {
            p.frenar = true;
            tem.stop();
            GameOver();
        } else {
            if (pasaPorEspacio && !interacion && puedeIncrementar) {
            contadorPuntos++;
            System.out.println("Contador: " + contadorPuntos);
            interacion = true;
            puedeIncrementar = false;

            // Programamos un temporizador para restablecer la capacidad de incrementar después de un tiempo
            Timer temporizador = new Timer(500, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    puedeIncrementar = true;
                    ((Timer) e.getSource()).stop();  // Detenemos el temporizador después de un tiempo
                    System.out.println("Restableciendo la capacidad de incrementar");
                }
            });
            temporizador.setRepeats(false);  // Configuramos el temporizador para no repetirse
            temporizador.start();
        } else if (!pasaPorEspacio) {
            interacion = false;
            System.out.println("Restableciendo la interacción");
        }

            moverTuberias();
            p.actualizar();
            repaint();
        }
    }
    
    // Dentro del método detectarEspacio de la clase Pez
    /*public boolean detectarEspacio(Espacio[] espacios) {
        for (Espacio espacio : espacios) {
            if (this.getBounds().intersects(espacio.getBounds())) {
                // Si el pez está dentro del espacio, devuelve true
                return true;
            }
        }
        // Si el pez no está en ningún espacio, devuelve false
        return false;
    }*/

    public void moverTuberias() {
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

    public void keyPressed(KeyEvent evt) {
        int codigo = evt.getKeyCode();
        if (codigo == 32) {
            p.mover();
        }
        if (codigo == 32) {
            boolean detectarAbajo = p.detectarTuberia(tAbajo);
            boolean detectarArriba = p.detectarTuberia(tArriba);
            boolean detectarEnMedio = p.detectarEspacio(recEnMedio);

            if (detectarAbajo || detectarArriba) {
                p.frenar = true;
                System.out.println("Si hay colision abajo/arriba");
            } else if (detectarEnMedio) {
                System.out.println("Si hay colision en medio");
                System.out.println("Contador: " + contadorPuntos);
            }
        }

        if (p.frenar) {
            tem.stop();
            GameOver();
        }
        repaint();
    }

    private void GameOver() {
        if (principal != null) {
            JOptionPane.showMessageDialog(this, "Game Over" + "\n Puntos: " + contadorPuntos);
            principal.cerrarVentana();
        }
    }

    public void keyReleased(KeyEvent evt) {
        // Lógica para la tecla liberada (si es necesaria)
    }

    public void keyTyped(KeyEvent evt) {
        // Lógica para la tecla pulsada (si es necesaria)
    }

    public void paint(Graphics g) {
        super.paint(g);
        f.dibujar(g);
        dibujarTuberia(g);
        p.dibujar(g);
        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.setColor(Color.RED);
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
