
import br.furb.furbot.Direcao;
import br.furb.furbot.Furbot;
import br.furb.furbot.MundoVisual;
import br.furb.furbot.Numero;
import br.furb.furbot.Tesouro;

/**
 * Avaliação: Prova3 Aluno: Henrique Eichstädt Data: 10/12/2018
 */
public class Prova3 extends Furbot {

    // atributo para vetor de TESOUROS
    public Tesouro vetorCofreTesouroRobo[] = new Tesouro[15];
    // atributo para saber a quantidade de NUMEROS no vetor
    public int nCR = 0;
    // atributo para vetor de TESOUROS
    public Tesouro vetorCofreAssistente[] = new Tesouro[15];
    // atributo para saber a quantidade de NUMEROS no vetor
    public int nCA = 0;

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

    // Método para exibir os valores no vetorCofreRobo
    private void MostraDadosDoVetorCofreRobo() {
        String valoresNoArray = "";
        for (int a = 0; a < nCR; a++) {
            valoresNoArray += vetorCofreTesouroRobo[a] + " ";
        }
        diga("Todos os valores no vetorCofreTesouroRobo: " + valoresNoArray);
    }

    // Método para exibir os valores no vetorAssistenteDoRobo
    private void MostraDadosDoVetorCofreAssistente() {
        String valoresNoArray = "";
        for (int a = 0; a < nCA; a++) {
            valoresNoArray += vetorCofreAssistente[a] + " ";
        }
        diga("Todos os valores no vetorCofreAssistente: " + valoresNoArray);
    }

    public boolean VeSeExisteValorIgualNoVetor(int valor, Tesouro tesouroNaPosicao) {
        for (int indice = 0; indice < 15; indice++) {
            if (vetorCofreTesouroRobo[indice] == tesouroNaPosicao) {
                return true;
            }
        }
        return false;
    }

    // Método para excluir valor em posição designada
    public void ExcluirNumeroNaPosicaoDesignada(int posicao) {
        for (int indice = posicao; indice < nCR; indice++) {
            vetorCofreTesouroRobo[indice] = vetorCofreTesouroRobo[indice + 1];
        }
    }

    @Override
    public void inteligencia() throws Exception {
        limparConsole();
        //iniciar uma variável para a direção
        Direcao direcao = DIREITA;
        //enquanto não para
        while (true) {

            // Se encontrar tesouro pelo caminho
            if (ehObjetoDoMundoTipo("Tesouro", AQUIMESMO)) {
                // Pega o valor do tesouro na posição
                int valorTesouro = (((Tesouro) getObjeto(AQUIMESMO))).getValor();
                Tesouro tesouroNaPosicao = (((Tesouro) getObjeto(AQUIMESMO)));
                if (VeSeExisteValorIgualNoVetor(valorTesouro, tesouroNaPosicao) == true) {
                    vetorCofreAssistente[nCA] = tesouroNaPosicao;
                    nCA++;
                } else if (VeSeExisteValorIgualNoVetor(valorTesouro, tesouroNaPosicao) == false) {
                    vetorCofreTesouroRobo[nCR] = tesouroNaPosicao;
                    nCR++;
                }
            }

            // Se tem Alien na Posição
            if (ehObjetoDoMundoTipo("Alien", AQUIMESMO)) {
                // Se o cofre estiver vazio
                if (nCR == 0) {
                    // Letra B - Se o cofre estiver vazio
                    diga("Escapei da morte!");
                }
                // Se o vetor não estiver vazio
                if (nCR > 0) {
                    // variavel para pegar o maior tesouro
                    int maiorTesouro = 0;
                    // variavel para pegar o indice do maior tesouro
                    int indiceDoMaiorTesouro = 0;
                    // for para ver qual o maior tesouro
                    int valorTesouroNoIndice = 0;
                    for (int indice = 0; indice < nCR; indice++) {
                        // se O indice do vetor não for nulo
                        if (vetorCofreTesouroRobo[indice] != null) {
                            // pegando o valor do tesouro no indice
                            valorTesouroNoIndice = vetorCofreTesouroRobo[indice].getValor();
                            // se o valor do tesouro for maior que o tesouro na variavel que pega o maior valor 
                            if (valorTesouroNoIndice > maiorTesouro) {
                                // atribui o valor a ela
                                maiorTesouro = valorTesouroNoIndice;
                                // pega o indice do maior tesouro
                                indiceDoMaiorTesouro = indice;
                            }
                        }
                    }
                    // chama o método que exclui o valor no indice indicado
                    ExcluirNumeroNaPosicaoDesignada(indiceDoMaiorTesouro);
                    nCR--;
                    // Letra A - Dizer qual o valor que foi roubado
                    diga("Fui roubado em: " + maiorTesouro);
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
        // Letra C - O valor de cada tesouro do robô
        MostraDadosDoVetorCofreRobo();
        // Letra C - O valor de cada tesouro do assistente
        MostraDadosDoVetorCofreAssistente();

        // somar valores no vetor de tesouros do robo e no vetor assistente
        int somaDosValoresVetorCofreTesouroRobo = 0;
        int somaValoresVetorCofreAssistente = 0;
        for (int i = 0; i < nCR; i++) {
            somaDosValoresVetorCofreTesouroRobo += vetorCofreTesouroRobo[i].getValor();
        }
        for (int i = 0; i < nCA; i++) {
            somaValoresVetorCofreAssistente += vetorCofreAssistente[i].getValor();
        }
        // Letra D - Se o cofre assistente tiver uma soma maior que o cofre principal
        if (somaValoresVetorCofreAssistente > somaDosValoresVetorCofreTesouroRobo) {
            diga("Você tem que me dar metade do seu tesouro!");
        }

        // Letra E -  Se o robô terminar o percurso sem nenhum tesouro
        if (nCR < 1) {
            diga("Malditos Piratas!");
        }
    }

    public static void main(String[] args) {
        MundoVisual.iniciar("Prova3.xml");
    }
}
