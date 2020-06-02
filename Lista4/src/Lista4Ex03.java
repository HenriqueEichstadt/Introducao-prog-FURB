
import br.furb.furbot.Direcao;
import br.furb.furbot.Furbot;
import br.furb.furbot.MundoVisual;
import br.furb.furbot.Numero;

/**
 *
 * @author mclopes
 */
public class Lista4Ex03 extends Furbot {

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

    /*
        Método para calcular a tabuada
     */
    private String CalculaTabuada(int numero) {
        String textoTabuada = "";
        int contador = 0;
        int tabuada = 0;
        for (int contA = 1; contA <= 10; contA++) {
            for (int contB = 1; contB <= 10; contB++) {
                tabuada = (contA * contB);
                if (contA * contB == numero) {
                    textoTabuada = contA + "X" + contB + "=" + numero;
                    contador++;
                }
            }
        }
        if(contador == 0){
            textoTabuada = "Nunhuma tabuada de 1 a 10 tem esse número";
        }
        contador = 0;
        return textoTabuada;
    }

    @Override
    public void inteligencia() throws Exception {
        // Mudar a posição do robô
        mudarPosicao(0, 0);
        limparConsole();
        //iniciar uma variável para a direção
        Direcao direcao = DIREITA;
        //enquanto não para
        while (true) {

            //identificar número
            if (ehObjetoDoMundoTipo("Numero", AQUIMESMO)) {
                Numero numero = getObjeto(AQUIMESMO);
                System.out.println("Número: " + numero);
                System.out.println(CalculaTabuada(numero.getValor()));
                System.out.println("------------------------------------------");
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

    }

    public static void main(String[] args) {
        MundoVisual.iniciar("Lista4Ex03.xml");
    }

}
