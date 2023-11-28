
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import javax.swing.Timer;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.Rectangle;
import java.awt.Font;
import javax.swing.JOptionPane;
public class Escenario extends JPanel implements ActionListener, KeyListener
{
    Tuberia tAbajo[];
    Tuberia tArriba[];
    Timer tem;
    Fondo f;
    Pez p;
    Espacio recMedio;
    Espacio recEnMedio[];
    int contadorPuntos = 0;
    Principal principal;
    //boolean cerrarVentana = false;
    //Rectangle recEnMedio[];
    public Escenario(Principal principal){
        this.principal = principal;
        inicializarTuberiaArriba();
        inicializarTuberiaAbajo();        
        inicializarEspacio();
        f = new Fondo(0,0,"imagenes/fondo3.jpg");
        p = new Pez(50,300,"imagenes/pez3.png");
        //recMedio = new Espacio(150, 193, 50, 245);
        tem = new Timer(70,null);
        tem.start();
        tem.addActionListener(this);
        addKeyListener(this);
        setFocusable(true); 
        setSize(f.ancho+200,f.alto+100);
        //setBackground(Color.BLUE);
    }
    
    /*public Escenario(Principal principal){
        this.principal = principal;
    }*/
    //Arreglos de tuberia
    public void inicializarTuberiaAbajo(){
        tAbajo = new Tuberia[11];
        for(int i = 0; i < tAbajo.length; i++){//410 a 500
            int yy = FM.generaAleatorio(410, 500);
            tAbajo[i] = new Tuberia(400 + i * 100,yy,"imagenes/tuberia8.png");
            System.out.println("Tubo Abajo " + i + ": x=" + tAbajo[i].getX() + ", y=" + tAbajo[i].getY());
        }
    }
    public void inicializarEspacio(){
        recEnMedio = new Espacio[11];
        for(int i = 0; i < recEnMedio.length; i++){//410 a 500
            int yy = FM.generaAleatorio(410, 500);
            int medioX = tAbajo[i].getX() + (tAbajo[i].getAncho() - 100) / 2;
            int medioY = (tAbajo[i].getY() + tArriba[i].getY() + tArriba[i].getAlto()) / 2 - 50; // Ajusta el valor para centrar verticalmente
            //recEnMedio[i] = new Espacio(medioX, medioY, 100, 100, Color.GREEN);
            recEnMedio[i] = new Espacio(medioX + 20, medioY - 65, 50, 245);
            System.out.println("Espacio " + i + ": x=" + recEnMedio[i].getX() + ", y=" + recEnMedio[i].getY());
        }
    }
    public void inicializarTuberiaArriba(){
        tArriba = new Tuberia[11];
        for(int i = 0; i < tArriba.length; i++){//0 a -50
            int yy = FM.generaAleatorioN(-25, -50);
            tArriba[i] = new Tuberia(400 + i * 100, yy, "imagenes/tuberiaArriba1.png");
            System.out.println("Tubo Arriba " + i + ": x=" + tArriba[i].getX() + ", y=" + tArriba[i].getY());
        }
    }
    //Movimientos automaticos
    public void actionPerformed(ActionEvent evt){
        //moverTuberias();
        //p.moverAut();
        //p.actualizar();
        movimientosAutomaticos(evt);
        repaint();
    }
    public void movimientosAutomaticos(ActionEvent evt){
        // Verificar colisión sin necesidad de entrada de teclado
        boolean detectarAbajo = p.detectarTuberia(tAbajo);
        boolean detectarArriba = p.detectarTuberia(tArriba);
        boolean pasaPorEspacio = p.detectarEspacio(recEnMedio);

        if (detectarAbajo || detectarArriba) {
            p.frenar = true;
            System.out.println("Chocaste con un tubo");
            tem.stop(); // Se detiene el tiempo y se paran los movimientos automáticos
            // JOptionPane.showMessageDialog(this, "GAME OVER");
            GameOver();
        } else {
            // Incrementar el contador solo si pasa por el espacio
            if (pasaPorEspacio) {
                contadorPuntos++;
                System.out.println("Contador: " + contadorPuntos);
            }

            moverTuberias();
            p.actualizar();
            repaint();
        }
    }
    public void moverTuberias(){
        for(int i = 0; i < tAbajo.length; i++){
            tAbajo[i].mover();
            repaint();
        }
        for(int i = 0; i < tArriba.length; i++){
            tArriba[i].mover();
            repaint();
        }
        for(int i = 0; i < recEnMedio.length; i++){
            recEnMedio[i].mover();
            repaint();
        }
    }
    //Movimientos de teclado
    public void keyPressed(KeyEvent evt){
        moviemientoTecla(evt);
        repaint();
    }
    public void keyReleased(KeyEvent evt){
        moviemientoTecla(evt);
        repaint();
    }
    public void keyTyped(KeyEvent evt){
        
    }
    public void moviemientoTecla(KeyEvent evt){
        int codigo = evt.getKeyCode();
        System.out.println("Hola "+codigo);
        if(codigo==32)//32 tecla espacio
        {
            p.mover();
            //repaint();
        }
        if(codigo == 32){
            boolean detectarAbajo = p.detectarTuberia(tAbajo);
            boolean detectarArriba = p.detectarTuberia(tArriba);
            boolean detectarEnMedio = p.detectarEspacio(recEnMedio);
            if(detectarAbajo){
                p.frenar = true;
                System.out.println("Si hay colision abajo");
            }else if(detectarArriba){
                p.frenar = true;
                System.out.println("si hay colision arriba");
            }else if(detectarEnMedio){
                //contadorPuntos++;
                System.out.println("Si hay colision en medio");
                System.out.println("Contador: " + contadorPuntos);
            }
            
        }
        
        if(p.frenar == true){
            System.out.println("Chocaste con un tubo");
            //principal.cerrarVentana();
            tem.stop();//se detiene el tiempo y se para los movimiento automaticos
            //JOptionPane.showMessageDialog(this,"GAME OVER"); 
            GameOver();
        }
        repaint();
    }
    private void GameOver() {
        if (this.principal != null) {
            JOptionPane.showMessageDialog(this, "Game Over"+"\n Puntos: "+contadorPuntos );
            this.principal.cerrarVentana();
        }
    }
    //Dibujar tuberias
    public void dibujarTuberia(Graphics g){
        for(int i = 0; i < tAbajo.length; i++){
            tAbajo[i].dibujar(g);
        }
        for(int i = 0; i < tArriba.length; i++){
            tArriba[i].dibujar(g);
        }
        for(int i = 0; i < recEnMedio.length; i++){
            recEnMedio[i].dibujar(g);
        }
    }
    public void paint(Graphics g){
        super.paint(g);
        f.dibujar(g);
        //p.dibujar(g);
        dibujarTuberia(g);
        p.dibujar(g);
        // Configuración del texto (tamaño de letra y color)
        g.setFont(new Font("Arial", Font.BOLD, 20)); // Cambia "Arial" por la fuente que desees
        g.setColor(Color.RED); // Cambia Color.RED por el color que desees
        g.drawString("PUNTOS: "+contadorPuntos,900,20);
        //g.setColor(Color.GREEN);
        //recMedio.dibujar(g);
        //dibujaRectagulo(g);
        //g.fillRect(recMedio.x, recMedio.y, recMedio.width, recMedio.height);
    }
}