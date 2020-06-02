
import br.furb.furbot.Direcao;
import br.furb.furbot.Furbot;
import br.furb.furbot.MundoVisual;
import br.furb.furbot.Numero;
import static br.furb.furbot.ObjetoDoMundoAdapter.AQUIMESMO;

/**
 *
 * @author mclopes
 */
public class Lista5Ex05 extends Furbot {

    // atributo vetor para guardar os valores 
    public int vetor[] = new int[30];
    // atributo para saber a quantidade de numeros no vetor
    public int n = 0;
    // atributo para somar o total de valores no array
    public int SomaTotalDeValores = 0;

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

    @Override
    public void inteligencia() throws Exception {
        limparConsole();
        //iniciar uma variável para a direção
        Direcao direcao = DIREITA;
        //enquanto não para
        while (true) {

            // Se tem número na posição
            if (ehObjetoDoMundoTipo("Numero", AQUIMESMO)) {
                // colocar o numero no vetor
                vetor[n] = (((Numero) getObjeto(AQUIMESMO))).getValor();
                SomaTotalDeValores += vetor[n];
                n++;
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

        // Pegar a média dos valores
        int media = SomaTotalDeValores / n;
        diga("A média dos valores é de " + media);
        for (int cont = 0; cont < n; cont++) {
            if (vetor[cont] > media) {
                diga("O número " + vetor[cont] + "é maior que a média!");
            }
        }

    }

    public static void main(String[] args) {
        MundoVisual.iniciar("Lista5Ex05.xml");
    }

}
