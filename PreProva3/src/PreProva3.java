
import br.furb.furbot.Alien;
import br.furb.furbot.Booleano;
import br.furb.furbot.Direcao;
import br.furb.furbot.Furbot;
import br.furb.furbot.MundoVisual;
import br.furb.furbot.Numero;
import br.furb.furbot.ObjetoDoMundo;

/**
 *
 * Nome: Henrique ALexsander Eichstädt Data: 07/12/2018 Avaliação: PreProva3
 */
public class PreProva3 extends Furbot {

    // atributo para vetor de NUMEROS
    public Numero vetorNumeros[] = new Numero[10];
    // atributo para saber a quantidade de NUMEROS no vetor
    public int nN = 0;
    // atributo para vetor de ALIENS
    public Alien vetorAliens[] = new Alien[10];
    // atributo para saber a quantidade de ALIEN no vetor
    public int nA = 0;
    // atributo para vetor de BOOLEANOS
    public Booleano vetorBooleanos[] = new Booleano[10];
    // atributo para saber a quantidade de BOOLEANOS no vetor
    public int nB = 0;
    // atributo para vetor de objetos do mundo
    public ObjetoDoMundo vetorObjetosDoMundo[] = new ObjetoDoMundo[20];
    // atributo para saber a quantidade de Objetos no vetor
    public int nO = 0;

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

    // Método para Ordenar o Vetor de Numeros em Ordem Crescente Letra(A)
    public void OrdenaValoresEmOrdemCrescenteNoVetor() {
        int cont1 = 0;
        int cont2 = 0;
        int aux = 0;

        for (cont1 = 0; cont1 < nN; cont1++) {
            for (cont2 = 0; cont2 < nN - 1; cont2++) {
                if (vetorNumeros[cont2].getValor() > vetorNumeros[cont2 + 1].getValor()) {
                    aux = vetorNumeros[cont2].getValor();
                    vetorNumeros[cont2] = vetorNumeros[cont2 + 1];
                    vetorNumeros[cont2 + 1].setValor(aux);
                }
            }
        }
    }

    // Método para Ordenar o Vetor de Booleanos Com TRUE nas Primeiras Posições - Letra(B)
    public void OrdenaBooleanosNoVetor() {
        int cont1 = 0;
        int cont2 = 0;
        Booleano booleanoAux = new Booleano();
        boolean aux = false;

        // Percorrendo o vetor de booleanos
        for (cont1 = 0; cont1 < nB; cont1++) {
            for (cont2 = 0; cont2 < nB - 1; cont2++) {
                // Se encontrar um Booleano False
                if (vetorBooleanos[cont2].getValor() == false) {
                    // Adiciona o seu valor em uma variavel auxiliar
                    booleanoAux = vetorBooleanos[cont2];
                    // Recebe o valor do índice seguinte
                    vetorBooleanos[cont2] = vetorBooleanos[cont2 + 1];
                    // Passa seu valor anterior para o índice seguinte
                    vetorBooleanos[cont2 + 1] = booleanoAux;
                }
            }
        }
    }

    // Método para intercalar objetos no vetor de ObjetosDoMundo - Letra(C)
    public void IntercalarObjetos() {
        int vetNum = 0;
        int vetbool = 0;
        int vetAlien = 0;
        for (int cont = 0; cont < 20; cont += 3) {
            if (nO < 20) {
                if (vetNum < nN) {
                    vetorObjetosDoMundo[cont] = vetorNumeros[vetNum];
                    nO++;
                    vetNum++;
                }
                if (vetAlien < nA) {
                    vetorObjetosDoMundo[cont + 1] = vetorAliens[vetAlien];
                    nO++;
                    vetAlien++;
                }
                if (cont != 18) {
                    if (vetbool < nB) {
                        vetorObjetosDoMundo[cont + 2] = vetorBooleanos[vetbool];
                        nO++;
                        vetbool++;
                    }
                }
            }
        }
         diga("Sobraram: " + (nN - vetNum) + "Numeros, " + (nA - vetAlien) + " Aliens, " + (nB - vetbool) + " Booleanos");
    }

