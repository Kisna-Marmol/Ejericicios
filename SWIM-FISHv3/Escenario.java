import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import javax.swing.Timer;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.Rectangle;
public class Escenario extends JPanel implements ActionListener, KeyListener
{
    Tuberia tAbajo[];
    Tuberia tArriba[];
    Timer tem;
    Fondo f;
    Pez p;
    Espacio recMedio;
    Espacio recEnMedio[];
    boolean cerrarVentana = false;
    //Rectangle recEnMedio[];
    public Escenario(){
        inicializarTuberiaArriba();
        inicializarTuberiaAbajo();        
        inicializarEspacio();
        f = new Fondo(0,0,"imagenes/fondo3.jpg");
        p = new Pez(50,300,"imagenes/pez3.png");
        //recMedio = new Espacio(150, 193, 50, 245);
        tem = new Timer(50,null);
        tem.start();
        tem.addActionListener(this);
        addKeyListener(this);
        setFocusable(true); 
        setSize(f.ancho+200,f.alto+100);
        //setBackground(Color.BLUE);
    }
    //Arreglos de tuberia
    public void inicializarTuberiaAbajo(){
        tAbajo = new Tuberia[8];
        for(int i = 0; i < tAbajo.length; i++){//410 a 500
            int yy = FM.generaAleatorio(410, 500);
            tAbajo[i] = new Tuberia(50 + i * 100,yy,"imagenes/tuberia8.png");
        }
    }
    public void inicializarEspacio(){
        recEnMedio = new Espacio[8];
        for(int i = 0; i < recEnMedio.length; i++){//410 a 500
            int yy = FM.generaAleatorio(410, 500);
            int medioX = tAbajo[i].getX() + (tAbajo[i].getAncho() - 100) / 2;
            int medioY = (tAbajo[i].getY() + tArriba[i].getY() + tArriba[i].getAlto()) / 2 - 50; // Ajusta el valor para centrar verticalmente
            //recEnMedio[i] = new Espacio(medioX, medioY, 100, 100, Color.GREEN);
            recEnMedio[i] = new Espacio(medioX + 20, medioY - 65, 50, 245);
        }
    }
    public void inicializarTuberiaArriba(){
        tArriba = new Tuberia[8];
        for(int i = 0; i < tArriba.length; i++){//0 a -50
            int yy = FM.generaAleatorioN(-25, -50);
            tArriba[i] = new Tuberia(50 + i * 100, yy, "imagenes/tuberiaArriba1.png");
        }
    }
    //Movimientos automaticos
    public void actionPerformed(ActionEvent evt){
        moverTuberias();
        //p.moverAut();
        p.actualizar();
        repaint();
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
                System.out.println("Si hay colision en medio");
            }
            
        }
        
        if(p.frenar == true){
            System.out.println("Chocaste con un tubo");
        }
        repaint();
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
        p.dibujar(g);
        dibujarTuberia(g);
        //g.setColor(Color.GREEN);
        //recMedio.dibujar(g);
        //dibujaRectagulo(g);
        //g.fillRect(recMedio.x, recMedio.y, recMedio.width, recMedio.height);
    }
}