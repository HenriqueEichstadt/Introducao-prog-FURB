
import br.furb.furbot.Booleano;
import br.furb.furbot.Direcao;
import br.furb.furbot.Furbot;
import br.furb.furbot.MundoVisual;

/**
 *
 * @author mclopes
 */
public class Lista5Ex03 extends Furbot {

    // atributo em vetor para guardar os Valores de True ou False
    private byte vetor[] = new byte[8];

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

    private short ConverterParaDecimal() {
        // inicializar a potencia
        byte pot = 0;
        // inicializar a soma dos termos
        short soma = 0;
        // repetir para cada termo
        for (int cont = 7; cont >= 0; cont--) {
            // somar o termo
            soma += vetor[cont] * Math.pow(2, pot);
            // incrementar a potência
            pot++;
        }
        // retornar o resultado
        return soma;
    }

    @Override
    public void inteligencia() throws Exception {
        limparConsole();
        //iniciar uma variável para a direção
        Direcao direcao = DIREITA;
        //enquanto não para
        // marcador de posição do vetor
        int i = 0;
        while (true) {

            if (ehObjetoDoMundoTipo("Booleano", AQUIMESMO)) {
                // se é true
                if (((Booleano) getObjeto(AQUIMESMO)).getValor()) {
                    vetor[i] = 1;
                    i++;
                } else {
                    vetor[i] = 0;
                    i++;
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
        // definir um texto para o Conteúdo
        String binario = "";
        for (i = 0; i <= 7; i++) {
            binario += vetor[i];
        }
        diga(binario);
        diga("Decimal = " + ConverterParaDecimal());

    }

    public static void main(String[] args) {
        MundoVisual.iniciar("Lista5Ex03.xml");
    }

}
