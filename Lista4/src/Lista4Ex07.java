
import br.furb.furbot.Direcao;
import br.furb.furbot.Furbot;
import br.furb.furbot.MundoVisual;
import br.furb.furbot.Numero;
import static br.furb.furbot.ObjetoDoMundoAdapter.AQUIMESMO;

/**
 *
 * @author mclopes
 */
public class Lista4Ex07 extends Furbot {

    // atributo para contar os triangulares pelo mapa
    private int contadorDeTriangulares = 0;
    // atributo para contar os não triangulares encontrados pelo mapa
    private int contadorDeNaoTriangulares = 0;
    // atributo para ver se é numero triangular
    private int numeroTriangular = 0;

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
        Método para ver se é numero triangular
     */
    private void NumeroTriangular(int numero) {
        int contador = 0;
        // for para o primeiro numero do produto
        for (int numUm = 1; numUm <= 10; numUm++) {
            // for para o segundo numero do produto
            for (int numDois = 2; numDois <= 10; numDois++) {
                // for para o terceiro numero do produto
                for (int numTres = 3; numTres <= 10; numTres++) {
                    numeroTriangular = numUm * numDois * numTres;
                    if (numeroTriangular == numero) {
                        diga("O número " + numero + " é triangular");
                        contadorDeTriangulares++;
                        contador++;
                        numTres = 10;
                        numDois = 10;
                        numUm = 10;
                    }
                }
            }
        }
        if (contador == 0) {
            diga("o número " + numero + " não é triangular");
            contadorDeNaoTriangulares++;
        }
    }

    @Override
    public void inteligencia() throws Exception {
        mudarPosicao(0, 0);
        limparConsole();
        //iniciar uma variável para a direção
        Direcao direcao = DIREITA;
        //enquanto não para
        while (true) {
            // Chama o método
            if (ehObjetoDoMundoTipo("Numero", AQUIMESMO)) {
                Numero numero = getObjeto(AQUIMESMO);
                NumeroTriangular(numero.getValor());
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
        MundoVisual.iniciar("Lista4Ex07.xml");
    }

}
