
import br.furb.furbot.Booleano;
import br.furb.furbot.Direcao;
import br.furb.furbot.Furbot;
import br.furb.furbot.MundoVisual;
import br.furb.furbot.Numero;
import static br.furb.furbot.ObjetoDoMundoAdapter.AQUIMESMO;

/**
 *
 * @author mclopes
 */
public class Lista5Ex11 extends Furbot {

    // atributo para pegar os numeros encontrados pelo mapa
    public int numeros[] = new int[30];
    // atributo para guardar os booleanos encontraods pelo mapa
    public boolean booleanos[] = new boolean[10];
    // atributo para saber quantos numeros existem no array
    public int nN = 0;
    // atributo para saber quantos booleanos existem no array
    public int nB = 0;

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
        for (int a = 0; a < nN; a++) {
            valoresNoArray += numeros[a] + " ";
        }
        diga("Todos os valores no array de numeros: " + valoresNoArray);
    }
    
    
    private void MostraDadosDoVetorDeBooleanos() {
        String valoresNoArray = "";
        for (int a = 0; a < nB; a++) {
            valoresNoArray += booleanos[a] + " ";
        }
        diga("Todos os valores no array de booleanos: " + valoresNoArray);
    }

    public void ExcluirNumeroNaPosicaoDesignada(int posicao) {
        for (int indice = posicao; indice < nN; indice++) {
            numeros[indice] = numeros[indice + 1];
        }
    }
    
    public void ExcluirPrimeiroBooleanoFalse(){
        for (int indice = 0; indice < nB ; indice++) {
            if(booleanos[indice] == false){
                booleanos[indice] = booleanos[indice + 1];
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

            if (ehObjetoDoMundoTipo("Numero", AQUIMESMO)) {       // Resolução da letra A
                numeros[nN] = (((Numero) getObjeto(AQUIMESMO))).getValor();
                nN++;
            }
            if (ehObjetoDoMundoTipo("Booleano", AQUIMESMO)) {     // Resolução da letra B
                booleanos[nB] = (((Booleano) getObjeto(AQUIMESMO))).getValor();
                nB++;
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
        
        // mostra os dados antes de excluir
        MostraDadosDoVetorDeNumeros();
        MostraDadosDoVetorDeBooleanos();
        // exclui numero na posição Zero
        ExcluirNumeroNaPosicaoDesignada(0);
        // excluir primeiro booleano
        ExcluirPrimeiroBooleanoFalse();
        // mostra depois de excluir valores
        MostraDadosDoVetorDeNumeros();
        MostraDadosDoVetorDeBooleanos();

    }

    public static void main(String[] args) {
        MundoVisual.iniciar("Lista5Ex11.xml");
    }

}
