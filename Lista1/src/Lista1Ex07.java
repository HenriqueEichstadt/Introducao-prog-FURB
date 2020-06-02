
import br.furb.furbot.Furbot;
import br.furb.furbot.MundoVisual;
import br.furb.furbot.Parede;

/**
 *
 * @author Henrique Eichst
 */
public class Lista1Ex07 extends Furbot {

    @Override
    public void inteligencia() throws Exception {
        while (ehVazio(ABAIXO)) {
            andarAbaixo();
        }
        while (ehVazio(DIREITA)) {
            andarDireita();
        }
        while (ehVazio(ACIMA)) {
            andarAcima();
        }
        while (ehVazio(DIREITA)) {
            andarDireita();
        }
        while (ehVazio(ABAIXO)) {
            andarAbaixo();
        }
        while (ehVazio(ESQUERDA)) {
            andarEsquerda();
        }
         diga ("cheguei no Tesouro"); 
    }

    public static void main(String[] args) {
        MundoVisual.iniciar("Lista1Ex07.xml");
    }
}
