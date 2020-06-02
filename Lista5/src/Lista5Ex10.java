
import br.furb.furbot.Booleano;
import br.furb.furbot.Direcao;
import br.furb.furbot.Furbot;
import br.furb.furbot.MundoVisual;
import static br.furb.furbot.ObjetoDoMundoAdapter.AQUIMESMO;
import br.furb.furbot.Tesouro;

/**
 *
 * @author mclopes
 */
public class Lista5Ex10 extends Furbot {

    public Tesouro tesouros[] = new Tesouro[30];
    public int n = 0;

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

    // método para adiconar tesouros no array
    public void AdicionarTesourosNoVetor() {
        if (ehObjetoDoMundoTipo("Tesouro", AQUIMESMO)) {
            tesouros[n] = (((Tesouro) getObjeto(AQUIMESMO)));
            n++;
        }
    }

    // método para retornar o tesouro com maior valor
    public void ObjetoComMaiorValor() {
        // variavel para pegar o índice do maior valor
        int indiceDoMaiorValor = 0;
        // variavel para pegar o valor do maior tesouro encontrado
        int valorMaiortesouro = 0;
        for (int cont = 0; cont < n; cont++) {
            if (tesouros[cont].getValor() > indiceDoMaiorValor) {
                indiceDoMaiorValor = n;
                valorMaiortesouro = tesouros[cont].getValor();
            }
        }
        diga("O Tesouro com maior valor está na posição " + indiceDoMaiorValor + " e tem o vale: " + valorMaiortesouro);
    }
    
     // método para retornar o tesouro com menor valor
    public void ObjetoComMenorValor() {
        // variavel para pegar o índice do maior valor
        int indiceDoMenorValor = 1000;
        // variavel para pegar o valor do maior tesouro encontrado
        int valorMenorTesouro = 0;
        for (int cont = 0; cont < n; cont++) {
            if (tesouros[cont].getValor() < indiceDoMenorValor) {
                indiceDoMenorValor = n;
                valorMenorTesouro = tesouros[cont].getValor();
            }
        }
        diga("O Tesouro com menor valor está na posição " + indiceDoMenorValor + " e tem o vale: " + valorMenorTesouro);
    }
    
    // método para somar os valores do vetor
    public void SomaDosValoresNoVetor(){
        // variável para somar os valores no vetor
        int somaDosValores = 0;
        for (int cont = 0; cont < n; cont++) {
            somaDosValores += tesouros[cont].getValor();
        }
        diga("A soma dos valores no vetor é de: " + somaDosValores);
    }

    @Override
    public void inteligencia() throws Exception {
        limparConsole();
        //iniciar uma variável para a direção
        Direcao direcao = DIREITA;
        //enquanto não para
        while (true) {

            // Chamando o método para adiconar os tesouros no array   Questão A
            AdicionarTesourosNoVetor();

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
        // retornando objeto do tipo tesouro com o maior valor
        ObjetoComMaiorValor();
        // retornando o tesouro com o menor valor
        ObjetoComMenorValor();
        // retornando a soma dos valores no vetor
        SomaDosValoresNoVetor();
        // quantidade de tesouros encontrados
        diga("A quantidade de tesouros encontrados é de " + n);
    }

    public static void main(String[] args) {
        MundoVisual.iniciar("Lista5Ex10.xml");
    }
}
