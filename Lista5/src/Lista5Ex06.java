
import br.furb.furbot.Direcao;
import br.furb.furbot.Furbot;
import br.furb.furbot.MundoVisual;
import br.furb.furbot.Numero;
import static br.furb.furbot.ObjetoDoMundoAdapter.AQUIMESMO;

/**
 *
 * @author mclopes
 */
public class Lista5Ex06 extends Furbot {

    // atributo vetor para guardar os valores 
    public int vetor[] = new int[30];
    // atributo para saber a quantidade de numeros no vetor
    public int n = 0;
    // atributo vetor para pega a linha onde o robô coletou o número
    public int linha[] = new int[30];
    // atributo vetor para pega a coluna onde o robô coletou o número
    public int coluna[] = new int[30];
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

    private void MostraDadosDoVetorDeNumeros() {
        String valoresNoArray = "";
        for (int a = 0; a < n; a++) {
            valoresNoArray += vetor[a] + " ";
        }
        diga("Todos os valores no array: " + valoresNoArray);
    }

    // ordenar os valores no vetor
    public void OrdenaValoresEmOrdemCrescenteNoVetor() {
        int cont1 = 0;
        int cont2 = 0;
        int aux = 0;

        for (cont1 = 0; cont1 < n; cont1++) {
            for (cont2 = 0; cont2 < n - 1; cont2++) {
                if (vetor[cont2] > vetor[cont2 + 1]) {
                    aux = vetor[cont2];
                    vetor[cont2] = vetor[cont2 + 1];
                    vetor[cont2 + 1] = aux;
                }
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

            // Se tem número na posição
            if (ehObjetoDoMundoTipo("Numero", AQUIMESMO)) {
                // colocar o numero no vetor
                vetor[n] = (((Numero) getObjeto(AQUIMESMO))).getValor();
                linha[vetLinha] = getY();
                coluna[vetColuna] = getX();
                n++;
                vetLinha++;
                vetColuna++;
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

        OrdenaValoresEmOrdemCrescenteNoVetor();

        // faz o robô percorrer o mundo novamente
        //iniciar uma variável para a direção
        mudarPosicao(0, 0);
        Direcao direcao2 = DIREITA;
        vetLinha = 0;
        vetColuna = 0;
        n = 0;
        //enquanto não para
        while (true) {
            
            int lin = getY();
            int col = getX();
            if (lin == linha[vetLinha] && col == coluna[vetColuna]) {
                Numero numero = new Numero();
                numero.setValor(vetor[n]);
                adicionarObjetoNoMundo(numero, AQUIMESMO);
                n++;
                vetLinha++;
                vetColuna++;
            }

            if (!ehFim(direcao2)) {
                //andar para a direção
                andar(direcao2);
                //quando termina a direção
            } else {
                //mudar a direção
                direcao2 = mudarDirecao(direcao2);
                //ver se o robô pode descer
                if (!ehFim(ABAIXO)) {
                    andarAbaixo();
                } else {
                    //para a repetição
                    break;
                }
            }
        }
        diga("Os valores foram adicionados em ordem crescente!!!");
    }

    public static void main(String[] args) {
        MundoVisual.iniciar("Lista5Ex06.xml");
    }

}
