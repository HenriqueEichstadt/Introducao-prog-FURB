
import br.furb.furbot.Furbot;
import br.furb.furbot.MundoVisual;

/**
 *
 * @author Henrique Eichst
 */
public class Lista1Ex08 extends Furbot {

    @Override
    public void inteligencia() throws Exception {
        while (!ehFim(ESQUERDA)) {
            andarEsquerda();
        }
        while (!ehFim(ABAIXO)) {
            andarAbaixo();
        }
        while (ehVazio(DIREITA)) {
            andarDireita();
        }
        if (ehVazio(ACIMA)) {
            andarAcima();
            andarDireita();
        }
        while (ehVazio(ACIMA)) {
            andarAcima();
        }
      diga ("Cheguei ao Tesouro");  
    }

    public static void main(String[] args) {
        MundoVisual.iniciar("Lista1Ex08.xml");
    }
}
