
import br.furb.furbot.Direcao;
import br.furb.furbot.Furbot;
import br.furb.furbot.MundoVisual;
import br.furb.furbot.ObjetoDoMundo;

/**
 *
 * @author mclopes
 */
public class Lista5Ex12 extends Furbot {

    // atributo vetor para adicionar objetos do mundo
    private String arrayObjetos[] = new String[10];
    //atributo do tipo int para saber quantas posições do vetor estão ocupadas
    private int n = 0;
    // atributo para a quantidad de objetos que foram substituídos
    private int objetosSubstituidos = 0;

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
            valoresNoArray += arrayObjetos[a] + " ";
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

            if (n == 10) {

                if (ehObjetoDoMundoTipo("Tesouro", AQUIMESMO)) {
                    for (int indice = 0; indice < n; indice++) {
                        if (arrayObjetos[indice] == "Numero") {
                            arrayObjetos[indice] = "Tesouro";
                            indice = 9;
                            objetosSubstituidos++;
                        }
                        if (arrayObjetos[indice] == "Alien") {
                            arrayObjetos[indice] = "Tesouro";
                            indice = 9;
                            objetosSubstituidos++;
                        }
                    }
                }
                if (ehObjetoDoMundoTipo("Alien", AQUIMESMO)) {
                    for (int indice = 0; indice < n; indice++) {
                        if (arrayObjetos[indice] == "Numero") {
                            arrayObjetos[indice] = "Alien";
                            indice = 9;
                        }
                    }
                }
            }
        
        if (n <= 9) {
            // adiciona numeros do mapa no vetor
            if (ehObjetoDoMundoTipo("Numero", AQUIMESMO)) {
                arrayObjetos[n] = "Numero";
                n++;
            }
            // adiciona Aliens no vetor
            if (ehObjetoDoMundoTipo("Alien", AQUIMESMO)) {
                arrayObjetos[n] = "Alien";
                n++;
            }
            // adiciona Tesouro no vetor
            if (ehObjetoDoMundoTipo("Tesouro", AQUIMESMO)) {
                arrayObjetos[n] = "Tesouro";
                n++;
            }
        }

        // método par apegar se for Número
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

    diga(

    "Cheguei!");
    MostraDadosDoVetorDeNumeros();
}

public static void main(String[] args) {
        MundoVisual.iniciar("Lista5Ex12.xml");
    }

}
