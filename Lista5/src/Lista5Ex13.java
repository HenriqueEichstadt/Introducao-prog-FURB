
import br.furb.furbot.Direcao;
import br.furb.furbot.Furbot;
import br.furb.furbot.MundoVisual;
import br.furb.furbot.Numero;
import br.furb.furbot.ObjetoDoMundo;
import static br.furb.furbot.ObjetoDoMundoAdapter.AQUIMESMO;

/**
 *
 * @author mclopes
 */
public class Lista5Ex13 extends Furbot {

    // atributo vetor para guardar os valores 
    public ObjetoDoMundo vetorObjetosDoMundo[] = new ObjetoDoMundo[10];
    // atributo para saber a quantidade de numeros no vetor
    public int n = 0;
    // atributo vetor para pega a linha onde o robô coletou o número
    public int linha[] = new int[10];
    // atributo vetor para pega a coluna onde o robô coletou o número
    public int coluna[] = new int[10];
    // atributo para saber a quantidade de numeros no vetor LINHA
    public int vetLinha = 0;
    // atributo para saber a quantidade de numeros no vetor de COLUNA
    public int vetColuna = 0;

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

    // exibir os elementos do vetor
    private void MostraDadosDoVetorDeNumeros() {
        String valoresNoArray = "";
        for (int a = 0; a < n; a++) {
            valoresNoArray += vetorObjetosDoMundo[a] + " ";
        }
        diga("Todos os valores no array: " + valoresNoArray);
    }

    @Override
    public void inteligencia() throws Exception {
        limparConsole();
        mudarPosicao(0, 0);
        //iniciar uma variável para a direção
        Direcao direcao = DIREITA;
        //enquanto não para
        while (true) {

            if (n < 10) {
                if (ehObjetoDoMundoTipo("Numero", AQUIMESMO)) {
                    // colocar o numero no vetor
                    vetorObjetosDoMundo[n] = (((ObjetoDoMundo)getObjeto(AQUIMESMO)));
                    linha[vetLinha] = getY();
                    coluna[vetColuna] = getX();
                    n++;
                    vetLinha++;
                    vetColuna++;
                }
                if (ehObjetoDoMundoTipo("Alien", AQUIMESMO)) {
                    // colocar o numero no vetor
                    vetorObjetosDoMundo[n] = (((ObjetoDoMundo) getObjeto(AQUIMESMO)));
                    linha[vetLinha] = getY();
                    coluna[vetColuna] = getX();
                    n++;
                    vetLinha++;
                    vetColuna++;
                }
                if (ehObjetoDoMundoTipo("Tesouro", AQUIMESMO)) {
                    // colocar o numero no vetor
                    vetorObjetosDoMundo[n] = (((ObjetoDoMundo) getObjeto(AQUIMESMO)));
                    linha[vetLinha] = getY();
                    coluna[vetColuna] = getX();
                    n++;
                    vetLinha++;
                    vetColuna++;
                }
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
        MostraDadosDoVetorDeNumeros();
        
        // para ver o tipo do objeto do mundo => diga(vetorObjetosDoMundo[0].getSouDoTipo());
        
        
    }

    public static void main(String[] args) {
        MundoVisual.iniciar("Lista5Ex13.xml");
    }

}
