
import br.furb.furbot.Direcao;
import br.furb.furbot.Furbot;
import br.furb.furbot.MundoVisual;
import br.furb.furbot.Numero;

/**
 *
 * @author mclopes
 */
public class Lista5Ex04 extends Furbot {

    // definir vetor para guardar os numeros
    private int vetor[] = new int[20];
    // definir variavel para saber quantos indices do vetor foram ocupados
    private int n = 0;

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

    public int CalcularMedia() {
        // definir variavel local para somar os valores
        int soma = 0;
        // percorrer o vetor
        for (int i = 0; i <= n; i++) {
            // somar o elemento no vetor
            soma += vetor[i];
        }
        //Calcular e retornar a media
        return soma / n;
    }

    public boolean CompararMedia(int media) {
        // variavel booleana que inicia com false
        boolean tem = false;
        // percorrer o vetor
        for (int i = 0; i < n; i++) {
            // se o elemento na posição i é o que procuro
            if(vetor[i] == media){
                tem = true;
            }
        }
        return tem;
    }

    @Override
    public void inteligencia() throws Exception {
        limparConsole();
        //iniciar uma variável para a direção
        Direcao direcao = DIREITA;
        //enquanto não para
        while (true) {

            // se tem numero na posição
            if (ehObjetoDoMundoTipo("Numero", AQUIMESMO)) {
                // colocar o numero no vetor
                vetor[n] = (((Numero) getObjeto(AQUIMESMO))).getValor();
                // incrementar a quantidade de elementos no vetor
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

        // Calcular a média
        int media = CalcularMedia();
        // comparar para ver se tem algum valor igual a média
        diga("Média = " + media);
        if (CompararMedia(media)) {
            diga("Tem valor igual a média");
        } else {
            diga("Não tem valor igual a média");
        }
    }

    public static void main(String[] args) {
        MundoVisual.iniciar("Lista5Ex04.xml");
    }

}
