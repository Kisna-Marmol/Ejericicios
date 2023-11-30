
import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.Graphics;

public class Coordenada
{
    int x; //Coordenada X
    int y; //Coordenada Y
    ImageIcon ima; //ImageIcon para cargar imagenes
    Image imagen; //Imagen a ser mostrada
    
    public Coordenada(int x, int y, String ruta){
        this.x = x;
        this.y = y;
        this.ima = new ImageIcon(getClass().getResource(ruta));//carga la imagen desde la ruta especificada
        this.imagen = ima.getImage(); //obtener el objeto imagen desde ImageIcon
    }
    public Coordenada(int x, int y){//Constructor solo con coordenadas X & Y
        this.x = x;
        this.y = y;
    }
    //Metodos Getters & Setters
    public int getX(){
        return this.x;
    }
    public void setX(int x){
        this.x = x;
    }
    
    public int getY(){
        return this.y;
    }
    public void setY(int y){
        this.y = y;
    }
    //Metodo para dibujar la imagen
    public void dibujar(Graphics g){
        g.drawImage(imagen,x,y,null);
    }
}