    // Método para exibir os valores no vetor de Numeros
    private void MostraDadosDoVetorDeNumeros() {
        String valoresNoArray = "";
        for (int a = 0; a < nN; a++) {
            valoresNoArray += vetorNumeros[a] + " ";
        }
        diga("Dados no vetor de Números: " + valoresNoArray);
    }
    // Método para exibir os valores no vetor de Aliens

    private void MostraDadosDoVetorDeAliens() {
        String valoresNoArray = "";
        for (int a = 0; a < nA; a++) {
            valoresNoArray += vetorAliens[a] + " ";
        }
        diga("Dados no vetor de ALiens: " + valoresNoArray);
    }

    // Método para exibir os valores no vetor de Booleanos
    private void MostraDadosDoVetorDeBooleanos() {
        String valoresNoArray = "";
        for (int a = 0; a < nB; a++) {
            valoresNoArray += vetorBooleanos[a] + " ";
        }
        diga("Dados no vetor de Booleanos: " + valoresNoArray);
    }
    // Método para exibir os valores no vetor de ObjetosDoMundo

    private void MostraDadosDoVetorDeObjetosDoMundo() {
        String valoresNoArray = "";
        for (int a = 0; a < nO; a++) {
            valoresNoArray += vetorObjetosDoMundo[a] + " ";
        }
        diga("Dados no vetor de ObjetosDoMundo: " + valoresNoArray);
    }

    @Override
    public void inteligencia() throws Exception {
        limparConsole();
        mudarPosicao(0, 0);
        //iniciar uma variável para a direção
        Direcao direcao = DIREITA;
        //enquanto não para
        while (true) {

            // Ver se possui espaço no vetor
            if (nN < 10) {
                // Se encontrar um Numero pelo caminho
                if (ehObjetoDoMundoTipo("Numero", AQUIMESMO)) {
                    vetorNumeros[nN] = ((Numero) getObjeto(AQUIMESMO));
                    nN++;
                }
            } else {
                diga("Mochila cheia, não foi possivel adicionar o objeto na mochila!");
            }

            // Ver se possui espaço no vetor
            if (nA < 10) {
                // Se encontrar um Alien pelo caminho
                if (ehObjetoDoMundoTipo("Alien", AQUIMESMO)) {
                    vetorAliens[nA] = ((((Alien) getObjeto(AQUIMESMO))));
                    nA++;
                }
            } else {
                diga("Mochila cheia, não foi possivel adicionar o objeto na mochila!");
            }

            // Ver se possui espaço no vetor
            if (nB < 10) {
                // Se encontrar um Booleano pelo caminho
                if (ehObjetoDoMundoTipo("Booleano", AQUIMESMO)) {
                    // colocar o numero no vetor
                    vetorBooleanos[nB] = ((Booleano) getObjeto(AQUIMESMO));
                    nB++;
                }
            } else {
                diga("Mochila cheia, não foi possivel adicionar o objeto na mochila!");
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

        //Chamando o Método para ordenar os valores em ordem Crescente no Vetor de Numeros - Letra (A)
        OrdenaValoresEmOrdemCrescenteNoVetor();

        // Chamando o Método que ordena os Boolenos no Vetor -  Letra (B)
        OrdenaBooleanosNoVetor();

        // Chamando método que intercala objetos no Vetor de ObjetosDoMundo - Letra (C)
        IntercalarObjetos();

        // Mostrando Dados do vetor
        MostraDadosDoVetorDeNumeros();
        MostraDadosDoVetorDeAliens();
        MostraDadosDoVetorDeBooleanos();
        MostraDadosDoVetorDeObjetosDoMundo();
    }

    public static void main(String[] args) {
        MundoVisual.iniciar("PreProva3.xml");
    }

}
