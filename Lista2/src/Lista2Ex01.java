
import br.furb.furbot.Furbot;
import br.furb.furbot.MundoVisual;

/**
 *
 * @author Henrique Eichst
 */
public class Lista2Ex01 extends Furbot{

    @Override
    public void inteligencia() throws Exception {
            
        while(!ehFim(DIREITA)){
            andarDireita();
        }
        diga("cheguei !!!!");
    }
    public static void main(String[] args) {
            MundoVisual.iniciar("Lista2Ex01.xml");
    }
}
