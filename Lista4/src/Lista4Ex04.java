
import br.furb.furbot.Direcao;
import br.furb.furbot.Furbot;
import br.furb.furbot.MundoVisual;
import br.furb.furbot.Numero;
import static br.furb.furbot.ObjetoDoMundoAdapter.AQUIMESMO;

/**
 *
 * @author mclopes
 */
public class Lista4Ex04 extends Furbot {

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

    private void AdicionaFibonacciNaPosicao(Direcao direcao) {
        if (ehObjetoDoMundoTipo("Numero", AQUIMESMO)) {
            int valor = ((Numero)getObjeto(AQUIMESMO)).getValor();
            andarDireita();
            for (int count = 0; count < valor; count++) {
                Numero numeroAqui = new Numero();
                // Calcula o Fibonaci
                int numeroUm = 0;
                int numeroDois = 1;
                int proximoFibonacci = numeroUm + numeroDois;
                numeroUm = numeroDois;
                numeroDois = proximoFibonacci;
                numeroAqui.setValor(numeroDois);
                adicionarObjetoNoMundo(numeroAqui, AQUIMESMO);
                andar(direcao);
                
                
            }

        }
    }

    @Override
    public void inteligencia() throws Exception {
        limparConsole();
        //iniciar uma variável para a direção
        Direcao direcao = DIREITA;
        //enquanto não para
        while (true) {
            // Chama o método
            AdicionaFibonacciNaPosicao(direcao);
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
        MundoVisual.iniciar("Lista4Ex04.xml");
    }

}
