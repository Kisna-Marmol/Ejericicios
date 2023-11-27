import java.util.Random;
public class FM
{
    public static int generaAleatorio(int desde, int hasta) {
        Random numaleatorio=new Random();
        int n=numaleatorio.nextInt(hasta-desde+1)+desde;
        return n;
    }
    public static int generaAleatorioN(int desde, int hasta) {
        Random numAleatorio = new Random();

        if (desde < hasta) {
            throw new IllegalArgumentException("'desde' debe ser menor o igual que 'hasta'");
        }

        long range = (long) hasta - desde + 1;

        if (range > 0) {
            return (int) (numAleatorio.nextLong() % range) + desde;
        } else if (range < 0) {
            return (int) (numAleatorio.nextLong() % -range) + desde;
        } else {
            return desde;
        }
    }
    
}
