
import br.furb.furbot.Direcao;
import br.furb.furbot.Furbot;
import br.furb.furbot.MundoVisual;
import br.furb.furbot.Numero;

/**
 *
 * @author mclopes
 */
public class Lista5Ex01 extends Furbot {

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

    @Override
    public void inteligencia() throws Exception {

        // Criar Vetor Para Numeros Inteiros
        int numeros[] = new int[10];
        // Vaariavel para indicar a posição e que estou no vetor
        int n = 0;
        limparConsole();
        //iniciar uma variável para a direção
        Direcao direcao = DIREITA;
        //enquanto não para
        while (true) {

            // quando encontrar um numero
            if(ehObjetoDoMundoTipo("Numero", AQUIMESMO))
            {
                // coloca numeros no vetor
                numeros[n] = ((Numero)getObjeto(AQUIMESMO)).getValor();
                // incrementar a posição
                n++;
               
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
        // repetição para imprimir os numeros na ordem inversa
        
        for (int count = n - 1; count >= 0; count--) {
            diga(numeros[count]);
        }

    }

    public static void main(String[] args) {
        MundoVisual.iniciar("Lista5Ex01.xml");
    }

}


/*  int[] numeros = new int[15];
        if (!ehFim(DIREITA)) {
            for (int count = 0; count < 15; count++) {
                numeros[count] = count;
                diga(count);
            }
        }
 */
