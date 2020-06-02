
import br.furb.furbot.Direcao;
import br.furb.furbot.Furbot;
import br.furb.furbot.MundoVisual;
import br.furb.furbot.Numero;
import static br.furb.furbot.ObjetoDoMundoAdapter.ABAIXO;
import static br.furb.furbot.ObjetoDoMundoAdapter.AQUIMESMO;
import static br.furb.furbot.ObjetoDoMundoAdapter.DIREITA;
import static br.furb.furbot.ObjetoDoMundoAdapter.ESQUERDA;

/**
 *
 * @author Henrique Eichst
 */
public class Lista2Ex15 extends Furbot {

    @Override
    public void inteligencia() throws Exception {
        // Limpa console
        limparConsole();
        Direcao direcao = DIREITA;
        int soma = 0;
        mudarPosicao(0, 0);

        while (true) {

            if (ehObjetoDoMundoTipo("Numero", AQUIMESMO)) {
                Numero numero = getObjeto(AQUIMESMO);
                soma += numero.getValor();

            }

            if (!ehFim(direcao)) {
                // andar para a direção
                if (direcao == DIREITA) {
                    andarDireita();
                } else {
                    andarEsquerda();
                }
                // Quando termina a direção
            } else {
                //dizer a soma
                diga("Soma da linha: " + getY() + " => " + soma);
                soma = 0;
                // Mudar a direção
                if (direcao == DIREITA) {
                    direcao = ESQUERDA;
                } else {
                    direcao = DIREITA;
                }
                // Ver se o robô pode descer
                if (!ehFim(ABAIXO)) {
                    andarAbaixo();
                } else {
                    // para a repetição
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        MundoVisual.iniciar("Lista2Ex15.xml");
    }
}
