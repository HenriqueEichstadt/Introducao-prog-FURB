
import br.furb.furbot.Furbot;
import br.furb.furbot.MundoVisual;

/**
 *
 * @author Henrique Eichst
 */
public class Lista1Ex04 extends Furbot {

    @Override
    public void inteligencia() throws Exception {

        diga("Posição Inicial");
        
        andarDireita();
        andarDireita();
        andarDireita();
        diga("Direita Acima !");

        andarAbaixo();
        andarAbaixo();
        andarAbaixo();
        diga("Direita Abaixo !");

        andarEsquerda();
        andarEsquerda();
        andarEsquerda();
        diga("Esquerda Abaixo !");

        andarAcima();
        andarAcima();
        andarAcima();
        diga("Esquerda Acima !");

    }

    public static void main(String[] args) {
        MundoVisual.iniciar("Lista1Ex04.xml");
    }
}
