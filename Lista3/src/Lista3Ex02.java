
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
public class Lista3Ex02 extends Furbot {

    // variavel para acumular valores
    int acumulador = 0;

    public void OperacaoComAcumulador() {
        if (ehObjetoDoMundoTipo("Numero", AQUIMESMO)) {
            Numero numero = getObjeto(AQUIMESMO);
            int valorNaPosicao = numero.getValor();
            if (acumulador > 0) {
                acumulador -= valorNaPosicao;
                diga("Subtrai do valor na posição: " + valorNaPosicao);
                diga("Valor parcial:  " + acumulador);
            }
            if (acumulador <= 0) {
                acumulador += valorNaPosicao;
                diga("Adicionei do valor na posição: " + valorNaPosicao);
                diga("Valor parcial:  " + acumulador);
            }
        }
    }

    @Override
    public void inteligencia() throws Exception {

        // Limpa console
        limparConsole();
        Direcao direcao = DIREITA;
        mudarPosicao(0, 0);

        while (true) {

            OperacaoComAcumulador();

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
        }
        limparConsole();
        diga("Cheguei ao Final Do Mapa!");
        diga("Valor Final do acumulador: " + acumulador);

    }

    public static void main(String[] args) {
        MundoVisual.iniciar("Lista3Ex02.xml");
    }
}
