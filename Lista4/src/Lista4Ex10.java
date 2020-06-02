
import br.furb.furbot.Direcao;
import br.furb.furbot.Furbot;
import br.furb.furbot.MundoVisual;
import br.furb.furbot.Numero;
import static br.furb.furbot.ObjetoDoMundoAdapter.AQUIMESMO;

/**
 *
 * @author mclopes
 */
public class Lista4Ex10 extends Furbot {

    // atributo para guardar o valor do calculo
    private long valorDoCalculo = 5;

    /**
     * método para o robô andar em uma determinada direção
     */
    private void andar(Direcao direcao) {
        if (direcao == DIREITA) {
            andarDireita();
        } else {
            if (direcao == ESQUERDA) {
                andarEsquerda();
            } else {
                if (direcao == ACIMA) {
                    andarAcima();
                } else {
                    if (direcao == ABAIXO) {
                        andarAbaixo();
                    }
                }
            }
        }
    }

    /**
     * método para o robô mudar de direção
     */
    private Direcao mudarDirecao(Direcao direcao) {
        if (direcao == DIREITA) {
            direcao = ESQUERDA;
        } else {
            if (direcao == ESQUERDA) {
                direcao = DIREITA;
            } else {
                if (direcao == ACIMA) {
                    direcao = ABAIXO;
                } else {
                    if (direcao == ABAIXO) {
                        direcao = ACIMA;
                    }
                }
            }
        }
        return direcao;
    }

    private void CalculaExponenciacao(int numero) {
        for (int number = 1; number < numero; number++) {
            valorDoCalculo *= 5;
        }
        diga("Resultado: " + valorDoCalculo);
        valorDoCalculo = 5;
    }

    @Override
    public void inteligencia() throws Exception {
        mudarPosicao(0, 0);
        limparConsole();
        //iniciar uma variável para a direção
        Direcao direcao = DIREITA;
        //enquanto não para
        while (true) {

            if (ehObjetoDoMundoTipo("Numero", AQUIMESMO)) {
                int valor = ((Numero) getObjeto(AQUIMESMO)).getValor();
                CalculaExponenciacao(valor);
            }

            if (!ehFim(direcao)) {
                //andar para a direção
                andar(direcao);
                //quando termina a direção
            } else {
                //mudar a direção
                direcao = mudarDirecao(direcao);
                //ver se o robô pode descer
                if (!ehFim(ABAIXO)) {
                    andarAbaixo();
                } else {
                    //para a repetição
                    break;
                }
            }
        }
        diga("Cheguei!");

    }

    public static void main(String[] args) {
        MundoVisual.iniciar("Lista4Ex10.xml");
    }

}
