
import br.furb.furbot.Direcao;
import br.furb.furbot.Furbot;
import br.furb.furbot.MundoVisual;
import br.furb.furbot.Numero;

/**
 *
 * @author mclopes
 */
public class Lista4Ex01 extends Furbot {

    // atributo para guardar o menor número encontrado
    public int menorNumeroNoMapa = 1000;
    // atributo para guardar o maior numero encontrado
    public int maiorNumeroNoMapa = 0;

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

    private void VerificaNumeroNaposicao() {
        if (ehObjetoDoMundoTipo("Numero", AQUIMESMO)) {
            int valorDoNumero = ((Numero) getObjeto(AQUIMESMO)).getValor();
            if (valorDoNumero < menorNumeroNoMapa) {
                menorNumeroNoMapa = valorDoNumero;
            }
            if (valorDoNumero > maiorNumeroNoMapa) {
                maiorNumeroNoMapa = valorDoNumero;
            }
        }
    }

    @Override
    public void inteligencia() throws Exception {
        // mudar a posição do robô
        mudarPosicao(0, 0);
        limparConsole();
        //iniciar uma variável para a direção
        Direcao direcao = DIREITA;
        //enquanto não para
        while (true) {
            // Chama o método
            VerificaNumeroNaposicao();
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
        diga("O menor número encontrado no percurso foi: " + menorNumeroNoMapa);
        diga("O maior número encontrado no percurso foi: " + maiorNumeroNoMapa);
        diga(" ### Valores entre " + menorNumeroNoMapa + " e " + maiorNumeroNoMapa + " ###");
        // For para mostrar todos os números que estão entre o menor e o maior valor
        for (int count = menorNumeroNoMapa; count <= maiorNumeroNoMapa; count++) {
            diga(count);
        }
    }

    public static void main(String[] args) {
        MundoVisual.iniciar("Lista4Ex01.xml");
    }

}
