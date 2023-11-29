
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
    private static final int TUBERIA_MIN_Y = -25;
    private static final int TUBERIA_MAX_Y = -50;
    private static final int TUBERIA_MIN_HEIGHT = 300;//410
    private static final int TUBERIA_MAX_HEIGHT = 410;//500
    int ESPACIO_ENTRE_TUBOS;

    Tuberia tAbajo[];
    Tuberia tArriba[];
    Timer tem;
    Fondo f;
    Pez p;
    Espacio recEnMedio[];
    int contadorPuntos = 0;
    Principal principal;
    List<Espacio> espacioAtravesado;

    public Escenario(Principal principal) {
        this.principal = principal;
        inicializarTuberiaArriba();
        inicializarTuberiaAbajo();
        inicializarEspacio();
        f = new Fondo(0, 0, "imagenes/fondo4.jpg");
        p = new Pez(50, 280, "imagenes/pez3.png");//y = 300
        espacioAtravesado = new ArrayList<>();
        tem = new Timer(70, this);
        tem.start();
        addKeyListener(this);
        setFocusable(true);
        setSize(f.ancho, f.alto);//f.ancho + 200, f.alto + 100;
    }

    private void inicializarTuberiaAbajo() {
        tAbajo = new Tuberia[11];
        int x = 400;
        for (int i = 0; i < tAbajo.length; i++) {
            int yy = FM.generaAleatorio(TUBERIA_MIN_HEIGHT + ESPACIO_ENTRE_TUBOS, TUBERIA_MAX_HEIGHT);
            //int yy = FM.generaAleatorio(_desde_, _hasta_);
            tAbajo[i] = new Tuberia(x + i * 100, yy, "imagenes/tuberia11.png");//x + i * 100
        }
    }

    private void inicializarEspacio() {
        recEnMedio = new Espacio[11];
        for (int i = 0; i < recEnMedio.length; i++) {
            int yy = FM.generaAleatorio(TUBERIA_MIN_HEIGHT, TUBERIA_MAX_HEIGHT);
            int medioX = tAbajo[i].getX() + (tAbajo[i].getAncho() - 100) / 2;
            int medioY = (tAbajo[i].getY() + tArriba[i].getY() + tArriba[i].getAlto()) / 2 - 50;
            recEnMedio[i] = new Espacio(medioX + 20, medioY - 15, 50, 150);//medioY - 65
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

        if (detectarAbajo || detectarArriba) {
            p.frenar = true;
            tem.stop();
            GameOver();
        } else {
            if (pasaPorEspacio) {
                for(Espacio espacio: recEnMedio){
                    if (espacio.pasarEspacio(p.getX(), p.getY(), p.getAncho(), p.getAlto())){
                        if(!espacioAtravesado.contains(espacio)){
                            contadorPuntos++;  // Incrementa el contador de puntos
                            espacioAtravesado.add(espacio);
                        }
                    }
                }
            }
            moverTuberias();
            p.actualizar();
            repaint();
        }
    }
    
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
                espacioAtravesado.clear();
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
        
    }

    public void keyTyped(KeyEvent evt) {
        
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