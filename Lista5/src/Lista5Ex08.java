
import br.furb.furbot.Direcao;
import br.furb.furbot.Furbot;
import br.furb.furbot.MundoVisual;
import br.furb.furbot.Numero;
import static br.furb.furbot.ObjetoDoMundoAdapter.AQUIMESMO;
import br.furb.furbot.Tesouro;

/**
 *
 * @author Henrique Alexsander Eichstädt
 */
public class Lista5Ex08 extends Furbot {

    // definir vetor para guardar os numeros
    private int vetor[] = new int[30];
    // definir variavel para saber quantos indices do vetor foram ocupados
    private int n = 0;
    // atributo para a soma dos valores no vetor (Questão A)
    private int somaDosValoresNoVetor = 0;
    // atributo para contar quantos tesouros foram pegos (Questão B)
    private int qtdDeValores = 0;
    // atributo para a média dos valores (Questão C)
    private int mediaDosValores = 0;
    // atributo para os cinco menores valores (Questão D)
    private int cincoMenoresValores = 0;
    // atributo para os cinco maiores valores (Questão D)
    private int cincoMaioresValores = 0;

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

    private String MostraCincoMenoresValores() {
        //Variavel para mostrar cinco menores valores
        String menoresValores = "";
        // pegar 5 maiores valores de um vetor
        for (int i = 0; i < 5; i++) {
            menoresValores += vetor[i] + " - ";
        }
        return menoresValores;
    }

    private String MostraCincoMaioresValores() {
        // Variavel para pegar os cinco maiores valores
        String maioresValores = "";
        // pegar cinco maiores valores
        for (int i = n - 1; i > n - 5; i--) {
            maioresValores += vetor[i] + " - ";
        }
        return maioresValores;
    }

    @Override
    public void inteligencia() throws Exception {
        limparConsole();
        //iniciar uma variável para a direção
        Direcao direcao = DIREITA;
        //enquanto não para
        while (true) {

            if (ehObjetoDoMundoTipo("Tesouro", AQUIMESMO)) {
                // colocar o numero no vetor
                vetor[n] = (((Tesouro) getObjeto(AQUIMESMO))).getValor();
                somaDosValoresNoVetor += vetor[n];
                qtdDeValores++;
                // incrementar a quantidade de elementos no vetor
                n++;
                OrdenaValoresEmOrdemCrescenteNoVetor();

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

        //incrementar a média dos valores no vetor
        mediaDosValores = somaDosValoresNoVetor / qtdDeValores;

        diga("Cheguei!");
        diga("A soma dos valores no vetor é: " + somaDosValoresNoVetor);
        diga("A quantidade de valores no vetor é " + qtdDeValores);
        diga("A média dos valores no vetor é " + mediaDosValores);
        diga("Os 5 menores valores no vetor: " + MostraCincoMenoresValores());
        diga("Os 5 maiores valores no vetor: " + MostraCincoMaioresValores());

        String valoresNoArray = "";
        for (int a = 0; a < n; a++) {
            valoresNoArray += vetor[a] + " ";
        }
        diga("Todos os valores no array: " + valoresNoArray);
    }

    public static void main(String[] args) {
        MundoVisual.iniciar("Lista5Ex08.xml");
    }

}
