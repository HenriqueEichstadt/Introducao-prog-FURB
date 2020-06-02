
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
public class Lista5Ex09 extends Furbot {

    // criar vetor
    boolean booleanos[];
    //inicializar atributo para contar as posições ocupadas no vetor
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

    private void MostraDadosDoVetorDeNumeros(int n, boolean vetor[]) {
        String valoresNoArray = "";
        for (int a = 0; a < n; a++) {
            valoresNoArray += vetor[a] + " ";
        }
        diga("Todos os valores no array: " + valoresNoArray);
    }

    // método para contar os booleanos true
    private int ContarTrue() {
        // inicializar variavel para contar 
        int contTrue = 0;
        // percorrer o vetor
        for (int cont = 0; cont < n; cont++) {
            if (booleanos[cont] == true) {
                contTrue++;
            }
        }
        return contTrue;
    }

    // método para contar os booleanos false nas posições ímpares
    private int contarFalse() {
        int contFalse = 0;
        for (int cont = 1; cont < n; cont += 2) {
            if (!booleanos[cont]) {
                // Contar
                contFalse++;
            }
        }
        return contFalse;
    }

    @Override
    public void inteligencia() throws Exception {
        limparConsole();
        //iniciar uma variável para a direção
        Direcao direcao = DIREITA;
        // Definir o tamanho do vetor de Booleanos
        int TamVetor = (((Numero) getObjeto(DIREITA))).getValor();
        // definir o vetor para guardar os valores booleanos do mapa
        booleanos = new boolean[TamVetor];

        while (true) {
            if (n < TamVetor) {
                if (ehObjetoDoMundoTipo("Booleano", AQUIMESMO)) {
                    // colocar o numero no vetor
                    booleanos[n] = (((Booleano) getObjeto(AQUIMESMO))).getValor();
                    n++;
                }
                if(TamVetor == n){
                    diga("To cheio!");
                    break;
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
        diga(" a) Quantidade de Booleanos encontrados: " + n);
        diga(" b) Quantidade de valores TRUE: " + ContarTrue());
        diga(" c) Quantidade de valores FALSE nas posições ímpares: " + contarFalse());

        MostraDadosDoVetorDeNumeros(n, booleanos);

    }

    public static void main(String[] args) {
        MundoVisual.iniciar("Lista5Ex09.xml");
    }

}
