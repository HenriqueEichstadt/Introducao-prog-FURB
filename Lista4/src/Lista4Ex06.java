
import br.furb.furbot.Direcao;
import br.furb.furbot.Furbot;
import br.furb.furbot.MundoVisual;
import br.furb.furbot.Numero;

/**
 *
 * @author mclopes
 */
public class Lista4Ex06 extends Furbot {

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

    private long calcularFatorial(int numero) {

        // Inicializar uma variável para calcular o fatorial
        long fatorial = 1;
        //repetição
        for (int count = numero; numero > 2; numero--) {
            // multiplicar o termo pelo fatorial
            fatorial *= count;
        }
        return fatorial;
    }

    @Override
    public void inteligencia() throws Exception {
        long somaFatorial = 0;
        mudarPosicao(0, 0);
        limparConsole();
        //iniciar uma variável para a direção
        Direcao direcao = DIREITA;
        //enquanto não para
        while (true) {

            if (ehObjetoDoMundoTipo("Numero", AQUIMESMO)) {
                // pegar o numero
                Numero numero = getObjeto(AQUIMESMO);
                // Calcula o fatorial
                long fatorial = calcularFatorial(numero.getValor());
                // somar o resultado
                somaFatorial += fatorial;
                // falar o fatorial
                diga(numero + "! = " + fatorial);
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
        diga("Soma dos fatoriais = " + somaFatorial);

    }

    public static void main(String[] args) {
        MundoVisual.iniciar("Lista4Ex06.xml");
    }

}
