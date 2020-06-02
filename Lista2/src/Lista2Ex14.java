
import br.furb.furbot.Alien;
import br.furb.furbot.Direcao;
import br.furb.furbot.Furbot;
import br.furb.furbot.MundoVisual;
import static br.furb.furbot.ObjetoDoMundoAdapter.ABAIXO;
import static br.furb.furbot.ObjetoDoMundoAdapter.DIREITA;
import static br.furb.furbot.ObjetoDoMundoAdapter.ESQUERDA;

/**
 *
 * @author Henrique Eichst
 */
public class Lista2Ex14 extends Furbot {

    @Override
    public void inteligencia() throws Exception {
        // Limpa console
        limparConsole();
        // Variável para direção
        Direcao direcao = DIREITA;
        int contador = 0;
        mudarPosicao(0, 0);

        while (true) {

            if (!ehFim(direcao)) {
                // andar para a direção
                if (direcao == DIREITA) {
                    andarDireita();
                } else {
                    andarEsquerda();
                }
                // Quando termina a direção
            } else {
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
            if (ehObjetoDoMundoTipo("Alien", AQUIMESMO)) {
                contador++;
                diga("Contador:  " + contador);
            }

        }
        diga("Quantidade total de Aliens:  " + contador);
    }

    public static void main(String[] args) {
        MundoVisual.iniciar("Lista2Ex14.xml");
    }
}
